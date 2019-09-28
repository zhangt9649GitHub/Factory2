<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/inventoryCheck/open.css">
	<script type="text/javascript" src="/static/js/inventoryCheck/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-盘点单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<input type="hidden" name="inventoryCheckId" value="${inventoryCheckId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="inventoryCheckNumber" readonly >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="fqTime" readonly>
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>仓库：</label>
									<input type="text" name="warehouseName" readonly>

								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>负责人：</label>
									<input type="text" name="name" readonly>

								</div>
							</div>
							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea name="comment" readonly class="layui-textarea"></textarea>
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