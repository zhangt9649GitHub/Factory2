<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/dataDictionary/index.css">
	<script type="text/javascript" src="/static/js/dataDictionary/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">数据字典 <span></span></h3>
				<div class="zq-btn-list">
					<form class="layui-form">
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="search" autocomplete="off" placeholder="输入关键字" class="layui-input">
							</div>
						</div>
						<#if insertBizd??>
						<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/dataDictionary/add">
							<i class="layui-icon layui-icon-add-1"></i>新增
						</button>
						</#if>
						<#if updateBizd??>
						<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/dataDictionary/edit">
							<i class="layui-icon layui-icon-edit"></i>编辑
						</button>
						</#if>
						<#if deleteBizd??>
						<button class="layui-btn red zq-active" type="button" data-type="delete">
							<i class="layui-icon layui-icon-delete"></i>删除
						</button>
						</#if>
						<button class="layui-btn blue" lay-submit="" lay-filter="*">
							<i class="layui-icon layui-icon-search"></i>搜索
						</button>
						<button class="layui-btn blue" type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					</form>

				</div>

			</div>
			<div class="layui-card-body">
				<div class="zq-layui-table  ">
					<table id="idTest" lay-filter="demo" class="layui-table" lay-even lay-skin="nob"></table>
				</div>
			</div>
		</div>
	</div>




</div>

</body>
</html>