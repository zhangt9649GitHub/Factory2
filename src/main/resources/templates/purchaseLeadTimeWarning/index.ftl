<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseLeadTimeWarning/index.css">
	<script type="text/javascript" src="/static/js/purchaseLeadTimeWarning/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">采购交货期预警  <span></span></h3>
				<div class="zq-btn-list">

					<!--<button class="layui-btn lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i>查询</button>-->
					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="supplierName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="defineDate" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-1">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="specification" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="quantity" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="deliveryDate" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-2">
							</div>

							<div class="item ">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="storageState" lay-search>
									<option value=""></option>
									<option value="1">未入库</option>
									<option value="2">部分入库</option>
									<option value="3">已入库</option>
								</select>
							</div>
							<div class="item ">
								<button type="button"  lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
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

</div>
<!-- 编号 -->
<script type="text/html" id="partsCd">
	<a href="###" class="zq-active zq-open" >{{d.partsCd}}</a>
</script>
<!-- 编号 -->
<!-- 状态 -->
<script type="text/html" id="storageState">

	{{# if(d.storageState == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg5">未入库</span>
	{{# } }}
	{{# if(d.storageState == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">部分入库</span>
	{{# } }}
	{{# if(d.storageState == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">已入库</span>
	{{# } }}
</script>
<!-- 状态 -->
</body>
</html>