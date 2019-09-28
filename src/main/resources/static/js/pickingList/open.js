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
			data: [],
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
						field: 'getQuantity',
						title: '已领数量',
						unresize: true
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


		//	获取数据
		let formdata = new FormData();
		formdata.append('pickingId',$('input[name="pickingId"]').val());
		axios.post('/picking/getPickingById',formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){

					form.val('formTest',{
						pickingNumber: data.data.pickingNumber,
						addTime: data.data.addTime,
						lotNumber: data.data.lotNumber,
						comment: data.data.comment,
						outWarehouseId: data.data.outWarehouse.warehouseName,
						intoWarehouseId: data.data.intoWarehouse.warehouseName,
						staffName: data.data.staff.name
					});


					let pickingDetailsList = [];
					$.each(data.data.pickingDetailsList,function (i,item) {
						let arr ={
							goodsId: item.goods.goodsId,
							partsCd: item.goods.partsCd,
							goodsName: item.goods.goodsName,
							specification: item.goods.specification,
							unit: item.goods.unit,
							skgCount: item.skgCount,
							quantity: item.quantity,
                            getQuantity: item.getQuantity,
							comment: item.comment

						};
						pickingDetailsList.push(arr);
					});
					table.reload('idTest', {
						data: pickingDetailsList
					});
				}
			});
	
	
	
	})
});

