<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseReturn/open.css">
	<script type="text/javascript" src="/static/js/purchaseReturn/open.js"></script>

</head>
<body>


<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-采购退换货单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form >
						<input type="hidden" name="proId" value="${proId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="purchaseReturnOrderNumber" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" class="layui-input" readonly>
								</div>
							</div>

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
											<input type="text" name="supplierId" class="layui-input" readonly>

										</div>
									</td>
								</tr>
								<tr>
									<th class="th-width240">
										<div>
											原采购订单编号
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="purchaseOrderId" class="layui-input" readonly>

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

					</form>


				</div>



			</div>

		</div>

	</div>



</div>





</body>
</html>