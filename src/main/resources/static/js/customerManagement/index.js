//客户管理
$(document).ready(function(){
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
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/customer/selectCustomerList',
			cols: [
				[{
					field: 'customerNumber',
					title: '编号',
					unresize: true,
					templet: '#customerNumber'
				}, {
					field: 'customerName',
					title: '客户名称',
					unresize: true
				}, {
					field: 'phone',
					title: '联系人电话',
					unresize: true
				}, {
					field: 'address',
					title: '地址',
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

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					customerNumber: $.trim(data.field.customerNumber),
					customerName: $.trim(data.field.customerName),
					phone: $.trim(data.field.phone),
					address: $.trim(data.field.address),
					comment: $.trim(data.field.comment)

				}
			});
			return false;
		});

	
		// 触发事件
		var active = {
			// 新增
			add: function(that,href){
				if(href){
					location.href = href;
				}else{
					layer.msg('页面开发中')
				}
			},
			// 编辑
			edit: function(that,href){
				
				if(row){
					if(href){
						location.href = href + '?customerId=' + row.customerId;
					}else{
						layer.msg('页面开发中')
					}
				}else{
					layer.msg('请选择一条数据')
				}
			},
			// 删除
			delete: function(){
				if(row){
					layer.confirm('您确定删除此客户吗?',
						{
							icon: 3,
							title:'提示'
						},
						function(index){
						var formdata = new FormData();
						formdata.append('customerId', parseInt(row.customerId));
						axios.post('/customer/deleteCustomer',formdata
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
					
				}else{
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