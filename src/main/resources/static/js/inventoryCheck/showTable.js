$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate;

		// 弹出层的表格
		table.render({
			elem: '#showTable',
			height: 500,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: './showTable.json',
			cols: [
				[{
					field: 'bupincd',
					title: '部品CD',
					unresize: true
					
				}, {
					field: 'mingcheng',
					title: '名称',
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
					field: 'kucunshuliang',
					title: '库存数量',
					unresize: true
				}, {
					field: 'pandianshuliang',
					title: '盘点数量',
					unresize: true
				}, {
					field: 'panyingshuliang',
					title: '盘盈数量',
					unresize: true
				}, {
					field: 'pankuishuliang',
					title: '盘亏数量',
					unresize: true
				}, {
					field: 'cangwei',
					title: '仓位',
					unresize: true
				}, {
					field: 'pandianren',
					title: '盘点人',
					unresize: true
				}]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});

		// 监听数据表格行双击事件
		table.on('rowDouble(showTable)', function(obj) {
			var dataIndex = $('input[name="dataIndex"]').val();
			// console.log(obj.data) //得到当前行数据
			parent.ml(dataIndex, obj.data); // 调用父页面方法
			window.parent.layer.closeAll('iframe'); //关闭弹出层
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

})
