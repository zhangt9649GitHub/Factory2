// 产品结构清单（BOM）
var table;
layui.use(['form', 'table', 'layer', 'laydate'], function() {

	var	layer = layui.layer,
		form = layui.form,
		laydate = layui.laydate;
	table = layui.table;



	// 日期
	laydate.render({
		elem: '#laydate-1' //指定元素
		,value: new Date()
	});


	//获取编号
	axios.get('/general/getFormNumber?type=5'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$('input[name="bomNumber"]').val(data.data.number);
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
					type: 'numbers',
					title: '序号',
					unresize: true
				}, {
					field: 'partsCd',
					title: '部品CD',
					unresize: true,
					edit: 'text'
				}, {
					field: 'goodsName',
					title: '使用物料名称',
					unresize: true
				}, {
					field: 'variety',
					title: '品种',
					unresize: true
				},  {
					field: 'specification',
					title: '规格',
					unresize: true
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'quantity',
					title: '必要数量',
					unresize: true,
					edit: 'text'
				}, {
					field: 'comment',
					title: '备注',
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
		$('.layui-table-fixed tr').removeClass('layui-table-click');
	});

	// 监听数据表格单元格编辑
	var editOldValue;
	table.on('edit(demo)', function(obj) {
		// console.log(obj.value); //得到修改后的值
		// console.log(obj.field); //当前编辑的字段名
		// console.log(obj.data); //所在行的所有相关数据

		let data = obj.data;
		let tr = obj.tr; //获得当前行 tr 的DOM对象
		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];
		if(obj.field == 'partsCd'){
			data.partsCd = editOldValue;
			tableBak.splice(tr.attr('data-index'), 1, data);
			table.reload('idTest', {
				data: tableBak
			});
			return false;
		}else if(obj.field == 'quantity'){
			if(isNaN(obj.value) || obj.value <= 0){
				layer.msg('数量数量只能是数字，并且大于0', {icon: 5});
				data.quantity = editOldValue;
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
			}
		}


	});

	// 监听数据表格编辑框选中

	$('.zq-datatable').on('focus', '.layui-table-edit', function() {
		// 删除放大镜与输入框
		$('.zq-datatable .zq-fangdajing').remove();
		$('.zq-datatable .zq-input').remove();
		var that = $(this);

		// 报错编辑前的值
		editOldValue = $(that).val();

		//标注选中样式
		that.parents('tr').addClass('layui-table-click').siblings().removeClass('layui-table-click');
		// 记录当前选中行的坐标
		var dataIndex = $(this).parents('tr').attr('data-index');
		var dataField = $(this).parents('td').attr('data-field');

		// 判断是那个数据表点击的：1是表1
		let datatable1 = 0;
		if($(this).parents('.datatable1').length >0){
			datatable1 = 1;
		}
		switch (dataField) {
			case 'partsCd':
				let html =
					`<i class="zq-fangdajing" onclick="active.zqIframeShow(${dataIndex},${datatable1})" >
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
				that.parent().append(html);
				break;
		}
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


	// 动态表格-1
	table.render({
		elem: '#idTest-1',
		limit: 10000,
		cellMinWidth: 80, // 定义所有常规单元格的最小宽度
		// totalRow: true, //开启合计行区域
		data: [{}],
		cols: [
			[
				{
					type: 'numbers',
					title: '序号',
					unresize: true
				}, {
					field: 'partsCd',
					title: '部品CD',
					unresize: true,
					edit: 'text'
				}, {
					field: 'goodsName',
					title: '产品名称',
					unresize: true
				}, {
					field: 'variety',
					title: '品种',
					unresize: true
				},  {
					field: 'specification',
					title: '规格',
					unresize: true
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'quantity',
					title: '数量',
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
	// 监听数据表格单元格编辑
	table.on('edit(demo-1)', function(obj) {
		// console.log(obj.value); //得到修改后的值
		// console.log(obj.field); //当前编辑的字段名
		// console.log(obj.data); //所在行的所有相关数据

		let data = obj.data;
		let tr = obj.tr; //获得当前行 tr 的DOM对象
		// 获取动态表格的数据
		let tableBak = table.cache['idTest-1'];
		if(obj.field == 'partsCd'){
			data.partsCd = editOldValue;
			tableBak.splice(tr.attr('data-index'), 1, data);
			table.reload('idTest-1', {
				data: tableBak
			});
			return false;
		}else if(obj.field == 'quantity'){
			if(isNaN(obj.value) || obj.value <= 0){
				layer.msg('数量数量只能是数字，并且大于0', {icon: 5});
				data.quantity = editOldValue;
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest-1', {
					data: tableBak
				});
			}
		}


	});

	// // 删除放大镜与输入框
	$('body').click(function() {
		$('.zq-datatable .zq-fangdajing').remove();
		$('.zq-datatable .zq-input').remove();
	});










	// 监听表单提交
	form.on('submit(*)', function(data) {
		let that = this;

		// 获取主体部分
		let tableBak1 = table.cache['idTest-1'];
		for(let i in tableBak1){
			if(tableBak1[i].goodId){
				data.field.goodId = tableBak1[i].goodId;
				data.field.quantity = tableBak1[i].quantity;
			}else{
				layer.msg('请选择主体部品', {icon: 1});
				return false;
			}
		}

		// 获取动态表格的数据(组成部分)
		let tableBak = table.cache['idTest'];
		let bomFormDetailList = [];
		for(let i in tableBak){
			if(tableBak[i].goodId){
				let arr ={
					goodId: tableBak[i].goodId,
					quantity: tableBak[i].quantity,
					comment: (tableBak[i].comment)?tableBak[i].comment:'',
				};
				bomFormDetailList.push(arr);
			}


		}
		if(bomFormDetailList.length == 0){
			layer.msg('请选择组成部品', {icon: 5});
			return false;
		}
		data.field.bomFormDetailList = bomFormDetailList;
		// 禁止点击
		$(that).addClass('zq-submit-disabled');

		axios.post('/bomForm/insertBomForm', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 20003) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/listOfProductStructure/index";  //刷新父页面
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




});
// 触发事件
var active = {
	zqIframeShow: function (dataIndex,datatable1) {

		let url = `/admin/listOfProductStructure/showTable?dataIndex=${dataIndex}&datatable1=${datatable1}`;

		zqIframeShow('查看',url,700,520)


	}

};

// 点击调用
$('body').on('click', '.zq-active', function() {
	var othis = $(this),
		type = othis.data('type');
	active[type] ? active[type].call(this, othis) : '';
});
// 从子页面传数据到表格
function updateData(dataIndex,datatable1, data){
	data['goodId'] = data.goodsId;
	delete data.goodsId;
	// 设置数量初始值
	data.quantity = 1;
	if(datatable1 == 0){
		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];

		$.each(tableBak,function(i,item){
			if(item.goodId == data.goodId){

				if(dataIndex == i){
					tableBak.splice(dataIndex, 1, data);
					table.reload('idTest', {
						data: tableBak
					});
					return false;
				}else{
					layer.msg('该信息已添加，不能重复添加！', {icon: 5});
					return false;
				}
			}else{
				if(i == (tableBak.length - 1 )){
					tableBak.splice(dataIndex, 1, data);
					table.reload('idTest', {
						data: tableBak
					});
				}
			}
		});
	}else{
		let tableBak1 = table.cache['idTest-1'];
		tableBak1.splice(dataIndex, 1, data);
		table.reload('idTest-1', {
			data: tableBak1
		});
	}




}
