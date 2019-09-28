<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/listOfProductStructure/index.css">
	<script type="text/javascript" src="/static/js/listOfProductStructure/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">产品结构清单（BOM） <span></span></h3>
				<div class="zq-btn-list">
					<#if insertBomForm??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/listOfProductStructure/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateBomFormDetail??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/listOfProductStructure/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteBomFormById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>

					<#if importBomForm??>
						<button class="layui-btn blue" type="button" id="upload-file">
							<i class="layui-icon layui-icon-upload-drag"></i>导入
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
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="defineDate" placeholder="请输入" autocomplete="off" class="layui-input"  id="laydate-1">
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
	<a href="###" class="zq-active zq-open" data-href="/admin/listOfProductStructure/open?bomId={{d.bomId}}" data-type="zq_newOpen">{{d.partsCd}}</a>
</script>
<!-- 编号 -->
</body>
</html>