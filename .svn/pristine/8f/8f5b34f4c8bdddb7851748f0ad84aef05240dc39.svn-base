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
						totalRowText: '合计（小写）',
						width: 120
					}, {
						field: 'goodsName',
						title: '品名',
						unresize: false
					}, {
						field: 'unit',
						title: '单位',
						unresize: true
					}, {
						field: 'quantity',
						title: '数量'
					}, {
						field: 'inQuantity',
						title: '已入库数量'
					},  {
						field: 'purchasePrice',
						title: '单价',
						unresize: true
					}, {
						field: 'excludingTaxAmount',
						title: '不含税金额',
						unresize: true
					}, {
						field: 'taxRate',
						title: '税率',
						unresize: true
					}, {
						field: 'tax',
						title: '税额',
						unresize: true
					}, {
						field: 'taxIncludedAmount',
						title: '含税金额',
						unresize: true,
						totalRow: true
					}, {
						field: 'financeMoney',
						title: '财务金额',
						unresize: true,
						totalRow: true
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
		formdata.append('purchaseOrderId',$('input[name="purchaseOrderId"]').val());
		axios.post('/purchaseOrder/getPurchaseOrderById',formdata)
			.then(function(response){
				if(response.data.code == 0){
					let data = response.data.data;
					form.val('formTest',{
						'purchaseOrderNumber': data.purchaseOrderNumber,
						'salesOrderId': data.salesOrderNumber,
						'defineDate': data.defineDate,
						'deliveryDate': data.deliveryDate,
						'supplierId': data.supplierName,
						'purchaseType': data.purchaseType,
						'capital': data.capital,
						'comment': data.comment
					});
					let purchaseOrderDetailsList = [];
					$.each(data.purchaseOrderDetailsList,function(i,item){
						let arr = {
							goodsId: item.goods.goodsId,
							partsCd: item.goods.partsCd,
							goodsName: item.goods.goodsName,
							unit: item.goods.unit,
							quantity: item.quantity,
							inQuantity: item.inQuantity,
							purchasePrice: item.purchasePrice,
							excludingTaxAmount: item.excludingTaxAmount,
							taxRate: item.taxRate,
							tax: item.tax,
							taxIncludedAmount: item.taxIncludedAmount,
							financeMoney: item.financeMoney

						};
						purchaseOrderDetailsList.push(arr);
					});

					table.reload('idTest', {
						data: purchaseOrderDetailsList
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
