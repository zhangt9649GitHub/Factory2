<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/index/homepage.css">
	<script type="text/javascript" src="/static/js/index/homepage.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row layui-col-space15">
		<div class="layui-col-sm6 layui-col-md3 bg-1">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					实时数据
				</div>
				<div class="layui-card-body card-list">

				</div>
			</div>
		</div>
		<div class="layui-col-sm6 layui-col-md3 bg-2">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					预警信息
				</div>
				<div class="layui-card-body card-list">
					<div class="item zq-active" data-href="/admin/inventoryWarning/index" data-type="zq_newOpen">
						<a href="###">库存预警</a>
					</div>
					<div class="item zq-active" data-href="/admin/purchaseLeadTimeWarning/index" data-type="zq_newOpen">
						<a href="###">采购交货期预警</a>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-sm6 layui-col-md3 bg-3">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					待办信息
				</div>
				<div class="layui-card-body card-list">

				</div>
			</div>
		</div>
		<div class="layui-col-sm6 layui-col-md3 bg-4">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					快捷操作
				</div>
				<div class="layui-card-body card-list">
					<div class="layui-btn white" id="upload-file">
						<i class="layui-icon layui-icon-upload-drag"></i>
						导入
					</div>
					<div class="layui-btn white">
						<i class="layui-icon layui-icon-download-circle"></i>
						导出
					</div>
				</div>
			</div>
		</div>

		<div class="layui-col-sm12 layui-col-md12">
			<div class="layui-card table2">

				<div class="layui-card-body">
					<table id="idTest2" lay-filter="demo1"></table>
					<div class="wrap">
						<div class="list">
							<div class="item">
								<div class="cell">目标</div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell">700万元</div>
							</div>
							<div class="item">
								<div class="cell">2500万日元</div>
							</div>
							<div class="item">
								<div class="cell">1000万日元</div>
							</div>
							<div class="item">
								<div class="cell">3500万日元</div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>
							<div class="item">
								<div class="cell"></div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="layui-col-sm12 layui-col-md6">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					总资产
				</div>
				<div class="layui-card-body">
					<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
					<div id="main1" class="echarts"></div>
				</div>
			</div>
		</div>
		<div class="layui-col-sm12 layui-col-md6">
			<div class="layui-card">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					采购分析
				</div>
				<div class="layui-card-body">
					<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
					<div id="main2" class="echarts"></div>
				</div>
			</div>
		</div>

		<div class="layui-col-sm12 layui-col-md6">
			<div class="layui-card table">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					领料明细
				</div>
				<div class="layui-card-body">
					<table id="idTest" lay-filter="demo"></table>
				</div>
			</div>
		</div>

		<div class="layui-col-sm12 layui-col-md6">
			<div class="layui-card table1">
				<div class="layui-card-header">
					<span class="iconfont iconego-menu"></span>
					排产单
				</div>
				<div class="layui-card-body">
					<table id="idTest1" lay-filter="demo1"></table>
				</div>
			</div>
		</div>






	</div>



</div>
<!-- 排产单状态 -->
<script type="text/html" id="ProductionOrder">

	{{# if(d.state == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
	{{# } }}
	{{# if(d.state == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">部分完成</span>
	{{# } }}

	{{# if(d.state == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已完成</span>
	{{# } }}



</script>
<!-- 排产单状态 -->
</body>
</html>