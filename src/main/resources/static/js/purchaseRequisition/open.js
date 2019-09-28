$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;
	
		// 日期
		laydate.render({
			elem: '#date' //指定元素
		});
	
		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			url: 'showTable.json',
			cols: [
				[
					{field: 'bupincd',title: '部品CD',unresize: true}
					,{field: 'pinming',title: '品名',unresize: true}
					,{field: 'guige',title: '规格',unresize: true}
					,{field: 'shuliang',title: '数量',unresize: true}
					,{field: 'danwei',title: '单位',unresize: true}
					,{field: 'field1',title: '在库月数',unresize: true}
					,{field: 'field2',title: '当前库存数',unresize: true}
					,{field: 'caigouzhouqiyaoqiu',title: '采购周期要求',unresize: true}
					,{field: 'jietijiagexinxi',title: '阶梯价格信息',unresize: true}
					,{field: 'yongtushuoming',title: '用途说明',unresize: true}
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
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');
			
			active[type] ? active[type].call(this, othis) : '';
		});
	
	
	
	})
})

