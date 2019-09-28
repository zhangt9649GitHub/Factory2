//管理员列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;


		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			// url: './index.json',
			data: [],
			cols: [
				[
					{field: 'field1',title: '管理员名称',unresize: true,templet: '#bianhao'}
					,{field: 'field2',title: '权限名称',unresize: true}
					,{field: 'field3',title: '状态',unresize: true}
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

		// 触发事件
		var active = {
			// 新增
			add: function(that, href) {
				if (href) {
					// location.href = href;
					zqIframeView('新增',href,400,580)
				} else {
					layer.msg('页面开发中')
				}
			},
			// 编辑
			edit: function(that, href) {

				if (row) {
					if (href) {
						// location.href = href;
						zqIframeView('编辑',href,400,580)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择订单')
				}
			},

			// 删除
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
			// 删除
			enableDisabling: function() {
				if (row) {
					layer.confirm('您确定启用/禁用此信息吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						layer.close(index);
						layer.msg('操作成功', {
							icon: 1
						});
					});

				} else {
					layer.msg('请选择订单')
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
