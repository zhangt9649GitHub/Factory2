<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/requisition/index.css">
	<script type="text/javascript" src="/static/js/requisition/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">调拨单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertRequisition??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/requisition/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<button class="layui-btn blue zq-active" type="button" data-type="reset" >
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
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="requisitionNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="addtime" placeholder="请输入" autocomplete="off" class="layui-input"
									   id="laydate-1">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="type" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="outWarehouseName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
								<input type="text" name="intoWarehouseName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*">
									<i class="layui-icon layui-icon-search"></i>
								</button>
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
<script type="text/html" id="requisitionNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/requisition/open?requisitionId={{d.requisitionId}}" data-type="zq_newOpen">
		{{d.requisitionNumber}}
	</a>
</script>
<!-- 编号 -->

</body>
</html>