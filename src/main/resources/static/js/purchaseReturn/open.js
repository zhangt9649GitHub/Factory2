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
			data:[],
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',

					}, {
						field: 'goodsName',
						title: '品名',

					}, {
						field: 'unit',
						title: '单位',

					}, {
						field: 'quantity',
						title: '退货数量',

					}, {
						field: 'price',
						title: '单价',

					}, {
						field: 'money',
						title: '总价',

					}, {
						field: 'reasonReturn',
						title: '退换原因',
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



		let formdata = new FormData();
		formdata.append('proId',$('input[name="proId"]').val());
		axios.post('/purchaseReturnOrder/getPurchaseReturnOrderByProId',formdata)
			.then(function(response){

				if(response.data.code == 0){
					let data = response.data.data;
					form.val('formTest',{
						purchaseReturnOrderNumber: data.purchaseReturnOrderNumber,
						defineDate: data.defineDate,
						supplierId: data.supplierName,
						purchaseOrderId: data.purchaseOrderNumber,
						comment: data.comment
					});

					let purchaseReturnOrderDetailsList = [];
					$.each(data.purchaseReturnOrderDetailsList,function (i,item) {
						let arr = {
							goodsId: item.goodsId,
							partsCd: item.partsCd,
							goodsName: item.goodsName,
							unit: item.unit,
							quantity: item.returnQuantity,
							price: item.price,
							money: item.money,
							reasonReturn: item.reasonReturn,
						};
						purchaseReturnOrderDetailsList.push(arr);
					});
					table.reload('idTest', {
						data: purchaseReturnOrderDetailsList
					});


				}

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
