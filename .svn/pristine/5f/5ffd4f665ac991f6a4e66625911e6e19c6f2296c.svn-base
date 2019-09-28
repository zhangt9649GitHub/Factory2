// 经验值管理
$(document).ready(function(){
	layui.use(['form', 'table', 'layer'], function() {
	
		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table;
	
		table.render({
			elem: '#idTest',
			limit:10000,
			height: 312,
			cellMinWidth: 80 ,// 定义所有常规单元格的最小宽度
			url: './jingyanzhiguanli.json',
			cols: [
				[
					{
						field: 'huowu',
						title: '货物',
						unresize: true,
						templet: '#bianhao'
					}, {
						field: 'jingyanzhi',
						title: '经验值',
						unresize: true
					}
				
				]
			],
			where: {
				id: $('input[name="staffId"]').val()
			},
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});
	
		// 监听数据表格行单击事件
		
		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			var row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});
	
		// 触发事件
		var active = {
			
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