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
			height: 500,
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/salesReturn/getSalesReturnGoodsList',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD'
					}, {
						field: 'goodsName',
						title: '商品名称',
					}, {
						field: 'lotNumber',
						title: '批次',
					}, {
						field: 'boxesNumber',
						title: '箱数'
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
						field: 'unitPrice',
						title: '单价'
					}, {
						field: 'quantity',
						title: '数量',
						totalRow: true
					}, {
						field: 'totalPrice',
						title: '总价',
						totalRow: true
					},  {
						field: 'netWeight',
						title: '净重'
					}, {
						field: 'grossWeight',
						title: '毛重'
					}, {
						field: 'volume',
						title: '体积'
					}, {
						field: 'customsCategory',
						title: '海关类别',
						unresize: true
					}, {
						field: 'seaTariffNumber',
						title: '海关税号',
						unresize: true
					}, {
						field: 'comment',
						title: '备注',
						unresize: true
					}
				
				]
			],
			where: {
				salesOrderId: $('input[name="salesOrderId"]').val()
			},
			parseData: function(res){
				// 重新编码返回信息
				$.each(res.data,function(i,item){
					item.goodsId = item.goods.goodsId;
					item.partsCd = item.goods.partsCd;
					item.goodsName = item.goods.goodsName;
					item.lotNumber = item.lotNumber;
					item.boxesNumber = item.goods.boxesNumber;
					item.monthlySalesVolume = item.goods.monthlySalesVolume;
					item.sellingMonths = item.goods.sellingMonths;
					item.skgCount = item.skgCount;
					item.netWeight = Number(item.goods.netWeight) * Number(item.quantity);
					item.grossWeight = Number(item.goods.grossWeight) * Number(item.quantity);
					item.volume = Number(item.goods.volume) * Number(item.quantity);
					// 记录净重/毛重/体积的初始值
					item.netWeight1 = item.goods.netWeight;
					item.grossWeight1 =item.goods.grossWeight;
					item.volume1 = item.goods.volume;
					// 记录数量的初始值
					item.quantity1 = item.quantity;
				});
			},
			done: function(res, curr, count){

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
			
			
			
		}
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');
			console.log(type)
			active[type] ? active[type].call(this, othis) : '';
		});
		
	
	
	})
	
})