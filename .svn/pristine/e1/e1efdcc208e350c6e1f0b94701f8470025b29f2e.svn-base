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

				editInfo(data.data);

			}
		}).catch(function (error) {
			console.log(error);
		});
		// 获取编辑信息
		function editInfo(res){
			let wpId = $('input[name="wpId"]').val();
			axios.get('/warehousePosition/selectEditWP?warehousePositionId='+wpId
			).then(function (response) {
				let data = response.data;
				if(data.code == 0) {
					$('input[name="wpName"]').val(data.data.wpName);

					$('textarea[name="comment"]').text(data.data.comment);

					$.each(res,function(i,item){
						if(item.warehouseId == data.data.warehouseId){
							$('input[name="warehouseId"]').val(item.warehouseName);
						}
					})
				}
			}).catch(function (error) {
				console.log(error);
			});
		}



	
	
	
	})
});
