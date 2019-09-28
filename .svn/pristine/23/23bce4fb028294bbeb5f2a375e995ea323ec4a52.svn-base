$(document).ready(function() {
	layui.use(['form', 'table', 'layer'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table;

		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计
			data: [],
			cols: [
				[
					{
						type: 'numbers',
						title: '序号',
						unresize: true,
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
						field: 'quantity',
						title: '排产数量',
						unresize: true
					}, {
						field: 'cycle',
						title: '生产周期',
						unresize: true
					}, {
						field: 'shift',
						title: '班次',
						unresize: true
					}, {
						field: 'serialNumber',
						title: '批次',
						unresize: true
					},  {
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


		// 获取信息
		let formdata = new FormData();
		formdata.append('productionOrderId',$('input[name="productionOrderId"]').val());
		axios.post('/productionOrder/getProductionOrderById',formdata)
			.then(function (response) {

				if(response.data.code == 0){
					let data = response.data.data;

					form.val('formTest',{
						'productionOrderNumber': data.productionOrderNumber,
						'addTime': data.addTime,
						'isCreatePicking': (data.isCreatePicking == 1)? true:false,
						'comment': data.comment,
						'name': data.staff.name
					});


					let productionOrderDetailsList = data.productionOrderDetailsList;
					if(productionOrderDetailsList.length >10){
						table.reload('idTest', {
							data: productionOrderDetailsList,
							height: 418
						});
					}else{
						table.reload('idTest', {
							data: productionOrderDetailsList
						});
					}



				}

			});



		// 触发事件
		var active = {

		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');

			active[type] ? active[type].call(this, othis) : '';
		});



	})
});
