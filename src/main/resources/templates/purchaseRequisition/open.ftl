<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseRequisition/open.css">
	<script type="text/javascript" src="/static/js/purchaseRequisition/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-采购申请单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">

						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" class="layui-input" readonly value="1929831239" >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" readonly value="2019-04-29">
								</div>
							</div>


							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea placeholder="备注信息" class="layui-textarea" readonly></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" readonly value="罗丽丽">
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