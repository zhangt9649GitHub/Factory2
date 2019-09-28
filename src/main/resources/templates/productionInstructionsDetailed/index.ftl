<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/productionInstructionsDetailed/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">生产指示书明细 <span> </span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="serialNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="productName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="connectionNo" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="parentNo" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="variety" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="productionSchedule" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="unit" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<select name="state" lay-search>
									<option value=""></option>
									<option value="1">已创建</option>
									<option value="2">部分完成</option>
									<option value="3">已完成</option>
								</select>
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
<script type="text/html" id="serialNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/productionInstructions/open?productionInstructionId={{d.productionInstructionId}}" data-type="zq_newOpen">{{d.serialNumber}}</a>
</script>
<!-- 编号 -->

<!-- 状态 -->
<script type="text/html" id="state">

	{{# if(d.state == 1){ }}
	<span class="layui-btn layui-btn-xs zq-bg1">已创建</span>
	{{# } }}
	{{# if(d.state == 2){ }}
	<span class="layui-btn layui-btn-xs zq-bg2">部分完成</span>
	{{# } }}
	{{# if(d.state == 3){ }}
	<span class="layui-btn layui-btn-xs zq-bg3">已完成</span>
	{{# } }}


</script>
<!-- 状态 -->

</body>
</html>