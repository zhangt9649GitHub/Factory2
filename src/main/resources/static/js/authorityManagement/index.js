// 权限管理
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','upload'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			upload = layui.upload,
			table = layui.table,
			row;
			

					
		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/staffGroupAccess/getGroupAccessList',
			cols: [
				[
					{field: 'groupName',title: '权限名称',unresize: true,templet: '#groupName'}
					,{field: 'groupText',title: '权限描述',unresize: true}
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

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					groupName: $.trim(data.field.groupName),
					groupText: $.trim(data.field.groupText)
				}
			});
			return false;
		});





		// 触发事件
		var active = {
			// 新增
			add: function(that, href) {
				if (href) {
					// location.href = href;
					zqIframeView('新增',href)
				} else {
					layer.msg('页面开发中')
				}
			},
			// 编辑
			edit: function(that, href) {
		
				if (row) {
					if (href) {
						let url = href + '?groupId=' + row.groupId;
						zqIframeView('编辑',url)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择权限')
				}
			},
			// 查看
			open: function (that, href) {
				if (href) {
					zqIframeView('查看',href)
				} else {
					layer.msg('页面开发中')
				}
			},
			// 删除
			delete: function() {
				if (row) {
					layer.confirm('您确定删除此订单吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var formdata = new FormData();
						formdata.append('groupId', parseInt(row.groupId));
						axios.post('/staffGroupAccess/deleteGroupAccess',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 30002){

								layui.table.reload('idTest');
								row = '';
							}

						});
					});
		
				} else {
					layer.msg('请选择权限')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
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
