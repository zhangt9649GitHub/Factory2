$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate',"table"], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;

		// 日期
		laydate.render({
			elem: '#laydate-1' //指定元素
			,value: new Date()
		});

		laydate.render({
			elem: '#laydate-2' //指定元素
			,value: new Date()
		});

		//获取编号
		axios.get('/general/getFormNumber?type=13'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="purchaseOrderNumber"]').val(data.data.number);
			}
		});
		// 获取采购类型
		axios.post('/purchaseOrder/getPurchaseTypeList')
			.then(function(response){
				if(response.data.code == 0){
					$.each(response.data.data, function(i,item){
						$('select[name="purchaseType"]').append(`<option value="${item.value}">${item.bizName}</option>`)
					});
					form.render('select')
				}
			});
		// 获取货物信息
		function getData() {
			layer.load(1, {
				shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			var detailsId = $('input[name="detailsId"]').val();
			var detailsIdList = detailsId.split(',');

			var detailsIdLists = [];
			$.each(detailsIdList,function(i,item){
				detailsIdLists.push({"ndid":Number(item)})
			});

			axios.post('/noteDocument/selectGoodInfoByNote',detailsIdLists)
				.then(function(response){
					var data = response.data;
					if(data.code == 0){
						// console.log(data);
						var goodsList = [];
						$.each(data.data,function(i,item){
							var arr = {
								'ndid': item.ndid,
								'goodsId': item.goodsId,
								'partsCd': item.partsCd,
								'goodsName': item.goodsName,
								'unit': item.unit,
								'quantity': item.count,
								'purchasePrice': item.price,
								'taxIncludedAmount': item.money
							};
							goodsList.push(arr);
							if(i == 0){
								form.val('formTest',{
									'supplierId': item.supplierId,
									'supplierName': item.supplierName
								})
							}

						});
						// console.log(goodsList);
						table.reload('idTest', {
							data: goodsList
						});
					}
				});
			// 关闭加载
			layer.closeAll('loading');
		}
		getData();






		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
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
						totalRowText: '合计（小写）',
						width: 120
					}, {
						field: 'goodsName',
						title: '品名',
						unresize: false
					}, {
						field: 'unit',
						title: '单位',
						unresize: true
					}, {
						field: 'quantity',
						title: '数量',
						edit: 'text'
					}, {
						field: 'purchasePrice',
						title: '单价',
						unresize: true,
						edit: 'text'
					}, {
						field: 'excludingTaxAmount',
						title: '不含税金额',
						unresize: true
					}, {
						field: 'taxRate',
						title: '税率',
						unresize: true
					}, {
						field: 'tax',
						title: '税额',
						unresize: true
					}, {
						field: 'taxIncludedAmount',
						title: '含税金额',
						unresize: true,
						totalRow: true
					}, {
						field: 'financeMoney',
						title: '财务金额',
						unresize: true,
						edit: 'text',
						totalRow: true
					}
				]
			],
			done: function(){
				// 设置合计的字段
				let  taxIncludedAmount = $('.layui-table-total td[data-field="taxIncludedAmount"]').text();
				form.val('formTest',{
					'capital':number_chinese(taxIncludedAmount)
				});
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});

		// 监听数据表格单元格编辑
		let editOldValue;
		table.on('edit(demo)', function(obj) {
			// console.log(obj.value); //得到修改后的值
			// console.log(obj.field); //当前编辑的字段名
			// console.log(obj.data); //所在行的所有相关数据

			let data = obj.data;
			let tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据

			let tableBak = table.cache['idTest'];
			//数量
			if(obj.field == 'quantity'){
				if(isNaN(obj.value) || (obj.value) < 1){

					data.quantity = editOldValue;
					data.taxIncludedAmount = (Number(data.quantity)* Number(data.purchasePrice)).toFixed(2);
					tableBak.splice(tr.attr('data-index'), 1, data);
					table.reload('idTest', {
						data: tableBak
					});
					layer.msg('数量只能是数字并且大于0', {
						icon: 5
					});
				}else{
					data.taxIncludedAmount = (Number(obj.value)* Number(data.purchasePrice)).toFixed(2);
					tableBak.splice(tr.attr('data-index'), 1, data);
					table.reload('idTest', {
						data: tableBak
					});
				}
			}else
			//	单价
			if(obj.field == 'purchasePrice'){
				if(isNaN(obj.value) || (obj.value) < 1){

					data.purchasePrice = editOldValue;
					data.taxIncludedAmount = (Number(data.quantity)* Number(data.purchasePrice)).toFixed(2);
					tableBak.splice(tr.attr('data-index'), 1, data);
					table.reload('idTest', {
						data: tableBak
					});
					layer.msg('单价只能是数字并且大于0', {
						icon: 5
					});
				}else{
					data.taxIncludedAmount = (Number(obj.value)* Number(data.quantity)).toFixed(2);
					tableBak.splice(tr.attr('data-index'), 1, data);
					table.reload('idTest', {
						data: tableBak
					});
				}
			}else
			// 财务金额
			if(obj.field == 'financeMoney'){
				if(isNaN(obj.value)){
					data.financeMoney = editOldValue;
					tableBak.splice(tr.attr('data-index'), 1, data);
					table.reload('idTest', {
						data: tableBak
					});
					layer.msg('财务金额只能是数字', {
						icon: 5
					});
				}else{
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

			delete data.field.supplierName;
			delete data.field.detailsId;

			let tableBak = table.cache['idTest'];
			let purchaseOrderDetailsList  = [];
			for(let i in tableBak){
				if(tableBak[i].goodsId){
					let arr ={
						ndid: tableBak[i].ndid,
						goodsId: tableBak[i].goodsId,
						quantity: tableBak[i].quantity,
						purchasePrice: tableBak[i].purchasePrice,
						excludingTaxAmount: tableBak[i].excludingTaxAmount,
						taxRate: tableBak[i].taxRate,
						tax: tableBak[i].tax,
						taxIncludedAmount: tableBak[i].taxIncludedAmount,
						financeMoney: tableBak[i].financeMoney

					};
					purchaseOrderDetailsList .push(arr);
				}


			}
			if(purchaseOrderDetailsList .length == 0){
				layer.msg('货物不能为空', {icon: 5});
				return false;
			}
			data.field.purchaseOrderDetailsList  = purchaseOrderDetailsList ;
			// 含税金额总计小写
			data.field.purchaseAmount = $('.layui-table-total td[data-field="taxIncludedAmount"]').text();
			// 财务金额总计小写
			data.field.financeMoneySum = $('.layui-table-total td[data-field="financeMoney"]').text();
			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/noteDocument/createPurchaseOrderNote', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 20015) {
						setTimeout(function () {
							location.href="/admin/notesManagement/index";  //刷新父页面
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


		// 触发事件
		var active = {

		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');

			active[type] ? active[type].call(this, othis) : '';
		});



	})
});
