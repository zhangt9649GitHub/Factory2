//采购申请单-列表
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
		//创建时间
		laydate.render({
			elem: '#laydate-1'
		});



		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/purchaseApply/getPurchaseApplyList',
			cols: [
				[
					{type:'checkbox',width:30,fixed:'left'}
					,{field: 'partsCd',title: '部品CD',unresize: true,fixed:'left'}
					,{field: 'goodsName',title: '品名',unresize: true}
					,{field: 'quantity',title: '数量',unresize: true}
					,{field: 'unit',title: '单位',unresize: true}
					,{field: 'purchaseCycle',title: '采购周期要求',unresize: true}
					,{field: 'purpose',title: '用途说明',unresize: true}
					,{field: 'defineDate',title: '创建时间',unresize: true}
					,{field: 'name',title: '创建人',unresize: true}
					,{field: 'monthsInStock',title: '在库月数',unresize: true}
					,{field: 'tjStock',title: '在库数量（天津侧）',unresize: true,width: 180}
				
					,{field: 'supplierName',title: '供应商',unresize: true}
					,{field: 'stairPrice',title: '阶梯价格信息',unresize: true}
					,{field: 'handleStatus',title: '处理状态',unresize: true,templet: '#handleStatus'}
					// ,{field: 'handleIdea',title: '处理意见',unresize: true}
					,{field: 'specification',title: '规格数据',unresize: true}
					,{field: 'comment',title: '备注',unresize: true}
					,{field: 'purchaseNumber',title: '编号',unresize: true}
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

		var exportField = {
            partsCd: '',
			goodsName: '',
			quantity: '',
			unit: '',
			purchaseCycle: '',
			purpose: '',
			defineDate: '',
			name: '',
			monthsInStock: '',
			tjStock: '',




			stairPrice: '',
			orderStatus: '',
			handleStatus: '',
			handleIdea: '',
			specificationData: '',
			comment: '',
			purchaseNumber: ''
		};

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					partsCd: $.trim(data.field.partsCd),
					goodsName: $.trim(data.field.goodsName),
					quantity: $.trim(data.field.quantity),
					unit: $.trim(data.field.unit),
					purchaseCycle: $.trim(data.field.purchaseCycle),
					purpose: $.trim(data.field.purpose),
					defineDate: $.trim(data.field.defineDate),
					name: $.trim(data.field.name),
					monthsInStock: $.trim(data.field.monthsInStock),
					tjStock: $.trim(data.field.tjStock),




					stairPrice: $.trim(data.field.stairPrice),
					orderStatus: $.trim(data.field.orderStatus),
					handleStatus: $.trim(data.field.handleStatus),
					handleIdea: $.trim(data.field.handleIdea),
					specificationData: $.trim(data.field.specificationData),
					comment: $.trim(data.field.comment),
					purchaseNumber: $.trim(data.field.purchaseNumber)
				}
			});
			exportField = {
				partsCd: $.trim(data.field.partsCd),
				goodsName: $.trim(data.field.goodsName),
				quantity: $.trim(data.field.quantity),
				unit: $.trim(data.field.unit),
				purchaseCycle: $.trim(data.field.purchaseCycle),
				purpose: $.trim(data.field.purpose),
				defineDate: $.trim(data.field.defineDate),
				name: $.trim(data.field.name),
				monthsInStock: $.trim(data.field.monthsInStock),
				tjStock: $.trim(data.field.tjStock),




				stairPrice: $.trim(data.field.stairPrice),
				orderStatus: $.trim(data.field.orderStatus),
				handleStatus: $.trim(data.field.handleStatus),
				handleIdea: $.trim(data.field.handleIdea),
				specificationData: $.trim(data.field.specificationData),
				comment: $.trim(data.field.comment),
				purchaseNumber: $.trim(data.field.purchaseNumber)
			};
			return false;
		});



		// 触发事件
		var active = {
			add: function(that,href){
				if(href){
					location.href = href;
				}else{
					layer.msg('页面开发中')
				}
			},
			edit: function(that,href){
				if(row){

					if(row.handleStatus == 1){
						if(href){
							location.href = `${href}?purchaseApplyDetailsId=${row.purchaseApplyDetailsId}`;
						}else{
							layer.msg('页面开发中')
						}
					}else{
						layer.msg('已生成采购订单不可编辑')
					}


				}else{
					layer.msg('请选择一条数据')
				}
			},
			delete: function(){
				if(row){
					layer.confirm('您确定删除此数据吗?', {icon: 3, title:'提示'}, function(index){

						let formdata = new FormData();
						formdata.append('purchaseApplyDetailsId', parseInt(row.purchaseApplyDetailsId));
						axios.post('/purchaseApply/deletePurchaseApply',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 20007){

								layui.table.reload('idTest');
							}

						});
					});

				}else{
					layer.msg('请选择一条数据')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			//	生成采购订单
			generatingOrders: function (that,href) {
				let checkStatus = table.checkStatus('idTest');
				let purchaseApplyDetailsList = [];
				let detailsId = '';
				$.each(checkStatus.data,function(i,item){

					if(i == 0){
						detailsId += item.purchaseApplyDetailsId;
					}else{
						detailsId += ',' + item.purchaseApplyDetailsId;
					}


					purchaseApplyDetailsList.push({'purchaseApplyDetailsId':item.purchaseApplyDetailsId})
				});
				if(purchaseApplyDetailsList.length == 0){
					layer.msg('最少选中一条信息');
					return;
				}
				console.log(detailsId);
				$(that).addClass('zq-submit-disabled');
				axios.post('/purchaseApply/selectCreatePurchaseOrder',{purchaseApplyDetailsList:purchaseApplyDetailsList})
					.then(function(response){
						if(response.data.code == 20013){
							location.href = `${href}?detailsId=${detailsId}`;
						}else{
							$(that).removeClass('zq-submit-disabled');
							layer.msg(response.data.msg);
						}
					})
			},
			// 导出
			export: function () {
				// console.log(exportField.partsCd);
				location.href = '/purchaseApply/exportPurchaseApplyList?partsCd=' + exportField.partsCd + '&goodsName=' + exportField.goodsName
				+ '&quantity=' + exportField.quantity + '&unit=' + exportField.unit + '&purchaseCycle=' + exportField.purchaseCycle
				+ '&purpose=' + exportField.purpose + '&defineDate=' + exportField.defineDate + '&name=' + exportField.name
				+ '&monthsInStock=' + exportField.monthsInStock + '&tjStock=' + exportField.tjStock + '&stairPrice=' + exportField.stairPrice
				+ '&orderStatus=' + exportField.orderStatus + '&handleStatus=' + exportField.handleStatus + '&handleIdea=' + exportField.handleIdea
				+ '&specificationData=' + exportField.specificationData + '&comment=' + exportField.comment + '&purchaseNumber=' + exportField.purchaseNumber;
			}
		};
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

});
