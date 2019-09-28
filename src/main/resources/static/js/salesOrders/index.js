// 销售订单-列表

$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate','upload'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			upload = layui.upload,
			laydate = layui.laydate,
			row;
		// 创建时间
		laydate.render({
			elem: '#laydate-1'
		});
		// 上传
		upload.render({
			elem: '#upload-file',
			url: '/salesOrder/importSalesOrder',
            accept: 'file',
            before: function(){
                layer.load(1, {
                    shade: [0.5,'#fff'] //0.1透明度的白色背景
                });
            },
			done: function(res){

                layer.closeAll('loading'); //关闭加载层
                layer.msg(res.msg);
                if(res.code == 10014) {
                    layui.table.reload('idTest');
                }
			},
			error: function(){
				layer.msg('上传失败',{icon:2})
			}

		});

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/salesOrder/getSalesOrderList',
			cols: [
				[
					{
						field: 'salesOrderNumber',
						title: '编号',
						unresize: true,
						templet: '#salesOrderNumber'
					}, {
						field: 'addtime',
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
						title: '回款状态',
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

		// 查询
		let exportField = {
			salesOrderNumber: '',
			addtime: '',
			customerName: '',
			state: '',
			paymentStatus: '',
			amount: '',
			amountReceived: '',
			comment: ''
		};
		form.on('submit(*)', function(data) {
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					salesOrderNumber: $.trim(data.field.salesOrderNumber),
					addtime: $.trim(data.field.addtime),
					customerName: $.trim(data.field.customerName),
					state: $.trim(data.field.state),
					paymentStatus: $.trim(data.field.paymentStatus),
					amount: $.trim(data.field.amount),
					amountReceived: $.trim(data.field.amountReceived),
					comment: $.trim(data.field.comment)
				}
			});
			exportField = data.field;
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
					if (row.state != 3 && row.paymentStatus == 1) {
						location.href = href + '?salesOrderId=' + row.salesOrderId;
					} else {
						layer.msg('货物已出库或已回款不能修改',{icon: 5})
					}
				} else {
					layer.msg('请选择一条数据')
				}
			},
			delete: function() {
				if (row) {

					if (row.state != 3 && row.paymentStatus == 1) {
						layer.confirm('您确定删除此订单吗?', {
							icon: 3,
							title: '提示'
						}, function(index) {
							let formdata = new FormData();
							formdata.append('salesOrderId', parseInt(row.salesOrderId));
							axios.post('/salesOrder/deleteSalesOrderById',formdata
							).then(function (response) {
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 10004){

									layui.table.reload('idTest');
									row = '';
								}

							}).catch(function (error) {
								console.log(error);
							});
						});
					} else {
						layer.msg('货物已出库或已回款不能删除',{icon: 5})
					}


				} else {
					layer.msg('请选择一条数据')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 更新状态
			updateStatus: function(){
				if(row){

					layer.confirm('您确定把此订单状态改为已出库吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						layer.load(1, {
							shade: [0.5,'#fff'] //0.1透明度的白色背景
						});
						let formdata = new FormData();
						formdata.append('salesOrderId',parseInt(row.salesOrderId));

						axios.post('/salesOrder/updateSalesOrderState',formdata
						).then(function (response) {
							layer.closeAll('loading'); //关闭加载层
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 10008){

								layui.table.reload('idTest');
							}else{
								layer.msg(response.data.msg, {
									icon: 5
								});
							}

						});
					});


				}else{
					layer.msg('请选择销售订单')
				}
			},
			// 导出
			export: function () {
				// 导出列表
				// location.href = '/salesOrder/exportSalesOrderList?salesOrderNumber='+$.trim(exportField.salesOrderNumber)+'&addtime='+$.trim(exportField.addtime)+'&customerName='+$.trim(exportField.customerName)+'&state='+$.trim(exportField.state)+'&paymentStatus='+$.trim(exportField.paymentStatus)+'&amount='+$.trim(exportField.amount)+'&amountReceived='+$.trim(exportField.amountReceived)+'&comment='+$.trim(exportField.comment) ;

				//	导出订单详情
				if (row) {
					location.href = '/salesOrder/exportSalesOrderDetails?salesOrderId=' + row.salesOrderId;
				} else {
					layer.msg('请选择一条数据')
				}
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

});
