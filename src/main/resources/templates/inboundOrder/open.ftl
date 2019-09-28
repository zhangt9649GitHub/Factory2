<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/inboundOrder/open.css">
	<script type="text/javascript" src="/static/js/inboundOrder/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-入库单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">
						<input type="hidden" name="storageAccessId" value="${storageAccessId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="storageNumber" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="rukuTime" class="layui-input" readonly>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>仓库：</label>
									<input type="text" name="warehouseId" readonly>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>入库类型：</label>
									<input type="text" name="type" readonly>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" readonly>
								</div>
							</div>


							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea name="comment" class="layui-textarea" readonly></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="createStaffId" readonly >
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