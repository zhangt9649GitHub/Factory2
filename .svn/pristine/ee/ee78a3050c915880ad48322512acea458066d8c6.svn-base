//采购订单-列表
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate','upload'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			upload = layui.upload,
			table = layui.table,
			row,
			purchaseOrderId = {purchaseOrderId: 0};

		// 创建时间
		laydate.render({
			elem: '#laydate-1'
		});
		// 入库时间
		laydate.render({
			elem: '#laydate-2'
		});
		// 交货日期
		laydate.render({
			elem: '#laydate-3'
		});
		// 付款时间
		laydate.render({
			elem: '#laydate-4'
		});


		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/purchaseOrder/getPurchaseOrderList',
			cols: [
				[
					{
						field: 'purchaseOrderNumber',
						title: '编号',
						unresize: true,
						templet: '#purchaseOrderNumber'
					}, {
						field: 'defineDate',
						title: '创建时间',
						unresize: true
					}, {
						field: 'name',
						title: '创建人',
						unresize: true
					}, {
						field: 'supplierName',
						title: '供应商',
						unresize: true
					}, {
						field: 'orderStatus',
						title: '订单状态',
						unresize: true,
						templet: "#orderStatus"
					}, {
						field: 'deliveryDate',
						title: '交货日期',
						unresize: true
					}, {
						field: 'storageTime',
						title: '入库时间',
						unresize: true
					}, {
						field: 'storageState',
						title: '入库状态',
						unresize: true,
						templet: '#storageState'
					}, {
						field: 'paymentStatus',
						title: '付款状态',
						unresize: true,
						templet: '#paymentStatus'
					},  {
						field: 'purchaseAmount',
						title: '采购金额',
						unresize: true
					}, {
						field: 'discountAmount',
						title: '折扣金额',
						unresize: true
					}, {
						field: 'actuallyPaidAmount',
						title: '实付金额',
						unresize: true
					}, {
						field: 'pendingAmount',
						title: '待付金额',
						unresize: true
					}, {
						field: 'paymentDate',
						title: '付款日期',
						unresize: true
					}, {
						field: 'purchaseType',
						title: '采购类型',
						unresize: true
					},  {
						field: 'comment',
						title: '备注',
						unresize: true
					}, {
						fixed: 'right',
						title:'操作',
						toolbar: '#barDemo',
						align:'center',
						width: 120
					}

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

		function f(val){

		}

		//监听行工具事件
		table.on('tool(demo)', function(obj){
			var data = obj.data;
			let formdata = new FormData();
			formdata.append('purchaseOrderId',data.purchaseOrderId);
			if(obj.event === 'reset'){
				layer.confirm('你确定要重置附件', function(index){
					layer.close(index);
					layer.msg('重置成功', {icon: 1});

					axios.post('/purchaseOrder/editFileAttachment',formdata)
						.then(function (response) {

							layer.msg(response.data.msg);
							if(response.data.code = 20022){
								layui.table.reload('idTest');
							}
						})

				});
			} else if(obj.event === 'detail'){
				// 查看
				location.href = '/purchaseOrder/selectFileAttachment?purchaseOrderId=' + data.purchaseOrderId;
			}
			else if(obj.event === 'upload'){
				// 附件导入
				$('body').append('<div class="layui-none" id="upload-' + data.purchaseOrderId + '"></div>');
				upload.render({
					elem: '#upload-' + data.purchaseOrderId //绑定元素
					,url: '/purchaseOrder/uploadFileAttachment' //上传接口
					,accept: 'file'
					,field: 'fileAttachment'
					,data: {
						purchaseOrderId: Number(data.purchaseOrderId)
					}
					,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
						$('#upload-' + data.purchaseOrderId).remove();
					}
					,done: function(res){
						//上传完毕回调
						layer.msg(res.msg);
						if(res.code = 20022){
							layui.table.reload('idTest');
						}

					}
					,error: function(index){
						//请求异常回调
						console.log(index);
					}
				});
				$('#upload-' + data.purchaseOrderId).click();



			}
		});

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					purchaseOrderNumber: $.trim(data.field.purchaseOrderNumber),
					defineDate: $.trim(data.field.defineDate),
					name: $.trim(data.field.name),
					supplierName: $.trim(data.field.supplierName),
					orderStatus: $.trim(data.field.orderStatus),
					deliveryDate: $.trim(data.field.deliveryDate),
					storageTime: $.trim(data.field.storageTime),
					storageState: $.trim(data.field.storageState),
					purchaseAmount: $.trim(data.field.purchaseAmount),
					discountAmount: $.trim(data.field.discountAmount),
					actuallyPaidAmount: $.trim(data.field.actuallyPaidAmount),
					pendingAmount: $.trim(data.field.pendingAmount),
					paymentDate: $.trim(data.field.paymentDate),
					paymentStatus: $.trim(data.field.paymentStatus),
					purchaseType: $.trim(data.field.purchaseType),
					comment: $.trim(data.field.comment)
				}
			});
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
					location.href = href + '?purchaseOrderId=' + row.purchaseOrderId;
				}else{
					layer.msg('请选择订单')
				}
			},
			delete: function(){
				if(row){
					if(row.storageState == 1 && row.paymentStatus ==1){
						layer.confirm('您确定删除此订单吗?', {icon: 3, title:'提示'}, function(index){
							let formdata = new FormData();
							formdata.append('purchaseOrderId', parseInt(row.purchaseOrderId));
							axios.post('/purchaseOrder/deletePurchaseOrder',formdata
							).then(function (response) {
								layer.close(index);
								layer.msg(response.data.msg);
								if(response.data.code == 20007){

									layui.table.reload('idTest');
								}

							});
						});

					}else{
						layer.msg('此订单已入库或已付款不可删除', {
							icon: 1
						});
					}

				}else{
					layer.msg('请选择订单')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 导出
			export: function () {
				// 导出列表
				// location.href = '/purchaseOrder/exportPurchaseOrderList';

				// 导出详情
				if(row){
					location.href = '/purchaseOrder/exportPurchaseOrderDetails?purchaseOrderId=' + row.purchaseOrderId;
				}else{
					layer.msg('请选择订单')
				}
			},
			editFinancialAmount: function(that,href){
				if(row){
					location.href = href + '?purchaseOrderId=' + row.purchaseOrderId;
				}else{
					layer.msg('请选择订单')
				}
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
