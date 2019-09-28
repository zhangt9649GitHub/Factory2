$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
			table = layui.table;

		// 日期
		laydate.render({
			elem: '#date' //指定元素
		});





		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			data: [],
			cols: [
				[
					{
						field: 'name',
						title: '姓名',
						unresize: true
					}, {
						field: 'position',
						title: '部门职务',
						unresize: true
					}, {
						field: 'phone',
						title: '电话',
						unresize: true
					}, {
						field: 'mobile',
						title: '手机',
						unresize: true
					}, {
						field: 'mail',
						title: '电子邮件',
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


		// 获取编辑信息
		var customerId = $('input[name="customerId"]').val();
		axios.get(`/customer/selectCustomerDetailByCId?customerId=${customerId}`
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="customerNumber"]').val(data.data.customerNumber);
				$('input[name="customerName"]').val(data.data.customerName);
				$('input[name="introduction"]').val(data.data.introduction);
				$('input[name="phone"]').val(data.data.phone);
				$('input[name="fax"]').val(data.data.fax);
				$('input[name="address"]').val(data.data.address);
				$('input[name="financialContact"]').val(data.data.financialContact);
				$('input[name="bankAccount"]').val(data.data.bankAccount);
				$('input[name="accountNumber"]').val(data.data.accountNumber);
				$('input[name="creditCode"]').val(data.data.creditCode);
				$('input[name="taxNumber"]').val(data.data.taxNumber);
				$('input[name="accountPeriod"]').val(data.data.accountPeriod);
				$('input[name="returnCredit"]').val(data.data.returnCredit);
				$('input[name="customerValue"]').val(data.data.customerValue);
				$('input[name="annualSales"]').val(data.data.annualSales);
				$('textarea[name="comment"]').text(data.data.comment);
				// 获取动态表格的数据
				table.reload('idTest', {
					data: data.data.customerContactList
				});
			}
		}).catch(function (error) {
			console.log(error);
		});



	})
});
