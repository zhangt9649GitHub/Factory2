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
			cols: [
				[
					{
						field: 'goodsNumber',
						title: '编号',
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
						field: 'stockQuantity',
						title: '库存数量',
						unresize: true
					}, {
						field: 'inventoryQuantity',
						title: '盘点数量',
						unresize: true
					}, {
						field: 'surplusQuantity',
						title: '盘盈数量',
						unresize: true
					}, {
						field: 'deficitQuantity',
						title: '盘亏数量',
						unresize: true
					}, {
						field: 'warehousePosition',
						title: '仓位',
						unresize: true
					}, {
						field: 'name',
						title: '盘点人',
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
		layer.load(1, {
			shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		let formdata = new FormData();
		formdata.append('id',$('input[name="inventoryCheckId"]').val());
		axios.post('/inventoryCheck/getById',formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					form.val('formTest',{
						"inventoryCheckNumber": data.data.inventoryCheckNumber,
						"fqTime": data.data.fqTime,
						"warehouseName": data.data.warehouseName,
						"name": data.data.name,
						"comment": data.data.comment
					});
					let inventoryCheckGoods = [];
					$.each(data.data.inventoryCheckGoods, function (i,item) {
						let arr = {
							"goodsNumber": item.goods.goodsNumber,
							"goodsId": item.goodsId,
							"partsCd": item.goods.partsCd,
							"goodsName": item.goods.goodsName,
							"specification": item.goods.specification,
							"unit": item.goods.unit,
							"stockQuantity": item.stockQuantity,
							"inventoryQuantity": item.inventoryQuantity,
							"surplusQuantity": item.surplusQuantity,
							"deficitQuantity": item.deficitQuantity,
							"warehousePosition": item.warehousePosition,
							"name": item.name
						};
						inventoryCheckGoods.push(arr)
					});
					table.reload('idTest', {
						data: inventoryCheckGoods
					});

				}
				layer.closeAll('loading'); //关闭加载层
			})









	})

});
