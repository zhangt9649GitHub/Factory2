$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;


		// 获取信息
		let formdata = new FormData();
		formdata.append('varietyValue', $('input[name="varietyValue"]').val());
		axios.post('/goodVariety/getGoodsVarietyById',formdata)
			.then(function (response) {
				if(response.data.code == 0){
					let data = response.data.data;
					form.val('formTest',{
						cnName: data.cnName,
						elName: data.elName,
						jpName: data.jpName
					})
				}
			});



		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/goodVariety/updateGoodsVariety', data.field)
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
