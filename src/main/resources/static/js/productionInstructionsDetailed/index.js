//生产指示书明细-列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'upload','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			upload = layui.upload,
			laydate = layui.laydate,
			table = layui.table,
			row;




		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/productionInstructionGoods/getProductionInstructionList',
			cols: [
				[
					{field: 'serialNumber',title: '指示书编号',unresize: true,templet: '#serialNumber'}
					,{field: 'productName',title: '部品名称',unresize: true}
					,{field: 'partsCd',title: '部品CD',unresize: true}
					,{field: 'connectionNo',title: '连接NO',unresize: true}
					,{field: 'parentNo',title: '父NO',unresize: true}
					,{field: 'variety',title: '品种',unresize: true}
					,{field: 'productionSchedule',title: '生产预定数',unresize: true}
					,{field: 'unit',title: '单位',unresize: true}
					,{field: 'state',title: '状态',unresize: true,templet: '#state'}

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
					serialNumber: $.trim(data.field.serialNumber),
					productName: $.trim(data.field.productName),
					partsCd: $.trim(data.field.partsCd),
					connectionNo: $.trim(data.field.connectionNo),
					parentNo: $.trim(data.field.parentNo),
					variety: $.trim(data.field.variety),
					productionSchedule: $.trim(data.field.productionSchedule),
					unit: $.trim(data.field.unit),
					state: $.trim(data.field.state)

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
