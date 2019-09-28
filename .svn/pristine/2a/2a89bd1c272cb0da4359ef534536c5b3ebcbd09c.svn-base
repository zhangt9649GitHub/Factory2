<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/outboundOrder/add.css">
	<script type="text/javascript" src="/static/js/outboundOrder/add.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-出库单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" >

						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="outboundOrderNumber" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" readonly lay-verify="required" class="layui-input" id="laydate-1">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>仓库：</label>
									<select name="warehouseId" lay-search lay-verify="required" lay-filter="warehouseId">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>出库类型：</label>
									<select name="type" lay-search lay-verify="required">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" lay-verify="required" autocomplete="off" class="layui-input">
								</div>
							</div>

							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea placeholder="备注信息" name="comment" class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<select name="staffId" lay-scarch lay-verify="required">
										<option value="${(Session.user.staffId)!''}">${(Session.user.name)!''}</option>
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