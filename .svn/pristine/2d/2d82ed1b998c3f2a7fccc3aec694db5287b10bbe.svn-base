<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseOrder/add.css">

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-采购订单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active"  lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form >
						<#-- 登入员工Id -->
						<input type="hidden" name="staffId" value="${(Session.user.staffId)!''}">
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
									<#--lay-verify="required" lay-reqtext="请选择销售订单"-->
									<select name="salesOrderId" lay-search >
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" class="layui-input" readonly lay-verify="required" lay-reqtext="请选择日期" id="laydate-1">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>交货日期：</label>
									<input type="text" name="deliveryDate" class="layui-input" readonly lay-verify="required" lay-reqtext="请选择交货日期" id="laydate-2">
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
												<select name="supplierId" lay-search lay-filter="supplierId" lay-verify="required" lay-reqtext="请选择供应商">
													<option value="">请选择</option>
												</select>
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
												<select name="purchaseType" lay-search  lay-verify="required" lay-reqtext="请选择采购类型">
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
								<table class="zq-table">
									<tr>
										<td class="td-width-51"><div></div></td>
										<td>
											<div>
												<input type="text" name="capital" placeholder="（大写）" readonly class="layui-input">
											</div>
										</td>
									</tr>
								</table>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" placeholder="备注信息" class="layui-textarea"></textarea>
								</div>
							</div>

						</div>

					</form>


				</div>



			</div>

		</div>

	</div>



</div>
<script type="text/javascript" src="/static/js/purchaseOrder/add.js"></script>

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