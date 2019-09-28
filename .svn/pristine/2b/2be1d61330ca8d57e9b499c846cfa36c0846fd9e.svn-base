//货单管理
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate,
			row;

		// 创建时间
        laydate.render({
            elem: '#laydate-1'
        });

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 150, // 定义所有常规单元格的最小宽度
			url: '/shipment/getShipmentList',
			cols: [
				[
					{field: 'shipmentNumber',title: '出货单编号',unresize: true,templet: '#shipmentNumber'}
					,{field: 'salesOrderNumber',title: '销售订单编号',unresize: true}
					,{field: 'state',title: '状态',unresize: true,templet: '#state'}
					,{field: 'addTime',title: '创建日期',unresize: true}
				]
			],
			done: function(response){

				row = '';
				//初始化
				$('.zq-search-form .search').css('margin-left',0);
				$(".layui-table-body.layui-table-main").scrollLeft(0);

				// 设置搜索滚动
				$('.zq-search-form .search').width($('.layui-table-view .layui-table-header table').width());


				// 监听查询滚动条的变化
				$(".layui-table-body.layui-table-main").scroll(function() {
					console.log();
					$('.zq-search-form .search').css('margin-left',-($(this).scrollLeft()));
				});

			}
		});

		// 监听数据表格行单击事件

		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});

		// 查询
		form.on('submit(*)', function(data) {
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
                    shipmentNumber: $.trim(data.field.shipmentNumber),
                    salesOrderNumber: $.trim(data.field.salesOrderNumber),
                    state: $.trim(data.field.state),
                    addTime: $.trim(data.field.addTime),
				}
			});
			return false;
		});


		// 触发事件
		var active = {
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
            // 更新状态
            updateStatus: function(){
                if(row){
					if(row.state == 2){
                        layer.confirm('您确定把此货单状态改为已出库吗?', {
                            icon: 3,
                            title: '提示'
                        }, function(index) {
                            layer.load(1, {
                                shade: [0.5,'#fff'] //0.1透明度的白色背景
                            });
                            let formdata = new FormData();
                            formdata.append('shipmentId',parseInt(row.shipmentId ));

                            axios.post('/shipment/updateShipmentState',formdata
                            ).then(function (response) {
                                layer.closeAll('loading'); //关闭加载层
                                layer.close(index);
                                layer.msg(response.data.msg);
                                if(response.data.code == 10008){

                                    layui.table.reload('idTest');
                                }

                            });
                        });
					}else{
                        layer.msg('此货单状态不为已配货，无法更新状态')
					}



                }else{
                    layer.msg('请选择一条货单')
                }
            },
		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

});
