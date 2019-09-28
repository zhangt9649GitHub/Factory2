$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;

		// 获取编辑信息
		let formdata = new FormData();
		formdata.append('id', $('input[name="staffId"]').val());
		axios.post('/staff/getById',formdata)
			.then(function (response) {
				console.log(response);
				let data = response.data;
				if(data.code == 0){

					let state;
					switch (data.data.state) {
						case 1:
							state = '离职';
							break;
						case 2:
							state = '在职';
							break;
					}
					let isTurnPositive;
					switch (data.data.isTurnPositive) {
						case 1:
							isTurnPositive = '是';
							break;
						case 2:
							isTurnPositive = '否';
							break;
					}
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
						state: state,
						isTurnPositive: isTurnPositive,
						department: data.data.department,
						role: data.data.role,
						post: data.data.post,
						groupId: data.data.staffAccessGroup.groupName,

						insuranceCompany: data.data.insuranceCompany,

						trainSalary: data.data.trainSalary,
						basicSalary: data.data.basicSalary,
						managementFee: data.data.managementFee,
						postAllowance: data.data.postAllowance,
						foodDeduction: data.data.foodDeduction,
						tjFactoryDeduction: data.data.tjFactoryDeduction,
						issocial: data.data.issocial
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


					$('#image').attr('src',data.data.uploadFiles.ufSavePath);




				}
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

