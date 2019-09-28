$(document).ready(function(){
	layui.use(['form', 'table', 'layer', 'laydate'], function() {
		
		var	layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate;
			table = layui.table;


	
		// 动态表格
		table.render({
			elem: '#idTest',
			limit: 10000,
			cellMinWidth: 80, // 定义所有常规单元格的最小宽度
			totalRow: true, //开启合计
			data: [],
			cols: [
				[
					{
						type: 'numbers',
						title: '序号',
						unresize: true,
						width: 70,
						totalRowText: '合计'
					}, {
						field: 'bookNumber',
						title: '禀议书号码',
						unresize: true
					}, {
						field: 'costPeriod',
						title: '费用日期',
						unresize: true
					}, {
						field: 'use',
						title: '用途',
						unresize: true

					}, {
						field: 'amount',
						title: '金额',
						edit: 'text',
						unresize: true,
						totalRow: true
					},  {
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



		// 获取编辑信息
		let formdata = new FormData();
		formdata.append('id',$('input[name="reimburseId"]').val());
		axios.post('/reimburse/getById',formdata
		).then(function (response) {
			let data = response.data;
			if(data.code == 0) {
				$('input[name="reimburseNumber"]').val(data.data.reimburseNumber);
				$('input[name="applicationTime"]').val(data.data.applicationTime);
				$('textarea[name="comment"]').text(data.data.comment);
				$('input[name="createStaffId"]').val(data.data.createName);

				$('input[name="reviewStaffId"]').val(data.data.reviewName);

				table.reload('idTest', {
					data: data.data.reimburseDetails
				});


				form.render('select');
			}
		}).catch(function (error) {
			console.log(error);
		});
	
	
	
	})
});

