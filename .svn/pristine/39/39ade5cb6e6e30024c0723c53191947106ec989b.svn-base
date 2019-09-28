//库存状态
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate,
			row;

		laydate.render({
			elem: '#chukuriqi'
		});

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			// url: './index.json',
			data: [],
			cols: [
				[
					{field: 'number',title: '部品CD',unresize: true,"rowspan": 2,templet: '#bianhao',align: 'center'}
					,{field: 'field16',title: '商品名称',unresize: true,"rowspan": 2,align: 'center'}
					,{field: 'field5',title: '平均月贩',unresize: true,"rowspan": 2,align: 'center'}
					,{field: 'field6',title: '包含运送途中的在库月数',unresize: true,"rowspan": 2,width:200,align: 'center'}
					,{title: '日本侧',unresize: true,"colspan": 2,align: 'center'}
					,{title: '中国侧',unresize: true,"colspan": 3,align: 'center'}
					,{field: 'field1',title: '手配',unresize: true,"rowspan": 2,align: 'center'}
					,{field: 'field2',title: '预定',unresize: true,"rowspan": 2,align: 'center'}
					,{title: '商品生产预定准备结果',unresize: true,"colspan": 4,align: 'center'}
				],
				[
					{field: 'field7',title: '商品',unresize: true,align: 'center'}
					,{field: 'field8',title: '半成品',unresize: true,align: 'center'}
					,{field: 'field9',title: '运输中',unresize: true,align: 'center'}
					,{field: 'field10',title: '半成品',unresize: true,align: 'center'}
					,{field: 'field11',title: '部品',unresize: true,align: 'center'}
					,{field: 'field12',title: '半成品合计',unresize: true,align: 'center'}
					,{field: 'field13',title: '月数',unresize: true,align: 'center'}
					,{field: 'field14',title: '半成品预备',unresize: true,align: 'center'}
					,{field: 'field15',title: '过不住',unresize: true,align: 'center'}
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
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
				}
			});
			return false;
		})


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
			open: function(that, href) {
				if (row) {
					if (href) {
						location.href = href;
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择订单')
				}
			}
		}
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

})
