<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/requisition/open.css">
	<script type="text/javascript" src="/static/js/requisition/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-调拨单 <span></span></h3>
				<div class="zq-btn-list"></div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="">
						<div class="layui-row layui-col-space10">
							<input type="hidden" name="requisitionId" value="${requisitionId}">
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" readonly name="requisitionNumber" readonly class="layui-input" >
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>调拨类型：</label>
									<input type="text" name="type" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addtime" readonly class="layui-input" autocomplete="off">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>调出仓库：</label>
									<input type="text" name="outWarehouseId" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>调入仓库：</label>
									<input type="text" name="intoWarehouseId" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md12">
								<div class="zq-datatable">
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" readonly placeholder="备注信息" class="layui-textarea"></textarea>
								</div>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="staffId" readonly class="layui-input">
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