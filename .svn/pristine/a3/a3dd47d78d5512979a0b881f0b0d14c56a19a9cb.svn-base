<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionOrder/open.css">
	<script type="text/javascript" src="/static/js/productionOrder/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-排产单 <span></span></h3>
				<div class="zq-btn-list">

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form>
						<input type="hidden" name="productionOrderId" value="${productionOrderId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="productionOrderNumber" class="layui-input" readonly >
								</div>
							</div>

							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" class="layui-input" readonly>
								</div>
							</div>

							<div class="layui-col-md12">
								<div class="zq-datatable">
									<div class="zq-item">
										销售订单

									</div>
									<div>
										<input type="checkbox" name="isCreatePicking" disabled lay-skin="primary" title="自动生成领料单">
									</div>
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" readonly class="layui-textarea"></textarea>
								</div>

								<div class="layui-col-md6">
									<div class="zq-item">
										<label>创建人：</label>
										<input type="text" name="name" readonly>
									</div>
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