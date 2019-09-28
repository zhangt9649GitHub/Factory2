//报销单
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;

		// 申请日期
		laydate.render({
			elem: '#laydate-1'
		});
	
		table.render({
			elem: '#idTest',
			height: 520,
			method: 'post',
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/reimburse/getReimburseList',
			cols: [
				[
					{
						field: 'reimburseNumber',
						title: '编号',
						unresize: true,
						templet: '#reimburseNumber'
					}, {
						field: 'createName',
						title: '报销人',
						unresize: true
					}, {
						field: 'applicationTime',
						title: '申请时间',
						unresize: true
					}, {
						field: 'amount',
						title: '金额',
						unresize: true
					}, {
						field: 'state',
						title: '状态',
						unresize: true,
						templet: '#state'
					}, {
						field: 'comment',
						title: '备注',
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
					reimburseNumber: $.trim(data.field.reimburseNumber),
					createName: $.trim(data.field.createName),
					applicationTime: $.trim(data.field.applicationTime),
					amount: $.trim(data.field.amount),
					state: $.trim(data.field.state),
					comment: $.trim(data.field.comment)
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
					if(row.state == 1){
						if(href){
							location.href = href + '?reimburseId=' + row.reimburseId;
						}else{
							layer.msg('页面开发中')
						}
					}else{
						layer.msg('此报销单已通过审核，不可再编辑')
					}

				}else{
					layer.msg('请选择报销单')
				}
			},
			delete: function(){
				if(row){
					layer.confirm('您确定删除此报销单吗?', {icon: 3, title:'提示'}, function(index){
						var formdata = new FormData();
						formdata.append('id', parseInt(row.reimburseId));
						axios.post('/reimburse/delete',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 30002){

								layui.table.reload('idTest');
								row = '';
							}

						}).catch(function (error) {
							console.log(error);
						});
					});
					
				}else{
					layer.msg('请选择报销单')
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