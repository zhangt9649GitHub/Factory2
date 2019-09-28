<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/positionManagement/index.css">
	<script type="text/javascript" src="/static/js/positionManagement/index.js"></script>

</head>
<body>

<div class="zq-wrap">


	<div class="layui-row">
		<div class="bg-1 layui-card layui-form">
			<div class="layui-card-header layui-clear">
				<h3 class="left">仓位管理 <span></span></h3>
				<div class="zq-btn-list">
					<#if addWarehousePosition??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/positionManagement/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if editWP??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/positionManagement/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteWPById??>
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
								<input type="text" name="wpName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="warehouseName" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="createTime" placeholder="请输入" autocomplete="off" class="layui-input" id="createTime">
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
<script type="text/html" id="wpName">
	<a href="###" class="zq-active zq-open" data-href="/admin/positionManagement/open" data-type="open">{{d.wpName}}</a>
</script>
<!-- 编号 -->


</body>
</html>