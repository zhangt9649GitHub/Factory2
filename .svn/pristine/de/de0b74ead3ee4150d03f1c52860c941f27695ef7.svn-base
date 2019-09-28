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

					// 调出仓库
					$('select[name="staffId"]').append('<option value="'+ item.staffId +'">'+ item.name +'</option>')

				});


				form.render('select');
				active.getEditInfo();
			}
		}).catch(function (error) {
			console.log(error);
		});



		// 重名验证
		function warehouseNameCheck(data){
			var formdata = new FormData();
			formdata.append('warehouseId',data.warehouseId);
			formdata.append('warehouseName',data.warehouseName);
			return axios.post('/warehouse/warehouseNameCheck',formdata)
		}
		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			data.field.updateTime =new Date().Format("yyyy-MM-dd HH:mm:ss");
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
					axios.post('/warehouse/editWarehouse', data.field)
						.then(function (response) {
							layer.msg(response.data.msg);
							if (response.data.code == 20005) {
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
	
	
		// 触发事件
		var active = {
			getEditInfo: function(){
				var url = '/warehouse/selectEditWarehouse?warehouseId='+$('input[name="warehouseId"]').val();
				axios.get(url
				).then(function (response) {
					let data = response.data;
					if(data.code == 0) {
						$('input[name="warehouseName"]').val(data.data.warehouseName);
						$('textarea[name="comment"]').text(data.data.comment);

						$('select[name="state"] option').each(function(i,item){
							if($(item).val() == data.data.state){
								$(item).prop('selected',true);
								form.render('select');
							}
						});
						$('select[name="staffId"] option').each(function(i,item){
							if($(item).val() == data.data.staffId){
								$(item).prop('selected',true);
								form.render('select');
							}
						});
						form.render('select');
					}
				}).catch(function (error) {
					console.log(error);
				});
			}

		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');
			
			active[type] ? active[type].call(this, othis) : '';
		});
	
	
	
	})
});
