//出库明细
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

		laydate.render({
			elem: '#laydate-2'
			,range: '~'
		});

		// 获取货物类别列表
		axios.post(`/goods/getGoodsCategoryList`)
			.then(function(response){
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function(i,item){
						$('select[name="category"]').append(`<option value="${item.key}">${item.value}</option>`)
					});
					form.render('select');
				}
			});




		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/outboundOrderDetails/getOutboundOrderDetailsList',
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
						title: '出库数量',
						unresize: true
					}, {
						field: 'outboundOrderNumber',
						title: '出库单编号',
						unresize: true
					}, {
						field: 'addTime',
						title: '出库日期',
						unresize: true
					}, {
						field: 'type',
						title: '出库类型',
						unresize: true
					}, {
						field: 'warehouseName',
						title: '仓库',
						unresize: true
					}, {
						field: 'categoryName',
						title: '货物类别',
						unresize: true
					}, {
						field: 'amount',
						title: '金额',
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
			let dateRange = $('input[name="dateRange"]').val();
			data.field.startTime = $.trim(dateRange.substring(0,dateRange.indexOf('~')));
			data.field.endTime = $.trim(dateRange.substring(dateRange.indexOf('~') + 1));

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
					outboundOrderNumber: $.trim(data.field.outboundOrderNumber),
					addTime: $.trim(data.field.addTime),
					type: $.trim(data.field.type),
					warehouseName: $.trim(data.field.warehouseName),
					category: $.trim(data.field.category),
					amount: $.trim(data.field.amount),
					startTime: $.trim(data.field.startTime),
					endTime: $.trim(data.field.endTime)
				}
			});
			return false;
		});


		// 触发事件
		var active = {
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 搜索按钮
			search: function () {
				$('.zq-search-form .item button').eq(0).click();
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
