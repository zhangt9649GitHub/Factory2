$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;

		// 获取员工列表
		axios.get('/general/getStaffNameList'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$.each(data.data,function(i,item){

					$('select[name="staffId"]').append('<option value="'+ item.staffId +'">'+ item.name +'</option>')

				});


				form.render('select');
			}
		}).catch(function (error) {
			console.log(error);
		});

		// 重名验证
		function warehouseNameCheck(data){
			var formdata = new FormData();
			formdata.append('warehouseName',data.warehouseName);
			return axios.post('/warehouse/warehouseNameCheck',formdata)
		}

	

		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			data.field.createTime =new Date().Format("yyyy-MM-dd HH:mm:ss");
			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.all([warehouseNameCheck(data.field)])
				.then(axios.spread(function (acct) {

					if(acct.data.code != 20009){
						layer.msg(acct.data.msg);
						$(that).removeClass('zq-submit-disabled');
						return false;
					}
					// 两个请求现在都执行完成
					axios.post('/warehouse/addWarehouse', data.field)
						.then(function (response) {
							layer.msg(response.data.msg);
							if (response.data.code == 20003) {
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
				}));



			return false;
		});
	

	
	
	
	})
});
