<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/payroll/open.css">
	<script type="text/javascript" src="/static/js/payroll/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-工资单 <span></span></h3>
				<div class="zq-btn-list">

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
									<input type="text" name="addTime" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>开始日期：</label>
									<input type="text" name="startTime" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>结束日期：</label>
									<input type="text" name="endTime" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md6 ">
								<div class="zq-item">
									<label>角色：</label>
									<input type="text" name="bizId" class="layui-input" readonly>
								</div>
							</div>

							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea readonly class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>制单人：</label>
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




</body>
</html>