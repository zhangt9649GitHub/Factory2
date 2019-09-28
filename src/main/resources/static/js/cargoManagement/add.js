$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate',"table"], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;

		// 获取供应商列表
		axios.get(`/general/getSupplierNameList`)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function(i,item){
						$('select[name="supplierId"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
					});
					form.render('select');
				}
			});

		// 获取货物类别列表
		axios.post(`/goods/getGoodsCategoryList`)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function(i,item){
						$('select[name="category"]').append(`<option value="${item.key}">${item.value}</option>`)
					});
					form.render('select');
				}
			});

		// 获取货物品种
		axios.post(`/goods/getGoodsVarietyList`)
			.then(function(response){
				if(response.data.code == 0){
					$.each(response.data.data,function (i,item) {
						$('select[name="varietyValue"]').append(`<option value="${item.varietyValue}">${item.cnName}</option>`)
					});
					form.render('select');
				}
			});

		// 获取仓位
		axios.get(`/general/getWpNameList`)
			.then(function(response){
				if(response.data.code == 0){
					$.each(response.data.data,function (i,item) {
						$('select[name="wpId"]').append(`<option value="${item.wpId}">${item.wpName}</option>`)
					});
					form.render('select');
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
					{width: 80,align: 'center',toolbar: '#barDemo',unresize: true,fixed: 'left'}
					,{type: 'numbers',title: '序号',unresize: true}
					,{field: 'startNumber',title: '起始数量',unresize: true,edit: 'text'}
					,{field: 'endNumber',title: '结束数量',unresize: true,edit: 'text'}
					,{field: 'price',title: '价格',unresize: true,edit: 'text'}
				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});

		// 获取动态表格的数据
		var tableBak = table.cache['idTest'];
		// 循环显示5行
		for (let i = 0; i < 5; i++) {
			tableBak.push({});
		}
		table.reload('idTest', {
			data: tableBak
		});


		// 监听数据表格单元格编辑
		table.on('edit(demo)', function(obj) {
			// console.log(obj.value); //得到修改后的值
			// console.log(obj.field); //当前编辑的字段名
			// console.log(obj.data); //所在行的所有相关数据

			let data = obj.data;
			let tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据

			let tableBak = table.cache['idTest'];
			if($.trim(obj.value).length > 0){
				if(isNaN($.trim(obj.value))){
					layer.msg('只能输入数字', {
						icon: 5
					});
                    data[obj.field] = '';
                    tableBak.splice(tr.attr('data-index'), 1, data);
                    table.reload('idTest', {
                        data: tableBak
                    });

				}else{
				    // 起始数量
				    if(obj.field == 'startNumber'){
                        if($.trim(data.endNumber).length > 0){
                            if(Number(obj.value) >= data.endNumber){
                                layer.msg('起始数量必须小于结束数量', {
                                    icon: 5
                                });
                                data[obj.field] = '';
                                tableBak.splice(tr.attr('data-index'), 1, data);
                                table.reload('idTest', {
                                    data: tableBak
                                });
                            }
                        }
                    }
                    // 起始数量
				    else if(obj.field == 'endNumber'){
                        if($.trim(data.startNumber).length > 0){
                            if(Number(obj.value) <= data.startNumber){
                                layer.msg('结束数量必须大于起始数量', {
                                    icon: 5
                                });
                                data[obj.field] = '';
                                tableBak.splice(tr.attr('data-index'), 1, data);
                                table.reload('idTest', {
                                    data: tableBak
                                });
                            }
                        }
                    }


                }
			}


		});




		// 监听表格工具栏操作
		table.on('tool(demo)', function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据
			var tableBak = table.cache['idTest'];

			if (layEvent === 'addRow') {
				// 新增行

				tableBak.push({});

				table.reload('idTest', {
					data: tableBak
				});

			} else if (layEvent === 'daleteRow') {
				// 删除行

				tableBak.splice(tr.attr('data-index'), 1);
				table.reload('idTest', {
					data: tableBak
				});

			}
		});






	
		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			let goodsLadderPriceList = [];
            let tableBak = table.cache['idTest'];
            for(let i in tableBak){
                if($.trim(tableBak[i].price).length > 0){
                    if($.trim(tableBak[i].startNumber).length > 0 && $.trim(tableBak[i].endNumber).length > 0){
                        let arr ={
                            startNumber: $.trim(tableBak[i].startNumber),
                            endNumber: $.trim(tableBak[i].endNumber),
                            price: $.trim(tableBak[i].price)
                        };
                        goodsLadderPriceList.push(arr);
                    }else {
                        layer.msg(`阶梯价格：第${Number(i)+1}行请输入完整的信息`, {
                            icon: 5
                        });
                        return false;
                    }


                }


            }
            if(goodsLadderPriceList.length == 0){
                layer.msg('请输入阶梯价格', {icon: 5});
                return false;
            }
            data.field.goodsLadderPriceList = goodsLadderPriceList;


			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/goods/insertGoods', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 10002) {
					setTimeout(function () {
						window.parent.location.reload(); //刷新父页面
					}, 1000);
				}else {
					// 取消禁止点击
					$(that).removeClass('zq-submit-disabled');
				}
			}).catch(function (error) {
					console.log(error);
			});

			return false;
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
