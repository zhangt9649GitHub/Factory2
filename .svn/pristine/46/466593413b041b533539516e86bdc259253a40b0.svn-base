$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate', 'table'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;


		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[

					{type: 'numbers',title: '序号',unresize: true}
					,{field: 'startNumber',title: '起始数量',unresize: true}
					,{field: 'endNumber',title: '结束数量',unresize: true}
					,{field: 'price',title: '价格',unresize: true}
				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});


		// 获取编辑信息
		var formdata = new FormData();
		formdata.append('goodsId', parseInt($('input[name="goodsId"]').val()));
		axios.post('/goods/getGoodsById', formdata
		).then(function (response) {
			let data = response.data;
			if(data.code == 0){


				form.val('formTest',{
                    'goodsNumber': data.data.goodsNumber,
					'partsCd': data.data.partsCd,
					'goodsName': data.data.goodsName,
					'varietyValue': data.data.variety,
					'unit': data.data.unit,
					'specification': data.data.specification,
					'weight': data.data.weight,
					'unitPrice': data.data.unitPrice,
					'aPrice': data.data.aPrice,
					'bPrice': data.data.bPrice,
					'purchaseOrderQuantity': data.data.purchaseOrderQuantity,
					'sellingPrice': data.data.sellingPrice,
					'wholesalePrices': data.data.wholesalePrices,
					'minimumStock': data.data.minimumStock,
					'procurementReserveStockIndex': data.data.procurementReserveStockIndex,
					'japanStock': data.data.japanStock,
					'tjStock': data.data.tjStock,
					'purchasePrice': data.data.purchasePrice,
					'salaryPrice': data.data.salaryPrice,
					'averagePrice': data.data.averagePrice,
					'boxesNumber': data.data.boxesNumber,
					'monthlySalesVolume': data.data.monthlySalesVolume,
					'sellingMonths': data.data.sellingMonths,
					'netWeight': data.data.netWeight,
					'grossWeight': data.data.grossWeight,
					'volume': data.data.volume,
					'monthsInStock': data.data.monthsInStock,
					'category': data.data.categoryName,
					'supplierId': data.data.supplierName,
					'wpId': data.data.wpName
				});


				$('#upload-image').attr('src',data.data.ufSavePath);
				table.reload('idTest', {
					data: data.data.goodsLadderPriceList
				});

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
