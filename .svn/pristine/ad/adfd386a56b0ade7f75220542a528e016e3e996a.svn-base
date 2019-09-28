$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;







		// 获取编辑信息

		let formdata = new FormData();
		formdata.append('id',$('input[name="receiptId"]').val());
		axios.post('/receipt/getById',formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){

					form.val("formTest", {
						"receiptNumber": data.data.receiptNumber,
						"cjTime": data.data.cjTime,
						"category": data.data.category,
						"payer": data.data.payer,
						"associatedDocument": data.data.associatedDocument,
						"amount": data.data.amount,
						"amountReceivable": data.data.amountReceivable,
						"pendingWriteOffAmount": data.data.pendingWriteOffAmount,
						"collectionAmount": data.data.collectionAmount,
						"writeOffAmount": data.data.writeOffAmount,
						"paymentMethod": data.data.paymentMethod,
						"comment": data.data.comment,
						"name": data.data.name
					});
				}
			})







	})
});

