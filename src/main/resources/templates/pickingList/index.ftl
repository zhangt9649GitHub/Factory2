<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/pickingList/index.css">
	<script type="text/javascript" src="/static/js/pickingList/index.js"></script>

</head>
</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">领料单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertPicking??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/pickingList/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updatePickingInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/pickingList/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deletePickingById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if updatePickingState??>
						<button class="layui-btn blue zq-active" type="button" data-type="updateStatus">
							更新状态
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
								<input type="text" name="pickingNumber" placeholder="请输入" autocomplete="off" class="layui-input">
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
								<input type="text" name="outWarehouseName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="intoWarehouseName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value=""></option>
									<option value="1">已创建</option>
									<option value="2">已领料</option>
									<option value="3">已确认</option>
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
<script type="text/html" id="pickingNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/pickingList/open?pickingId={{d.pickingId}}" data-type="zq_newOpen">{{d.pickingNumber}}</a>
</script>
<!-- 编号 -->
<!-- 状态 -->
<script type="text/html" id="state">

	{{# if(d.state == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
	{{# } }}
	{{# if(d.state == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">已领料</span>
	{{# } }}

	{{# if(d.state == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已确认</span>
	{{# } }}



</script>
<!-- 状态 -->


</body>
</html>