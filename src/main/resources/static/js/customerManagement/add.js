$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;
	
		// 日期
		laydate.render({
			elem: '#date' //指定元素
		});

		//获取编号
		axios.get('/general/getFormNumber?type=3'
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="customerNumber"]').val(data.data.number);
			}
		}).catch(function (error) {
			console.log(error);
		});



	
		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
					{
						width: 50,
						align: 'center',
						toolbar: '#barDemo',
						unresize: true,
						fixed: 'left'
					}, {
						field: 'name',
						title: '姓名',
						unresize: true,
						edit: 'text'
					}, {
						field: 'position',
						title: '部门职务',
						unresize: true,
						edit: 'text'
					}, {
						field: 'phone',
						title: '电话',
						unresize: true,
						edit: 'text',
					}, {
						field: 'mobile',
						title: '手机',
						unresize: true,
						edit: 'text'
					}, {
						field: 'mail',
						title: '电子邮件',
						unresize: true,
						edit: 'text'
					}
				]
			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});
	
		// 获取动态表格的数据
		var tableBak = table.cache['idTest'];
		// 循环显示5行
		for (let i = 0; i < 5; i++) {
			tableBak.push({});
		}
		table.reload('idTest', {
			data: tableBak
		});
	
		// 监听数据表格行单击事件
		table.on('row(demo)', function(obj) {
	
			// console.log(obj.data) //得到当前行数据
			//标注选中样式
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});
	
		// 监听数据表格单元格编辑
		table.on('edit(demo)', function(obj) {
			// console.log(obj.value); //得到修改后的值
			// console.log(obj.field); //当前编辑的字段名
			// console.log(obj.data); //所在行的所有相关数据  
	
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据
			var tableBak = table.cache['idTest'];
			tableBak.splice(tr.attr('data-index'), 1, obj.data);
			table.reload('idTest', {
				data: tableBak
			});

		});
	
		// 监听数据表格编辑框选中
		$('.zq-datatable').on('focus', '.layui-table-edit', function() {
			$('.zq-datatable .zq-fangdajing').remove();
			$('.zq-datatable .zq-input').remove();
			var that = $(this);
	
			//标注选中样式
			that.parents('tr').addClass('layui-table-click').siblings().removeClass('layui-table-click');
	
			var dataIndex = $(this).parents('tr').attr('data-index');
			var dataField = $(this).parents('td').attr('data-field');

	
		});
	

	
	
		// 监听表格工具栏操作
		table.on('tool(demo)', function(obj) {
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
			// 获取动态表格的数据
			var tableBak = table.cache['idTest'];
			if (layEvent === 'addRow') {
				// 新增行
	
				tableBak.push({});
	
				table.reload('idTest', {
					data: tableBak
				});
				

			} else if (layEvent === 'daleteRow') {
				// 删除行
	
				tableBak.splice(tr.attr('data-index'), 1);
				table.reload('idTest', {
					data: tableBak
				});

			}
		});

		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;
			// 禁止点击
			let tableBak = table.cache['idTest'];
			let customerContactList = [];
			$.each(tableBak,function (i,item) {
				if(item.name){
					customerContactList.push(item);
				}
			});

			data.field.customerContactList = customerContactList;
			$(that).addClass('zq-submit-disabled');

			axios.post('/customer/addCustomerDetail', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 20003) {
						setTimeout(function () {
							location.href="/admin/customerManagement/index"; //刷新父页面
						}, 1000);
					}else {
						// 取消禁止点击
						$(that).removeClass('zq-submit-disabled');
					}
				}).catch(function (error) {
				console.log(error);
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

