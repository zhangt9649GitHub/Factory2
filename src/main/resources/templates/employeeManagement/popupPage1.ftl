<#include "../public_header.ftl">

	<link rel="stylesheet" href="/static/css/employeeManagement/popupPage1.css">
	<script type="text/javascript" src="/static/js/employeeManagement/popupPage1.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="layui-card bg-1 layui-form">
			<div class="layui-card-header layui-clear">
				<div class="zq-btn-list">
					<button class="layui-btn"  lay-submit lay-filter="*">
						提交
					</button>
				</div>

			</div>
			<div class="layui-card-body">
				<input type="hidden" name="staffId" value="${staffId}">
				<div class="zq-layui-table zq-showtable">
					<table id="idTest" lay-filter="demo" class="layui-table"></table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 添加删除图标按钮 -->
<script type="text/html" id="barDemo">
	<div>

		<span class="iconfont iconhao green"  lay-event="addRow"></span>

		&nbsp;

		<span class="iconfont icon-hao red"  lay-event="daleteRow"></span>

	</div>
</script>

<#-- 货物列表 -->
<script type="text/html" id="goodsId">
	<select name="goodsId" lay-filter="goodsId" lay-search data-value="{{d.goodsId}}">
		<option value=""></option>
		{{#  layui.each(d.goodsList, function(index, item){ }}
		<option value="{{ item.goodsId }}">{{ item.goodsName }}</option>
		{{#  }); }}
	</select>
</script>
</body>
</html>