<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/listOfProductStructure/open.css">

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-产品结构表 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" >
						<input type="hidden" name="bomId" value="${bomId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="bomNumber" readonly class="layui-input">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="defineDate" readonly class="layui-input">
								</div>
							</div>

							<div class="zq-datatable datatable1">
								<table id="idTest-1" lay-filter="demo-1" class="layui-table"></table>
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

<script type="text/javascript" src="/static/js/listOfProductStructure/open.js"></script>



</body>
</html>