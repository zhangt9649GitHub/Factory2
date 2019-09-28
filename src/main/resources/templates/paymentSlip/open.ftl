<#include "../public_header.ftl">



<script type="text/javascript" src="/static/js/paymentSlip/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-付款单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<input type="hidden" name="paymentOrderId" value="${paymentOrderId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="paymentOrderNumber" readonly  class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" readonly  class="layui-input" >
								</div>
							</div>
							<table class="zq-table">

								<tbody>
								<tr>
									<th >
										<div>
											付款类型
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="category" readonly  class="layui-input" >
										</div>
									</td>
									<th >
										<div>
											收款方
										</div>
									</th>
									<td >
										<div class="input">
											<input type="text" name="beneficiary" readonly/>
										</div>

									</td>
									<th >
										<div>
											关联单据
										</div>
									</th>
									<td >
										<div class="input">
											<input type="text" name="associatedDocument" readonly/>
										</div>
									</td>
								</tr>

								<tr>
									<th >
										<div>
											单据金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="amount" readonly/>
										</div>
									</td>
									<th >
										<div>
											待付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="pendingPaymentAmount" readonly/>
										</div>
									</td>
									<th >
										<div>
											折扣金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="discountAmount" readonly/>
										</div>
									</td>

								</tr>

								<tr>
									<th >
										<div>
											待核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="pendingWriteOffAmount" readonly/>
										</div>
									</td>
									<th >
										<div>
											付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="paymentAmount" readonly/>
										</div>
									</td>
									<th >
										<div>
											核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="writeOffAmount" readonly/>
										</div>
									</td>

								</tr>
								<tr>
									<th >
										<div>
											支付方式
										</div>
									</th>
									<td colspan="5">
										<div>
											<input type="text" name="paymentMethod" readonly/>
										</div>
									</td>
								</tr>



								</tbody>
							</table>


							<!-- 备注 -->

							<div class="remarks">
								<textarea name="comment" readonly class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="name" readonly/>
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