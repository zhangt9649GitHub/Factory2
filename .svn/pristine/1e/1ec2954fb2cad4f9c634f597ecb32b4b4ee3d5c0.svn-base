//天津库存表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			table = layui.table,
			laydate = layui.laydate,
			row;

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
			url: '/tjInventory/getTjGoodsKucunList',
			cols: [
				[
					{field: 'partsCd',title: '部品CD',unresize: true,templet: '#partsCd'}
					,{field: 'goodsName',title: '品名',unresize: true}
					,{field: 'specification',title: '规格',unresize: true}
					,{field: 'skgCount',title: '库存数量',unresize: true}
					,{field: 'warehouseName',title: '仓库',unresize: true}
					,{field: 'wpName',title: '库位',unresize: true}
					,{field: 'latestShipment',title: '最新出货数',unresize: true}
					,{field: 'aPrice',title: 'a单价',unresize: true}
					,{field: 'bPrice',title: 'b单价',unresize: true}
					,{field: 'amount',title: '金额',unresize: true}
					,{field: 'categoryName',title: '种类',unresize: true}
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
		let exportField = {
			partsCd: '',
			goodsName: '',
			specification: '',
			skgCount: '',
			warehouseName: '',
			wpName: '',
			latestShipment: '',
			aPrice: '',
			bPrice: '',
			amount: '',
			category: ''
		};
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
					skgCount: $.trim(data.field.skgCount),
					warehouseName: $.trim(data.field.warehouseName),
					wpName: $.trim(data.field.wpName),
					latestShipment: $.trim(data.field.latestShipment),
					aPrice: $.trim(data.field.aPrice),
					bPrice: $.trim(data.field.bPrice),
					amount: $.trim(data.field.amount),
					category: $.trim(data.field.category)

				}
			});
			exportField = data.field;
			return false;
		});


		// 触发事件
		var active = {
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			},
			// 导出
			export: function () {
				location.href = '/tjInventory/exportTjGoodsKucunList?partsCd='+$.trim(exportField.partsCd)+'&goodsName='+$.trim(exportField.goodsName)+'&specification='+$.trim(exportField.specification)+'&skgCount='+$.trim(exportField.skgCount)+'&warehouseName='+$.trim(exportField.warehouseName)+'&wpName='+$.trim(exportField.wpName)+'&latestShipment='+$.trim(exportField.latestShipment)+'&aPrice='+$.trim(exportField.aPrice)+'&bPrice='+$.trim(exportField.bPrice)+'&amount='+$.trim(exportField.amount)+'&category='+$.trim(exportField.category) ;
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
