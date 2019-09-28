
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
				editInfo()
			}
		}).catch(function (error) {
			console.log(error);
		});
		// 获取编辑信息
		function editInfo(){
			let wpId = $('input[name="wpId"]').val();
			axios.get('/warehousePosition/selectEditWP?warehousePositionId='+wpId
			).then(function (response) {
				let data = response.data;
				if(data.code == 0) {
					$('input[name="wpName"]').val(data.data.wpName);

					$('textarea[name="comment"]').text(data.data.comment);

					$('select[name="warehouseId"] option').each(function(i,item){

						if($(item).val() == data.data.warehouseId){
							$(item).prop('selected',true);
							form.render('select');
						}
					});
				}
			}).catch(function (error) {
				console.log(error);
			});
		}





		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			data.field.updateTime = new Date().Format("yyyy-MM-dd HH:mm:ss");
			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/warehousePosition/editWP', data.field)
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
})
