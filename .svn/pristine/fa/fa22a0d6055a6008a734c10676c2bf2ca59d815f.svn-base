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
			data: [],
			totalRow: true, //开启合计行区域
			cols: [
				[
					{
						type: 'numbers',
						unresize: true,
						title: '序号',
						totalRowText: '合计金额',
						width: 70
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
						field: 'amount',
						title: '入库数量',
						unresize: true
					}, {
						field: 'unitPrice',
						title: '单价',
						unresize: true
					}, {
						field: 'money',
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

		// 消耗列表
		// 弹出层的表格
		table.render({
			elem: '#idTest1',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			data: [],
			cols: [
				[
					{
						type: 'numbers',
						unresize: true,
						title: '序号'
					},{
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

		//	获取信息
		let formdata = new FormData();
		formdata.append('productionEntryId',$('input[name="productionEntryId"]').val());
		axios.post("/productionEntry/getProductionEntryInfoById",formdata)
			.then(function (response) {

				if(response.data.code == 0){
					let data = response.data.data;

					form.val('formTest',{
						'productionEntryNumber': data.productionEntryNumber,
						'addTime': data.addTime,
						'warehouseName': data.warehouseName,
						'lotNumber': data.lotNumber,
						'comment': data.comment,
						'name': data.name
					});
					//	生产货物
					let productionGoodsList = data.productionGoodsList;
					table.reload('idTest', {
						data: productionGoodsList
					});

					//	消耗货物
					let consumptionGoodsList = data.consumptionGoodsList;
					table.reload('idTest1', {
						data: consumptionGoodsList
					})
				}
			});






	})

});
