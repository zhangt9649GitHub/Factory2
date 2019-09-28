<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/manifestManagement/open.js"></script>

</head>
<body>


<div class="zq-wrap">

	<div class="layui-row">
		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-货单管理 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="print">
						打印
					</button>

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form >
						<input type="hidden" name="shipmentId" value="${shipmentId}">
						<div class="layui-row layui-col-space10">
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="shipmentNumber" readonly class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md4">
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" class="layui-input" readonly>
								</div>
							</div>

							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
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