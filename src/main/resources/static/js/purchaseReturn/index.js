//采购退货单-列表
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
		// 创建时间
		laydate.render({
			elem: '#laydate-1'
		});
	
		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/purchaseReturnOrder/getPurchaseReturnOrderList',
			cols: [
				[
					{
						field: 'purchaseReturnOrderNumber',
						title: '编号',
						unresize: true,
						templet: '#purchaseReturnOrderNumber'
					}, {
						field: 'defineDate',
						title: '创建时间',
						unresize: true
					}, {
						field: 'name',
						title: '创建人',
						unresize: true
					}, {
						field: 'purchaseOrderNumber',
						title: '原采购订单号',
						unresize: true
					}, {
						field: 'supplierName',
						title: '供应商',
						unresize: true
					}, {
						field: 'purchaseReturnAmount',
						title: '退货金额',
						unresize: true
					}, {
						field: 'paymentStatus',
						title: '结算状态',
						unresize: true,
						templet: '#paymentStatus'
					}, {
						field: 'storageState',
						title: '出库状态',
						unresize: true,
						templet: '#storageState'
					}, {
						field: 'comment',
						title: '备注',
						unresize: true
					}

				]
			],
			done: function(response){

				row = '';
				//初始化
				$('.zq-search-form .search').css('margin-left',0);
				$(".layui-table-body.layui-table-main").scrollLeft(0);

				// 设置搜索滚动
				$('.zq-search-form .search').width($('.layui-table-view .layui-table-header table').width());


				// 监听查询滚动条的变化
				$(".layui-table-body.layui-table-main").scroll(function() {
					console.log();
					$('.zq-search-form .search').css('margin-left',-($(this).scrollLeft()));
				});

			}
		});
	
		// 监听数据表格行单击事件

		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});


		var exportField = {
			purchaseReturnOrderNumber: '',
			defineDate: '',
			name: '',
			purchaseOrderNumber: '',
			supplierName: '',
			purchaseReturnAmount: '',
			paymentStatus: '',
			storageState: '',
			comment: ''

		};
		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					purchaseReturnOrderNumber: $.trim(data.field.purchaseReturnOrderNumber),
					defineDate: $.trim(data.field.defineDate),
					name: $.trim(data.field.name),
					purchaseOrderNumber: $.trim(data.field.purchaseOrderNumber),
					supplierName: $.trim(data.field.supplierName),
					purchaseReturnAmount: $.trim(data.field.purchaseReturnAmount),
					paymentStatus: $.trim(data.field.paymentStatus),
					storageState: $.trim(data.field.storageState),
					comment: $.trim(data.field.comment)

				}
			});

			exportField = {
				purchaseReturnOrderNumber: $.trim(data.field.purchaseReturnOrderNumber),
				defineDate: $.trim(data.field.defineDate),
				name: $.trim(data.field.name),
				purchaseOrderNumber: $.trim(data.field.purchaseOrderNumber),
				supplierName: $.trim(data.field.supplierName),
				purchaseReturnAmount: $.trim(data.field.purchaseReturnAmount),
				paymentStatus: $.trim(data.field.paymentStatus),
				storageState: $.trim(data.field.storageState),
				comment: $.trim(data.field.comment)
			};
			return false;
		});


	
		// 触发事件
		var active = {
			add: function(that,href){
				if(href){
					location.href = href;
				}else{
					layer.msg('页面开发中')
				}
			},
			edit: function(that,href){
				if(row){
					if(row.storageState == 1 && row.paymentStatus == 1){
						location.href = href + '?proId=' + row.proId;
					}else{
						layer.msg('此订单已出库或已结算，不可编辑', {
							icon: 1
						});
					}
				}else{
					layer.msg('请选择订单')
				}
			},
			delete: function(){
				if(row){

					if(row.storageState == 1 && row.paymentStatus == 1){
						layer.confirm('您确定删除此采购退货单吗?', {icon: 3, title:'提示'}, function(index){

							let formdata = new FormData();
							formdata.append('proId', parseInt(row.proId ));
							axios.post('/purchaseReturnOrder/deletePurchaseReturnOrder',formdata
							).then(function (response) {
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 20007){

									layui.table.reload('idTest');
								}

							});
						});
					}else{
						layer.msg('此订单已出库或已结算，不可删除', {
							icon: 1
						});
					}

					
				}else{
					layer.msg('请选择订单')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 导出
			export: function () {
				location.href = '/purchaseReturnOrder/exportPurchaseReturnOrderList?purchaseReturnOrderNumber=' + exportField.purchaseReturnOrderNumber
				+'&defineDate=' + exportField.defineDate + '&name=' + exportField.name + '&purchaseOrderNumber=' + exportField.purchaseOrderNumber
				+'&supplierName=' + exportField.supplierName + '&purchaseReturnAmount=' + exportField.purchaseReturnAmount
				+'&paymentStatus+' + exportField.paymentStatus + '&storageState=' + exportField.storageState + '&comment=' + exportField.comment;
			},
			// 更新状态
			updateStatus: function(){
				if(row){
					if(row.storageState ==1){
						layer.confirm('您确定把此订单状态改为已出库吗?', {
							icon: 3,
							title: '提示'
						}, function(index) {
							layer.load(1, {
								shade: [0.5,'#fff'] //0.1透明度的白色背景
							});
							let formdata = new FormData();
							formdata.append('purchaseReturnOrderId',parseInt(row.proId));

							axios.post('/purchaseReturnOrder/updatePurchaseReturnOrderStorageState',formdata
							).then(function (response) {
								layer.closeAll('loading'); //关闭加载层
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 20005){

									layui.table.reload('idTest');
								}

							});
						});
					}else{
						layer.msg('此订单状态已经是：已出库，不可进行修改', {
							icon: 1
						});
					}

				}else{
					layer.msg('请选择销售退货单')
				}
			}
		};
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});
	
	
	})
	
});