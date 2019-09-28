<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/employeeManagement/popupPage1.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="layui-card bg-1">
			<div class="layui-card-body">
				<input type="hidden" name="staffId" value="${staffId}">
				<div class="zq-layui-table zq-showtable">
					<table id="idTest" lay-filter="demo" class="layui-table"></table>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>