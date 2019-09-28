$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate','element'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table,
			element = layui.element;

		//	入职日期
		laydate.render({
			elem: '#entryTime'
		});
		//	离职日期
		laydate.render({
			elem: '#departureTime'
		});
		//	转正日期
		laydate.render({
			elem: '#positiveTime'
		});

		//	获取部门
		axios.get('/general/getDeptNameList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="department"]').append(`<option value="${item}">${item}</option>`)
					});
					form.render('select');
				}
			});
		//	获取角色
		axios.get('/general/getRoleNameList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="role"]').append(`<option value="${item}">${item}</option>`)
					});
					form.render('select');
				}
			});
		//	获取岗位
		axios.get('/general/getPostNameList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="post"]').append(`<option value="${item}">${item}</option>`)
					});
					form.render('select');
				}
			});

		//	获取权限组
		axios.post('/staff/getStaffAccessGroupList')
			.then(function (response) {
				let data = response.data;
				if(data.code == 0){
					$.each(data.data,function (i,item) {
						$('select[name="groupId"]').append(`<option value="${item.groupId}">${item.groupName}</option>`)
					});
					form.render('select');
				}
			});

		// 工资
		$('.wages input[type="text"]').change(function () {
			if(isNaN($(this).val())){
				layer.msg('请输入数字');
				$(this).val(0);
			}
		});

		// 监听社保选择
		form.on('radio(issocial)', function(data){
			console.log(data.elem); //得到radio原始DOM对象
			console.log(data.value); //被点击的radio的value值

			if(data.value == 0){
				$('.social-insurance').hide();
			}else{
				$('.social-insurance').show();
			}

		});

		// 个人
		$('.personal input[type="text"]').change(function(){

			if(isNaN($(this).val())){
				layer.msg('请输入数字');
				$(this).val(0);
			}

			let personalInsuranceBenefits = $('input[name="personalInsuranceBenefits"]').val();
			let personalEndowmentInsurance = $('input[name="personalEndowmentInsurance"]').val();
			let personalMedicalInsurance = $('input[name="personalMedicalInsurance"]').val();
			let personalUnemploymentInsurance = $('input[name="personalUnemploymentInsurance"]').val();

			let personalAccumulationFund = $('input[name="personalAccumulationFund"]').val();

			let personalInsuranceTotal = Number(personalEndowmentInsurance)
				+ Number(personalMedicalInsurance) + Number(personalUnemploymentInsurance)
				- Number(personalInsuranceBenefits);
			$('input[name="personalInsuranceTotal"]').val(personalInsuranceTotal);

			let personalTotalIndividual = Number(personalInsuranceTotal) + Number(personalAccumulationFund);
			$('input[name="personalTotalIndividual"]').val(personalTotalIndividual);
		});

		// 公司
		$('.company input[type="text"]').change(function(){

			if(isNaN($(this).val())){
				layer.msg('请输入数字');
				$(this).val(0);
			}

			let companyEndowmentInsurance = $('input[name="companyEndowmentInsurance"]').val();
			let companyMedicalInsurance = $('input[name="companyMedicalInsurance"]').val();
			let companyUnemploymentInsurance = $('input[name="companyUnemploymentInsurance"]').val();
			let inductrialInjuryInsurance = $('input[name="inductrialInjuryInsurance"]').val();

			let fertilityInsurance = $('input[name="fertilityInsurance"]').val();
			let companyAccumulationFund = $('input[name="companyAccumulationFund"]').val();

			let companyInsuranceTotal = Number(companyEndowmentInsurance)
				+ Number(companyMedicalInsurance) + Number(companyUnemploymentInsurance)
				+ Number(inductrialInjuryInsurance) + Number(fertilityInsurance);
			$('input[name="companyInsuranceTotal"]').val(companyInsuranceTotal);

			let companyTotalIndividual = Number(companyInsuranceTotal) + Number(companyAccumulationFund);
			$('input[name="companyTotalIndividual"]').val(companyTotalIndividual);
		});






		// 监听表单提交
		form.on('submit(*)', function(data) {
			let that = this;

			//判断转正日期是否必填
			if(data.field.isTurnPositive == 1){
				if((data.field.positiveTime).length == 0){
					layer.msg('请选择转正日期',{
						icon: 5
					});
					return false;
				}
			}

			//判断离职日期是否必填
			if(data.field.state == 1){
				if((data.field.departureTime).length == 0){
					layer.msg('请选择离职日期',{
						icon: 5
					});
					return false;
				}
			}


			if(data.field.issocial == 0){
				data.field.staffInsurance = {
					// 个人
					personalInsuranceBenefits: 0,
					personalEndowmentInsurance: 0,
					personalMedicalInsurance: 0,
					personalUnemploymentInsurance: 0,
					personalInsuranceTotal: 0,
					personalAccumulationFund: 0,
					personalTotalIndividual: 0,
					// 公司
					companyEndowmentInsurance: 0,
					companyMedicalInsurance: 0,
					companyUnemploymentInsurance: 0,
					inductrialInjuryInsurance: 0,
					fertilityInsurance: 0,
					companyInsuranceTotal: 0,
					companyAccumulationFund: 0,
					companyTotalIndividual: 0,

				}
			}else{
				data.field.staffInsurance = {
					// 个人
					personalInsuranceBenefits: data.field.personalInsuranceBenefits,
					personalEndowmentInsurance: data.field.personalEndowmentInsurance,
					personalMedicalInsurance: data.field.personalMedicalInsurance,
					personalUnemploymentInsurance: data.field.personalUnemploymentInsurance,
					personalInsuranceTotal: data.field.personalInsuranceTotal,
					personalAccumulationFund: data.field.personalAccumulationFund,
					personalTotalIndividual: data.field.personalTotalIndividual,
					// 公司
					companyEndowmentInsurance: data.field.companyEndowmentInsurance,
					companyMedicalInsurance: data.field.companyMedicalInsurance,
					companyUnemploymentInsurance: data.field.companyUnemploymentInsurance,
					inductrialInjuryInsurance: data.field.inductrialInjuryInsurance,
					fertilityInsurance: data.field.fertilityInsurance,
					companyInsuranceTotal: data.field.companyInsuranceTotal,
					companyAccumulationFund: data.field.companyAccumulationFund,
					companyTotalIndividual: data.field.companyTotalIndividual,

				}
			}
			delete data.field.file;
			delete data.field.personalInsuranceBenefits;
			delete data.field.personalEndowmentInsurance;
			delete data.field.personalMedicalInsurance;
			delete data.field.personalUnemploymentInsurance;
			delete data.field.personalInsuranceTotal;
			delete data.field.personalAccumulationFund;
			delete data.field.personalTotalIndividual;
			// 公司
			delete data.field.companyEndowmentInsurance;
			delete data.field.companyMedicalInsurance;
			delete data.field.companyUnemploymentInsurance;
			delete data.field.inductrialInjuryInsurance;
			delete data.field.fertilityInsurance;
			delete data.field.companyInsuranceTotal;
			delete data.field.companyAccumulationFund;
			delete data.field.companyTotalIndividual;
			// 禁止点击
			$(that).addClass('zq-submit-disabled');

			axios.post('/staff/insert', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 30004) {
						setTimeout(function () {
							// active.zq_return();
							location.href="/admin/employeeManagement/index";  //刷新父页面
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

