$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;




		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
					{
						type: 'checkbox',
						width: 55
					},
                    {
                        field: 'containerInfo',
                        title: '货柜信息',
                        unresize: true,
                        edit: 'text',
                        totalRowText: '合计（小写）',
                        width: 120
                    },
                    {
                        field: 'outQuantity',
                        title: '出货数量',
                        unresize: true,
                        edit: 'text'
                    },
                    {
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
					}, {
						field: 'goodsName',
						title: '商品名称',
						unresize: true
					}, {
						field: 'lotNumber',
						title: '批次',
						unresize: true
					}, {
						field: 'returnNumber',
						title: '回次',
						unresize: true,
					}, {
						field: 'boxesNumber',
						title: '箱数',
						unresize: true,
						totalRow: true
					}, {
						field: 'monthlySalesVolume',
						title: '月贩卖量',
						unresize: true
					}, {
						field: 'sellingMonths',
						title: '贩卖月数',
						unresize: true
					},  {
						field: 'skgCount',
						title: '现库存',
						unresize: true
					},  {
						field: 'unitPrice',
						title: '单价',
						unresize: true
					}, {
						field: 'quantity',
						title: '需求数量',
						unresize: true,
						totalRow: true
					}, {
						field: 'notOutQuantity',
						title: '未出货数量',
						unresize: true,
					}, {
						field: 'totalPrice',
						title: '总价',
						unresize: true,
						totalRow: true
					}, {
						field: 'netWeight',
						title: '净重',
						unresize: true,
						totalRow: true
					}, {
						field: 'grossWeight',
						title: '毛重',
						unresize: true,
						totalRow: true
					}, {
						field: 'volume',
						title: '体积',
						unresize: true,
						totalRow: true
					}, {
						field: 'customsCategory',
						title: '海关类别',
						unresize: true
					}, {
						field: 'seaTariffNumber',
						title: '海关税号',
						unresize: true
					}, {
						field: 'comment',
						title: '备注',
						unresize: true
					}, {
						field: 'status',
						title: '状态',
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

		// 获取编辑信息
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
		let formdata = new FormData();
		formdata.append('salesOrderId', parseInt($('input[name="salesOrderId"]').val()));
		axios.post('/salesOrder/getSalesOrderById', formdata
		).then(function (response) {
			let data = response.data;

			if(data.code == 0){

				let orderType;
				switch (data.data.orderType) {
					case 1:
						orderType = '日本出口';
						break;
					case 2:
						orderType = '天津贩卖';
						break;

				}

                let customerName = '';
                if( data.data.customer != null){

                    customerName = data.data.customer.customerName;
                }
				let staffName = '';
                if( data.data.staff != null){

                    staffName = data.data.staff.name;
                }

				form.val('formTest',{
					'salesOrderNumber': data.data.salesOrderNumber,
					'orderType': orderType,
					'addtime': data.data.addtime,
					'customerId': customerName,
					'comment': data.data.comment,
					'staffName': staffName
				});
				let salesOrderDetailsList = [];
				$.each(data.data.salesOrderDetailsList,function (i,item) {

					let status ;
					switch (item.status) {
						case 1:
                            status = '未出货';
                            break;
                        case 2:
                            status = '已部分出货';
                            break;
                        case 3:
                            status = '已出货';
                            break;
                    }

					let arr ={
						goodsId: item.goods.goodsId,
						partsCd: item.goods.partsCd,
						goodsName: item.goods.goodsName,
						lotNumber: item.lotNumber,
                        returnNumber: item.returnNumber,
						boxesNumber: item.goods.boxesNumber,
						monthlySalesVolume: item.goods.monthlySalesVolume,
						sellingMonths: item.goods.sellingMonths,
						skgCount: item.skgCount,
						unitPrice: item.unitPrice,
						quantity: item.quantity,
						totalPrice: item.totalPrice,
						netWeight: Number(item.goods.netWeight)* Number(item.quantity),
						grossWeight: Number(item.goods.grossWeight)* Number(item.quantity),
						volume: Number(item.goods.volume)* Number(item.quantity),

						// 记录净重/毛重/体积的初始值
						netWeight1: item.goods.netWeight,
						grossWeight1: item.goods.grossWeight,
						volume1: item.goods.volume,

						customsCategory: item.customsCategory,
						seaTariffNumber: item.seaTariffNumber,
						comment: item.comment,
						status: status,

						// 未出货数量
                        notOutQuantity: item.notOutQuantity,
						//出货数量
                        outQuantity: item.notOutQuantity,
						//	详情id
                        salesOrderDetailsId: item.salesOrderDetailsId
					};
					salesOrderDetailsList.push(arr);
				});


				table.reload('idTest', {
					data: salesOrderDetailsList
				});

			}
            layer.closeAll('loading'); //关闭加载层
		});

        // 监听数据表格单元格编辑
        var editOldValue;
        table.on('edit(demo)', function(obj) {
            // console.log(obj.value); //得到修改后的值
            // console.log(obj.field); //当前编辑的字段名
            // console.log(obj.data); //所在行的所有相关数据

            let data = obj.data;
            let tr = obj.tr; //获得当前行 tr 的DOM对象
            // 获取动态表格的数据
            let tableBak = table.cache['idTest'];

            if(obj.field == 'outQuantity'){

            	if(isNaN(obj.value) || Number(obj.value)>Number(data.notOutQuantity) || Number(obj.value)<= 0){
                    $(this).val(editOldValue);

                    layer.msg('出货数量请输入数字，且大于0小于未出货数量！');
				}

                return false;
            }

        });

        $('.zq-datatable').on('focus', '.layui-table-edit', function() {

            var that = $(this);

            // 报错编辑前的值
            editOldValue = $(that).val();
        });



        // 触发事件
		var active = {
			// 导出
            export:function () {
                let checkStatus = table.checkStatus('idTest');
                // console.log(checkStatus);
                var data = checkStatus.data;



                let salesOrderDetailsListDtoList = [];
                $.each(data,function (i,item) {
                	if(Number(item.notOutQuantity) > 0){
                        let arr= {
                            salesOrderDetailsId: item.salesOrderDetailsId,
                            containerInfo: item.containerInfo,
                            outQuantity: item.outQuantity
                        };
                        salesOrderDetailsListDtoList.push(arr);
					}

                });

                if(salesOrderDetailsListDtoList.length == 0 ){
                    layer.msg('请至少选择一条未出货数量不为0的数据');
                    return;
                }


                layer.prompt(
                    {title: '输入货单编号，并确认', formType: 0}
                    ,function(pass, index){
                        if($.trim(pass).length == 0){
                            layer.msg('请输入货单编号');
                            return;
                        }

                        let field = {
                            salesOrderDetailsListDtos:   JSON.stringify(salesOrderDetailsListDtoList),
                            shipmentNumber: $.trim(pass)
                        };
                        // console.log(field);

                        // location.href = '/salesOrder/exportSalesOrderDetailsList?salesOrderDetailsListDtoList='+ JSON.stringify(salesOrderDetailsListDtoList);
                        location.href = '/salesOrder/exportSalesOrderDetailsList?shipmentListDto='+ JSON.stringify(field);
                        layer.close(index);
                    });



                // layer.alert(JSON.stringify(data));

            }
		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');
			
			active[type] ? active[type].call(this, othis) : '';
		});
	
	
	
	})
});
