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

				getEditInfo(data.data);
			}
		}).catch(function (error) {
			console.log(error);
		});
		 function getEditInfo(res){
			var url = '/warehouse/selectEditWarehouse?warehouseId='+$('input[name="warehouseId"]').val();
			axios.get(url
			).then(function (response) {
				let data = response.data;
				if(data.code == 0) {
					$('input[name="warehouseName"]').val(data.data.warehouseName);
					$('textarea[name="comment"]').text(data.data.comment);

					$.each(res,function (i,item) {
						if(item.staffId == data.data.staffId){
							$('input[name="staffId"]').val(item.name)
						}
					});
					var state;
					switch (data.data.state) {
						case 1:
							state = '空闲';
							break;
						case 2:
							state = '使用中';
							break;
					}
					$('input[name="state"]').val(state);
				}
			}).catch(function (error) {
				console.log(error);
			});
		}
	
	

	
	
	})
});
