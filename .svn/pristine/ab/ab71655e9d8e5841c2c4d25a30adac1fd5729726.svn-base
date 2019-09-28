$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;

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
					,{field: 'name',title: '姓名',align: 'center',fixed: 'left',"rowspan": 2}
					,{field: 'operationPermitNo',title: '作业证NO',"rowspan": 2}
					,{field: 'attendanceDays',title: '出勤天数',"rowspan": 2}
					,{title: '支付劳动局',align: 'center',"colspan": 2}
					,{title: '工资',align: 'center',"colspan": 8}
					,{title: '扣款',align: 'center',"colspan": 5}
					,{field: 'deserve',title: '应得',align: 'right',"rowspan": 2}
					,{title: '待扣代缴',align: 'center',"colspan": 2}
					,{field: 'accumulationFund',title: '公积金',align: 'right',"rowspan": 2,totalRow:true}
					,{field: 'subsidies',title: '补贴',align: 'right',"rowspan": 2,totalRow:true}
					,{field: 'realize',title: '实得',align: 'right',"rowspan": 2,totalRow:true}

				],
				[
					{field: 'insuranceCompany',title: '保险公司'}
					,{field: 'managementFee',title: '管理费',align: 'right'}
					,{field: 'basicTiming',title: '基本工资/计时工资',width: 150,align: 'right'}
					,{field: 'subsidy',title: '奖金/加班/津贴',align: 'right'}
					,{field: 'basicWage',title: '基本工资/计件工资',width: 150,align: 'right'}
					,{field: 'pieces',title: '计件',align: 'center'}
					,{field: 'bonus',title: '奖金',align: 'right'}
					,{field: 'evaluation',title: '职能评价'}
					,{field: 'postAllowance',title: '岗位津贴',align: 'right'}
					,{field: 'subtotalWage',title: '工资小计',align: 'right'}
					,{field: 'foodDeduction',title: '伙食扣款',align: 'right',totalRow:true}
					,{field: 'tjFactoryDeduction',title: '天津工厂扣款',align: 'right',totalRow:true}
					,{field: 'providentFundDeduction',title: '公积金扣款',align: 'right',totalRow:true}
					,{field: 'insuranceDeduction',title: '保险扣款',align: 'right',totalRow:true}
					,{field: 'subtotalDeduction',title: '扣款小计',align: 'right',totalRow:true}
					,{field: 'withholdingInsurance',title: '保险',align: 'right',totalRow:true}
					,{field: 'personalIncomeTax',title: '个人所得税',align: 'right'}

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
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type');

			active[type] ? active[type].call(this, othis) : '';
		});



	})
});
