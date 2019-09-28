<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/outboundOrder/index.css">
	<script type="text/javascript" src="/static/js/outboundOrder/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">出库单 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertOutboundOrder??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/outboundOrder/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
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
								<input type="text" name="outboundOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="addTime" placeholder="请输入" autocomplete="off" class="layui-input"id="laydate-1">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="type" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="warehouseName" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="outboundOrderNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/outboundOrder/open?outboundOrderId={{d.outboundOrderId}}" data-type="zq_newOpen">{{d.outboundOrderNumber}}</a>
</script>
<!-- 编号 -->
<!-- 类型 -->
<script type="text/html" id="type">
	{{# if(d.type == '盘亏出库'){ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg1">{{d.type}}</a>
	{{# }else if(d.type == '销售出库'){ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg2">{{d.type}}</a>
	{{# }else if(d.type == '调拨出库'){ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg3">{{d.type}}</a>
	{{# }else if(d.type == '退货出库'){ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg4">{{d.type}}</a>
	{{# }else if(d.type == '领料出库'){ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg5">{{d.type}}</a>
	{{# }else{ }}
	<a href="###" class="layui-btn layui-btn-xs zq-bg-white">{{d.type}}</a>
	{{# } }}

</script>
<!-- 类型 -->

</body>
</html>