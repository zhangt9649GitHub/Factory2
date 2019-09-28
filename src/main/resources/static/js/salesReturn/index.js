// 销售退货单-列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate','upload'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			upload = layui.upload,
			laydate = layui.laydate,
			row;
			
		laydate.render({
			elem: '#date'
		});


		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/salesReturn/getSalesReturnList',
			cols: [
				[
					{
						field: 'salesReturnNumber',
						title: '编号',
						unresize: true,
						templet: '#salesReturnNumber'
					}, {
						field: 'addTime',
						title: '创建时间',
						unresize: true
					}, {
						field: 'customerName',
						title: '客户',
						unresize: true
					}, {
						field: 'state',
						title: '当前状态',
						unresize: true,
						templet: '#state'
					}, {
						field: 'paymentStatus',
						title: '付款状态',
						unresize: true,
						templet: '#paymentStatus'
					}, {
						field: 'amount',
						title: '金额',
						unresize: true
					}, {
						field: 'amountReceived',
						title: '已收金额',
						unresize: true
					}, {
						field: 'comment',
						title: '备注',
						unresize: true
					}

				]
			],
			done: function(response){

				row ='';
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

		// 查询
		form.on('submit(*)', function(data) {
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					salesReturnNumber: data.field.salesReturnNumber,
					addTime: data.field.addTime,
					customerName: data.field.customerName,
					state: data.field.state,
					paymentStatus: data.field.paymentStatus,
					amount: data.field.amount,
					amountReceived: data.field.amountReceived,
					comment: data.field.comment
				}
			});
			return false;
		});


		// 触发事件
		var active = {
			add: function(that, href) {
				if (href) {
					location.href = href;
				} else {
					layer.msg('页面开发中')
				}
			},
			edit: function(that, href) {
				if (row) {
					if (row.state == 1 && row.paymentStatus == 1) {
						location.href = href + '?salesReturnId=' + row.salesReturnId;
					} else {
						layer.msg('货物已入库或已付款不能修改',{icon: 5})
					}
				} else {
					layer.msg('请选择销售退货单')
				}
			},
			delete: function() {
				if (row) {
					if(row.state == 1 && row.paymentStatus == 1){
						layer.confirm('您确定删除此订单吗?', {
							icon: 3,
							title: '提示'
						}, function(index) {
							var formdata = new FormData();
							formdata.append('salesReturnId', parseInt(row.salesReturnId));
							axios.post('/salesReturn/deleteSalesReturnById',formdata
							).then(function (response) {
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 10004){

									layui.table.reload('idTest');
									row = '';
								}

							});
						});
					} else {
						layer.msg('货物已入库或已付款不能删除',{icon: 5})
					}



				} else {
					layer.msg('请选择销售退货单')
				}
			},
			updateStatus: function(that){
				if(row){
					if(row.state ==1){
						layer.confirm('您确定把此订单状态改为已入库吗?', {
							icon: 3,
							title: '提示'
						}, function(index) {
							var formdata = new FormData();
							formdata.append('salesReturnId', parseInt(row.salesReturnId));
							axios.post('/salesReturn/updateSalesReturnState',formdata
							).then(function (response) {
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 10008){

									layui.table.reload('idTest');
									row = '';
								}

							});
						});
					}else{
						layer.msg('此订单状态已经是：已入库，不可进行修改', {
							icon: 1
						});
					}

				}else{
					layer.msg('请选择销售退货单')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			}
		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

})
