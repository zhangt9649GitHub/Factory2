<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/returnOrder/add.css">


</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-退料单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green" lay-submit lay-filter="*">提交</button>
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
									<input type="text" name="refundPickingNumber"  lay-verify="required" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime"  lay-verify="required" class="layui-input" readonly id="laydate-1">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>批号：</label>
									<select name="lotNumber" lay-search lay-verify="required">
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>领出仓库：</label>
									<select name="outWarehouseId" lay-search  lay-verify="required">
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>领入仓库：</label>
									<select name="intoWarehouseId" lay-search  lay-verify="required">
										<option value=""></option>
									</select>
								</div>
							</div>


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
									<input type="hidden" name="staffId" readonly value="${(Session.user.staffId)!''}">
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

<script type="text/javascript" src="/static/js/returnOrder/add.js"></script>
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