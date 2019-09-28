//生产日报
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
			url: '/productionDaily/getProductionDailyList',
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
						field: 'amount',
						title: '数量',
						unresize: true
					}, {
						field: 'addTime',
						title: '日期',
						unresize: true
					}, {
						field: 'productionEntryNumber',
						title: '单据编号',
						unresize: true
					}, {
						field: 'jobNumber',
						title: '员工编号',
						unresize: true
					}, {
						field: 'name',
						title: '员工姓名',
						unresize: true
					}, {
						field: 'machinaryCode',
						title: '机器编号',
						unresize: true
					}, {
						field: 'boxesNumber',
						title: '每箱个数',
						unresize: true
					}, {
						field: 'salary',
						title: '工资',
						unresize: true
					}, {
						field: 'serialNumber',
						title: '批次',
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
					amount: $.trim(data.field.amount),
					addTime: $.trim(data.field.addTime),
					productionEntryNumber: $.trim(data.field.productionEntryNumber),
					jobNumber: $.trim(data.field.jobNumber),
					name: $.trim(data.field.name),
					machinaryCode: $.trim(data.field.machinaryCode),
					boxesNumber: $.trim(data.field.boxesNumber),
					salary: $.trim(data.field.salary),
					serialNumber: $.trim(data.field.serialNumber),
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
