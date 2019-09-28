<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesOrders/open.css">
	<script type="text/javascript" src="/static/js/salesOrders/open.js"></script>

</head>
<body>


<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-销售订单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="export">导出</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form >
						<input type="hidden" name="salesOrderId" value="${salesOrderId}">
						<div class="layui-row layui-col-space10">
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="salesOrderNumber" readonly class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>订单类型：</label>
									<input type="text" name="orderType" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addtime" class="layui-input" readonly>
								</div>
							</div>

							<div class="layui-col-md12">
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
									</tbody>
								</table>

								<div class="zq-datatable">
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" readonly class="layui-textarea"></textarea>
								</div>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="staffName" readonly>

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