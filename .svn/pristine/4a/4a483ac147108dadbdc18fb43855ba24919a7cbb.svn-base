$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
	

		// 获取信息
		let formdata = new FormData();
		formdata.append('productionInstructionId',$('input[name="productionInstructionId"]').val());
		axios.post(`/productionInstruction/getProductionInstructionById`,formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$('input[name="serialNumber"]').val(data.data.serialNumber);
					$('textarea[name="comment"]').text(data.data.comment);
					$('select[name="state"] option').each(function (i,item) {
						if($(item).val() == data.data.state){
							$(item).prop('selected',true)
						}
					});
					form.render('select');
				}
			});
	
	
		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/productionInstruction/updateProductionInstructionInfo', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 10008) {
						setTimeout(function () {
							window.parent.location.reload(); //刷新父页面
						}, 1000);
					}else {
						// 取消禁止点击
						$(that).removeClass('zq-submit-disabled');
					}
				});
			return false;
		});
	
	

	
	
	})
});
