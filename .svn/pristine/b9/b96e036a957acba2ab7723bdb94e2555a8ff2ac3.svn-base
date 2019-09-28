$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
		table = layui.table;

		// 日期
		laydate.render({
			elem: '#date' //指定元素
			,value: new Date()
		});


		// 获取收款类型
		function getTypeList(){
			return axios.post('/receipt/getTypeList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="category"]').append(`<option value="${item.value}">${item.bizName}</option>`)
						});
						form.render('select');
					}
				});
		}

		// 获取支付方式
		function getPayTypeList(){
			return axios.post('/general/getPayTypeList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="paymentMethod"]').append(`<option value="${item.value}">${item.bizName}</option>`)
						});
						form.render('select');
					}
				});
		}

		// 获取付款方
		function getCustomerNameList(){
			return axios.get('/general/getCustomerNameList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="payerSelect"]').append(`<option value="${item.customerId}">${item.customerName}</option>`)
						});
						form.render('select');
					}
				});
		}

		// 单据列表
		let associatedDocumentList;
		function getSaleData(val){
			let formdata = new FormData();
			formdata.append('id',val);
			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			axios.post('/receipt/getUnSaleData',formdata)
				.then(function(response){
					if(response.data.code == 0){
						associatedDocumentList = response.data.data;
						$.each(response.data.data,function (i,item) {

							$('select[name="associatedDocumentSelect"]').append(`<option value="${item.salesOrderId}">${item.salesOrderNumber}</option>`)
						});
						form.render('select');
					}
				})
		}


		// 获取编辑信息
		axios.all([getTypeList(), getPayTypeList(),getCustomerNameList()])
			.then(axios.spread(function (acct, perms) {
				// 两个请求现在都执行完成
				let formdata = new FormData();
				formdata.append('id',$('input[name="receiptId"]').val());
				axios.post('/receipt/getById',formdata)
					.then(function (response) {
						let data = response.data;
						if(data.code == 0){

							switch (data.data.category) {
								case '销售收款':
									$('.select').show();
									$('.input').hide();

									let formdata = new FormData();
									formdata.append('id',data.data.payerId);
									$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
									axios.post('/receipt/getUnSaleData',formdata)
										.then(function(response){
											if(response.data.code == 0){
												associatedDocumentList = response.data.data;
												$.each(response.data.data,function (i,item) {

													$('select[name="associatedDocumentSelect"]').append(`<option value="${item.salesOrderId}">${item.salesOrderNumber}</option>`)
												});
												form.render('select');

												form.val("formTest", {
													"receiptNumber": data.data.receiptNumber,
													"cjTime": data.data.cjTime,
													"category": data.data.category,
													"payerSelect": data.data.payerId,
													"associatedDocumentSelect": data.data.saleId,
													"amount": data.data.amount,
													"amountReceivable": data.data.amountReceivable,
													"pendingWriteOffAmount": data.data.pendingWriteOffAmount,
													"collectionAmount": data.data.collectionAmount,
													"writeOffAmount": data.data.writeOffAmount,
													"paymentMethod": data.data.paymentMethod,
													"comment": data.data.comment
												});


											}
										});



									break;
								default:
									$('.select').hide();
									$('.input').show();
									form.val("formTest", {
										"receiptNumber": data.data.receiptNumber,
										"cjTime": data.data.cjTime,
										"category": data.data.category,
										"payerInput": data.data.payer,
										"associatedDocumentInput": data.data.associatedDocument,
										"amount": data.data.amount,
										"amountReceivable": data.data.amountReceivable,
										"pendingWriteOffAmount": data.data.pendingWriteOffAmount,
										"collectionAmount": data.data.collectionAmount,
										"writeOffAmount": data.data.writeOffAmount,
										"paymentMethod": data.data.paymentMethod,
										"comment": data.data.comment
									});
									break;

							}
							$('select[name="staffId"] option').text(data.data.name);
							form.render('select');
						}
					})

			}));


		// 监听收款类型选择
		let oldCategory ;
		form.on('select(category)', function(data){
			// console.log(data.elem); //得到select原始DOM对象
			// console.log(data.value); //得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象

			if(oldCategory != data.value){
				oldCategory = data.value;
				// 初始化表单
				form.val("formTest", {
					"category": data.value,
					"payerInput": '',
					"payerSelect": '',
					"associatedDocumentInput": '',
					"associatedDocumentSelect": '',
					"amount": '',
					"amountReceivable": '',
					"pendingWriteOffAmount": '',
					"collectionAmount": '',
					"writeOffAmount": ''
				});
				if(data.value == "销售收款"){
					$('.select').show();
					$('.input').hide();
				}else{
					$('.select').hide();
					$('.input').show();
				}
			}


		});

		// 监听付款方选择
		let oldPayerSelect;
		// 单据列表
		form.on('select(payerSelect)', function(data){
			// console.log(data.elem); //得到select原始DOM对象
			// console.log(data.value); //得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象

			if(oldPayerSelect != data.value){
				oldCategory = data.value;
				// 初始化表单
				form.val("formTest", {
					"amount": '',
					"amountReceivable": '',
					"pendingWriteOffAmount": '',
					"collectionAmount": '',
					"writeOffAmount": ''
				});
				getSaleData(data.value);

			}


		});

		// 监听单据选择
		let oldAssociatedDocument ;
		form.on('select(associatedDocumentSelect)', function(data){
			// console.log(data.elem); //得到select原始DOM对象
			// console.log(data.value); //得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象

			if(oldAssociatedDocument != data.value){
				oldCategory = data.value;

				$.each(associatedDocumentList,function (i,item) {
					if(item.salesOrderId == data.value){
						// 初始化表单
						form.val("formTest", {
							"amount": item.amount, // 单据金额
							"amountReceivable": item.outstandingAmount, // 应收金额
							"pendingWriteOffAmount": '',
							"collectionAmount": '',
							"writeOffAmount": ''
						});
					}
				})

			}


		});



		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			switch (data.field.category) {
				case '销售收款':
					data.field.payer = $('select[name="payerSelect"] option:selected').text();
					data.field.associatedDocument = $('select[name="associatedDocumentSelect"] option:selected').text();
					data.field.payerId = data.field.payerSelect;
					data.field.saleId = data.field.associatedDocumentSelect;
					break;
				default:
					data.field.payer = $.trim(data.field.payerInput);
					data.field.associatedDocument = $.trim(data.field.associatedDocumentInput);
			}
			delete data.field.payerSelect;
			delete data.field.payerInput;
			delete data.field.associatedDocumentSelect;
			delete data.field.associatedDocumentInput;
			if((data.field.payer).length == 0 ){
				layer.msg('付款方不能为空', {icon: 5});
				return false;
			}
			if((data.field.payer).length == 0 ){
				layer.msg('关联单据不能为空', {icon: 5});
				return false;
			}
			if(data.field.collectionAmount > data.field.amountReceivable || data.field.collectionAmount <= 0 ){
				layer.msg('收款金额不能大于应收金额，且不能小于等于0！', {icon: 5});
				return false;
			}


			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/receipt/update', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 30006) {
						setTimeout(function () {
							location.href="/admin/receipt/index";  //刷新父页面
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

