$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;

		// 获取仓库列表
		axios.get('/general/getWarehouseNameList'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$.each(data.data,function(i,item){

					// 调出仓库
					$('select[name="warehouseId"]').append('<option value="'+ item.warehouseId +'">'+ item.warehouseName +'</option>')

				});


				form.render('select');
			}
		}).catch(function (error) {
			console.log(error);
		});


		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			data.field.createTime = new Date().Format("yyyy-MM-dd HH:mm:ss");


			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/warehousePosition/addWarehousePosition', data.field)
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
