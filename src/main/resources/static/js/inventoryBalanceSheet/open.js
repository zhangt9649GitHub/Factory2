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
					{type:'numbers'}
					,{field: 'skgCreateDatetime',title: '时间',unresize: true}
					,{field: 'skgCount',title: '数量',unresize: true}
					,{field: 'totalSkgCount',title: '当时总数量',unresize: true}
					,{field: 'skgType',title: '类型',unresize: true}
					,{field: 'skgSerialNumber',title: '单据编号',unresize: true}
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
		formdata.append('goodsId',$('input[name="goodsId"]').val());
		axios.post('/tjInventory/getTjGoodsKucunInfoById',formdata)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					form.val('formTest',{
						'partsCd': data.data.partsCd,
						'goodsName': data.data.goodsName,
						'specification': data.data.specification

					});

					table.reload('idTest', {
						data: data.data.stockKucunGoodsList
					});


				}
			})



	})

});
