var table;
layui.use(['form', 'table', 'layer', 'laydate'], function() {

	var	layer = layui.layer,
		form = layui.form,
		laydate = layui.laydate;
	table = layui.table;



	// 日期
	laydate.render({
		elem: '#laydate-1' //指定元素
		,value: new Date()
	});

	// 获取供应商
	function getSupplierNameList() {

		return axios.get('/general/getSupplierNameList')

	}

	// 获取编辑信息
	axios.all([getSupplierNameList()])
		.then(axios.spread(function(acct){
			if(acct.data.code == 0){
				$.each(acct.data.data, function(i,item){
					$('select[name="supplierId"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
				});
				form.render('select')
			}
			let formdata = new FormData();
			formdata.append('proId',$('input[name="proId"]').val());
			axios.post('/purchaseReturnOrder/getPurchaseReturnOrderByProId',formdata)
				.then(function(response){

					if(response.data.code == 0){
						let data = response.data.data;

						let formdata = new FormData();
						formdata.append('supplierId', data.supplierId);
						//获取原采购订单
						axios.post('/purchaseReturnOrder/getPurchaseOrderBySupplierId',formdata)
							.then(function(res){
								if(res.data.code == 0){
									$.each(res.data.data,function (i,item) {

										$('select[name="purchaseOrderId"]').append(`<option value="${item.purchaseOrderId}">${item.purchaseOrderNumber}</option>`)
									});
									form.render('select');
									form.val('formTest',{
										purchaseReturnOrderNumber: data.purchaseReturnOrderNumber,
										defineDate: data.defineDate,
										supplierId: data.supplierId,
										purchaseOrderId: data.purchaseOrderId,
										comment: data.comment
									})
								}
							});

						let purchaseReturnOrderDetailsList = [];
						$.each(data.purchaseReturnOrderDetailsList,function (i,item) {
							let arr = {
								goodsId: item.goodsId,
								partsCd: item.partsCd,
								goodsName: item.goodsName,
								unit: item.unit,
								quantity1: item.quantity,
								quantity: item.returnQuantity,
								price: item.price,
								money: item.money,
								reasonReturn: item.reasonReturn,
							};
							purchaseReturnOrderDetailsList.push(arr);
						});
						purchaseReturnOrderDetailsList.push({});
						table.reload('idTest', {
							data: purchaseReturnOrderDetailsList
						});


					}

				})
		}));



	// 获取原采购订单
	function getPurchaseOrderBySupplierId(val){
		$('select[name="purchaseOrderId"]').html(`<option value=""></option>`);

		if($.trim(val).length == 0){
			form.render('select');
			return;
		}

		let formdata = new FormData();
		formdata.append('supplierId',val);

		axios.post('/purchaseReturnOrder/getPurchaseOrderBySupplierId',formdata)
			.then(function(response){
				if(response.data.code == 0){
					$.each(response.data.data,function (i,item) {

						$('select[name="purchaseOrderId"]').append(`<option value="${item.purchaseOrderId}">${item.purchaseOrderNumber}</option>`)
					});
					form.render('select');
				}
			})
	}


	// 监听供应商选择
	let oldSupplierId;
	form.on('select(supplierId)', function(data){
		// console.log(data.elem); //得到select原始DOM对象
		// console.log(data.value); //得到被选中的值
		// console.log(data.othis); //得到美化后的DOM对象


		if(oldSupplierId != data.value){
			oldSupplierId = data.value;
			let tableBak = [];
			for (let i = 0; i < 5; i++) {
				tableBak.push({});
			}
			table.reload('idTest', {
				data: tableBak
			});
			getPurchaseOrderBySupplierId(data.value);
		}

	});

	// 监听原采购订单选择
	let oldPurchaseOrderId;
	form.on('select(purchaseOrderId)', function(data){
		// console.log(data.elem); //得到select原始DOM对象
		// console.log(data.value); //得到被选中的值
		// console.log(data.othis); //得到美化后的DOM对象


		if(oldPurchaseOrderId != data.value){
			oldPurchaseOrderId = data.value;
			let tableBak = [];
			for (let i = 0; i < 5; i++) {
				tableBak.push({});
			}
			table.reload('idTest', {
				data: tableBak
			});
		}

	});

	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 120, // 定义所有常规单元格的最小宽度
		totalRow: true, //开启合计行区域
		data: [],
		cols: [
			[
				{
					width: 50,
					align: 'center',
					toolbar: '#barDemo',
					unresize: true,
					fixed: 'left'
				}, {
					field: 'partsCd',
					title: '部品CD',
					unresize: true,
					edit: 'text'
				}, {
					field: 'goodsName',
					title: '品名',
					unresize: true
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'quantity1',
					title: '采购数量',
					unresize: true
				},  {
					field: 'quantity',
					title: '退货数量',
					unresize: true,
					edit: 'text'
				}, {
					field: 'price',
					title: '单价',
					unresize: true,
					edit: 'text'
				}, {
					field: 'money',
					title: '总价',
					unresize: true,
					totalRow: true
				}, {
					field: 'reasonReturn',
					title: '退换原因',
					unresize: true,
					edit: 'text'
				}
			]
		],
		done: function(){
			$('.layui-table-view .layui-table-body').niceScroll({
				cursorcolor: '#828e94',
				cursorborder: "1px solid #828e94",
			});
		}
	});



	// 监听数据表格行单击事件
	table.on('row(demo)', function(obj) {

		// console.log(obj.data) //得到当前行数据
		//标注选中样式
		obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		$('.layui-table-fixed tr').removeClass('layui-table-click');
	});

	// 监听数据表格单元格编辑
	var editOldValue;
	table.on('edit(demo)', function(obj) {
		// console.log(obj.value); //得到修改后的值
		// console.log(obj.field); //当前编辑的字段名
		// console.log(obj.data); //所在行的所有相关数据

		let data = obj.data;
		let tr = obj.tr; //获得当前行 tr 的DOM对象
		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];
		if(obj.field == 'partsCd'){
			data.partsCd = editOldValue;
			tableBak.splice(tr.attr('data-index'), 1, data);
			table.reload('idTest', {
				data: tableBak
			});
			return false;
		}else
		if(obj.field == 'quantity'){
            if(isNaN(obj.value) || Number(obj.value) < 1 || Number(obj.value) > Number(data.quantity1)){

				data.quantity = editOldValue;

				data.money = (Number(data.quantity)* Number(data.price)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('退货数量只能是数字,且小于采购数量大于0', {
					icon: 5
				});
			}else{

				data.money = (Number(data.quantity)* Number(data.price)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
			}
		}else
		//	单价
		if(obj.field == 'price'){
			if(isNaN(obj.value) || Number(obj.value) < 0){
				data.price = editOldValue;

				data.money = (Number(data.quantity)* Number(data.price)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('单价只能是数字,且大于0', {
					icon: 5
				});
			}else{
				data.money = (Number(data.quantity)* Number(data.price)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
			}
		}


	});

	// 监听数据表格编辑框选中
	$('.zq-datatable').on('focus', '.layui-table-edit', function() {
		// 删除放大镜与输入框
		$('.zq-datatable .zq-fangdajing').remove();
		$('.zq-datatable .zq-input').remove();
		var that = $(this);

		// 报错编辑前的值
		editOldValue = $(that).val();
		//标注选中样式
		that.parents('tr').addClass('layui-table-click').siblings().removeClass('layui-table-click');
		// 记录当前选中行的坐标
		var dataIndex = $(this).parents('tr').attr('data-index');
		var dataField = $(this).parents('td').attr('data-field');

		switch (dataField) {
			case 'partsCd':
				let html =
					`<i class="zq-fangdajing" onclick="active.zqIframeShow(${dataIndex})" >
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
				that.parent().append(html);
				break;
		}
	});




	// // 删除放大镜与输入框
	$('body').click(function() {
		$('.zq-datatable .zq-fangdajing').remove();
		$('.zq-datatable .zq-input').remove();
	});


	// 监听表格工具栏操作
	table.on('tool(demo)', function(obj) {
		var data = obj.data; //获得当前行数据
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的DOM对象
		// 获取动态表格的数据
		var tableBak = table.cache['idTest'];

		if (layEvent === 'addRow') {
			// 新增行

			tableBak.push({});

			table.reload('idTest', {
				data: tableBak
			});

		} else if (layEvent === 'daleteRow') {
			// 删除行

			tableBak.splice(tr.attr('data-index'), 1);
			table.reload('idTest', {
				data: tableBak
			});

		}
	});




	// 监听表单提交
	form.on('submit(*)', function(data) {
		let that = this;


		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];
		let purchaseReturnOrderDetailsList  = [];
		for(let i in tableBak){
			if(tableBak[i].goodsId){
				let arr ={
					goodsId: tableBak[i].goodsId,
					returnQuantity: tableBak[i].quantity,
					price: tableBak[i].price,
					money: tableBak[i].money,
					reasonReturn: (tableBak[i].reasonReturn)?tableBak[i].reasonReturn:'',
				};
				purchaseReturnOrderDetailsList .push(arr);
			}


		}
		if(purchaseReturnOrderDetailsList .length == 0){
			layer.msg('请选择退货货物', {icon: 5});
			return false;
		}
		data.field.purchaseReturnOrderDetailsList = purchaseReturnOrderDetailsList ;
		//采购退货金额（合计）
		data.field.purchaseReturnAmount = $('.layui-table-total td[data-field="money"]').text();

		// 禁止点击
		$(that).addClass('zq-submit-disabled');

		axios.post('/purchaseReturnOrder/updatePurchaseReturnOrderInfo', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 20005) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/purchaseReturn/index";  //刷新父页面
					}, 1000);
				}else {
					// 取消禁止点击
					$(that).removeClass('zq-submit-disabled');
				}
			}).catch(function (error) {
			console.log(error);

		});
		return false;
	});




});
// 触发事件
var active = {
	zqIframeShow: function (dataIndex) {

		let val = $('select[name="purchaseOrderId"] option:selected').val();

		let url = `/admin/purchaseReturn/showTable?dataIndex=${dataIndex}&purchaseOrderId=${val}`;
		if(val.length != 0){
			zqIframeShow('查看',url,700,520)
		}else{
			layer.msg('请选择原采购订单', {icon: 5});
		}
	}

};

// 点击调用
$('body').on('click', '.zq-active', function() {
	var othis = $(this),
		type = othis.data('type');
	active[type] ? active[type].call(this, othis) : '';
});
// 从子页面传数据到表格
function updateData(dataIndex, data){
	// 获取动态表格的数据
	let tableBak = table.cache['idTest'];

	if(data.quantity1 != 0){
		$.each(tableBak,function(i,item){
			if(item.goodsId == data.goodsId){

				if(dataIndex == i){
					tableBak.splice(dataIndex, 1, data);
					table.reload('idTest', {
						data: tableBak
					});
					return false;
				}else{
					layer.msg('该信息已添加，不能重复添加！', {icon: 5});
					return false;
				}
			}else{
				if(i == (tableBak.length - 1 )){
					tableBak.splice(dataIndex, 1, data);
					table.reload('idTest', {
						data: tableBak
					});
				}
			}
		});
	}else{
		layer.msg('该货物数量为0，无法退货', {icon: 5});
	}




}
