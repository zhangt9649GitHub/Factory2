<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseOrder/open.css">
	<script type="text/javascript" src="/static/js/purchaseOrder/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-采购订单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form >
						<input type="hidden" name="purchaseOrderId" value="${purchaseOrderId}">

						<div class="layui-row layui-col-space10">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="purchaseOrderNumber" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>销售订单：</label>
									<input type="text" name="salesOrderId" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>交货日期：</label>
									<input type="text" name="deliveryDate" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md12">
								<table class="zq-table">
									<tbody>
									<tr>
										<th class="th-width240">
											<div>
												供应商
											</div>
										</th>
										<td >
											<div>
												<input type="text" name="supplierId" readonly class="layui-input">
											</div>
										</td>
									</tr>
									<tr>
										<th class="th-width240">
											<div>
												采购类型
											</div>
										</th>
										<td >
											<div>
												<input type="text" name="purchaseType" readonly class="layui-input">

											</div>
										</td>
									</tr>

									</tbody>
								</table>
								<div class="zq-datatable">
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<table class="zq-table">
									<tr>
										<td class="td-width-51"><div></div></td>
										<td>
											<div>
												<input type="text" name="capital"  readonly class="layui-input">
											</div>
										</td>
									</tr>
								</table>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" readonly class="layui-textarea"></textarea>
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