//销售明细-列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate,
			row;

		// 销售日期
		laydate.render({
			elem: '#laydata-2'
		});
		// 日期段
		laydate.render({
			elem: '#laydata-1'
			,range: '~'
		});

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/salesDetails/getSalesDetailsList\n',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
						templet: '#partsCd'
					}, {
						field: 'customerName',
						title: '客户',
						unresize: true
					}, {
						field: 'addtime',
						title: '销售日期',
						unresize: true
					}, {
						field: 'goodsName',
						title: '品名',
						unresize: true
					}, {
						field: 'specification',
						title: '规格',
						unresize: true
					}, {
						field: 'quantity',
						title: '销售数量',
						unresize: true
					}, {
						field: 'sellingPrice',
						title: '单价',
						unresize: true
					}, {
						field: 'totalPrice',
						title: '总价',
						unresize: true
					}, {
						field: 'skgCount',
						title: '在库库存数',
						unresize: true
					}, {
						field: 'salesOrderNumber',
						title: '订单编号',
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
		form.on('submit(*)', function(data) {
			let dateRange = $('input[name="dateRange"]').val();
			data.field.startTime = $.trim(dateRange.substring(0,dateRange.indexOf('~')));
			data.field.endTime = $.trim(dateRange.substring(dateRange.indexOf('~') + 1));

			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					partsCd: $.trim(data.field.partsCd),
					customerName: $.trim(data.field.customerName),
					addtime: $.trim(data.field.addtime),
					goodsName: $.trim(data.field.goodsName),
					specification: $.trim(data.field.specification),
					quantity: $.trim(data.field.quantity),
					sellingPrice: $.trim(data.field.sellingPrice),
					totalPrice: $.trim(data.field.totalPrice),
					skgCount: $.trim(data.field.skgCount),
					salesOrderNumber: $.trim(data.field.salesOrderNumber),
					startTime: $.trim(data.field.startTime),
					endTime: $.trim(data.field.endTime),

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
					if (href) {
						location.href = href;
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择订单')
				}
			},
			delete: function() {
				if (row) {
					layer.confirm('您确定删除此订单吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						layer.close(index);
						layer.msg('删除成功', {
							icon: 1
						});
					});

				} else {
					layer.msg('请选择订单')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 搜索按钮
			search: function () {
				$('.zq-search-form .item button').eq(0).click();
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
