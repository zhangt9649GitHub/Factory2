$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {

		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
		table = layui.table;

		// 获取编辑信息
		var formData= new FormData();
		formData.append('id',$('input[name="supplierId"]').val());
		axios.post('/supplier/getById',formData
		).then(function (response) {
			let data = response.data;

			if(data.code == 0) {
				$('input[name="supplierName"]').val(data.data.supplierName);
				$('input[name="supplierNumber"]').val(data.data.supplierNumber);
				$('input[name="contact"]').val(data.data.contact);
				$('input[name="address"]').val(data.data.address);
				$('input[name="phone"]').val(data.data.phone);
				$('input[name="fax"]').val(data.data.fax);
				$('input[name="email"]').val(data.data.email);
				$('input[name="website"]').val(data.data.website);
				$('input[name="paymentMethod"]').val(data.data.paymentMethod);
				$('input[name="invoiceCategory"]').val(data.data.invoiceCategory);
				$('input[name="payee"]').val(data.data.payee);
				$('input[name="bankAccount"]').val(data.data.bankAccount);
				$('input[name="accountNumber"]').val(data.data.accountNumber);
				$('input[name="taxNumber"]').val(data.data.taxNumber);
				$('input[name="accountPeriod"]').val(data.data.accountPeriod);
				// 获取动态表格的数据
				table.reload('idTest', {
					data: data.data.supplierContacts
				});
				table.reload('idTest1', {
					data: data.data.supplierGoods
				});
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
					{type:'numbers'},
					{
						field: 'department',
						title: '部门',
						unresize: true
					}, {
						field: 'position',
						title: '职务',
						unresize: true
					}, {
						field: 'contact',
						title: '联系人',
						unresize: true
					}, {
						field: 'phone',
						title: '电话',
						unresize: true
					}, {
						field: 'fax',
						title: '传真',
						unresize: true
					}, {
						field: 'email',
						title: 'EMAIL',
						unresize: true
					}, {
						field: 'comment',
						title: '备注',
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



		// 动态表格
		table.render({
			elem: '#idTest1',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			// totalRow: true, //开启合计行区域
			data: [],
			cols: [
				[
					{type:'numbers'},
					{
						field: 'partsCd',
						title: '部品CD',
						unresize: true
					}, {
						field: 'productName',
						title: '品名',
						unresize: true
					}, {
						field: 'specification',
						title: '规格',
						unresize: true
					}, {
						field: 'quantity',
						title: '供应过的数量',
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




	})
});

