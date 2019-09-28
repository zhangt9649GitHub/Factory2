//生产领料明细
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate,
			row;
			
		laydate.render({
			elem: '#laydate-1'
		});

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/pickingDetails/getPickingDetailsList',
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
						field: 'specification',
						title: '规格',
						unresize: true
					}, {
						field: 'quantity',
						title: '数量',
						unresize: true
					}, {
						field: 'name',
						title: '领料人',
						unresize: true
					}, {
						field: 'outWarehouseName',
						title: '领出仓库',
						unresize: true
					}, {
						field: 'intoWarehouseName',
						title: '领入仓库',
						unresize: true
					}, {
						field: 'addTime',
						title: '日期',
						unresize: true
					}, {
						field: 'pickingNumber',
						title: '领料单编号',
						unresize: true
					}, {
						field: 'lotNumber',
						title: '批号',
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

		// 查询
		form.on('submit(*)', function(data) {
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					partsCd: $.trim(data.field.partsCd),
					goodsName: $.trim(data.field.goodsName),
					specification: $.trim(data.field.specification),
					quantity: $.trim(data.field.quantity),
					name: $.trim(data.field.name),
					outWarehouseName: $.trim(data.field.outWarehouseName),
					intoWarehouseName: $.trim(data.field.intoWarehouseName),
					addTime: $.trim(data.field.addTime),
					pickingNumber: $.trim(data.field.pickingNumber),
					lotNumber: $.trim(data.field.lotNumber)

				}
			});
			return false;
		});


		// 触发事件
		var active = {
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			}
		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

});
