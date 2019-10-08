<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/cargoManagement/index.css">
	<script type="text/javascript" src="/static/js/cargoManagement/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">货物管理 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertGoods??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/cargoManagement/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateGoodsInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/cargoManagement/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteGoodsById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<button class="layui-btn blue zq-active" type="reset" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>

					<#if importGoods??>
					<button class="layui-btn blue" type="button" id="upload-file">
						<i class="layui-icon layui-icon-upload-drag"></i>导入
					</button>
					</#if>
					<#if importGoodsInfo??>
						<button class="layui-btn blue" type="button" id="upload-file1">
							<i class="layui-icon layui-icon-upload-drag"></i>导入日本数据
						</button>
					</#if>
					<#if exportGoodsList??>
					<button class="layui-btn blue zq-active" type="button" data-type="export">
						<i class="layui-icon layui-icon-download-circle"></i>导出
					</button>
					</#if>
					<button class="layui-btn blue zq-active" type="button" data-type="printing">
						打印
					</button>
					<button class="layui-btn blue zq-active" type="button" data-type="printAll">
						全部打印
					</button>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">

							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search zq-active"></i></button>
								<input type="text" name="goodsName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="variety" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="unit" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="specification" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="weight" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="unitPrice" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item a-danjia">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="aPrice" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item b-danjia">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="bPrice" placeholder="请输入）" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="sellingPrice" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="wholesalePrices" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="minimumStock" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="japanStock" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item tianjincekucun">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="tjStock" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="goodsNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/cargoManagement/open?goodsId={{d.goodsId}}" data-type="open">{{d.goodsNumber}}</a>
</script>
<!-- 编号 -->

</body>
</html>