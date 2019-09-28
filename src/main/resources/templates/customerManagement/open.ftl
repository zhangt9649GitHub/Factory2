<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/customerManagement/open.css">
	<script type="text/javascript" src="/static/js/customerManagement/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-客户信息 <span></span></h3>
				<div class="zq-btn-list">

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" >
						<input type="hidden" name="customerId" value="${customerId}">
						<div class="layui-row layui-col-space10">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="customerNumber" readonly class="layui-input" >
								</div>
							</div>


							<div class="layui-col-md12">
								<table class="zq-table">
									<tbody>
									<tr>
										<th><div>客户名称</div></th>
										<td><div><input type="text" name="customerName" readonly autocomplete="off"/></div></td>
										<th><div>公司简介</div></th>
										<td><div><input type="text" name="introduction" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>电话</div></th>
										<td><div><input type="text" name="phone" readonly autocomplete="off"/></div></td>
										<th><div>传真</div></th>
										<td><div><input type="text" name="fax" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>客户地址</div></th>
										<td><div><input type="text" name="address" readonly autocomplete="off"/></div></td>
										<th><div>财务联系人</div></th>
										<td><div><input type="text" name="financialContact" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>开户银行</div></th>
										<td><div><input type="text" name="bankAccount" readonly autocomplete="off"/></div></td>
										<th><div>账号</div></th>
										<td><div><input type="text" name="accountNumber" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>社会统一信用代码</div></th>
										<td><div><input type="text" name="creditCode" readonly autocomplete="off"/></div></td>
										<th><div>税号</div></th>
										<td><div><input type="text" name="taxNumber" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>账期（月）</div></th>
										<td><div><input type="text" name="accountPeriod" readonly autocomplete="off"/></div></td>
										<th><div>回款信誉</div></th>
										<td><div><input type="text" name="returnCredit" readonly autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>客户价值</div></th>
										<td><div><input type="text" name="customerValue" readonly autocomplete="off"/></div></td>
										<th><div>年销售额</div></th>
										<td><div><input type="text" name="annualSales" readonly autocomplete="off" /></div></td>
									</tr>
									</tbody>
								</table>

								<div class="zq-datatable">
									<div class="zq-item">联系人信息</div>
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea placeholder="备注信息" name="comment" readonly class="layui-textarea"></textarea>
								</div>
							</div>



						</div>

					</form>


				</div>



			</div>

		</div>

	</div>



</div>


<!-- 添加删除图标按钮 -->
<script type="text/html" id="barDemo">
	<div>

		<span class="iconfont iconhao green"  lay-event="addRow"></span>

		&nbsp;

		<span class="iconfont icon-hao red"  lay-event="daleteRow"></span>

	</div>
</script>


</body>
</html>