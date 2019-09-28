<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/MRPOperation/open.css">
	<script type="text/javascript" src="/static/js/MRPOperation/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-MRP运算 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">

						<div class="layui-row">

							<div class="layui-tab layui-tab-brief">
								<ul class="layui-tab-title">
									<li class="layui-this">毛需求</li>
									<li>采购建议</li>
								</ul>
								<div class="layui-tab-content">
									<div class="layui-tab-item layui-show">

										<div class="layui-row">
											<div class="layui-col-md12">
												<div class="layui-card">
													<div class="layui-card-body">
														<div class="zq-zq-datatable">
															<table id="idTest" lay-filter="demo"></table>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
									<div class="layui-tab-item">
										<div class="layui-row">
											<div class="layui-col-md12">
												<div class="layui-card">
													<div class="layui-card-header">
														<div class="zq-btn-list">
															<button class="layui-btn green zq-active" type="button">下达任务</button>
														</div>
													</div>
													<div class="layui-card-body">
														<div class="zq-zq-datatable">
															<table id="idTest1" lay-filter="demo1"></table>
														</div>
													</div>
												</div>
											</div>
										</div>
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