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
		//	获取查看信息
		let formdata = new FormData();
		formdata.append('requisitionId',$('input[name="requisitionId"]').val());
		axios.post('/requisition/getRequisitionById',formdata
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="requisitionNumber"]').val(data.data.requisitionNumber);
				$('input[name="type"]').val(data.data.type);
				$('input[name="addtime"]').val(data.data.addtime);
				$('input[name="lotNumber"]').val(data.data.lotNumber);
				$('input[name="outWarehouseId"]').val(data.data.outWarehouseName);
				$('input[name="intoWarehouseId"]').val(data.data.intoWarehouseName);
				$('textarea[name="comment"]').text(data.data.comment);
				$('input[name="staffId"]').val(data.data.name);
				let requisitionDetailsList = [];
				$.each(data.data.requisitionDetailsList,function (i,item) {
					let obj = new Object();
					obj.partsCd = item.goods.partsCd;
					obj.goodsName = item.goods.goodsName;
					obj.specification = item.goods.specification;
					obj.unit = item.goods.unit;
					obj.quantity = item.quantity;
					obj.comment = item.comment;
					requisitionDetailsList.push(obj);
				});
				
				// 获取动态表格的数据
				table.reload('idTest', {
					data: requisitionDetailsList
				});
			}
		}).catch(function (error) {
			console.log(error);
		});


	})

});
