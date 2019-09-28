<#include "../public_header.ftl">



	<script type="text/javascript" src="/static/js/paymentSlip/edit.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-付款单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" type="button" >提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">

						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" class="layui-input" value="1929831239">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" class="layui-input" autocomplete="off" id="date">
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
											<select name="">
												<option value=""></option>
												<option value="">采购付款</option>
												<option value="">工资付款</option>
												<option value="">其它付款</option>
												<option value="">报销付款</option>
											</select>
										</div>
									</td>
									<th >
										<div>
											收款方
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
									<th >
										<div>
											关联单据
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
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
											<input type="text" name="" id="" value="" />
										</div>
									</td>
									<th >
										<div>
											待付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
									<th >
										<div>
											待核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
								</tr>

								<tr>
									<th >
										<div>
											付款金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
									<th >
										<div>
											核销金额
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
									<th >
										<div>
											支付方式
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="" id="" value="" />
										</div>
									</td>
								</tr>



								</tbody>
							</table>

							<!-- 备注 -->

							<div class="remarks">
								<textarea placeholder="备注信息" class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<select lay-scarch>
										<option value=""></option>
										<option value="1">丽丽</option>
										<option value="2">琪琪</option>
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