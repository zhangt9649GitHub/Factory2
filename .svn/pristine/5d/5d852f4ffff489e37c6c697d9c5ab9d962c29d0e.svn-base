// 收款单
$(document).ready(function(){
	layui.use(['form', 'table', 'layer','laydate'], function() {
	
		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			row;
			
		laydate.render({
			elem: '#chuangjianshijian'
		});
	
		table.render({
			elem: '#idTest',
			height: 520,
			method: 'post',
			page: true,
			cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
			url: '/receipt/getPageData',
			cols: [
				[{
					field: 'receiptNumber',
					title: '编号',
					unresize: true,
					templet: '#receiptNumber'
				}, {
					field: 'category',
					title: '收款类别',
					unresize: true
				}, {
					field: 'cjTime',
					title: '创建时间',
					unresize: true
				}, {
					field: 'payer',
					title: '付款方',
					unresize: true
				}, {
					field: 'collectionAmount',
					title: '收款金额',
					unresize: true
				},{
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
					receiptNumber: $.trim(data.field.receiptNumber),
					category: $.trim(data.field.category),
					cjTime: $.trim(data.field.cjTime),
					payer: $.trim(data.field.payer),
					collectionAmount: $.trim(data.field.collectionAmount),
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