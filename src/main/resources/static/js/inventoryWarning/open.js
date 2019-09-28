$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate;

		// 弹出层的表格
		table.render({
			elem: '#idTest',
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			url: './open.json',
			cols: [
				[
					{type:'numbers'}
					,{field: 'field1',title: '时间',unresize: true}
					,{field: 'field2',title: '数量',unresize: true}
					,{field: 'field3',title: '当时总数量',unresize: true}
					,{field: 'field4',title: '类型',unresize: true}
					,{field: 'field5',title: '单据编号',unresize: true}
				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});








		// 触发事件
		var active = {



		};
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');
			console.log(type)
			active[type] ? active[type].call(this, othis) : '';
		});



	})

});
