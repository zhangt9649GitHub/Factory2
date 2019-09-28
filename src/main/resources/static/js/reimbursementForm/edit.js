$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;

		// 日期
		laydate.render({
			elem: '#date' //指定元素
			,value: new Date()
		});


		// 获取员工列表
		function getStaffNameList(){
			return axios.get('/general/getStaffNameList'
			).then(function (response) {
				let data = response.data;
				if(data.code == 0) {
					$.each(data.data,function(i,item){

						$('select[name="reviewStaffId"]').append('<option value="'+ item.staffId +'">'+ item.name +'</option>')

					});


					form.render('select');
				}
			}).catch(function (error) {
				console.log(error);
			});
		}
		axios.all([getStaffNameList()])
			.then(axios.spread(function (acct, perms) {
				// 两个请求现在都执行完成
				let formdata = new FormData();
				formdata.append('id',$('input[name="reimburseId"]').val());
				axios.post('/reimburse/getById',formdata
				).then(function (response) {
					let data = response.data;
					if(data.code == 0) {
						$('input[name="reimburseNumber"]').val(data.data.reimburseNumber);
						$('input[name="applicationTime"]').val(data.data.applicationTime);
						$('textarea[name="comment"]').text(data.data.comment);
						$('select[name="createStaffId"] option').text(data.data.createName);

						$('select[name="reviewStaffId"] option').each(function(i,item){
							if($(item).val() == data.data.reviewStaffId){
								$(item).prop('selected',true);
							}
						});

						data.data.reimburseDetails.push({});
						table.reload('idTest', {
							data: data.data.reimburseDetails
						});


						form.render('select');
					}
				}).catch(function (error) {
					console.log(error);
				});
			}));


		// 动态表格
		table.render({
			elem: '#idTest',
			limit:10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			totalRow: true, //开启合计
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
						type: 'numbers',
						title: '序号',
						unresize: true,
						width: 70,
						totalRowText: '合计'
					}, {
						field: 'bookNumber',
						title: '禀议书号码',
						unresize: true,
						edit: 'text'
					}, {
						field: 'costPeriod',
						title: '费用日期',
						unresize: true,
						edit: 'text'
					}, {
						field: 'use',
						title: '用途',
						unresize: true,
						edit: 'text'

					}, {
						field: 'amount',
						title: '金额',
						edit: 'text',
						unresize: true,
						totalRow: true
					},  {
						field: 'comment',
						title: '备注',
						edit: 'text',
						unresize: true
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

			switch (dataField) {
				case 'costPeriod':
					that.attr("readonly","readonly");
					let dateInput = `<input type="text" class="zq-input" id="dataTableDate">`;
					that.parent().append(dateInput);
					// 动态表格日期
					laydate.render({
						elem: '#dataTableDate', //指定元素
						show: true,
						value: that.val(),
						done: function(value) {
							// 获取动态表格的数据
							var tableBak = table.cache['idTest'];
							tableBak[dataIndex].costPeriod = value;

							table.reload('idTest', {
								data: tableBak
							});
							$('.zq-datatable .zq-input').remove();

						}

					});
					break;
			}

		});




		// 删除放大镜与输入框
		$('body').click(function() {
			$('.zq-datatable .zq-fangdajing').remove();
			$('.zq-datatable .zq-input').remove();
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
			// 获取动态表格的数据
			let tableBak = table.cache['idTest'];
			let reimburseDetails = [];
			for(let i in tableBak){
				let arr = Object.keys(tableBak[i]);
				if(arr.length > 1){
					reimburseDetails.push(tableBak[i]);
				}
			}


			data.field.reimburseDetails = reimburseDetails;
			data.field.amount = $('.layui-table-total td[data-field="amount"]').text();
			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			axios.post(`/reimburse/update`, data.field)
				.then(function(response){
					let data = response.data;
					layer.msg(data.msg);
					if(data.code == 30006){
						setTimeout(function () {
							// active.zq_return();
							location.href="/admin/reimbursementForm/index";  //刷新父页面
						}, 1000);
					}else {
						// 取消禁止点击
						$(that).removeClass('zq-submit-disabled');
					}
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

