//库存盘点单
$(document).ready(function(){

	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
		// 发起时间
		laydate.render({
			elem: '#laydate-1'
		});
	
		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			method: 'post',
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/inventoryCheck/getAll',
			cols: [
				[
					{
						field: 'inventoryCheckNumber',
						title: '编号',
						unresize: true,
						templet: '#inventoryCheckNumber'
					},{
						field: 'fqTime',
						title: '发起时间',
						unresize: true
					}, {
						field: 'name',
						title: '创建人',
						unresize: true
					}, {
						field: 'warehouseName',
						title: '仓库',
						unresize: true
					}, {
						field: 'state',
						title: '当前状态',
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
					inventoryCheckNumber: $.trim(data.field.inventoryCheckNumber),
					fqTime: $.trim(data.field.fqTime),
					name: $.trim(data.field.name),
					warehouseName: $.trim(data.field.warehouseName),
					state: $.trim(data.field.state),
					comment: $.trim(data.field.comment)
				}
			});
			return false;
		});
		
	
		// 触发事件
		var active = {
			// 新增
			add: function(that,href){

				if (href) {
					// location.href = href;
					zqIframeView('新增',href,400,550)
				} else {
					layer.msg('页面开发中')
				}
			},
			// 删除
			delete: function(){
				if(row){
					layer.confirm('您确定删除此订单吗?', {icon: 3, title:'提示'}, function(index){
						var formdata = new FormData();
						formdata.append('id', parseInt(row.inventoryCheckId));
						axios.post('/inventoryCheck/delete',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 30002){

								layui.table.reload('idTest');
								row = '';
							}

						}).catch(function (error) {
							console.log(error);
						});
					});
					
				}else{
					layer.msg('请选择订单')
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