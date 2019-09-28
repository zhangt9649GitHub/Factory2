<#include "../public_header.ftl">



<script type="text/javascript" src="/static/js/paymentSlip/add.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-付款单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*" >提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">

						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="paymentOrderNumber" readonly lay-verify="required" class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" readonly lay-verify="required" class="layui-input" id="date">
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
											<select name="category" lay-verify="required" lay-reqText="付款类型不能为空" lay-search lay-filter="category">
												<option value=""></option>
											</select>
										</div>
									</td>
									<th >
										<div>
											收款方
										</div>
									</th>
									<td >
										<div class="input">
											<input type="text" name="beneficiaryInput"  autocomplete="off"/>
										</div>
										<div class="zq-hide select">
											<select name="beneficiarySelect" lay-search lay-filter="beneficiarySelect">
												<option value=""></option>
											</select>
										</div>
									</td>
									<th >
										<div>
											关联单据
										</div>
									</th>
									<td >
										<div class="input">
											<input type="text" name="associatedDocumentInput"  autocomplete="off"/>
										</div>
										<div class="select zq-hide">
											<select name="associatedDocumentSelect" lay-search lay-filter="associatedDocumentSelect">
												<option value=""></option>
											</select>
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
											<input type="text" name="amount" lay-verify="required|number" lay-reqText="单据金额不能为空" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											待付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="pendingPaymentAmount" lay-verify="required|number" lay-reqText="代付款金额不能为空" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											折扣金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="discountAmount" lay-verify="required|number" lay-reqText="折扣金额不能为空" autocomplete="off"/>
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
											<input type="text" name="pendingWriteOffAmount"  autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="paymentAmount" lay-verify="required|number" lay-reqText="付款金额不能为空" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="writeOffAmount" lay-verify="number" autocomplete="off"/>
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
											<select name="paymentMethod" lay-verify="required" lay-reqText="支付方式不能为空" lay-search >
												<option value=""></option>
											</select>
										</div>
									</td>
								</tr>



								</tbody>
							</table>


							<!-- 备注 -->

							<div class="remarks">
								<textarea name="comment" placeholder="备注信息" class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="hidden" name="staffId" value="${(Session.user.staffId)!''}" lay-verify="required" >
									<input type="text" name="staffName" readonly value="${(Session.user.name)!''}">

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