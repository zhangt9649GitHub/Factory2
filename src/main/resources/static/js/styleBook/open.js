$(document).ready(function(){
// 富文本编辑器初始化
	var E = window.wangEditor;
	var editor = new E('#editor','#editor1');
	// 隐藏“网络图片”tab

	editor.create();
	// 禁用编辑功能
	editor.$textElem.attr('contenteditable', false)

	//漂亮的滚动条
	$('#editor1>.w-e-text').niceScroll({
		cursorcolor: '#828e94'
	});
	layui.use(['form', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;


		//获取编辑信息
		let formdata = new FormData();
		formdata.append('styleBookId',$('input[name="styleBookId"]').val());
		axios.post('/styleBook/getStyleBookById',formdata)
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$('input[name="styleBookNumber"]').val(data.data.styleBookNumber);
					$('input[name="date"]').val(data.data.date);
					$('input[name="goodsName"]').val(data.data.goodsName);
					$('input[name="staffId"]').val(data.data.staffName);
					editor.txt.html(data.data.introduction);

				}
			}).catch(function (error) {
			console.log(error);
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

