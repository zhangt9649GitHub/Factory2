<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesReturn/open.css">
	<script type="text/javascript" src="/static/js/salesReturn/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-销售退货单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form>
						<input type="hidden" name="salesReturnId" value="${salesReturnId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="salesReturnNumber" readonly lay-verify="required" class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" readonly lay-verify="required" lay-reqText="请选择日期" class="layui-input" >
								</div>
							</div>

							<table class="zq-table">
								<tbody>
								<tr>
									<th class="th-width240">
										<div>
											客户名称
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="customerId" readonly class="layui-input">
										</div>
									</td>
								</tr>
								<tr>
									<th class="th-width240">
										<div>
											销售订单
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="salesOrderId" readonly class="layui-input">
										</div>
									</td>
								</tr>
								</tbody>
							</table>

							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea name="comment" readonly class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="staffName" readonly >
								</div>
							</div>


						</div>

					</form>


				</div>



			</div>

		</div>

	</div>



</div>





</body>
</html>