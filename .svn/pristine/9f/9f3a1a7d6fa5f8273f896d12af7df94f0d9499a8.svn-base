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
	axios.get('/general/getFormNumber?type=6'
	).then(function (response) {
		let data = response.data;
		if(data.code == 0) {
			$('input[name="purchaseNumber"]').val(data.data.number);
		}
	});

	// 动态表格
	table.render({
		elem: '#idTest',
		limit: 10000,
		cellMinWidth: 120, // 定义所有常规单元格的最小宽度
		// totalRow: true, //开启合计行区域
		data: [],
		cols: [
			[
				{width: 50,align: 'center',toolbar: '#barDemo',unresize: true,fixed: 'left'}
				,{field: 'partsCd',title: '部品CD',unresize: true,edit: 'text'}
				,{field: 'goodsName',title: '品名',unresize: true}
				,{field: 'specification',title: '规格',unresize: true}
				,{field: 'unit',title: '单位',unresize: true}
				,{field: 'monthsInStock',title: '在库月数',unresize: true}
				,{field: 'skgCount',title: '当前库存数',unresize: true}
				,{field: 'purchaseOrderQuantity',title: '采购起订量',unresize: true}
				,{field: 'quantity',title: '申购数量',unresize: true,edit: 'text'}
				,{field: 'purchaseCycle',title: '采购周期要求',unresize: true,edit: 'text'}
				,{field: 'ladderPrice',title: '阶梯价格信息',unresize: true}
				,{field: 'purpose',title: '用途说明',unresize: true,edit: 'text'}
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
			$(this).val(editOldValue);
			return false;
		}else if(obj.field == 'quantity'){
			if(isNaN(obj.value) || (obj.value) < 1){

				$(this).val(editOldValue);

				layer.msg('数量只能是数字并且大于0', {
					icon: 2
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




	// 监听表单提交
	form.on('submit(*)', function(data) {
		let that = this;

		delete data.field.staffName;
		// 获取动态表格的数据
		let tableBak = table.cache['idTest'];
		let purchaseApplyDetailsList  = [];
		for(let i in tableBak){
			if(tableBak[i].goodsId){
				let arr ={
					goodsId: tableBak[i].goodsId,
					quantity: tableBak[i].quantity,
					purchaseCycle: (tableBak[i].purchaseCycle)?tableBak[i].purchaseCycle:'',
					stairPrice: tableBak[i].ladderPrice,
					purpose: (tableBak[i].purpose)?tableBak[i].purpose:'',
				};
				purchaseApplyDetailsList .push(arr);
			}


		}
		if(purchaseApplyDetailsList .length == 0){
			layer.msg('请选择采购货物', {icon: 5});
			return false;
		}
		data.field.purchaseApplyDetailsList  = purchaseApplyDetailsList ;
		// 禁止点击
		$(that).addClass('zq-submit-disabled');

		axios.post('/purchaseApply/insertPurchaseApply', data.field)
			.then(function (response) {
				layer.msg(response.data.msg);
				if (response.data.code == 20003) {
					setTimeout(function () {
						// active.zq_return();
						location.href="/admin/purchaseRequisition/index";  //刷新父页面
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
	zqIframeShow: function (dataIndex) {

		let url = `/admin/purchaseRequisition/showTable?dataIndex=${dataIndex}`;
		zqIframeShow('查看',url,700,520)

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
	// 设置初始数量
	data.quantity = 1;
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
