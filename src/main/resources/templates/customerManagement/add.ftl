<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/customerManagement/add.css">
	<script type="text/javascript" src="/static/js/customerManagement/add.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-客户信息 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" >

						<div class="layui-row layui-col-space10">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="customerNumber" readonly lay-verify="required" class="layui-input" >
								</div>
							</div>


							<div class="layui-col-md12">
								<table class="zq-table">
									<tbody>
									<tr>
										<th><div>客户名称</div></th>
										<td><div><input type="text" name="customerName" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>公司简介</div></th>
										<td><div><input type="text" name="introduction" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>电话</div></th>
										<td><div><input type="text" name="phone" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>传真</div></th>
										<td><div><input type="text" name="fax" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>客户地址</div></th>
										<td><div><input type="text" name="address" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>财务联系人</div></th>
										<td><div><input type="text" name="financialContact" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>开户银行</div></th>
										<td><div><input type="text" name="bankAccount" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>账号</div></th>
										<td><div><input type="text" name="accountNumber" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>社会统一信用代码</div></th>
										<td><div><input type="text" name="creditCode" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>税号</div></th>
										<td><div><input type="text" name="taxNumber" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>账期（月）</div></th>
										<td><div><input type="text" name="accountPeriod" lay-verify="required|number" autocomplete="off"/></div></td>
										<th><div>回款信誉</div></th>
										<td><div><input type="text" name="returnCredit" lay-verify="required" autocomplete="off"/></div></td>
									</tr>
									<tr>
										<th><div>客户价值</div></th>
										<td><div><input type="text" name="customerValue" lay-verify="required" autocomplete="off"/></div></td>
										<th><div>年销售额</div></th>
										<td><div><input type="text" name="annualSales" lay-verify="required" autocomplete="off" /></div></td>
									</tr>
									</tbody>
								</table>

								<div class="zq-datatable">
									<div class="zq-item">联系人信息</div>
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea placeholder="备注信息" name="comment" class="layui-textarea"></textarea>
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