$(document).ready(function(){

    layui.config({
        base: '/static/public/layui/formSelects/',
    }).extend({
        formSelects: 'formSelects-v4'
    });
	layui.use(['form', 'table', 'layer', 'laydate', 'table','formSelects'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
            formSelects = layui.formSelects,
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

        // 获取供应商列表
        function getSupplierNameList(){

            return axios.get(`/general/getSupplierNameList`)
                .then(function(response){
                    let data = response.data;
                    if(data.code == 0){
                        var arr = [];
                        $.each(data.data,function(i,item){

                            arr.push({
                                name: item.supplierName,
                                value: item.supplierId
                            });

                            // $('select[name="supplierId"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
                        });
                        layui.formSelects.data('supplierId', 'local', {
                            arr
                        });
                    }
                });
        }


        // 获取编辑信息
        axios.all([getSupplierNameList()])
            .then(axios.spread(function () {
                // 两个请求现在都执行完成
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
                            // 'supplierId': data.data.supplierName,
                            'wpId': data.data.wpName
                        });

                        // 多个供应商赋值
                        var goodsSupplierList = [];
                        $.each(data.data.goodsSupplierList,function(i,item){
                            goodsSupplierList.push(item.supplierId);
                        });

                        layui.formSelects.value('supplierId', goodsSupplierList);

                        $('#upload-image').attr('src',data.data.ufSavePath);
                        table.reload('idTest', {
                            data: data.data.goodsLadderPriceList
                        });

                    }

                });
            }));






	
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
