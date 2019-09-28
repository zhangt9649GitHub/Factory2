<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/outboundOrder/open.css">
	<script type="text/javascript" src="/static/js/outboundOrder/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-出库单 <span></span></h3>
				<div class="zq-btn-list">

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">
						<input type="hidden" name="outboundOrderId" value="${outboundOrderId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="outboundOrderNumber" readonly >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" readonly >
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>仓库：</label>
									<input type="text" name="warehouseId" readonly >
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>出库类型：</label>
									<input type="text" name="type" readonly >
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" readonly >
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
									<input type="text" name="staffId" readonly >
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