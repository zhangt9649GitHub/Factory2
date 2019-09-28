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
	axios.get('/general/getFormNumber?type=7'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$('input[name="outboundOrderNumber"]').val(data.data.number);
		}
	});

	//获取出库类型
	axios.post('/outboundOrder/getOutboundOrderTypeList'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$.each(data.data,function(i,item){
				$('select[name="type"]').append('<option value="'+ item.value +'">'+ item.value +'</option>')
			});
			form.render('select');
		}
	});

	//获取仓库
	axios.get('/general/getWarehouseNameList'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$.each(data.data,function(i,item){

				// 调出仓库
				$('select[name="warehouseId"]').append('<option value="'+ item.warehouseId +'">'+ item.warehouseName +'</option>');
			});


			form.render('select');
		}
	});

	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 80, // 定义所有常规单元格的最小宽度
		totalRow: true, //开启合计行区域
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
					unresize: true,
					title: '序号',
					totalRowText: '合计金额',
					width: 70
				}, {
					field: 'partsCd',
					title: '部品CD',
					unresize: true,
					edit: 'text'
				}, {
					field: 'goodsName',
					title: '名称',
					unresize: true
				}, {
					field: 'specification',
					title: '规格',
					unresize: true
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'skgCount',
					title: '库存',
					unresize: true
				},  {
					field: 'quantity',
					title: '出库数量',
					unresize: true,
					edit: 'text'
				}, {
					field: 'sellingPrice',
					title: '单价',
					unresize: true
				}, {
					field: 'amount',
					title: '金额',
					unresize: true,
					totalRow: true
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
	let tableBak = table.cache['idTest'];
	// 循环显示5行
	for (let i = 0; i < 5; i++) {
		tableBak.push({});
	}
	table.reload('idTest', {
		data: tableBak
	});

	// 监听仓库选择
	var warehouseId;
	form.on('select(warehouseId)', function(data){
		// console.log(data.value); //得到被选中的值
		// 调出仓库改变时，初始化表格
		if(data.value != warehouseId){
			table.reload('idTest', {
				data: tableBak
			});
		}
		warehouseId = data.value;

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
			$(this).val(editOldValue);
			return false;
		}else if(obj.field == 'quantity') {
			if(isNaN(obj.value)){
				layer.msg('出库数量只能是数字', {icon: 2});
				$(this).val(editOldValue);
				return false;
			}else{
				data.amount = obj.value * data.sellingPrice;
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				return false;
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

		switch (dataField) {
			case 'partsCd':
				let html =
					`<i class="zq-fangdajing" onclick="active.zqIframeShow(${dataIndex})" >
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
				that.parent().append(html);
				break;
		}
	});




	// // 删除放大镜与输入框
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
		let outboundOrderDetailsList = [];
		for(let i in tableBak){
			if(tableBak[i].goodsId){
				let index = parseInt(i) + 1;
				if(isNaN(tableBak[i].quantity)){
					layer.msg('第：'+ index +'行的出库数量只能是数字', {icon: 1});
					return false;
				}else if( Number(tableBak[i].quantity) <= 0 ){
					layer.msg('第：'+ index +'行出库数量不能小于等于0', {icon: 1});
					return false;
				}else if(Number(tableBak[i].quantity) > Number(tableBak[i].skgCount)){
					layer.msg('第：'+ index +'行出库数量不能大于库存数', {icon: 1});
					return false;
				}else{
					let arr ={
						goodsId: tableBak[i].goodsId,
						quantity: tableBak[i].quantity,
						amount: tableBak[i].amount,
						comment: (tableBak[i].comment)?tableBak[i].comment:'',
					};
					outboundOrderDetailsList.push(arr);
				}
			}


		}
		if(outboundOrderDetailsList.length == 0){
			layer.msg('请选择出库货物', {icon: 5});
			return false;
		}
		data.field.outboundOrderDetailsList = outboundOrderDetailsList;
		data.field.totalPrice = $('.layui-table-total td[data-field="amount"]').text();
		// 禁止点击

		$(that).addClass('zq-submit-disabled');

		axios.post('/outboundOrder/insertOutboundOrder', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 10002) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/outboundOrder/index";  //刷新父页面
					}, 1000);
				}else {
					// 取消禁止点击
					$(that).removeClass('zq-submit-disabled');
				}
			});
		return false;
	});




});
// 触发事件
var active = {
	zqIframeShow: function (dataIndex) {
		// 获取调出仓库的值

		let val = $.trim($('select[name="warehouseId"] option:selected').val());
		let url = `/admin/outboundOrder/showTable?dataIndex=${dataIndex}&warehouseId=${val}`;
		if(val.length != 0){
			zqIframeShow('查看',url,700,520)
		}else{
			layer.msg('请选择仓库', {icon: 5});
		}

	}
	//

};

// 点击调用
$('body').on('click', '.zq-active', function() {
	var othis = $(this),
		type = othis.data('type');
	active[type] ? active[type].call(this, othis) : '';
});
// 从子页面传数据到表格
function updateData(dataIndex, data){
	// 获取动态表格的数据
	let tableBak = table.cache['idTest'];
	data.sellingPrice = data.aPrice;
	$.each(tableBak,function(i,item){
		if(item.goodsId == data.goodsId){

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


}
