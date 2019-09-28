//工资单
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
			
		// 创建时间 
		laydate.render({
			elem: '#laydate-1'
		});
		// 开始日期
		laydate.render({
			elem: '#laydate-2'
		});
		// 结束日期
		laydate.render({
			elem: '#laydate-3'
		});
		// 付款日期
		laydate.render({
			elem: '#laydate-4'
		});
			
	
		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/payroll/getPayrollList',
			cols: [
				[
					{
						field: 'payrollNumber',
						title: '编号',
						unresize: true,
						templet: '#payrollNumber'
					}, {
						field: 'addTime',
						title: '创建时间',
						unresize: true
					}, {
						field: 'name',
						title: '创建人',
						unresize: true
					}, {
						field: 'startTime',
						title: '开始日期',
						unresize: true
					}, {
						field: 'endTime',
						title: '结束日期',
						unresize: true
					}, {
						field: 'state',
						title: '状态',
						unresize: true,
						templet: '#state'
					}, {
						field: 'paymentTime',
						title: '付款日期',
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

		form.on('submit(*)', function(data) {
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					payrollNumber: $.trim(data.field.payrollNumber),
					addTime: $.trim(data.field.addTime),
					name: $.trim(data.field.name),
					startTime: $.trim(data.field.startTime),
					endTime: $.trim(data.field.endTime),
					state: $.trim(data.field.state),
					paymentTime: $.trim(data.field.paymentTime)
				}
			});
			exportField = data.field;
			return false;
		});

	
		// 监听数据表格行单击事件

		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
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

						location.href = href + '?payrollId='+ row.payrollId;
					}else{
						layer.msg('页面开发中')
					}
				}else{
					layer.msg('请选择工资单')
				}
			},
			delete: function(){
				if(row){
					layer.confirm('您确定删除此工资单吗?', {icon: 3, title:'提示'}, function(index){
						var formdata = new FormData();
						formdata.append('payrollId', parseInt(row.payrollId));
						axios.post('/payroll/deletePayrollById',formdata
						).then(function (response) {
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 10004){
								layui.table.reload('idTest');
							}

						}).catch(function (error) {
							console.log(error);
						});
					});
					
				}else{
					layer.msg('请选择工资单')
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