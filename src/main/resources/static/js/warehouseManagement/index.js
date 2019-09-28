//仓库管理
$(document).ready(function() {
	layui.use(['form', 'table', 'layer'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table,
			row;


		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/warehouse/selectWarehouseAll',
			cols: [
				[
					{
						field: 'warehouseId',
						title: '编号',
						unresize: true,
						templet: '#warehouseId'
					}, {
						field: 'warehouseName',
						title: '仓库名称',
						unresize: true
					}, {
						field: 'name',
						title: '联系人',
						unresize: true
					}, {
						field: 'state',
						title: '状态',
						unresize: true,
						templet: '#state'
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

		// 获取员工列表
		axios.get('/general/getStaffNameList'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$.each(data.data,function(i,item){

					// 调出仓库
					$('select[name="staffId"]').append('<option value="'+ item.staffId +'">'+ item.name +'</option>')

				});


				form.render('select');
			}
		}).catch(function (error) {
			console.log(error);
		});

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					warehouseId: $.trim(data.field.warehouseId),
					warehouseName: $.trim(data.field.warehouseName),
					contact: $.trim(data.field.contact),
					state: $.trim(data.field.state),
					staffId: $.trim(data.field.staffId)

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
					zqIframeView('新增',href,400,550)
				} else {
					layer.msg('页面开发中')
				}
			},
			// 编辑
			edit: function(that, href) {

				if (row) {
					if (href) {
						let url = href + `?warehouseId=${row.warehouseId}`;
						zqIframeView('编辑',url,400,550)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择一条数据')
				}
			},
			// 查看
			open: function(that, href){
				if (row) {
					if (href) {

						zqIframeView('查看',href,400,550)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择一条数据')
				}
			},
			// 删除
			delete: function() {
				if (row) {
					layer.confirm('您确定删除此仓库?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var formdata = new FormData();
						formdata.append('warehouseId ', parseInt(row.warehouseId ));
						axios.post('/warehouse/deletetWarehouse',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 20007){

								layui.table.reload('idTest');
								row = '';
							}

						}).catch(function (error) {
							console.log(error);
						});
					});

				} else {
					layer.msg('请选择一条数据')
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

})
