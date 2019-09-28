<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesReturn/add.css">


</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-销售退货单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form>

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
									<input type="text" name="addTime" readonly lay-verify="required" lay-reqText="请选择日期" class="layui-input" id="laydate-1">
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
												<select name="customerId" lay-search lay-filter="customerId" lay-verify="required" lay-reqtext="请选择客户">
													<option value="">请选择</option>
												</select>
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
												<select name="salesOrderId" lay-search lay-filter="salesOrderId" lay-verify="required" lay-reqtext="请选择销售订单">
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

<script type="text/javascript" src="/static/js/salesReturn/add.js"></script>
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