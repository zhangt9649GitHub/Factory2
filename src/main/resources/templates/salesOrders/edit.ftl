<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesOrders/edit.css">


</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-销售订单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*" >提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
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
									<input type="text" name="salesOrderNumber"  lay-verify="required" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>订单类型：</label>
									<select name="orderType" lay-search  lay-filter="orderType" lay-verify="required" lay-reqText="请选择订单类型">
										<option value=""></option>
										<option value="1">日本出口</option>
										<option value="2">天津贩卖</option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addtime"  lay-verify="required" lay-reqText="请选择日期" class="layui-input" readonly id="laydate-1">
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
												<select name="customerId" lay-search  lay-verify="required" lay-reqtext="请选择客户">
													<option value="">请选择</option>
												</select>
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
									<textarea name="comment" placeholder="备注信息" class="layui-textarea"></textarea>
								</div>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="hidden" name="staffId" value="${(Session.user.staffId)!''}" lay-verify="required" >
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
<script type="text/javascript" src="/static/js/salesOrders/edit.js"></script>

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