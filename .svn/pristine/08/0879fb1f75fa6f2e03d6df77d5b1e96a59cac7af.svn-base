//产品结构清单-列表
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate', 'upload'], function() {
	
		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			upload = layui.upload,
			row;
	
		// 创建时间
		laydate.render({
			elem: '#laydate-1'
		});

		// 导入
		upload.render({
			elem: '#upload-file',
			url: '/bomForm/importBomForm',
			accept: 'file',
			before: function(){
				layer.load(1, {
					shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
			},
			done: function(res){
				layer.closeAll('loading'); //关闭加载层
				layer.msg(res.msg);
				if(res.code == 10014) {
					layui.table.reload('idTest');
				}
			},
			error: function(){
				layer.msg('上传失败',{icon:2})
			}

		});


		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/bomForm/getBomFormList',
			cols: [
				[
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true,
						templet: '#partsCd'
					}, {
						field: 'goodsName',
						title: '品名',
						unresize: true
					}, {
						field: 'defineDate',
						title: '创建日期',
						unresize: true
					}
				
				]
			],
			done: function(response){
				row = '';

				//初始化
				$('.zq-search-form .search').css('margin-left',0);
				$(".layui-table-body.layui-table-main").scrollLeft(0);

				// 设置搜索滚动
				$('.zq-search-form .search').width($('.layui-table-view .layui-table-header table').width());


				// 监听查询滚动条的变化
				$(".layui-table-body.layui-table-main").scroll(function() {
					console.log();
					$('.zq-search-form .search').css('margin-left',-($(this).scrollLeft()));
				});

			}
		});
	
		// 监听数据表格行单击事件

		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});

		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					partsCd: $.trim(data.field.partsCd),
					goodsName: $.trim(data.field.goodsName),
					defineDate: $.trim(data.field.defineDate)

				}
			});
			return false;
		});
	
		// 触发事件
		var active = {
			add: function(that,href){
				if(href){
					location.href = href;
				}else{
					layer.msg('页面开发中')
				}
			},
			edit: function(that,href){
				if(row){
					if(href){
						location.href = href + '?bomId=' + row.bomId;
					}else{
						layer.msg('页面开发中')
					}
				}else{
					layer.msg('请选择一条数据')
				}
			},
			delete: function(){
				if(row){
					layer.confirm('您确定删除此数据吗?', {icon: 3, title:'提示'}, function(index){
						var formdata = new FormData();
						formdata.append('bomId', parseInt(row.bomId));
						axios.post('/bomForm/deleteBomFormById',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 20007){


								layui.table.reload('idTest');
							}

						}).catch(function (error) {
							console.log(error);
						});
					});
					
				}else{
					layer.msg('请选择一条数据')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
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