$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
	
		// 获取权限
		var index = layer.load(1, {
			shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		axios.get('/staffGroupAccess/accessTreeAll')
			.then(function(responent){
				if(responent.data.code == 0){
					let data = responent.data.data;

					// 一级
					for(let a in data){
						$(`.list`).append(
							`
								<div class="item item${a}">
									<div class="one">
										<input type="checkbox" name="" title="${data[a].accessName}" value="${data[a].accessId}" lay-skin="primary">
									</div>
									<div class="two">
										<ul>

										</ul>
									</div>
									<div class="there"></div>
								</div>
							`
						);

						// 二级
						let twoChildren = data[a].children;
						for(let b in twoChildren ){
							$(`.item.item${a} .two ul`).append(
								`
									<li>
										<input type="checkbox" name="" title="${twoChildren[b].accessName}" value="${twoChildren[b].accessId}" lay-skin="primary">
									</li>
								`
							);
							$(`.item.item${a} .there`).append(
								`
									<ul class="ul${b}"></ul>
								`
							);
							// 三级
							let threeChildren = twoChildren[b].children;
							for(let c in threeChildren){
								// console.log()
								$(`.item.item${a} .there .ul${b}`).append(
									`
										<li>
											<input type="checkbox" name="" title="${threeChildren[c].accessName}" value="${threeChildren[c].accessId}" lay-skin="primary">
										</li>
									`
								)
							}
						}



					}
					form.render('checkbox');
					layer.close(index);
				}else{
					layer.close(index);
				}

			});


	
	
		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			let accessIds = new Array();
			$('.layui-form-checkbox').each(function(){
				if($(this).hasClass('layui-form-checked')){
					// $(this).siblings('input').val();
					accessIds.push($(this).siblings('input').val())
				}
			});
			if(accessIds.length == 0){
				layer.msg('请选择权限！');
				return false;
			}
			data.field.accessIds = accessIds;
			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post('/staffGroupAccess/addGroupAccess', data.field)
				.then(function (response) {

					layer.msg(response.data.msg);
					if (response.data.code == 30004) {
						setTimeout(function () {
							window.parent.location.reload(); //刷新父页面
						}, 1000);
					}else{
						// 取消禁止点击
						$(that).removeClass('zq-submit-disabled');
					}

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
