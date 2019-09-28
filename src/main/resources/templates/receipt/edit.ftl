<#include "../public_header.ftl">



<script type="text/javascript" src="/static/js/receipt/edit.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-收款单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*" >提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<input type="hidden" name="receiptId" value="${receiptId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="receiptNumber" readonly lay-verify="required" class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="cjTime" readonly lay-verify="required" class="layui-input" id="date">
								</div>
							</div>
							<table class="zq-table">

								<tbody>
								<tr>
									<th >
										<div>
											收款类型
										</div>
									</th>
									<td >
										<div>
											<select name="category" lay-verify="required" lay-search lay-filter="category">
												<option value=""></option>
											</select>
										</div>
									</td>
									<th >
										<div>
											付款方
										</div>
									</th>
									<td >
										<div class="input">
											<input type="text" name="payerInput" autocomplete="off"/>
										</div>
										<div class="zq-hide select">
											<select name="payerSelect" lay-search lay-filter="payerSelect">
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
											<input type="text" name="associatedDocumentInput" autocomplete="off"/>
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
											<input type="text" name="amount" lay-verify="required|number" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											应收金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="amountReceivable" lay-verify="required|number" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											待核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="pendingWriteOffAmount" lay-verify="required|number" autocomplete="off"/>
										</div>
									</td>
								</tr>

								<tr>
									<th >
										<div>
											收款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="collectionAmount" lay-verify="required|number" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="writeOffAmount" lay-verify="required|number" autocomplete="off"/>
										</div>
									</td>
									<th >
										<div>
											支付方式
										</div>
									</th>
									<td >
										<div>
											<select name="paymentMethod" lay-verify="required" lay-search >
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
									<select name="staffId" lay-scarch lay-verify="required">
										<option value="${(Session.user.staffId)!''}"></option>
									</select>
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