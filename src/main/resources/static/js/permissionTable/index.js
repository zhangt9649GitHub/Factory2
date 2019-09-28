//数据字典
$(document).ready(function() {

	layui.config({
		base: '../../public/layui/'
	}).extend({
		treetable: 'treetable-lay/treetable'
	}).use(['form', 'treetable', 'layer', 'table'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			treetable = layui.treetable;

		// 获取列表数据
		axios.post('/staffAccess/getStaffAccessList'
		).then(function (response) {
			renderTable(response.data.data);

		}).catch(function (error) {
			console.log(error);
		});

		var renderTable = function (data) {
			layer.load(2);
			treetable.render({
				elem: '#idTest',
				height: 500,
				treeColIndex: 1, //树形图标显示在第几列
				treeSpid: 0, //最上级的父级id
				treeIdName: 'accessId', //id字段的名称
				treePidName: 'accessModuleId', //pid字段的名称
				treeDefaultClose: true, //是否默认折叠
				treeLinkage: false, //父级展开时是否自动展开所有子级
				data:data,
				page: false,
				cols: [
					[
						{
							type: 'numbers'
						},
						{
							field: 'accessName',
							width: 200,
							title: '名称'
						},
						{
							field: 'permissions',
							title: '值'
						},
						{
							field: 'url',
							title: '接口'
						},
						{
							field: 'accessId',
							title: 'accessId',
							width:100
						},
						{
							field: 'accessModuleId',
							title: '父Id',
							width:100
						}
					]
				],
				done: function(response){

					layer.closeAll('loading');

					let mainHeight = $('.layui-table-body.layui-table-main').height();
					let pageHeight = $('.layui-table-page').outerHeight();

					$('.layui-table-body.layui-table-main').height(pageHeight + mainHeight);
				}

			});
		};


		// 监听数据表格行单击事件
		var row;
		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});



		// 监听表单提交
		form.on('submit(*)', function(data) {

			var keyword = $.trim(data.field.search);

			var searchCount = 0;
			$('#idTest').next('.treeTable').find('.layui-table-body tbody tr td').each(function() {
				$(this).css('background-color', 'transparent');
				var text = $(this).text();
				if (keyword != '' && text.indexOf(keyword) >= 0) {
					$(this).css('background-color', 'rgba(250,230,160,0.5)');
					if (searchCount == 0) {
						treetable.expandAll('#idTest');
						$('html,body').stop(true);

						$('#auth-table').next('.treeTable').find('.layui-table-body').animate({scrollTop: $(this).offset().top - 150}, 500);
						// $('html,body').animate({
						// 	scrollTop: $(this).offset().top - 150
						// }, 500);
						$('#idTest').next('.treeTable').find('.layui-table-body tbody tr').removeClass('layui-table-click');
					}
					searchCount++;
				}
			});
			if (keyword.length == 0) {
				layer.msg("请输入搜索内容", {
					icon: 5
				});
			} else if (searchCount == 0) {
				layer.msg("没有匹配结果", {
					icon: 5
				});
			}
			return false;
		});


		// 触发事件
		var active = {
			add: function(that, href) {

				if (href) {
					let url;
					if(row){
						url= href + '?accessModuleId=' + row.accessModuleId;
						console.log(url);
						zqIframeView('新增',url,500,550)
					}else {
						url = href + '?accessModuleId=0';
						console.log(url);
						zqIframeView('新增',url,500,550)
					}

				} else {
					layer.msg('页面开发中')
				}
			},
			edit: function(that, href) {
				if (row) {
					if (href) {
						let url = href + '?accessId=' + row.accessId;
						zqIframeView('编辑',url,500,550)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择一条数据')
				}
			},
			delete: function() {
				if (row) {
					layer.confirm('你确定删除数据吗？如果存在下级节点则一并删除，此操作不能撤销！', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var formdata = new FormData();
						formdata.append('id', parseInt(row.accessId));
						axios.post('/staffAccess/deleteStaffAccess',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 30002){

								setTimeout(function () {
									location.reload();
								}, 1000);
							}

						}).catch(function (error) {
							console.log(error);
						});

					});

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

})
