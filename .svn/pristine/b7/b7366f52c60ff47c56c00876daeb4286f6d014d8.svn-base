<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/warehouseManagement/index.css">
	<script type="text/javascript" src="/static/js/warehouseManagement/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card layui-form">
			<div class="layui-card-header layui-clear">
				<h3 class="left">仓库管理 <span></span></h3>
				<div class="zq-btn-list">
					<#if addWarehouse??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/warehouseManagement/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if editWarehouse??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/warehouseManagement/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deletetWarehouse??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<button class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class=" zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="warehouseId" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="warehouseName" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="staffId" lay-search >
									<option value=""></option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<select name="state" lay-search >
									<option value=""></option>
									<option value="2">使用中</option>
									<option value="1">空闲</option>
								</select>
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="comment" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="warehouseId">
	<a href="###" class="zq-active zq-open" data-href="/admin/warehouseManagement/open?warehouseId={{d.warehouseId}}" data-type="open">{{d.warehouseId}}</a>
</script>
<!-- 编号 -->
<#-- 仓库状态 -->
<script type="text/html" id="state">
	{{# if(d.state == 2){ }}
	<span class="">使用中</span>
	{{# } }}
	{{# if(d.state == 1){ }}
	<span class="">空闲</span>
	{{# } }}

</script>

<#-- 仓库状态 -->
</body>
</html>