<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/purchaseOrder/index.css">
	<script type="text/javascript" src="/static/js/purchaseOrder/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">采购订单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertPurchaseOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/purchaseOrder/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updatePurchaseOrderInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/purchaseOrder/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deletePurchaseOrder??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if updatePurchaseOrderInfo??>
						<button class="layui-btn blue zq-active" type="button" data-type="editFinancialAmount" data-href="/admin/purchaseOrder/editFinancialAmount">
							<i class="layui-icon layui-icon-edit"></i>编辑财务金额
						</button>
					</#if>
					<button class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					<#if exportPurchaseOrderDetails??>
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
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="defineDate" placeholder="请输入" autocomplete="off" class="layui-input" id='laydate-1'>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="supplierName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="orderStatus" lay-search>
									<option value=""></option>
									<option value="1">未确认</option>
									<option value="2">已确认</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="deliveryDate" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-2">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="storageTime" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-3">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="storageState" lay-search>
									<option value=""></option>
									<option value="1">未入库</option>
									<option value="2">部分入库</option>
									<option value="3">已入库</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="paymentStatus" lay-search>
									<option value=""></option>
									<option value="1">未付款</option>
									<option value="2">部分付款</option>
									<option value="3">已付款</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseAmount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="discountAmount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="actuallyPaidAmount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="pendingAmount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="paymentDate" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-4">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="purchaseType" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="comment" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item"></div>
						</div>
						<div class="zq-search zq-search-fixed right">
							<div class="item"></div>
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


<!-- 操作 -->
<script type="text/html" id="barDemo">

	{{#  if(d.fileAttachment == 0){ }}
	<#if uploadFileAttachment??>
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="upload">上传</a>
	</#if>
	{{#  } }}

	{{#  if(d.fileAttachment != 0){ }}
	<#if selectFileAttachment??>
	<a class="layui-btn layui-btn-xs layui-btn-primary" lay-event="detail">查看</a>
	</#if>
	<#if editFileAttachment??>
	<a class="layui-btn layui-btn-xs" lay-event="reset">重置</a>
	</#if>
	{{#  } }}
</script>
<!-- 操作 -->

<!-- 编号 -->
<script type="text/html" id="purchaseOrderNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/purchaseOrder/open?purchaseOrderId={{d.purchaseOrderId}}" data-type="zq_newOpen">{{d.purchaseOrderNumber}}</a>
</script>
<!-- 编号 -->

<!-- 订单状态 -->
<script type="text/html" id="orderStatus">

	{{# if(d.orderStatus == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">未确认</span>
	{{# } }}
	{{# if(d.orderStatus == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已确认</span>
	{{# } }}
</script>
<!-- 订单状态 -->
<!-- 入库状态 -->
<script type="text/html" id="storageState">

	{{# if(d.storageState == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">未入库</span>
	{{# } }}
	{{# if(d.storageState == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">部分入库</span>
	{{# } }}
	{{# if(d.storageState == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已入库</span>
	{{# } }}
</script>
<!-- 入库状态 -->

<!-- 付款状态 -->
<script type="text/html" id="paymentStatus">

	{{# if(d.paymentStatus == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg4">未付款</span>
	{{# } }}
	{{# if(d.paymentStatus == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">部分付款</span>
	{{# } }}
	{{# if(d.paymentStatus == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已付款</span>
	{{# } }}


</script>
<!-- 付款状态 -->

<!-- 采购类型 -->
<script type="text/html" id="purchaseType">

	{{# if(d.purchaseType == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg4">天津贩卖</span>
	{{# } }}
	{{# if(d.purchaseType == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">资材</span>
	{{# } }}
</script>
<!-- 采购类型 -->

</body>
</html>