<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/manifestManagement/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">货单管理 <span></span></h3>
				<div class="zq-btn-list">
					<#if updateShipmentState??>
						<button class="layui-btn blue zq-active" type="button" data-type="updateStatus">
							更新状态
						</button>
					</#if>

					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
				</div>
			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide"></button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="shipmentNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="salesOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value=""></option>
									<option value="1">已创建</option>
									<option value="2">已配货</option>
									<option value="3">已出库</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addTime" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-1">
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
<script type="text/html" id="shipmentNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/manifestManagement/open?shipmentId={{d.shipmentId}}" data-type="zq_newOpen">{{d.shipmentNumber}}</a>
</script>
<!-- 编号 -->

<!-- 状态 -->
<script type="text/html" id="state">

	{{# if(d.state == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
	{{# } }}
	{{# if(d.state == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">已配货</span>
	{{# } }}

	{{# if(d.state == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已出库</span>
	{{# } }}



</script>
<!-- 状态 -->

</body>
</html>