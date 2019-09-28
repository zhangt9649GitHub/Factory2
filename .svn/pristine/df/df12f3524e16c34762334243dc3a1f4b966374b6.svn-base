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
		axios.get('/general/getFormNumber?type=15'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="receiptNumber"]').val(data.data.number);
			}
		}).catch(function (error) {
			console.log(error);
		});


		// 获取收款类型
		axios.post('/receipt/getTypeList')
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

		// 获取销售收款付款方
		function getCustomerNameList(){
            axios.get('/general/getCustomerNameList')
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

		// 销售收款单据列表
		let associatedDocumentList;
		function getSaleData(val){

			$('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
			form.render('select');
			if($.trim(val).length == 0){
				return false;
			}

			let formdata = new FormData();
			formdata.append('id',val);

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


		// 采购退货收款
		let getPurchaseReturnOrderListData;
		function getPurchaseReturnOrderList(){
            axios.post('/receipt/getPurchaseReturnOrderList')
                .then(function (response) {
                    let data = response.data;
                    getPurchaseReturnOrderListData = data.data;
                    if(data.code == 0){
                        $.each(data.data,function (i,item) {
                            $('select[name="payerSelect"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
                        });
                        form.render('select');
                    }
                });
		}
		// 采购退货单据
		function purchaseReturnDocument(val){
            $('select[name="associatedDocumentSelect"]').html(`<option value=""></option>`);
            form.render('select');
            if($.trim(val).length == 0){
                return false;
            }
            console.log(val);
			$.each(getPurchaseReturnOrderListData,function (i,item){
                if(item.supplierId == val){
                    $('select[name="associatedDocumentSelect"]').append(`<option value="${item.proId}">${item.purchaseReturnOrderNumber}</option>`)
                }

                form.render('select');
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

				switch (data.value) {
					case '销售收款':
                        getCustomerNameList();
                        $('.select').show();
                        $('.input').hide();
                        $('input[name="amount"]').attr('readonly','readonly');
                        $('input[name="amountReceivable"]').attr('readonly','readonly');
                        $('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');
                        break;
                    case '采购退货收款':
                        getPurchaseReturnOrderList();
                        $('.select').show();
                        $('.input').hide();
                        $('input[name="amount"]').attr('readonly','readonly');
                        $('input[name="amountReceivable"]').attr('readonly','readonly');
                        $('input[name="pendingWriteOffAmount"]').attr('readonly','readonly');
                        break;
                    default:
                        $('.select').hide();
                        $('.input').show();
                        $('input[name="amount"]').removeAttr('readonly');
                        $('input[name="amountReceivable"]').removeAttr('readonly');
                        $('input[name="pendingWriteOffAmount"]').removeAttr('readonly');
                }
			}


		});

		// 监听付款方选择
		let oldPayerSelect;
		form.on('select(payerSelect)', function(data){
			// console.log(data.elem); //得到select原始DOM对象
			// console.log(data.value); //得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象
            var category = $('select[name="category"] option:selected').val();

			if(oldPayerSelect != data.value){
                oldPayerSelect = data.value;
				// 初始化表单
				form.val("formTest", {
					"amount": '',
					"amountReceivable": '',
					"pendingWriteOffAmount": '',
					"collectionAmount": '',
					"writeOffAmount": ''
				});

                switch (category) {
                    case "销售收款":
                        getSaleData(data.value);
                        break;
                    case "采购退货收款":
                        purchaseReturnDocument(data.value);
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
					// 初始化表单
					form.val("formTest", {
						"amount": '', // 单据金额
						"amountReceivable": '', // 应收金额
						"pendingWriteOffAmount": '',
						"collectionAmount": '',
						"writeOffAmount": ''
					});

				}else{

                	switch (category) {
						case '销售收款':
                            $.each(associatedDocumentList,function (i,item) {
                                if(item.salesOrderId == data.value){
                                    // 初始化表单
                                    form.val("formTest", {
                                        "amount": item.amount, // 单据金额
                                        "amountReceivable": item.outstandingAmount, // 应收金额
                                        "pendingWriteOffAmount": item.writeOffAmount,
                                        "collectionAmount": '',
                                        "writeOffAmount": ''
                                    });
                                }
                            });
							break;
						case '采购退货收款':
							$.each(getPurchaseReturnOrderListData,function(i,item){
								if(data.value == item.proId){
                                    // 初始化表单
                                    form.val("formTest", {
                                        "amount": item.purchaseReturnAmount, // 单据金额
                                        "amountReceivable": item.noneReceiveAmount, // 应收金额
                                        "pendingWriteOffAmount": item.pendingAmount, // 带核销金额
                                        "collectionAmount": '',
                                        "writeOffAmount": ''
                                    });
								}
							})
                    }


				}



			}


		});



		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			delete data.field.staffName;

			switch (data.field.category) {
				case '其他收款':
                case '罚款收款':

                    data.field.payer = $.trim(data.field.payerInput);
                    data.field.associatedDocument = $.trim(data.field.associatedDocumentInput);
                    break;
				default:
                    data.field.payer = $('select[name="payerSelect"] option:selected').text();
                    data.field.associatedDocument = $('select[name="associatedDocumentSelect"] option:selected').text();
                    data.field.payerId = data.field.payerSelect;
                    data.field.saleId = data.field.associatedDocumentSelect;
			}

			delete data.field.payerSelect;
			delete data.field.payerInput;
			delete data.field.associatedDocumentSelect;
			delete data.field.associatedDocumentInput;

			if((data.field.payer).length == 0 ){
				layer.msg('付款方不能为空', {icon: 5});
				return false;
			}
			if((data.field.associatedDocument).length == 0 ){
				layer.msg('关联单据不能为空', {icon: 5});
				return false;
			}
			if(Number(data.field.collectionAmount) > Number(data.field.amountReceivable) || Number(data.field.collectionAmount) <= 0 ){
				layer.msg('收款金额不能大于应收金额，且不能小于等于0！', {icon: 5});
				return false;
			}
			if(!data.field.pendingWriteOffAmount ){
				data.field.pendingWriteOffAmount = 0;
			}

			if(Number(data.field.writeOffAmount) > Number(data.field.pendingWriteOffAmount) ){
				layer.msg('核销金额不能大于待核销金额', {icon: 5});
				return false;
			}


			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/receipt/insert', data.field)
				.then(function (response) {

					layer.msg(response.data.msg);
					if (response.data.code == 30004) {
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

