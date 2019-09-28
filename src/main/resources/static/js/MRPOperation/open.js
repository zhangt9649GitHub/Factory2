$(document).ready(function(){
	layui.config({
		base: '../../public/layui/'
	}).extend({
		treetable: 'treetable-lay/treetable'
	}).use(['form', 'table', 'layer', 'laydate','element','treetable'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			element = layui.element,
			treetable = layui.treetable;
			table = layui.table;


		treetable.render({
			elem: '#idTest',
			// height: 500,
			treeColIndex: 1, //树形图标显示在第几列
			treeSpid: 0, //最上级的父级id
			treeIdName: 'id', //id字段的名称
			treePidName: 'parentId', //pid字段的名称
			treeDefaultClose: true, //是否默认折叠
			treeLinkage: false, //父级展开时是否自动展开所有子级
			url: './menus.json',
			page: false,
			cols: [
				[{
					type: 'numbers'
				},
					{
						field: 'field1',
						minWidth: 200,
						title: '部品CD'
					},
					{
						field: 'field2',
						title: '货物名称'
					},
					{
						field: 'field3',
						title: '毛需求'
					},
					{
						field: 'id',
						title: 'Id'
					},
					{
						field: 'parentId',
						title: 'ParentId'
					}
				]
			]

		});
	
	
		// 动态表格
		table.render({
			elem: '#idTest1',
			limit:10000,
			// height: 500,
			// page: true,
			cellMinWidth: 60, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计
			url: 'open.json',
			cols: [
				[{
						type: 'checkbox',
						unresize: true
					}, {
						field: 'bupincd',
						title: '部品CD',
						unresize: true

					}, {
						field: 'name',
						title: '货物名称',
						unresize: true
					}, {
						field: 'guige',
						title: '规格',
						unresize: true
					}, {
						field: 'danwei',
						title: '单位',
						unresize: true
						
					}, {
						field: 'shuliang',
						title: '数量',
						unresize: true
					}, {
						field: 'dangqiankucun',
						title: '当前库存',
						unresize: true
					}, {
						field: 'zuidikucun',
						title: '最低库存',
						unresize: true
					}, {
						field: 'xucaigoushuliang',
						title: '需采购数量',
						unresize: true
					}
				]
			]
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
});

