$(document).ready(function() {
	layui.use(['table', 'layer', 'form'], function() {

		var layer = layui.layer,
			table = layui.table,
			form = layui.form;

		// 弹出层的表格
		table.render({
			elem: '#showTable',
			height: 350,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/general/getAllGoodsList',
			cols: [
				[
					{field: 'partsCd',title: '部品CD',fixed: 'left'}
					,{field: 'goodsName',title: '品名',}
					,{field: 'specification',title: '规格',}
					,{field: 'unit',title: '单位',}
					,{field: 'monthsInStock',title: '在库月数'}
					,{field: 'skgCount',title: '当前库存数'}
					,{field: 'purchaseOrderQuantity',title: '采购起订量'}
					,{field: 'ladderPrice',title: '阶梯价格信息'}
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
			let dataIndex = $('input[name="dataIndex"]').val();
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
