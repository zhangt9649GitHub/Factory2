<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/supplierManagement/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">
			<input type="hidden" name="supplierId" value="${supplierId}">
			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-供应商 <span></span></h3>
				<div class="zq-btn-list">

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" >

						<div class="layui-row">


							<table class="zq-table">
								<tbody>
								<tr>
									<th><div>供应商名称</div></th>
									<td><div><input type="text" name="supplierName" readonly lay-verify="required" autocomplete="off"/></div></td>
									<th><div>供应商编码</div></th>
									<td><div><input type="text" name="supplierNumber" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>联系人</div></th>
									<td><div><input type="text" name="contact" readonly lay-verify="required" autocomplete="off"/></div></td>
									<th><div>地址</div></th>
									<td><div><input type="text" name="address" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>联系电话</div></th>
									<td><div><input type="text" name="phone" readonly lay-verify="required" autocomplete="off"/></div></td>
									<th><div>传真号码</div></th>
									<td><div><input type="text" name="fax" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>邮箱</div></th>
									<td><div><input type="text" name="email" readonly lay-verify="required" autocomplete="off"/></div></td>
									<th><div>公司网址</div></th>
									<td><div><input type="text" name="website" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>付款方式</div></th>
									<td><div><input type="text" name="paymentMethod" readonly lay-verify="required" autocomplete="off"/></div></td>
									<th><div>发票类别</div></th>
									<td><div><input type="text" name="invoiceCategory" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>账期</div></th>
									<td colspan="3">
										<div>
											<input type="text" name="accountPeriod" readonly lay-verify="required" autocomplete="off">
										</div>
									</td>
								</tr>
								</tbody>
							</table>
							<table  class="zq-table zq-margin-t30">
								<tbody>
								<tr>
									<th><div>户名</div></th>
									<td><div><input type="text" name="payee" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>银行名称</div></th>
									<td><div><input type="text" name="bankAccount" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>账号</div></th>
									<td><div><input type="text" name="accountNumber" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								<tr>
									<th><div>税号</div></th>
									<td><div><input type="text" name="taxNumber" readonly lay-verify="required" autocomplete="off"/></div></td>
								</tr>
								</tbody>
							</table>

							<div class="zq-datatable">
								<div class="zq-item">联系人信息</div>
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<div class="zq-datatable">
								<div class="zq-item">供应货物列表</div>
								<table id="idTest1" lay-filter="demo1" class="layui-table"></table>
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