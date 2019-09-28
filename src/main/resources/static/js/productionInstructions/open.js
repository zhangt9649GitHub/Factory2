$(document).ready(function(){
	layui.use(['table', 'layer','laytpl'], function() {

		var layer = layui.layer,
			table = layui.table,
			laytpl = layui.laytpl;


		// 获取信息
		var index = layer.load(1, {
			shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		let formdata = new FormData();
		formdata.append('productionInstructionId',$('input[name="productionInstructionId"]').val());
		axios.post(`/productionInstruction/getProductionInstructionDetailByPId`,formdata)
			.then(function (response) {

				if(response.data.code == 0){
					let data = response.data.data;

					var getTpl = document.getElementById('demo').innerHTML
						,view = document.getElementById('view');
					laytpl(getTpl).render(data, function(html){
						view.innerHTML = html;
					});

				}
				layer.close(index);
			});



		// 触发事件
		var active = {
			returnOperation: function(){
				zqDivShow('返品操作','#open','400','500')
			}
		};
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});
	
	
	})
	
});