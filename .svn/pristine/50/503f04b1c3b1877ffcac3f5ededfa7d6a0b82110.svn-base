$(document).ready(function() {
	layui.use(['table', 'layer'], function() {

		var layer = layui.layer,
			table = layui.table;

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
						field: 'aPrice',
						title: '单价',
						unresize: true
					},  {
						field: 'quantity',
						title: '入库数量',
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
		formdata.append('id',$('input[name="storageAccessId"]').val());
		axios.post('/storageAcess/getById',formdata)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					$('input[name="storageNumber"]').val(data.data.storageNumber);
					$('input[name="rukuTime"]').val(data.data.rukuTime);
					$('input[name="warehouseId"]').val(data.data.warehouseName);
					$('input[name="type"]').val(data.data.type);
					$('input[name="lotNumber"]').val(data.data.lotNumber);
					$('textarea[name="comment"]').text(data.data.comment);
					$('input[name="createStaffId"]').val(data.data.name);

					let storageGoods = [];
					$.each(data.data.storageGoods,function (i,item) {
						let obj = new Object();
						obj.partsCd = item.goods.partsCd;
						obj.goodsName = item.goods.goodsName;
						obj.specification = item.goods.specification;
						obj.unit = item.goods.unit;
						obj.aPrice = item.goods.aPrice;
						obj.quantity = item.quantity;
						obj.amount = item.amount;
						obj.comment = item.comment;
						storageGoods.push(obj);
					});

					// 获取动态表格的数据
					table.reload('idTest', {
						data: storageGoods
					});
				}
			})






	})

});
