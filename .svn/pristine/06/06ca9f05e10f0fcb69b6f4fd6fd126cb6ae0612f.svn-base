<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionOrder/index.css">
	<script type="text/javascript" src="/static/js/productionOrder/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">排产单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertProductionOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/productionOrder/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateProductionOrderInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/productionOrder/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteProductionOrderById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<button class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>

				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">

						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="productionOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addTime" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-1">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value=""></option>
									<option value="1">已创建</option>
									<option value="2">部分完成</option>
									<option value="3">已完成</option>
								</select>
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
<script type="text/html" id="productionOrderNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/productionOrder/open?productionOrderId={{d.productionOrderId}}" data-type="zq_newOpen">{{d.productionOrderNumber}}</a>
</script>
<!-- 编号 -->
<!-- 状态 -->
<script type="text/html" id="state">

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
<!-- 状态 -->

</body>
</html>