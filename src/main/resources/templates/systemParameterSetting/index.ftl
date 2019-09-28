<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/systemParameterSetting/index.css">
	<script type="text/javascript" src="/static/js/systemParameterSetting/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">系统参数设置 <span></span></h3>
			</div>
			<div class="layui-card-body index-body">

				<div class="layui-tab layui-tab-brief">
					<ul class="layui-tab-title">
						<li class="layui-this">基本参数设置</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<form class="layui-form" lay-filter="formTest">
								<div class="list">
									<div class="left">
										PDA生产入库:
									</div>
									<div class="main">
										<input type="checkbox" name="requiredQuantityGoodsInsufficient" value="1" lay-skin="switch" lay-text="开启|关闭">
									</div>
									<div class="right">
										生产入库数量所属货物数量小于库存量是否可以操作的设置
									</div>

								</div>
								<div class="list">
									<div class="left">
										日志写入:
									</div>
									<div class="main">
										<input type="checkbox" name="logWrite" value="true" lay-skin="switch" lay-text="开启|关闭">
									</div>
									<div class="right">
										后台是否保留操作记录
									</div>
								</div>
								<div class="list">
									<div class="left"></div>
									<div class="main">
										<button class="layui-btn green" lay-submit="" lay-filter="*">提交</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>
</body>
</html>