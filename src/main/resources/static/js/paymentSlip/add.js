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
		//获取编号
		axios.get('/general/getFormNumber?type=16'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="paymentOrderNumber"]').val(data.data.number);
			}
		}).catch(function (error) {
			console.log(error);
		});


		// 获取付款类型
		axios.post('/paymentOrder/getPaymentTypeList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="category"]').append(`<option value="${item.value}">${item.bizName}</option>`)
					});
					form.render('select');
				}
			});
		// 获取支付方式
		axios.post('/general/getPayTypeList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="paymentMethod"]').append(`<option value="${item.value}">${item.bizName}</option>`)
					});
					form.render('select');
				}
			});

		// 采购付款的收款方
		function getSupplierNameList(){
			$('select[name="beneficiarySelect"]').html('<option value=""></option>');
			axios.get('/general/getSupplierNameList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="beneficiarySelect"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
						});

					}
					form.render('select');
				});
		}

		// 工资付款的收款方
		function getPayrollList(){
			$('select[name="beneficiarySelect"]').html('<option value=""></option>');
			axios.post('/paymentOrder/getPayrollList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						var staffIdList = [];
						$.each(data.data,function (i,item) {


							if(staffIdList.length == 0){
								staffIdList.push(item.staffId);
								$('select[name="beneficiarySelect"]').append(`<option value="${item.staffId}">${item.name}</option>`)
							}else{
								for(let a in staffIdList){
									if(staffIdList[a] != item.staffId){
										if(a == (staffIdList.length - 1)){
											staffIdList.push(item.staffId);
											$('select[name="beneficiarySelect"]').append(`<option value="${item.staffId}">${item.name}</option>`)
										}
									}else {
                                        return;
                                    }
								}
							}


						});

					}
					form.render('select');
				});
		}

		// 报销付款的收款方
		function getReimburseCreateStaffList(){
			$('select[name="beneficiarySelect"]').html('<option value=""></option>');
			axios.post('/paymentOrder/getReimburseCreateStaffList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						var staffIdList = [];
						$.each(data.data,function (i,item) {


							if(staffIdList.length == 0){
								staffIdList.push(item.createStaffId);
								$('select[name="beneficiarySelect"]').append(`<option value="${item.createStaffId}">${item.createName}</option>`)
							}else{
								for(let a in staffIdList){
									if(staffIdList[a] != item.createStaffId){
										if(a == (staffIdList.length - 1)){
											staffIdList.push(item.createStaffId);
											$('select[name="beneficiarySelect"]').append(`<option value="${item.createStaffId}">${item.createName}</option>`)
										}
									}else {
                                        return;
                                    }
								}
							}


						});

					}
					form.render('select');
				});
		}

		// 退货付款的收款方
		function getSalesReturnList(){
			$('select[name="beneficiarySelect"]').html('<option value=""></option>');
			axios.post('/paymentOrder/getSalesReturnList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						var staffIdList = [];
						$.each(data.data,function (i,item) {


							if(staffIdList.length == 0){
								staffIdList.push(item.customerId);
								$('select[name="beneficiarySelect"]').append(`<option value="${item.customerId}">${item.customerName}</option>`)
							}else{
								for(let a in staffIdList){
									if(staffIdList[a] != item.customerId){

										if(a == (staffIdList.length - 1)){
											staffIdList.push(item.customerId);
											$('select[name="beneficiarySelect"]').append(`<option value="${item.customerId}">${item.customerName}</option>`)
										}
									}else {
                                        return;
                                    }
								}
							}


						});

					}
					form.render('select');
				});
		}




		// 采购付款的单据列表
		let associatedDocumentList;
		function getPurchaseOrderBySupplierId(val){
			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			form.render('select');
			if($.trim(val).length == 0){
				return false;
			}

			axios.get(`/paymentOrder/getPurchaseOrderBySupplierId?supplierId=${val}`)
				.then(function(response){
					if(response.data.code == 0){
						associatedDocumentList = response.data.data;
						$.each(response.data.data,function (i,item) {

							$('select[name="associatedDocumentSelect"]').append(`<option value="${item.purchaseOrderId}">${item.purchaseOrderNumber}</option>`)
						});
						form.render('select');
					}
				})
		}

		// 获取工资付款的单据
		let getWageDocumentsData;
		function getWageDocumentsList(val){
			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			form.render('select');
			if($.trim(val).length == 0){
				return false;
			}
			axios.post('/paymentOrder/getPayrollList')
				.then(function(response){
					if(response.data.code == 0){
						getWageDocumentsData = response.data.data;
						$.each(response.data.data,function (i,item) {
							if(item.staffId == val){
								$('select[name="associatedDocumentSelect"]').append(`<option value="${item.payrollId}">${item.payrollNumber}</option>`)

							}
						});
						form.render('select');
					}
				})
		}

		// 获取报销付款的单据
		let getReimbursementDocumentsData;
		function getReimbursementDocumentsList(val){
			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			form.render('select');
			if($.trim(val).length == 0){
				return false;
			}
			axios.post('/paymentOrder/getReimburseCreateStaffList')
				.then(function(response){
					if(response.data.code == 0){
						getReimbursementDocumentsData = response.data.data;
						$.each(response.data.data,function (i,item) {
							if(item.createStaffId == val){
								$('select[name="associatedDocumentSelect"]').append(`<option value="${item.reimburseId}">${item.reimburseNumber}</option>`)

							}
						});
						form.render('select');
					}
				})
		}


		// 获取退货付款的单据
		let getReturnDocumentsData;
		function getReturnDocumentsList(val){
			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			form.render('select');
			if($.trim(val).length == 0){
				return false;
			}
			axios.post('/paymentOrder/getSalesReturnList')
				.then(function(response){
					if(response.data.code == 0){
						getReturnDocumentsData = response.data.data;
						$.each(response.data.data,function (i,item) {
							if(item.customerId == val){
								$('select[name="associatedDocumentSelect"]').append(`<option value="${item.salesReturnId}">${item.salesReturnNumber}</option>`)

							}
						});
						form.render('select');
					}
				})
		}



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
					"beneficiarySelectInput": '',
					"beneficiarySelectSelect": '',
					"associatedDocumentInput": '',
					"associatedDocumentSelect": '',
					"amount": '',
					"pendingPaymentAmount": '',
					"discountAmount": '',
					"pendingWriteOffAmount": '',
					"paymentAmount": '',
					"writeOffAmount": ''
				});
				switch (data.value) {
					case "采购付款":
						getSupplierNameList();
						$('.select').show();
						$('.input').hide();
						$('input[name="amount"]').attr('readonly','readonly');
						$('input[name="pendingPaymentAmount"]').attr('readonly','readonly');
						$('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');
						break;
					case "工资付款":
						getPayrollList();
						$('.select').show();
						$('.input').hide();
						$('input[name="amount"]').attr('readonly','readonly');
						$('input[name="pendingPaymentAmount"]').attr('readonly','readonly');
						$('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');

						$('input[name="discountAmount"]').attr('readonly','readonly');
						break;
					case "报销付款":
						getReimburseCreateStaffList();
						$('.select').show();
						$('.input').hide();
						$('input[name="amount"]').attr('readonly','readonly');
						$('input[name="pendingPaymentAmount"]').attr('readonly','readonly');
						$('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');

						$('input[name="discountAmount"]').attr('readonly','readonly');
						break;
					case "退货付款":
						getSalesReturnList();
						$('.select').show();
						$('.input').hide();
						$('input[name="amount"]').attr('readonly','readonly');
						$('input[name="pendingPaymentAmount"]').attr('readonly','readonly');
						$('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');

						$('input[name="discountAmount"]').attr('readonly','readonly');
						break;
					default:
						$('.select').hide();
						$('.input').show();
						$('input[name="amount"]').removeAttr('readonly');
						$('input[name="pendingPaymentAmount"]').removeAttr('readonly');
						$('input[name="pendingWriteOffAmount"]').removeAttr('readonly');

						$('input[name="discountAmount"]').removeAttr('readonly');
				}

			}


		});

		// 监听收款方选择
		let oldBeneficiarySelect;
		form.on('select(beneficiarySelect)', function(data){
			var category = $('select[name="category"] option:selected').val();
			if(oldBeneficiarySelect != data.value){
				oldBeneficiarySelect = data.value;
				// 初始化表单
				form.val("formTest", {
					"amount": '',
					"pendingPaymentAmount": '',
					"discountAmount": '',
					"pendingWriteOffAmount": '',
					"paymentAmount": '',
					"writeOffAmount": ''
				});
				switch (category) {
					case "采购付款":
						getPurchaseOrderBySupplierId(data.value);
						break;
					case "工资付款":
						getWageDocumentsList(data.value);
						break;
					case "报销付款":
						getReimbursementDocumentsList(data.value);
						break;
					case "退货付款":
						getReturnDocumentsList(data.value);
						break;
				}


			}


		});

		// 监听单据选择
		let oldAssociatedDocumentSelect ;
		form.on('select(associatedDocumentSelect)', function(data){
			// console.log(data.elem); //得到select原始DOM对象
			// console.log(data.value); //得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象
			var category = $('select[name="category"] option:selected').val();
			if(oldAssociatedDocumentSelect != data.value){
				oldAssociatedDocumentSelect = data.value;


				if((data.value).length == 0){
					form.val("formTest", {
						"amount": '',
						"pendingPaymentAmount": '',
						"discountAmount": '',
						"pendingWriteOffAmount": '',
						"paymentAmount": '',
						"writeOffAmount": ''
					});
				}else{
					switch (category) {
						case "采购付款":
							$.each(associatedDocumentList,function (i,item) {
								if(item.purchaseOrderId == data.value){

									// 初始化表单
									form.val("formTest", {
										"amount": item.purchaseAmount,
										"pendingPaymentAmount": item.pendingAmount,
										"discountAmount": 0,
										"pendingWriteOffAmount": item.pendAmount,
										"paymentAmount": 0,
										"writeOffAmount": 0
									});
								}
							});
							break;
						case "工资付款":
							$.each(getWageDocumentsData,function (i,item) {
								if(item.payrollId == data.value){
									// 初始化表单
									form.val("formTest", {
										"amount": item.totalWages,
										"pendingPaymentAmount": item.totalWages,
										"discountAmount": 0,
										"pendingWriteOffAmount": 0,
										"paymentAmount": 0,
										"writeOffAmount": 0
									});
								}
							});
							break;
						case "报销付款":
							$.each(getReimbursementDocumentsData,function (i,item) {
								if(item.reimburseId == data.value){
									// 初始化表单
									form.val("formTest", {
										"amount": item.amount,
										"pendingPaymentAmount": item.amount,
										"discountAmount": 0,
										"pendingWriteOffAmount": 0,
										"paymentAmount": 0,
										"writeOffAmount": 0
									});
								}
							});
							break;
						case "退货付款":

							$.each(getReturnDocumentsData,function (i,item) {
								if(item.salesReturnId == data.value){
									// 初始化表单
									form.val("formTest", {
										"amount": item.amount,
										"pendingPaymentAmount": item.outstandingAmount,
										"discountAmount": 0,
										"pendingWriteOffAmount": item.customer.writeOffAmount,
										"paymentAmount": 0,
										"writeOffAmount": 0
									});
								}
							});
							break;
					}
				}



			}


		});



		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			delete data.field.staffName;
			switch (data.field.category) {
				case '其他付款':

					data.field.beneficiary = $.trim(data.field.beneficiaryInput);
					data.field.associatedDocument = $.trim(data.field.associatedDocumentInput);
					break;
				default:
					data.field.beneficiary = $('select[name="beneficiarySelect"] option:selected').text();
					data.field.associatedDocument = $('select[name="associatedDocumentSelect"] option:selected').text();
					data.field.beneficiaryId = data.field.beneficiarySelect;
					data.field.associatedDocumentId = data.field.associatedDocumentSelect;

			}

			delete data.field.beneficiarySelect;
			delete data.field.beneficiaryInput;
			delete data.field.associatedDocumentSelect;
			delete data.field.associatedDocumentInput;
			if((data.field.beneficiary).length == 0 ){
				layer.msg('付款方不能为空', {icon: 5});
				return false;
			}
			if((data.field.associatedDocument).length == 0 ){
				layer.msg('关联单据不能为空', {icon: 5});
				return false;
			}
			if(Number(data.field.paymentAmount) <= 0){
				layer.msg('付款金额不能小于等于0！', {icon: 5});
				return false;
			}
			let sum = Number(data.field.paymentAmount) + Number(data.field.discountAmount);
			if( sum > Number(data.field.pendingPaymentAmount) ){
				layer.msg('付款金额与折扣金额相加不能大于代付款金额', {icon: 5});
				return false;
			}

			if(!data.field.pendingWriteOffAmount){
				data.field.pendingWriteOffAmount = 0;
			}

			if( Number(data.field.writeOffAmount) > Number(data.field.pendingWriteOffAmount) ){
				layer.msg(' 核销金额不能大于待核销金额', {icon: 5});
				return false;
			}



			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/paymentOrder/insertPaymentOrder', data.field)
				.then(function (response) {

					layer.msg(response.data.msg);
					if (response.data.code == 20003) {
						setTimeout(function () {
							location.href="/admin/paymentSlip/index";  //刷新父页面
						}, 1000);
					}else{
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

