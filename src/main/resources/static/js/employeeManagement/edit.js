$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;

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
		function getDeptNameList(){
			return axios.get('/general/getDeptNameList')
				.then(function (response) {
					console.log(1)
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="department"]').append(`<option value="${item}">${item}</option>`)
						});
						form.render('select');
					}
				});
		}
		//	获取角色
		function getRoleNameList(){
			return axios.get('/general/getRoleNameList')
				.then(function (response) {
					console.log(2)
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="role"]').append(`<option value="${item}">${item}</option>`)
						});
						form.render('select');
					}
				});
		}
		//	获取岗位
		function getPostNameList(){
			return axios.get('/general/getPostNameList')
				.then(function (response) {
					console.log(3)
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="post"]').append(`<option value="${item}">${item}</option>`)
						});
						form.render('select');
					}
				});
		}
		//	获取权限组
		function getStaffAccessGroupList(){
			return axios.post('/staff/getStaffAccessGroupList')
				.then(function (response) {
					let data = response.data;
					if(data.code == 0){
						$.each(data.data,function (i,item) {
							$('select[name="groupId"]').append(`<option value="${item.groupId}">${item.groupName}</option>`)
						});
						form.render('select');
					}
				});
		}

		// 获取编辑信息
		axios.all([getDeptNameList(), getRoleNameList(), getPostNameList(),getStaffAccessGroupList()])
			.then(axios.spread(function (acct, perms) {
				// 两个请求现在都执行完成
				let formdata = new FormData();
				formdata.append('id', $('input[name="staffId"]').val());
				axios.post('/staff/getById',formdata)
					.then(function (response) {
						console.log(response);
						let data = response.data;
						if(data.code == 0){

							form.val('formTest',{
								ufId: data.data.ufId,
								jobNumber: data.data.jobNumber,
								name: data.data.name,
								cardNumber: data.data.cardNumber,
								phone: data.data.phone,
								address: data.data.address,
								entryTime: data.data.entryTime,
								positiveTime: data.data.positiveTime,
								comment: data.data.comment,
								gender: data.data.gender,
								state: data.data.state,
								isTurnPositive: data.data.isTurnPositive,
								department: data.data.department,
								role: data.data.role,
								post: data.data.post,
								groupId: data.data.groupId,

								insuranceCompany: data.data.insuranceCompany,

								trainSalary: data.data.trainSalary,
								basicSalary: data.data.basicSalary,
								managementFee: data.data.managementFee,
								postAllowance: data.data.postAllowance,
								foodDeduction: data.data.foodDeduction,
								tjFactoryDeduction: data.data.tjFactoryDeduction,
								issocial: data.data.issocial,

							});
							if(data.data.issocial == 1){
								form.val('formTest',{
									//	个人
									personalInsuranceBenefits: data.data.staffInsurance.personalInsuranceBenefits,
									personalEndowmentInsurance: data.data.staffInsurance.personalEndowmentInsurance,
									personalMedicalInsurance: data.data.staffInsurance.personalMedicalInsurance,
									personalUnemploymentInsurance: data.data.staffInsurance.personalUnemploymentInsurance,
									personalInsuranceTotal: data.data.staffInsurance.personalInsuranceTotal,
									personalAccumulationFund: data.data.staffInsurance.personalAccumulationFund,
									personalTotalIndividual: data.data.staffInsurance.personalTotalIndividual,
									//公司
									companyEndowmentInsurance: data.data.staffInsurance.companyEndowmentInsurance,
									companyMedicalInsurance: data.data.staffInsurance.companyMedicalInsurance,
									companyUnemploymentInsurance: data.data.staffInsurance.companyUnemploymentInsurance,
									inductrialInjuryInsurance: data.data.staffInsurance.inductrialInjuryInsurance,
									fertilityInsurance: data.data.staffInsurance.fertilityInsurance,
									companyInsuranceTotal: data.data.staffInsurance.companyInsuranceTotal,
									companyAccumulationFund: data.data.staffInsurance.companyAccumulationFund,
									companyTotalIndividual: data.data.staffInsurance.companyTotalIndividual
								});
							}else{
								$('.social-insurance').hide();
							}


							$('#upload-image').attr('src',data.data.uploadFiles.ufSavePath);
						}
					});
			}));

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

			axios.post('/staff/update', data.field)
				.then(function (response) {
					layer.msg(response.data.msg);
					if (response.data.code == 30006) {
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
})

