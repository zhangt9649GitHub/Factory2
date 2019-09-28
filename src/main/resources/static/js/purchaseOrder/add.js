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
	// 交货日期
	laydate.render({
		elem: '#laydate-2' //指定元素
		,value: new Date()
	});


	//获取编号
	axios.get('/general/getFormNumber?type=13'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$('input[name="purchaseOrderNumber"]').val(data.data.number);
		}
	});
	// 获取供应商
	axios.get('/general/getSupplierNameList')
		.then(function (response) {
			if(response.data.code == 0){
				$.each(response.data.data, function(i,item){
					$('select[name="supplierId"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
				});
				form.render('select')
			}
		});

	// 获取采购类型
	axios.post('/purchaseOrder/getPurchaseTypeList')
		.then(function(response){
			if(response.data.code == 0){
				$.each(response.data.data, function(i,item){
					$('select[name="purchaseType"]').append(`<option value="${item.value}">${item.bizName}</option>`)
				});
				form.render('select')
			}
		});

	// 获取销售订单
	axios.post('/purchaseOrder/getSalesOrder')
		.then(function(response){
			if(response.data.code == 0){
				$.each(response.data.data, function(i,item){
					$('select[name="salesOrderId"]').append(`<option value="${item.salesOrderId}">${item.salesOrderNumber}</option>`)
				});
				form.render('select')
			}
		});


	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 100, // 定义所有常规单元格的最小宽度
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
					field: 'partsCd',
					title: '部品CD',
					unresize: true,
					totalRowText: '合计（小写）',
					width: 120,
					edit: 'text'
				}, {
					field: 'goodsName',
					title: '品名',
					unresize: false
				}, {
					field: 'unit',
					title: '单位',
					unresize: true
				}, {
					field: 'quantity',
					title: '数量',
					edit: 'text'
				}, {
					field: 'purchasePrice',
					title: '单价',
					unresize: true,
					edit: 'text'
				}, {
					field: 'excludingTaxAmount',
					title: '不含税金额',
					unresize: true
				}, {
					field: 'taxRate',
					title: '税率',
					unresize: true
				}, {
					field: 'tax',
					title: '税额',
					unresize: true
				}, {
					field: 'taxIncludedAmount',
					title: '含税金额',
					unresize: true,
					totalRow: true
				}, {
					field: 'financeMoney',
					title: '财务金额',
					unresize: true,
					edit: 'text',
					totalRow: true
				}
			]
		],
		done: function(){
			// 设置大写金额
			let  taxIncludedAmount = $('.layui-table-total td[data-field="taxIncludedAmount"]').text();
			form.val('formTest',{
				'capital':number_chinese(taxIncludedAmount)
			});

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

		if(!(data.goodsId)){
			return;
		}
		if(obj.field == 'partsCd'){
			data.partsCd = editOldValue;
			tableBak.splice(tr.attr('data-index'), 1, data);
			table.reload('idTest', {
				data: tableBak
			});
			return false;
		}else
		//	数量
		if(obj.field == 'quantity'){
			if(isNaN(obj.value) || (obj.value) < 1){

				data.quantity = editOldValue;
				data.taxIncludedAmount = (Number(data.quantity)* Number(data.purchasePrice)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('数量只能是数字并且大于0', {
					icon: 5
				});
			}else{
				data.taxIncludedAmount = (Number(obj.value)* Number(data.purchasePrice)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
			}
		}else
		//	单价
		if(obj.field == 'purchasePrice'){
			if(isNaN(obj.value) || (obj.value) < 1){

				data.purchasePrice = editOldValue;
				data.taxIncludedAmount = (Number(data.quantity)* Number(data.purchasePrice)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('单价只能是数字并且大于0', {
					icon: 5
				});
			}else{
				data.taxIncludedAmount = (Number(obj.value)* Number(data.quantity)).toFixed(2);
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
			}
		}else
		//	财务金额
		if(obj.field == 'financeMoney'){
			if(isNaN(obj.value)){
				data.financeMoney = editOldValue;
				tableBak.splice(tr.attr('data-index'), 1, data);
				table.reload('idTest', {
					data: tableBak
				});
				layer.msg('财务金额只能是数字', {
					icon: 5
				});
			}else{
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


	// 监听供应商选择
	let oldSupplierId;
	form.on('select(supplierId)', function(data){
		// console.log(data.elem); //得到select原始DOM对象
		// console.log(data.value); //得到被选中的值
		// console.log(data.othis); //得到美化后的DOM对象

		if(data.value != oldSupplierId){
			oldSupplierId = data.value;
			let tableBak = [];
			for (let i = 0; i < 5; i++) {
				tableBak.push({});
			}
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
		let purchaseOrderDetailsList  = [];
		for(let i in tableBak){
			if(tableBak[i].goodsId){
				let arr ={
					goodsId: tableBak[i].goodsId,
					quantity: tableBak[i].quantity,
					purchasePrice: tableBak[i].purchasePrice,
					excludingTaxAmount: tableBak[i].excludingTaxAmount,
					taxRate: tableBak[i].taxRate,
					tax: tableBak[i].tax,
					taxIncludedAmount: tableBak[i].taxIncludedAmount,
					financeMoney: tableBak[i].financeMoney

				};
				purchaseOrderDetailsList.push(arr);
			}


		}
		if(purchaseOrderDetailsList.length == 0){
			layer.msg('请选择采购货物', {icon: 5});
			return false;
		}
		data.field.purchaseOrderDetailsList  = purchaseOrderDetailsList ;
		// 含税金额总计小写
		data.field.purchaseAmount = $('.layui-table-total td[data-field="taxIncludedAmount"]').text();
		// 财务金额总计小写
		data.field.financeMoneySum = $('.layui-table-total td[data-field="financeMoney"]').text();
		// 禁止点击
		$(that).addClass('zq-submit-disabled');

		axios.post('/purchaseOrder/insertPurchaseOrder', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 20003) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/purchaseOrder/index";  //刷新父页面
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

		let val = $('select[name="supplierId"] option:selected').val();

		let url = `/admin/purchaseOrder/showTable?dataIndex=${dataIndex}&supplierId=${val}`;
		if(val.length != 0){
			zqIframeShow('查看',url,700,520)
		}else{
			layer.msg('请选择供应商', {icon: 5});
		}
	}
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
	// 设置初始数量
	data.quantity = 1;
	// 单价字段
	data.purchasePrice = data.aPrice;
	// 含税金额
	data.taxIncludedAmount = (Number(data.purchasePrice)*Number(data.quantity)).toFixed(2);
	// 财务金额
	data.financeMoney = 0;
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
