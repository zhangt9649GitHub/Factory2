$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate','upload'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			upload = layui.upload,
			table = layui.table,
			editOldValue;


		// 日期
		laydate.render({
			elem: '#date' //指定元素
			,value: new Date()
		});

		// 工资开始日期
		laydate.render({
			elem: '#date-1' //指定元素
		});
		// 工资结束日期
		laydate.render({
			elem: '#date-2' //指定元素
		});

		// 获取编辑信息
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
		var formdata = new FormData();
		formdata.append('payrollId',$('input[name="payrollId"]').val());
		axios.post('/payroll/getPayrollById',formdata)
			.then(function(response){
                if(response.data.code == 0){
                    let data = response.data.data;

                    form.val('formTest',{
                        payrollNumber: data.payrollNumber,
                        addTime: data.addTime,
                        startTime: data.startTime,
                        endTime: data.endTime,
                        staffName: data.staff.name
                    });

                    table.reload('idTest', {
                        data: data.payrollDetailsList
                    })

                }
                layer.closeAll('loading'); //关闭加载层
            });


		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			totalRow: true, //开启合计
			data: [],
			cols:  [
				[
					{width: 50,align: 'center',toolbar: '#barDemo',unresize: true,fixed: 'left',"rowspan": 2}
					,{type: 'numbers',title: '序号',totalRowText: '合计',fixed: 'left',"rowspan": 2}
					,{field: 'name',title: '姓名',align: 'center',fixed: 'left',edit: 'text',"rowspan": 2}
					,{field: 'operationPermitNo',title: '作业证NO',edit: 'text',"rowspan": 2}
					,{field: 'attendanceDays',title: '出勤天数',edit: 'text',"rowspan": 2}
					,{title: '支付劳动局',edit: 'text',align: 'center',"colspan": 2}
					,{title: '工资',align: 'center',edit: 'text',"colspan": 8}
					,{title: '扣款',align: 'center',edit: 'text',"colspan": 5}
					,{field: 'deserve',title: '应得',align: 'right',edit: 'text',"rowspan": 2}
					,{title: '待扣代缴',align: 'center',edit: 'text',"colspan": 2}
					,{field: 'accumulationFund',title: '公积金',align: 'right',edit: 'text',"rowspan": 2,totalRow:true}
					,{field: 'subsidies',title: '补贴',align: 'right',edit: 'text',"rowspan": 2,totalRow:true}
					,{field: 'realize',title: '实得',align: 'right',"rowspan": 2,totalRow:true}

				],
				[
					{field: 'insuranceCompany',title: '保险公司',edit: 'text'}
					,{field: 'managementFee',title: '管理费',align: 'right',edit: 'text'}
					,{field: 'basicTiming',title: '基本工资/计时工资',width: 150,align: 'right',edit: 'text'}
					,{field: 'subsidy',title: '奖金/加班/津贴',align: 'right',edit: 'text'}
					,{field: 'basicWage',title: '基本工资/计件工资',width: 150,align: 'right',edit: 'text'}
					,{field: 'pieces',title: '计件',align: 'center',edit: 'text'}
					,{field: 'bonus',title: '奖金',align: 'right',edit: 'text'}
					,{field: 'evaluation',title: '职能评价',edit: 'text'}
					,{field: 'postAllowance',title: '岗位津贴',align: 'right',edit: 'text'}
					,{field: 'subtotalWage',title: '工资小计',align: 'right'}
					,{field: 'foodDeduction',title: '伙食扣款',align: 'right',edit: 'text',totalRow:true}
					,{field: 'tjFactoryDeduction',title: '天津工厂扣款',align: 'right',edit: 'text',totalRow:true}
					,{field: 'providentFundDeduction',title: '公积金扣款',align: 'right',edit: 'text',totalRow:true}
					,{field: 'insuranceDeduction',title: '保险扣款',align: 'right',edit: 'text',totalRow:true}
					,{field: 'subtotalDeduction',title: '扣款小计',align: 'right',totalRow:true}
					,{field: 'withholdingInsurance',title: '保险',align: 'right',edit: 'text',totalRow:true}
					,{field: 'personalIncomeTax',title: '个人所得税',align: 'right',edit: 'text'}

				]

			],
			done: function(){
				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: '0',
					zindex: '120'
				});
			}
		});

		let arr = {
			name: null,
			operationPermitNo: null,
			attendanceDays: null,
			insuranceCompany: null,
			managementFee: null,
			basicTiming: null,
			basicWage: null,
			subsidy: null,
			pieces: null,
			bonus: null,
			evaluation: null,
			postAllowance: null,
			subtotalWage: null,
			foodDeduction: null,
			tjFactoryDeduction: null,
			providentFundDeduction: null,
			insuranceDeduction: null,
			subtotalDeduction: null,
			deserve: null,
			withholdingInsurance: null,
			personalIncomeTax: null,
			accumulationFund: null,
			subsidies: null,
			realize: null
		};




		table.on('edit(demo)', function(obj) {
			console.log(obj);
			if(obj.field != 'name' || obj.field != 'operationPermitNo'
				|| obj.field != 'attendanceDays' || obj.field != 'insuranceCompany'
				|| obj.field != 'evaluation'){
				if(isNaN(obj.value)){
					layer.msg('请输入数字');
					$(this).val(editOldValue);

				}else{

					totalRow(obj)
				}
			}

		});
		// 个人工资合计
		function totalRow(obj){
			var data = obj.data;
			// 工资小计
			if(!data.managementFee){
				data.managementFee = 0;
			}
			if(!data.basicTiming){
				data.basicTiming = 0;
			}
			if(!data.subsidy){
				data.subsidy = 0;
			}
			if(!data.basicWage){
				data.basicWage = 0;
			}
			if(!data.bonus){
				data.bonus = 0;
			}
			if(!data.postAllowance){
				data.postAllowance = 0;
			}
			var subtotalWage = Number(data.managementFee)+Number(data.basicTiming)
				+Number(data.subsidy)+Number(data.basicWage)+ Number(data.bonus)
				+Number(data.postAllowance);
			data.subtotalWage = subtotalWage.toFixed(2);

			// 扣款小计
			if(!data.foodDeduction){
				data.foodDeduction = 0;
			}
			if(!data.tjFactoryDeduction){
				data.tjFactoryDeduction = 0;
			}
			if(!data.providentFundDeduction){
				data.providentFundDeduction = 0;
			}
			if(!data.insuranceDeduction){
				data.insuranceDeduction = 0;
			}
			var subtotalDeduction =Number(data.foodDeduction)+Number(data.tjFactoryDeduction)
				+Number(data.providentFundDeduction)+Number(data.insuranceDeduction);
			data.subtotalDeduction = subtotalDeduction.toFixed(2);

			// 应得
			var deserve =Number(data.subtotalWage) - Number(data.subtotalDeduction);
			data.deserve = deserve.toFixed(2);

			// 实得
			if(!data.withholdingInsurance){
				data.withholdingInsurance = 0;
			}
			if(!data.personalIncomeTax){
				data.personalIncomeTax = 0;
			}
			if(!data.accumulationFund){
				data.accumulationFund = 0;
			}
			if(!data.subsidies){
				data.subsidies = 0;
			}
			var realize = Number(data.deserve)-Number(data.withholdingInsurance)
				-Number(data.personalIncomeTax)-Number(data.accumulationFund)
				+Number(data.subsidies);
			data.realize = realize.toFixed(2);

			obj.update(data);
			total();
		}
		// 合计行
		function total(){
			// 表格数据
			var tableBak = table.cache['idTest'];

			// 伙食扣款
			var foodDeductionTotal = 0.00;
			// 天津工厂扣款
			var tjFactoryDeductionTotal = 0.00;
			// 公积金扣款
			var providentFundDeductionTotal = 0.00;
			// 保险扣款
			var insuranceDeductionTotal = 0.00;
			// 扣款小计
			var subtotalDeductionTotal = 0.00;
			// 保险
			var withholdingInsuranceTotal = 0.00;
			// 公积金
			var accumulationFundTotal = 0.00;
			// 补贴
			var subsidiesTotal = 0.00;
			// 实得
			var realizeTotal = 0.00;
			$.each(tableBak,function(i,item){

				// 伙食扣款
				if(item.foodDeduction){
					foodDeductionTotal += Number(item.foodDeduction);
				}
				// 天津工厂扣款
				if(item.tjFactoryDeduction){
					tjFactoryDeductionTotal += Number(item.tjFactoryDeduction);
				}
				// 公积金扣款
				if(item.providentFundDeduction){
					providentFundDeductionTotal += Number(item.providentFundDeduction);
				}
				// 保险扣款
				if(item.insuranceDeduction){
					insuranceDeductionTotal += Number(item.insuranceDeduction);
				}
				// 扣款小计
				if(item.subtotalDeduction){
					subtotalDeductionTotal += Number(item.subtotalDeduction);
				}
				// 保险
				if(item.withholdingInsurance){
					withholdingInsuranceTotal += Number(item.withholdingInsurance);
				}
				// 公积金
				if(item.accumulationFund) {
					accumulationFundTotal += Number(item.accumulationFund);
				}
				// 补贴
				if(item.subsidies) {
					subsidiesTotal += Number(item.subsidies);
				}
				// 实得
				if(item.realize) {
					realizeTotal += Number(item.realize);
				}

			});
			$('.layui-table-total td[data-field="foodDeduction"] .layui-table-cell').text(foodDeductionTotal.toFixed(2));
			$('.layui-table-total td[data-field="tjFactoryDeduction"] .layui-table-cell').text(tjFactoryDeductionTotal.toFixed(2));
			$('.layui-table-total td[data-field="providentFundDeduction"] .layui-table-cell').text(providentFundDeductionTotal.toFixed(2));
			$('.layui-table-total td[data-field="insuranceDeduction"] .layui-table-cell').text(insuranceDeductionTotal.toFixed(2));
			$('.layui-table-total td[data-field="subtotalDeduction"] .layui-table-cell').text(subtotalDeductionTotal.toFixed(2));
			$('.layui-table-total td[data-field="withholdingInsurance"] .layui-table-cell').text(withholdingInsuranceTotal.toFixed(2));
			$('.layui-table-total td[data-field="accumulationFund"] .layui-table-cell').text(accumulationFundTotal.toFixed(2));
			$('.layui-table-total td[data-field="subsidies"] .layui-table-cell').text(subsidiesTotal.toFixed(2));
			$('.layui-table-total td[data-field="realize"] .layui-table-cell').text(realizeTotal.toFixed(2));
		}


		// 监听数据表格编辑框选中
		$('.zq-datatable').on('focus', '.layui-table-edit', function() {
			$('.zq-datatable .zq-fangdajing').remove();
			$('.zq-datatable .zq-input').remove();
			var that = $(this);

			// 报错编辑前的值
			editOldValue = $(that).val();


			var dataIndex = $(this).parents('tr').attr('data-index');
			var dataField = $(this).parents('td').attr('data-field');

			switch (dataField) {
				case 'date':
					let html =
						`<i class="zq-fangdajing" onclick="zqIframeShow('查看','showTable.html','800','600',${dataIndex})">
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
					that.parent().append(html);
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

				tableBak.push(arr);

				table.reload('idTest', {
					data: tableBak
				})
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
			let payrollDetailsList = tableBak;

			data.field.payrollDetailsList = payrollDetailsList;
			data.field.totalWages = $('.layui-table-total td[data-field="realize"] .layui-table-cell').text();
			// 禁止点击
			$(that).addClass('zq-submit-disabled');
			layer.load(1, {
				shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			axios.post('/payroll/updatePayrollInfo', data.field)
				.then(function (response) {
					layer.closeAll('loading'); //关闭加载层
					layer.msg(response.data.msg);
					if (response.data.code == 10008) {
						setTimeout(function () {
							location.href="/admin/payroll/index";  //刷新父页面
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

function ml(dataIndex, data) {
	// 获取动态表格的数据
	var tableBak = table.cache['idTest'];
	tableBak.splice(dataIndex, 1, data);
	table.reload('idTest', {
		data: tableBak
	})

}

