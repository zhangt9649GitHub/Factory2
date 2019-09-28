$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate;

		// 弹出层的表格
		table.render({
			elem: '#showTable',
			height: 312,
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/productionOrder/getProductionOrderGoodsList',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
						fixed: 'left'
					}, {
						field: 'goodsName',
						title: '名称',
						unresize: true
					}, {
						field: 'specification',
						title: '规格',
						unresize: true
					}, {
						field: 'unit',
						title: '单位',
						unresize: true

					}, {
						field: 'totalTaskAmount',
						title: '总任务量',
						unresize: true
					}, {
						field: 'salesBooking',
						title: '销售预定数',
						unresize: true
					}, {
						field: 'skgCount',
						title: '现库存',
						unresize: true
					}, {
						field: 'serialNumber',
						title: '批次',
						unresize: true
					}, {
						field: 'cycle',
						title: '生产周期',
						unresize: true
					}

				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body.layui-table-main').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "0",
					zindex: '10001'
				});
			}
		});

		// 监听数据表格行双击事件
		table.on('rowDouble(showTable)', function(obj) {
			var dataIndex = $('input[name="dataIndex"]').val();
			// console.log(obj.data) //得到当前行数据
			parent.updateData(dataIndex,obj.data);	// 调用父页面方法
			window.parent.layer.closeAll('iframe'); //关闭弹出层
		});

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('showTable', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					partsCd: $.trim(data.field.partsCd),
					goodsName: $.trim(data.field.goodsName)

				}
			});
			return false;
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
