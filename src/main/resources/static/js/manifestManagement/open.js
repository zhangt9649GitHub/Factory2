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
			// totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
                    {
                        field: 'containerInfo',
                        title: '货柜信息',
                        unresize: true,
                    },
                    {
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
					},
					{
						field: 'goodsName',
						title: '商品名称',
						unresize: true
					},
					{
						field: 'lotNumber',
						title: '批次',
						unresize: true
					},
					{
						field: 'returnNumber',
						title: '回次',
						unresize: true,
					},
					{
						field: 'boxesNumber',
						title: '箱数',
						unresize: true,
						totalRow: true
					},
                    {
                        field: 'outQuantity',
                        title: '出货数量',
                        unresize: true,
                    },



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
		formdata.append('shipmentId', Number($('input[name="shipmentId"]').val()));
		axios.post('/shipment/getShipmentById', formdata
		).then(function (response) {
			let data = response.data;
			if(data.code == 0){

				console.log(data);
				form.val('formTest',{
					'shipmentNumber': data.data.shipmentNumber,
					'addTime': data.data.addTime,
					'staffName': data.data.staff.name
				});
				let shipmentDetailsList = [];
				$.each(data.data.shipmentDetailsList,function (i,item) {
					let arr ={
						goodsId: item.goods.goodsId,
						partsCd: item.goods.partsCd,
						goodsName: item.goods.goodsName,
						// 批号
						lotNumber: item.lotNumber,
						// 回次
                        returnNumber: item.returnNumber,
						// 货柜信息
                        containerInfo: item.containerInfo,
						// 箱数
                        boxesNumber: item.boxesNumber,
						// 数量
                        outQuantity: item.outQuantity

					};
                    shipmentDetailsList.push(arr);
				});


				table.reload('idTest', {
					data: shipmentDetailsList
				});

			}
            layer.closeAll('loading'); //关闭加载层

		});


        // 触发事件
		var active = {
			// 打印
            print: function () {
                layer.confirm('是否打印？', {
                    btn: ['是','否'] //按钮
                }, function(){

                	axios.post('/shipment/updateShipmentPrint',{isPrint:1,shipmentId: Number($('input[name="shipmentId"]').val())})
						.then(function (response) {
                            layer.msg(response.data.msg)
                        })

                });
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
