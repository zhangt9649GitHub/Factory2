<#include "../public_header.ftl">


<link rel="stylesheet" type="text/css" href="/static/css/salesOrders/index.css">
<script type="text/javascript" src="/static/js/salesOrders/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">销售订单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertSalesOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/salesOrders/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateSalesOrderInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/salesOrders/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteSalesOrderById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if updateSalesOrderState??>
						<button class="layui-btn blue zq-active" type="button" data-type="updateStatus">
							更新状态
						</button>
					</#if>
					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
					<#if importSalesOrder??>
					<button class="layui-btn blue" type="button" id="upload-file">
						<i class="layui-icon layui-icon-upload-drag"></i>导入
					</button>
					</#if>
					<#if exportSalesOrderDetails??>
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
								<input type="text" name="salesOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addtime" placeholder="请输入" autocomplete="off" class="layui-input" id="laydate-1">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="customerName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value="">请选择</option>
									<option value="1">已创建</option>
									<option value="2">已部分出库</option>
									<option value="3">已出库</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="paymentStatus" lay-search>
									<option value="">请选择</option>
									<option value="1">未回款</option>
									<option value="2">部分回款</option>
									<option value="3">已回款</option>
								</select>
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="amount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="amountReceived" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="salesOrderNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/salesOrders/open?salesOrderId={{d.salesOrderId}}" data-type="zq_newOpen">{{d.salesOrderNumber}}</a>
</script>
<!-- 编号 -->

<!-- 当前状态 -->
<script type="text/html" id="state">

	{{# if(d.state == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
	{{# } }}
	{{# if(d.state == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">已部分出库</span>
	{{# } }}
	{{# if(d.state == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">已出库</span>
	{{# } }}


</script>
<!-- 当前状态 -->
<!-- 回款状态 -->
<script type="text/html" id="paymentStatus">

	{{# if(d.paymentStatus == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg4">未回款</span>
	{{# } }}
	{{# if(d.paymentStatus == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">部分回款</span>
	{{# } }}
	{{# if(d.paymentStatus == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已回款</span>
	{{# } }}


</script>
<!-- 回款状态 -->

</body>
</html>