<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/payroll/edit.css">
	<script type="text/javascript" src="/static/js/payroll/edit.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-工资单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*">提交</button>

					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">
						返回列表
					</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<input type="hidden" name="payrollId" value="${payrollId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="payrollNumber" readonly class="layui-input">
								</div>
							</div>

							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" lay-verify="required" lay-reqtext="请选择日期" class="layui-input" readonly id="date">
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>开始日期：</label>
									<input type="text" name="startTime" lay-verify="required" lay-reqtext="请选择开始日期" class="layui-input" readonly id="date-1">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>结束日期：</label>
									<input type="text" name="endTime" lay-verify="required" lay-reqtext="请选择结束日期" class="layui-input" readonly id="date-2">
								</div>
							</div>


							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea placeholder="" class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>制单人：</label>
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