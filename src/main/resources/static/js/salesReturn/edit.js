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




	//获取客户列表
	function getCustomerNameList() {
		return axios.get('/general/getCustomerNameList'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$.each(data.data,function(i,item) {
					$('select[name="customerId"]').append('<option value="' + item.customerId + '">' + item.customerName + '</option>');

				});
				form.render('select');
			}
		});
	}


	//获取销售订单
	function getSaleData(val){
		$('select[name="salesOrderId"]').html(`<option value=""></option>`);

		if($.trim(val).length == 0){
			form.render('select');
			return false;
		}

		let formdata = new FormData();
		formdata.append('id',val);

		axios.post('/receipt/getSaleData',formdata)
			.then(function(response){
				if(response.data.code == 0){
					$.each(response.data.data,function (i,item) {

						$('select[name="salesOrderId"]').append(`<option value="${item.salesOrderId}">${item.salesOrderNumber}</option>`)
					});
					form.render('select');
				}
			})
	}


	// 获取编辑信息
	let oldCustomerId; // 供应商选中值
	let oldSalesOrderId; // 销售订单选中值
	axios.all([getCustomerNameList()])
		.then(axios.spread(function (acct, perms) {
			// 两个请求现在都执行完成
			let formdata = new FormData();
			formdata.append('salesReturnId', parseInt($('input[name="salesReturnId"]').val()));
			axios.post('/salesReturn/getSalesReturnById', formdata
			).then(function (response) {
				let data = response.data;

				if(data.code == 0){
					let formdata = new FormData();
					formdata.append('id', data.data.customer.customerId);

					axios.post('/receipt/getSaleData',formdata)
						.then(function(response){
							if(response.data.code == 0){
								$.each(response.data.data,function (i,item) {

									$('select[name="salesOrderId"]').append(`<option value="${item.salesOrderId}">${item.salesOrderNumber}</option>`)
								});
								form.render('select');
								form.val('formTest',{
									'salesReturnNumber': data.data.salesReturnNumber,
									'addTime': data.data.addTime,
									'customerId': data.data.customer.customerId,
									'salesOrderId': data.data.salesOrderId,
									'comment': data.data.comment,
									'staffName': data.data.staff.name
								});
								oldCustomerId = data.data.customer.customerId;
								oldSalesOrderId = data.data.salesOrderId;
							}
						});

					let salesReturnDetailsList = [];
					$.each(data.data.salesReturnDetailsList,function (i,item) {
						let arr ={
							goodsId: item.goods.goodsId,
							partsCd: item.goods.partsCd,
							goodsName: item.goods.goodsName,
							lotNumber: item.goods.lotNumber,
							boxesNumber: item.goods.boxesNumber,
							monthlySalesVolume: item.goods.monthlySalesVolume,
							sellingMonths: item.goods.sellingMonths,
							skgCount: item.skgCount,
							unitPrice: item.unitPrice,
							quantity: item.quantity,
							quantity1: item.orderQuantity,
							totalPrice: item.totalPrice,
							netWeight: Number(item.goods.netWeight)* Number(item.quantity),
							grossWeight: Number(item.goods.grossWeight)* Number(item.quantity),
							volume: Number(item.goods.volume)* Number(item.quantity),

							// 记录净重/毛重/体积的初始值
							netWeight1: item.goods.netWeight,
							grossWeight1: item.goods.grossWeight,
							volume1: item.goods.volume,

							customsCategory: item.customsCategory,
							seaTariffNumber: item.seaTariffNumber,
							comment: item.comment,
						};
						salesReturnDetailsList.push(arr);
					});

					salesReturnDetailsList.push({});
					table.reload('idTest', {
						data: salesReturnDetailsList
					});

				}

			})
		}));




	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 100, // 定义所有常规单元格的最小宽度
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
					edit: 'text',
					unresize: true,
					totalRowText: '合计（小写）',
					width: 120
				}, {
					field: 'goodsName',
					title: '商品名称',
					unresize: true
				}, {
					field: 'lotNumber',
					title: '批次',
					unresize: true
				}, {
					field: 'boxesNumber',
					title: '箱数',
					unresize: true,
					totalRow: true
				}, {
					field: 'monthlySalesVolume',
					title: '月贩卖量',
					unresize: true
				}, {
					field: 'sellingMonths',
					title: '贩卖月数',
					unresize: true
				},  {
					field: 'skgCount',
					title: '现库存',
					unresize: true
				},  {
					field: 'unitPrice',
					title: '单价',
					unresize: true,
					edit: 'text'
				}, {
					field: 'quantity1',
					title: '销售数量',
					unresize: true
				}, {
					field: 'quantity',
					title: '退货数量',
					edit: 'text',
					unresize: true,
					totalRow: true
				}, {
					field: 'totalPrice',
					title: '总价',
					unresize: true,
					totalRow: true
				}, {
					field: 'netWeight',
					title: '净重',
					unresize: true,
					totalRow: true
				}, {
					field: 'grossWeight',
					title: '毛重',
					unresize: true,
					totalRow: true
				}, {
					field: 'volume',
					title: '体积',
					unresize: true,
					totalRow: true
				}, {
					field: 'customsCategory',
					title: '海关类别',
					unresize: true,
					edit: 'text'
				}, {
					field: 'seaTariffNumber',
					title: '海关税号',
					unresize: true,
					edit: 'text'
				}, {
					field: 'comment',
					title: '备注',
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

		if(!(data.goodsId)){
			return;
		}

		if(obj.field == 'partsCd'){
			data.partsCd = editOldValue;
			tableBak.splice(tr.attr('data-index'), 1, data);
			table.reload('idTest', {
				data: tableBak
			});
			return false;
		}else if(obj.field == 'quantity'){

			if(!(isNaN(obj.value)) && (obj.value)>0 &&　Number(obj.value) <= Number(data.quantity1)){
				// 数量
				data.quantity = obj.value;
				// 总净重
				data.netWeight = (Number(data.netWeight1) * Number(data.quantity)).toFixed(2);
				// 总毛重
				data.grossWeight = (Number(data.grossWeight1) * Number(data.quantity)).toFixed(2);
				// 总体积
				data.volume = (Number(data.volume1) * Number(data.quantity)).toFixed(2);
				// 总价
				data.totalPrice = (Number(data.unitPrice) * Number(data.quantity)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});

			}else{
				data.quantity = editOldValue;
				data.netWeight = (Number(data.netWeight1) * Number(data.quantity)).toFixed(2);
				data.grossWeight = (Number(data.grossWeight1) * Number(data.quantity)).toFixed(2);
				data.volume = (Number(data.volume1) * Number(data.quantity)).toFixed(2);
				data.totalPrice =  (Number(data.unitPrice) * Number(data.quantity)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('数量只能是数字,并且大于0小于销售数量', {
					icon: 5
				});


			}



		}else if(obj.field == 'unitPrice'){
			if(!(isNaN(obj.value)) && (obj.value)>0){
				// 单价
				data.unitPrice = obj.value;
				// 总价
				data.totalPrice = (Number(data.unitPrice) * Number(data.quantity)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});

			}else{
				data.unitPrice = editOldValue;
				data.totalPrice = (Number(data.unitPrice) * Number(data.quantity)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('单价只能是数字并且大于0', {
					icon: 5
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



	// 监听客户选择

	form.on('select(customerId)', function(data){
		// console.log(data.elem); //得到select原始DOM对象
		// console.log(data.value); //得到被选中的值
		// console.log(data.othis); //得到美化后的DOM对象


		if(oldCustomerId != data.value){
			oldCustomerId = data.value;
			let tableBak = [];
			for (let i = 0; i < 5; i++) {
				tableBak.push({});
			}
			table.reload('idTest', {
				data: tableBak
			});
			getSaleData(data.value);
		}

	});
	// 监听销售订单选择
	form.on('select(salesOrderId)', function(data){
		// console.log(data.elem); //得到select原始DOM对象
		// console.log(data.value); //得到被选中的值
		// console.log(data.othis); //得到美化后的DOM对象


		if(oldSalesOrderId != data.value){
			oldSalesOrderId = data.value;
			let tableBak = [];
			for (let i = 0; i < 5; i++) {
				tableBak.push({});
			}
			table.reload('idTest', {
				data: tableBak
			});
		}

	});




	// 监听表单提交
	form.on('submit(*)', function(data) {
		let that = this;

		delete data.field.staffName;

		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];
		let salesReturnDetailsList = [];
		for(let i in tableBak){
			if(tableBak[i].goodsId){
				let arr ={
					goodsId: tableBak[i].goodsId,
					unitPrice: tableBak[i].unitPrice,
					quantity: tableBak[i].quantity,
					totalPrice: tableBak[i].totalPrice,
					customsCategory: (tableBak[i].customsCategory)?tableBak[i].customsCategory:'',
					seaTariffNumber: (tableBak[i].seaTariffNumber)?tableBak[i].seaTariffNumber:'',
					comment: (tableBak[i].comment)?tableBak[i].comment:''
				};
				salesReturnDetailsList.push(arr);
			}


		}
		if(salesReturnDetailsList.length == 0){
			layer.msg('请选择货物', {icon: 5});
			return false;
		}
		data.field.salesReturnDetailsList = salesReturnDetailsList;

		// 总箱数/总价/总数量/总净重/总毛重/总体积
		data.field.totalBoxesNumber = parseInt($('.layui-table-total td[data-field="boxesNumber"]').text());
		data.field.amount = $('.layui-table-total td[data-field="totalPrice"]').text();
		data.field.totalAmount = $('.layui-table-total td[data-field="quantity"]').text();
		data.field.totalNetWeight = $('.layui-table-total td[data-field="netWeight"]').text();
		data.field.totalGrossWeight = $('.layui-table-total td[data-field="grossWeight"]').text();
		data.field.totalVolume = $('.layui-table-total td[data-field="volume"]').text();

		// 禁止点击
		$(that).addClass('zq-submit-disabled');

		axios.post('/salesReturn/updateSalesReturnInfo', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 10008) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/salesReturn/index";  //刷新父页面
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
		// 获取客户id
		let val = $('select[name="salesOrderId"] option:selected').val();

		let url = `/admin/salesReturn/showTable?dataIndex=${dataIndex}&salesOrderId=${val}`;
		if(val.length != 0){
			zqIframeShow('查看',url,700,520)
		}else{
			layer.msg('请选择销售订单', {icon: 5});
		}
	}
	//

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
