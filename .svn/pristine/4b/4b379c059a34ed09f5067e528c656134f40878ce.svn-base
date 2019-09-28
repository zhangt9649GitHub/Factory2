$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;
	

		// 获取编辑信息
		let formdata = new FormData();
		formdata.append("paymentOrderId",$('input[name="paymentOrderId"]').val());
		axios.post('/paymentOrder/getPaymentOrderById',formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					// 初始化表单
					form.val("formTest", {
						"paymentOrderNumber": data.data.paymentOrderNumber,
						"defineDate": data.data.defineDate,
						"category": data.data.category,
						"beneficiary": data.data.beneficiary,
						"beneficiarySelect": data.data.beneficiary,
						"associatedDocument": data.data.associatedDocument,
						"amount": data.data.amount,
						"pendingPaymentAmount": data.data.pendingPaymentAmountView,
						"discountAmount": data.data.discountAmount,
						"pendingWriteOffAmount": data.data.pendingWriteOffAmount,
						"paymentAmount": data.data.paymentAmount,
						"writeOffAmount": data.data.writeOffAmount,
						"paymentMethod": data.data.paymentMethod,
						"comment": data.data.comment,
						"name": data.data.name
					});

				}
			})
	
	
	
	})
});

