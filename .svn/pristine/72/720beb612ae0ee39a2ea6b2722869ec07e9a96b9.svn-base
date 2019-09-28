$(document).ready(function(){
	$('.slimscrollleft').slimScroll({
		height: 'auto',
		position: 'right',
		size: "7px",
		color: '#828e94',
		wheelStep: 5
	});

	// 菜单展开一项时其它的关闭
	$('.sidebar .layui-nav-item>a').click(function(){

		if($(this).parent().hasClass('zq-nav-this')){
			$(this).parent().removeClass('zq-nav-this');
			$(this).siblings('.layui-nav-child').css('height','0px');
		}else{
			$(this).parent().siblings('.layui-nav-item').removeClass('zq-nav-this');
			$(this).parent().siblings('.layui-nav-item').find('.layui-nav-child').css('height','0px');
			$(this).parent().addClass('zq-nav-this');

			var length = $(this).siblings('.layui-nav-child').find('dd').length;
			var height = 40*length;
			height = height + 'px';
			$(this).siblings('.layui-nav-child').css('height',height);
		}

	});
	
	// 触发事件
	var active = {
		changePassword: function(that,href){
			if (href) {
				// location.href = href;
				zqIframeView('修改密码',href,400,300)
			} else {
				layer.msg('页面开发中')
			}
		},
		//退出登入
		signOut: function(){
			layer.confirm('您确定退出此系统吗?', {
				icon: 3,
				title: '提示'
			}, function(index) {
				axios.post('/adminlogin/logOutAdmin'
				).then(function (response) {
					if(response.data.code == 0){
						layer.close(index);
						layer.msg(response.data.msg, {
							icon: 1
						});
						setTimeout(function(){
							window.location.href = '/admin/index/login';
						},1000)
					}

				});
			});
		},
		shrink: function(){
			if($('.shrink i').hasClass('layui-icon-shrink-right')){
				$('.sidebar').toggleClass('left');
				$('.main').toggleClass('left');
				$('.shrink i').addClass('layui-icon-spread-left');
				$('.shrink i').removeClass('layui-icon-shrink-right');
			}else{
				$('.sidebar').toggleClass('left');
				$('.main').toggleClass('left');
				$('.shrink i').removeClass('layui-icon-spread-left');
				$('.shrink i').addClass('layui-icon-shrink-right');
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
	
});