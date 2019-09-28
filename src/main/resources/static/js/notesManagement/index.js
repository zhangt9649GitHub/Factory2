//注文书管理-列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate','upload'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			upload = layui.upload,
			laydate = layui.laydate,
			row;

		laydate.render({
			elem: '#laydate-1'
		});
		laydate.render({
			elem: '#laydate-2'
		});
		// 导入
		upload.render({
			elem: '#upload-file',
			url: '/noteDocument/importNoteDocumentExcel',
			accept: 'file',
			field: 'file', // 字段名
			before: function(){
				layer.load(1, {
					shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
			},
			done: function(res){
				layer.closeAll('loading'); //关闭加载层
				layer.msg(res.msg);
				if(res.code == 20027) {
					layui.table.reload('idTest');
				}
			},
			error: function(){
				layer.msg('上传失败',{icon:2})
			}

		});

		table.render({
			elem: '#idTest',
			height: 560,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			totalRow: true,
			url: '/noteDocument/getNoteDocumentList',
			cols: [
				[
					{type:'checkbox',width:30,fixed:'left'}
					,{field: 'noteDcNumber',title: '注文书号',unresize: true,templet: '#noteDcNumber',fixed:'left',totalRowText:'合计',width:160}
					,{field: 'productionInstructionId',title: '回次',unresize: true,fixed:'left'}
					,{field: 'partsCd',title: '部品CD',unresize: true,fixed:'left'}
					,{field: 'goodsName',title: '品名',unresize: true,fixed:'left'}
					,{field: 'supplierName',title: '供应商',unresize: true,fixed:'left'}
					,{field: 'count',title: '采购数量',unresize: true,totalRow:true}
					,{field: 'unit',title: '单位',unresize: true}
					,{field: 'price',title: '预计单价',unresize: true}
					,{field: 'money',title: '合计',unresize: true,totalRow:true}
					,{field: 'ndStatus',title: '状态',unresize: true,templet: '#ndStatus'}
					,{field: 'monthsInStock',title: '在库月数',unresize: true}
					,{field: 'tjStock',title: '在库数量（天津侧）',unresize: true,width: 160,totalRow:true}

					,{field: 'faZhuZhong',title: '发注中',unresize: true}
					,{field: 'faZhuCan',title: '发注残',unresize: true}
					,{field: 'yinDangCan',title: '引当残',unresize: true}
					,{field: 'annotation',title: '注文不足或多余在库',unresize: true,width: 160}

					,{field: 'defineDate',title: '采购日期',unresize: true}
					,{field: 'purchasePrice',title: '实际单价',unresize: true}
					,{field: 'deliveryDate',title: '交货期',unresize: true}
					,{field: 'storageState',title: '已到情况',unresize: true,templet: '#storageState'}
					,{field: 'storageTime',title: '到货日期',unresize: true}
					,{field: 'purchaseOrderNumber',title: '订单编号',unresize: true}
					,{field: 'specification',title: '规格数据',unresize: true}
					,{field: 'purchaseReturnSituation',title: '退换货情况',unresize: true ,templet: '#purchaseReturnSituation'}
					,{field: 'comment',title: '备注',unresize: true}

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
			// console.log(obj) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});

		// 查询
		var exportField = {
			noteDcNumber: ''
			,productionInstructionId: ''
			,partsCd: ''
			,goodsName: ''
			,supplierName: ''
			,count: ''
			,unit: ''
			,price: ''
			,money: ''
			,ndStatus: ''
			,monthsInStock: ''
			,tjStock: ''
			,faZhuZhong: ''
			,faZhuCan: ''
			,yinDangCan: ''
			,annotation: ''
			,defineDate: ''
			,purchasePrice: ''
			,deliveryDate: ''
			,storageState: ''
			,storageTime: ''
			,purchaseOrderNumber: ''
			,specification: ''
			,purchaseReturnSituation: ''
			,comment: ''

		};
		form.on('submit(*)', function(data) {

			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					noteDcNumber: $.trim(data.field.noteDcNumber)
					,productionInstructionId: $.trim(data.field.productionInstructionId)
					,partsCd: $.trim(data.field.partsCd)
					,goodsName: $.trim(data.field.goodsName)
					,supplierName: $.trim(data.field.supplierName)
					,count: $.trim(data.field.count)
					,unit: $.trim(data.field.unit)
					,price: $.trim(data.field.price)
					,money: $.trim(data.field.money)
					,ndStatus: $.trim(data.field.ndStatus)
					,monthsInStock: $.trim(data.field.monthsInStock)
					,tjStock: $.trim(data.field.tjStock)
					,faZhuZhong: $.trim(data.field.faZhuZhong)
                    ,faZhuCan: $.trim(data.field.faZhuCan)
					,yinDangCan:  $.trim(data.field.yinDangCan)
                    ,annotation:  $.trim(data.field.annotation)
					,defineDate: $.trim(data.field.defineDate)
					,purchasePrice: $.trim(data.field.purchasePrice)
					,deliveryDate: $.trim(data.field.deliveryDate)
					,storageState: $.trim(data.field.storageState)
					,storageTime: $.trim(data.field.storageTime)
					,purchaseOrderNumber: $.trim(data.field.purchaseOrderNumber)
					,specification: $.trim(data.field.specification)
					,purchaseReturnSituation: $.trim(data.field.purchaseReturnSituation)
					,comment: $.trim(data.field.comment)
				}
			});
			exportField = {
				noteDcNumber: $.trim(data.field.noteDcNumber)
				,productionInstructionId: $.trim(data.field.productionInstructionId)
				,partsCd: $.trim(data.field.partsCd)
				,goodsName: $.trim(data.field.goodsName)
				,supplierName: $.trim(data.field.supplierName)
				,count: $.trim(data.field.count)
				,unit: $.trim(data.field.unit)
				,price: $.trim(data.field.price)
				,money: $.trim(data.field.money)
				,ndStatus: $.trim(data.field.ndStatus)
				,monthsInStock: $.trim(data.field.monthsInStock)
				,tjStock: $.trim(data.field.tjStock)
                ,faZhuZhong: $.trim(data.field.faZhuZhong)
                ,faZhuCan: $.trim(data.field.faZhuCan)
                ,yinDangCan:  $.trim(data.field.yinDangCan)
                ,annotation:  $.trim(data.field.annotation)


				,defineDate: $.trim(data.field.defineDate)
				,purchasePrice: $.trim(data.field.purchasePrice)
				,deliveryDate: $.trim(data.field.deliveryDate)
				,storageState: $.trim(data.field.storageState)
				,storageTime: $.trim(data.field.storageTime)
				,purchaseOrderNumber: $.trim(data.field.purchaseOrderNumber)
				,specification: $.trim(data.field.specification)
				,purchaseReturnSituation: $.trim(data.field.purchaseReturnSituation)
				,comment: $.trim(data.field.comment)
			};

			return false;
		});


		// 触发事件
		var active = {
			edit: function(that, href) {
				if (row) {
					if(row.ndStatus == 1){
						if (href) {
							var url = href + '?ndid='+ row.ndid;
							zqIframeView('编辑',url)
						} else {
							layer.msg('页面开发中')
						}
					}else{
						layer.msg('已生成采购订单,不能编辑')
					}

				} else {
					layer.msg('请选择注文书')
				}
			},
			// 导出
			export: function () {

				// 导出列表
				location.href = '/noteDocument/exportNoteDocumentList?noteDcNumber=' + exportField.noteDcNumber
				+ '&productionInstructionId=' + exportField.productionInstructionId + '&partsCd=' + exportField.partsCd
				+ '&goodsName=' + exportField.goodsName + '&supplierName=' + exportField.supplierName
				+ '&count=' + exportField.count + '&unit=' + exportField.unit + '&price=' + exportField.price
				+ '&money=' + exportField.money + '&ndStatus=' + exportField.ndStatus + '&monthsInStock=' + exportField.monthsInStock
				+ '&tjStock=' + exportField.tjStock + '&defineDate=' + exportField.defineDate + '&purchasePrice=' + exportField.purchasePrice
				+ '&deliveryDate=' + exportField.deliveryDate + '&storageState=' + exportField.storageState + '&storageTime=' + exportField.storageTime
				+ '&purchaseOrderNumber=' + exportField.purchaseOrderNumber + '&specification=' + exportField.specification
				+ '&purchaseReturnSituation=' + exportField.purchaseReturnSituation + '&comment=' + exportField.comment
					+ '&faZhuCan=' + exportField.faZhuCan + '&yinDangCan=' + exportField.yinDangCan
                    + '&annotation=' + exportField.annotation;
			},
			//	生成采购订单
			generatingOrders: function (that,href) {
				let checkStatus = table.checkStatus('idTest');
				let noteDocument = [];
				let detailsId = '';
				$.each(checkStatus.data,function(i,item){

					if(i == 0){
						detailsId += item.ndid
					}else {
						detailsId +=',' + item.ndid
					}
					noteDocument.push({'ndid':item.ndid})
				});
				if(noteDocument.length == 0){
					layer.msg('最少选中一条信息');
					return;
				}
				console.log(detailsId);
				$(that).addClass('zq-submit-disabled');
				axios.post('/noteDocument/selectCreatePurchaseOrderNote',noteDocument)
					.then(function(response){
						if(response.data.code == 20013){
							location.href = href +'?detailsId='+ detailsId;
						}else{
							$(that).removeClass('zq-submit-disabled');
							layer.msg(response.data.msg);
						}
					})
			},
            // 重置
            reset: function () {
                $('.zq-search-form button[type="reset"]').click();
            }
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
