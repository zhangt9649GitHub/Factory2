<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesDetails/index.css">
	<script type="text/javascript" src="/static/js/salesDetails/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">销售明细 <span></span></h3>
				<div class="zq-btn-list">
					<form action="" class="layui-form">

						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="dateRange" readonly placeholder="请输入日期" class="layui-input" id="laydata-1">
							</div>
						</div>

						<button type="button" class="layui-btn blue zq-active" data-type="search"><i class="layui-icon layui-icon-search"></i>搜索</button>
						<button type="reset" class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					</form>
				</div>
			</div>

			<div class="layui-card-body index-body">
				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入部件CD" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="customerName" placeholder="请输入客户名称" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addtime" placeholder="请输入销售日期" autocomplete="off" class="layui-input" id="laydata-2">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsName" placeholder="请输入品名" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="specification" placeholder="请输入规格" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="quantity" placeholder="请输入销售数量" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="sellingPrice" placeholder="请输入单价" autocomplete="off" class="layui-input">
							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="totalPrice" placeholder="请输入总价" autocomplete="off" class="layui-input">
							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="skgCount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="salesOrderNumber" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
							</div>

						</div>
					</div>
				</form>
				<div class="zq-layui-table index-table ">
					<table id="idTest" lay-filter="demo" class="layui-table" lay-even lay-skin="nob"></table>
				</div>

			</div>
		</div>
	</div>





	<!-- 编号 -->
	<script type="text/html" id="partsCd">
		<a href="###" class="zq-active zq-open" >{{d.partsCd}}</a>
	</script>
	<!-- 编号 -->
</div>

</body>
</html>