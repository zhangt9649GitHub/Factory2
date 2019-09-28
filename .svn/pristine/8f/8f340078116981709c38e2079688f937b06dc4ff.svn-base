<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/styleBook/add.css">
	<script type="text/javascript" src="/static/js/styleBook/add.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-式样书 <span></span></h3>
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
									<input type="text" name="styleBookNumber" readonly lay-verify="required" class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="date" class="layui-input" lay-verify="required" autocomplete="off" id="date">
								</div>
							</div>

							<div class="layui-col-md12">
								<table class="zq-table">
									<tbody>
									<tr>
										<th>
											<div>
												品名
											</div>
										</th>
										<td>
											<div>
												<input type="text" name="goodsName" autocomplete="off" lay-verify="required"/>
											</div>
										</td>
										<th>
											<div>
												创建人
											</div>
										</th>
										<td>
											<div>
												<select name="staffId" lay-verify="required">
													<option value="${(Session.user.staffId)!''}">${(Session.user.name)!''}</option>
												</select>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="4" class="zq-padding-lr-0">
											<div id="editor"></div>
										</td>
									</tr>
									</tbody>
								</table>

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