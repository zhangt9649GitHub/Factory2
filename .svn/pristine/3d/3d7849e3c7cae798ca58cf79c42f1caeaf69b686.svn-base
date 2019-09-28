<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/salesReturn/index.css">
	<script type="text/javascript" src="/static/js/salesReturn/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">销售退货单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertSalesReturn??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/salesReturn/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateSalesReturnInfo??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/salesReturn/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteSalesReturnById??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<#if updateSalesReturnState??>
						<button class="layui-btn blue zq-active" type="button" data-type="updateStatus">
							更新状态
						</button>
					</#if>

					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
				</div>
			</div>
			<div class="layui-card-body index-body">
				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="salesReturnNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addTime" placeholder="请输入" autocomplete="off" class="layui-input" id="date">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="customerName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value=""></option>
									<option value="1">已创建</option>
									<option value="2">已入库</option>
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
								<input type="text" name="amount" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="amountReceived" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item beizhu" lay-submit lay-filter="*">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="comment" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

						</div>
					</div>
				</form>
				<div class="zq-layui-table index-table ">
					<table id="idTest" lay-filter="demo" class="layui-table"></table>
				</div>

			</div>
		</div>
	</div>

	<!-- 编号 -->
	<script type="text/html" id="salesReturnNumber">
		<a href="###" class="zq-active zq-open" data-href="/admin/salesReturn/open?salesReturnId={{d.salesReturnId}}" data-type="zq_newOpen">{{d.salesReturnNumber}}</a>
	</script>
	<!-- 编号 -->

	<!-- 当前状态 -->
	<script type="text/html" id="state">

		{{# if(d.state == 1){ }}
		<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
		{{# } }}
		{{# if(d.state == 2){ }}
		<span class="layui-btn layui-btn-xs zq-bg2">已入库</span>
		{{# } }}



	</script>
	<!-- 当前状态 -->
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
</div>

</body>
</html>