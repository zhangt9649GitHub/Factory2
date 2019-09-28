//入库单
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
		// 入库时间
		laydate.render({
			elem: '#laydate-1'
		});

		table.render({
			elem: '#idTest',
			height: 520,
			method: 'post',
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/storageAcess/getStorageAccessList',
			cols: [
				[
					{
						field: 'storageNumber',
						title: '编号',
						unresize: true,
						templet: '#storageNumber'
					}, {
						field: 'rukuTime',
						title: '入库时间',
						unresize: true
					}, {
						field: 'name',
						title: '创建人',
						unresize: true
					}, {
						field: 'type',
						title: '入库类型',
						unresize: true,
						templet: '#type'
					}, {
						field: 'warehouseName',
						title: '仓库',
						unresize: true,
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
					storageNumber: $.trim(data.field.storageNumber),
					rukuTime: $.trim(data.field.rukuTime),
					name: $.trim(data.field.name),
					type: $.trim(data.field.type),
					warehouseName: $.trim(data.field.warehouseName),
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