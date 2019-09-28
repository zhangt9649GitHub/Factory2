$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;
	
	
		// 动态表格
		table.render({
			elem: '#idTest',
			limit:10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计
			data:[],
			cols: [
				[
					{
						type: 'numbers',
						title: '序号',
						unresize: true
					}, {
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
						field: 'quantity',
						title: '数量',
						unresize: true
					}, {
						field: 'comment',
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
		formdata.append('refundPickingId',$('input[name="refundPickingId"]').val());
		axios.post(`/refundPicking/getRefundPickingById`,formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){

					form.val('formTest',{
						refundPickingNumber: data.data.refundPickingNumber,
						addTime: data.data.addTime,
						lotNumber: data.data.lotNumber,
						outWarehouseId: data.data.outWarehouse.warehouseName,
						intoWarehouseId: data.data.intoWarehouse.warehouseName,
						comment: data.data.comment,
						staffId: data.data.staff.name
					});

					let refundPickingDetailsList = [];
					$.each(data.data.refundPickingDetailsList,function (i,item) {
						let arr ={
							goodsId: item.goods.goodsId,
							partsCd: item.goods.partsCd,
							goodsName: item.goods.goodsName,
							specification: item.goods.specification,
							unit: item.goods.unit,
							skgCount: item.skgCount,
							quantity: item.quantity,
							comment: item.reason

						};
						refundPickingDetailsList.push(arr);
					});
					table.reload('idTest', {
						data: refundPickingDetailsList
					});
				}
			})
	
	
	
	})
});

