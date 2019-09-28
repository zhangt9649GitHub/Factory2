<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/requisition/add.css">

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">新增-调拨单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" type="button" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<div class="layui-row layui-col-space10">
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" lay-verify="required" name="requisitionNumber" readonly class="layui-input" >
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>调拨类型：</label>
									<select name="type" lay-verify="required" lay-search>
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addtime" lay-verify="required" class="layui-input" autocomplete="off" id="laydate-1">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" lay-verify="required">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>调出仓库：</label>
									<select name="outWarehouseId" lay-verify="required" lay-search lay-filter="outWarehouseId">
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>调入仓库：</label>
									<select name="intoWarehouseId" lay-verify="required" lay-search >
										<option value=""></option>
									</select>
								</div>
							</div>
							<div class="layui-col-md12">
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
									<select lay-scarch name="staffId" lay-verify="required">
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

<script type="text/javascript" src="/static/js/requisition/add.js"></script>

</body>
</html>