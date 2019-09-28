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
			// totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
					{
						width: 50,
						align: 'center',
						toolbar: '#barDemo',
						unresize: true,
						fixed: 'left'
					}, {
						type: 'numbers',
						title: '序号',
						unresize: true
					}, {
						field: 'bupincd',
						title: '部品CD',
						unresize: true,
						edit: 'text'
					}, {
						field: 'mingcheng',
						title: '名称',
						unresize: true,
						edit: 'text'
					}, {
						field: 'guige',
						title: '规格',
						unresize: true,
						edit: 'text',
					}, {
						field: 'danwei',
						title: '单位',
						unresize: true,
						edit: 'text'
					}, {
						field: 'shuliang',
						title: '数量',
						unresize: true,
						edit: 'text'
					}, {
						field: 'beizhu',
						title: '备注',
						unresize: true,
						edit: 'text'
					}
				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});
	
		// 获取动态表格的数据
		var tableBak = table.cache['idTest'];
		// 循环显示5行
		for (let i = 0; i < 5; i++) {
			tableBak.push({});
		}
		table.reload('idTest', {
			data: tableBak
		});
	
		// 监听数据表格行单击事件
		table.on('row(demo)', function(obj) {
	
			// console.log(obj.data) //得到当前行数据
			//标注选中样式
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});
	
		// 监听数据表格单元格编辑
		table.on('edit(demo)', function(obj) {
			// console.log(obj.value); //得到修改后的值
			// console.log(obj.field); //当前编辑的字段名
			// console.log(obj.data); //所在行的所有相关数据  
	
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据
			var tableBak = table.cache['idTest'];
			tableBak.splice(tr.attr('data-index'), 1, obj.data);
			table.reload('idTest', {
				data: tableBak
			});
			eachTd();
		});
	
		// 监听数据表格编辑框选中
		$('.zq-datatable').on('focus', '.layui-table-edit', function() {
			$('.zq-datatable .zq-fangdajing').remove();
			$('.zq-datatable .zq-input').remove();
			var that = $(this);
	
			//标注选中样式
			that.parents('tr').addClass('layui-table-click').siblings().removeClass('layui-table-click');
	
			var dataIndex = $(this).parents('tr').attr('data-index');
			var dataField = $(this).parents('td').attr('data-field');
	
			switch (dataField) {
				case 'date':
					let dateInput = `<input type="text" class="zq-input" id="dataTableDate">`;
					that.parent().append(dateInput);
					// 动态表格日期
					laydate.render({
						elem: '#dataTableDate', //指定元素
						show: true,
						value: that.val(),
						done: function(value) {
							// 获取动态表格的数据
							var tableBak = table.cache['idTest'];
							tableBak[dataIndex].date = value;
	
							table.reload('idTest', {
								data: tableBak
							})
							$('.zq-datatable .zq-input').remove();
							eachTd();
						}
					});
					break;
				default:
					let html =
						`<i class="zq-fangdajing" onclick="zqIframeShow('查看','/admin/requisition/showTable',${dataIndex})">
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
					that.parent().append(html);
					break;
			}
	
		});
	
	
	
	
		// 删除放大镜与输入框
		$('body').click(function() {
			$('.zq-datatable .zq-fangdajing').remove();
			$('.zq-datatable .zq-input').remove();
		});
	
	
		// 监听表格工具栏操作
		table.on('tool(demo)', function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据
			var tableBak = table.cache['idTest'];
			if (layEvent === 'addRow') {
				// 新增行
	
				tableBak.push({});
	
				table.reload('idTest', {
					data: tableBak
				});
				
				eachTd();
			} else if (layEvent === 'daleteRow') {
				// 删除行
	
				tableBak.splice(tr.attr('data-index'), 1);
				table.reload('idTest', {
					data: tableBak
				});
				eachTd();
			}
		});

		// 监听表单提交
		form.on('submit(*)', function(data) {
			console.log(data.field);
			return false;
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

function ml(dataIndex, data) {
	// 获取动态表格的数据
	var tableBak = table.cache['idTest'];
	tableBak.splice(dataIndex, 1, data);
	table.reload('idTest', {
		data: tableBak
	});
	
	eachTd();
}
function eachTd(){
	$('.zq-datatable .layui-table-body td[data-field="stock"]').each(function(i,item){
		var stock = $(item).text();
		var usageQuantity = $(item).siblings('td[data-field="usageQuantity"]').text();
		if(Number(stock) < Number(usageQuantity)){
			
			$(item).find('.layui-table-cell').addClass('zq-color-red')
		}else{
			$(item).find('.layui-table-cell').removeClass('zq-color-red')

		}
	})
}