<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/purchaseReturn/showTable.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="layui-card bg-1">
			<div class="layui-card-body">
				<form class="layui-form">
					<div class="layui-form-item">
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="partsCd" autocomplete="off" placeholder="请输入部品CD" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="goodsName" autocomplete="off" placeholder="请输入品名" class="layui-input">
							</div>
						</div>
						<div class="layui-inline">
							<button class="layui-btn blue" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i>搜索</button>
						</div>
					</div>
				</form>
				<div class="zq-layui-table zq-showtable">
					<input type="hidden" name="dataIndex" value="${dataIndex}">
					<input type="hidden" name="purchaseOrderId" value="${purchaseOrderId}">
					<table id="showTable" lay-filter="showTable" class="layui-table"></table>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>