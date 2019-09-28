<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseRequisition/index.css">
	<script type="text/javascript" src="/static/js/purchaseRequisition/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">采购申请单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertPurchaseApply??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/purchaseRequisition/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updatePurchaseApplyInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/purchaseRequisition/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deletePurchaseApply??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if createPurchaseOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="generatingOrders" data-href="/admin/purchaseRequisition/generatingOrders">
						生成采购订单
					</button>
					</#if>

					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
					<#if exportPurchaseApplyList??>
					<button class="layui-btn blue zq-active" type="button" data-type="export">
						<i class="layui-icon layui-icon-download-circle"></i>导出
					</button>
					</#if>
				</div>

			</div>
			<div class="layui-card-body index-body">
				<form class="layui-form zq-search-form">
					<button class="layui-btn layui-hide" type="reset">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search zq-search-fixed">
							<div class="item checkbox">

							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="zq-search search">
							<div class="item checkbox">

							</div>
							<div class="item ">

							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="quantity" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="unit" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseCycle" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purpose" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="defineDate" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-1">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="monthsInStock" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item tjStock">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="tjStock" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>




							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="supplierName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item ">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="stairPrice" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="handleStatus" lay-search>
									<option value=""></option>
									<option value="1">未生成</option>
									<option value="2">已生成</option>
								</select>
							</div>
							<#--<div class="item">-->
								<#--<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>-->
								<#--<input type="text" name="handleIdea" placeholder="请输入" autocomplete="off" class="layui-input">-->
							<#--</div>-->
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="specification" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="comment" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseNumber" placeholder="请输入" autocomplete="off" class="layui-input">
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




	<!-- 订单状态 -->
	<script type="text/html" id="orderStatus">

		{{# if(d.orderStatus == 1){ }}
		<span class="layui-btn layui-btn-xs zq-bg-gray">未确认</span>
		{{# } }}
		{{# if(d.orderStatus == 2){ }}
		<span class="layui-btn layui-btn-xs zq-bg-orange">未确认</span>
		{{# } }}
	</script>
	<!-- 订单状态 -->


	<!-- 处理状态 -->
	<script type="text/html" id="handleStatus">

		{{# if(d.handleStatus == 1){ }}
		<span class="layui-btn layui-btn-xs zq-bg-gray">未生成</span>
		{{# } }}
		{{# if(d.handleStatus == 2){ }}
		<span class="layui-btn layui-btn-xs zq-bg-white">已生成</span>
		{{# } }}
	</script>
	<!-- 处理状态 -->
</div>

</body>
</html>