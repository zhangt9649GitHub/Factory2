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
			url: '/salesOrder/getJPExportsGoodsList',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD'
					}, {
						field: 'goodsName',
						title: '商品名称'
					},
					// {
					// 	field: 'lotNumber',
					// 	title: '批次'
					// },
					{
						field: 'boxesNumber',
						title: '每箱数量'
					}, {
						field: 'skgCount',
						title: '现库存'
					}, {
						field: 'monthlySalesVolume',
						title: '月贩卖量'
					}, {
						field: 'sellingMonths',
						title: '贩卖月数'
					}, {
						field: 'sellingPrice',
						title: '单价'
					}, {
						field: 'netWeight',
						title: '净重'
					}, {
						field: 'grossWeight',
						title: '毛重'
					}, {
						field: 'volume',
						title: '体积'
					}
				
				]
			],
			where: {
                orderType: $('input[name="orderType"]').val()
			},
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
				$('.layui-table-view .layui-table-body').getNiceScroll().resize();
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