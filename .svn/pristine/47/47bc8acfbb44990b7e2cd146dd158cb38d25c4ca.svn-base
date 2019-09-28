// 产品结构清单（BOM）
layui.use(['form', 'table', 'layer'], function() {

	var	layer = layui.layer,
		form = layui.form,
		table = layui.table;



	//获取编辑信息
	//获取编辑信息
	let formdata = new FormData();
	formdata.append('bomId ', $('input[name="bomId"]').val());
	axios.post('/bomForm/getBomFormDetailById',formdata
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$('input[name="bomNumber"]').val(data.data.bomNumber);
			$('input[name="defineDate"]').val(data.data.defineDate);
			$('textarea[name="comment"]').text(data.data.comment);

			// 主体部品
			let tableData = [
				{
					goodId: data.data.goodId,
					partsCd: data.data.partsCd,
					goodsName:data.data.goodsName,
					variety: data.data.variety,
					specification: data.data.specification,
					unit: data.data.unit,
					quantity: data.data.quantity,
				}
			];
			table.reload('idTest-1', {
				data: tableData
			});
			// 组成部分
			let bomFormDetailList = data.data.bomFormDetailList;
			table.reload('idTest', {
				data: bomFormDetailList
			});

		}
	});

	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 80, // 定义所有常规单元格的最小宽度
		// totalRow: true, //开启合计行区域
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
					title: '使用物料名称',
					unresize: true
				}, {
					field: 'variety',
					title: '品种',
					unresize: true
				},  {
					field: 'specification',
					title: '规格',
					unresize: true
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'quantity',
					title: '必要数量',
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



	// 动态表格-1
	table.render({
		elem: '#idTest-1',
		limit: 10000,
		cellMinWidth: 80, // 定义所有常规单元格的最小宽度
		// totalRow: true, //开启合计行区域
		data: [{}],
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
					title: '产品名称',
					unresize: true
				}, {
					field: 'variety',
					title: '品种',
					unresize: true
				},  {
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




});
