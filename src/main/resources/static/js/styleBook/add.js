$(document).ready(function(){
	// 富文本编辑器初始化
    var E = window.wangEditor;
    var editor = new E('#editor');

	editor.customConfig.uploadImgServer = '/styleBook/saveFile';
	editor.customConfig.uploadFileName = 'file';
	// 限制一次最多上传 1 张图片
	editor.customConfig.uploadImgMaxLength = 1;


	editor.create();



	//漂亮的滚动条
	$('#editor>.w-e-text-container>.w-e-text').niceScroll({
		cursorcolor: '#828e94'
	});
	layui.use(['form', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
	
		// 日期
		laydate.render({
			elem: '#date' //指定元素
			,value: new Date()
		});

		//获取编号
		axios.get('/general/getFormNumber?type=4'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="styleBookNumber"]').val(data.data.number);
			}
		}).catch(function (error) {
			console.log(error);
		});



		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			// 禁止点击
			data.field.introduction = editor.txt.html();
			$(that).addClass('zq-submit-disabled');

			axios.post('/styleBook/insertStyleBook', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 20003) {
						setTimeout(function () {
							location.href="/admin/styleBook/index"; //刷新父页面
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

