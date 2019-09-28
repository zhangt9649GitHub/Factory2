$(document).ready(function(){
	layui.use(['form','layer'],function(){
		var form = layui.form,
			layer = layui.layer;
			
		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			if(!$.trim(data.field.jobNumber) || !data.field.password){
				$('.error-prompt span').text('Error,请输入账号或密码！');
				$('.error-prompt').show();
				return false;
			}
			data.field.jobNumber = $.trim(data.field.jobNumber);

			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/adminlogin/loginAdmin',data.field)
				.then(function(response){
					let data = response.data;

					if(data.code == 30011){
						$('.error-prompt').hide();
						layer.msg(data.msg, {
							icon: 1
						});
						setTimeout(function(){
							window.location.href = '/admin/index/index';
						},1000)

					}else{
						// 取消禁止点击
						$(that).removeClass('zq-submit-disabled');
						$('.error-prompt span').text(data.msg);
						$('.error-prompt').show();

					}
				});
			
			
			

			return false;
		});
		//回车事件
		document.onkeydown = function (event) {
			var e = event || window.event;
			if (e && e.keyCode == 13) { //回车键的键值为13
				$(".submit").click(); //调用登录按钮的登录事件
			}
		};
		
		// 关闭错误信息
		$('.error-prompt .layui-icon').click(function(){
			$('.error-prompt').hide();
		})
	})
});