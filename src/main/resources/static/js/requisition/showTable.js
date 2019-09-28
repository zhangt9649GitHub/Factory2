$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate;

		// 弹出层的表格
		table.render({
			elem: '#showTable',
			height: 312,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/general/getGoodsListByWarehouseId',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true
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
						field: 'skgCount',
						title: '库存',
						unresize: true
					}, {
						field: 'averagePrice',
						title: '平均单价',
						unresize: true
					}
				]
			],
			where: {
				warehouseId: $('input[name="outWarehouseId"]').val()
			},
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
			parent.updateData(dataIndex, obj.data); // 调用父页面方法
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



	})

});
