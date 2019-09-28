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
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
						totalRowText: '合计金额'
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
						field: 'quantity',
						title: '出库数量',
						unresize: true
					}, {
						field: 'sellingPrice',
						title: '单价',
						unresize: true
					}, {
						field: 'amount',
						title: '金额',
						unresize: true,
						totalRow: true
					}, {
						field: 'comment',
						title: '备注',
						unresize: true
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


		//	获取编辑信息
		let formdata = new FormData();
		formdata.append('outboundOrderId',$('input[name="outboundOrderId"]').val());
		axios.post('/outboundOrder/getOutboundOrderById',formdata)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					$('input[name="outboundOrderNumber"]').val(data.data.outboundOrderNumber);
					$('input[name="addTime"]').val(data.data.addTime);
					$('input[name="warehouseId"]').val(data.data.warehouse.warehouseName);
					$('input[name="type"]').val(data.data.type);
					$('input[name="lotNumber"]').val(data.data.lotNumber);
					$('textarea[name="comment"]').text(data.data.comment);
					$('input[name="staffId"]').val(data.data.staff.name);

					let outboundOrderDetailsList = [];
					$.each(data.data.outboundOrderDetailsList,function (i,item) {
						let obj = new Object();
						obj.partsCd = item.goods.partsCd;
						obj.goodsName = item.goods.goodsName;
						obj.specification = item.goods.specification;
						obj.unit = item.goods.unit;
						obj.sellingPrice = item.goods.sellingPrice;
						obj.quantity = item.quantity;
						obj.amount = item.amount;
						obj.comment = item.comment;
						outboundOrderDetailsList.push(obj);
					});

					// 获取动态表格的数据
					table.reload('idTest', {
						data: outboundOrderDetailsList
					});
				}

			})



	})

});
