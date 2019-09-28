<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseReturn/index.css">
	<script type="text/javascript" src="/static/js/purchaseReturn/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">采购退换货单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertPurchaseReturnOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/purchaseReturn/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updatePurchaseReturnOrderInfo??>
						<#-- 出库以后不能编辑与删除 -->
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/purchaseReturn/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deletePurchaseReturnOrder??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if updatePurchaseReturnOrderStorageState??>
						<button class="layui-btn blue zq-active" type="button" data-type="updateStatus">
							更新状态
						</button>
					</#if>
					<#if exportPurchaseReturnOrderList??>
						<button class="layui-btn blue zq-active" type="button" data-type="export">
							<i class="layui-icon layui-icon-download-circle"></i>导出
						</button>
					</#if>

					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>

				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button class="layui-btn layui-hide" type="reset">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseReturnOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="defineDate" placeholder="请输入" autocomplete="off" class="layui-input" id='laydate-1'>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="supplierName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseReturnAmount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="paymentStatus" lay-search>
									<option value=""></option>
									<option value="1">未结算</option>
									<option value="2">已结算</option>
									<option value="3">部分结算</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="storageState" lay-search>
									<option value=""></option>
									<option value="1">未出库</option>
									<option value="2">已出库</option>
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
<script type="text/html" id="purchaseReturnOrderNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/purchaseReturn/open?proId={{d.proId}}" data-type="zq_newOpen">{{d.purchaseReturnOrderNumber}}</a>
</script>
<!-- 编号 -->
<!-- 结算状态 -->
<script type="text/html" id="paymentStatus">

	{{# if(d.paymentStatus == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg4">未结算</span>
	{{# } }}
	{{# if(d.paymentStatus == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已结算</span>
	{{# } }}
	{{# if(d.paymentStatus == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">部分结算</span>
	{{# } }}
</script>
<!-- 结算状态 -->

<!-- 出库状态 -->
<script type="text/html" id="storageState">

	{{# if(d.storageState == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg4">未出库</span>
	{{# } }}
	{{# if(d.storageState == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已出库</span>
	{{# } }}



</script>
<!-- 出库状态 -->

</body>
</html>