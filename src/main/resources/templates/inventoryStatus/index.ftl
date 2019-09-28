<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/inventoryStatus/index.css">
	<script type="text/javascript" src="/static/js/inventoryStatus/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">库存状态 <span></span></h3>
				<div class="zq-btn-list">
					<form action="" class="layui-form">

						<div class="layui-inline">
							<div class="layui-input-inline">
								<select name="" lay-search>
									<option value="">请选择分类</option>
									<option value="1">商品</option>
									<option value="2">完成品</option>
									<option value="3">制造品</option>
								</select>
							</div>
						</div>
						<div class="layui-inline">
							<div class="layui-input-inline">
								<select name="" lay-search>
									<option value="">请选择状态</option>
									<option value="1">着急出货</option>
									<option value="2">着急生产</option>
									<option value="3">着急准备</option>
								</select>
							</div>
						</div>
						<button class="layui-btn blue" type="reset"><i class="layui-icon layui-icon-search"></i>搜索</button>
						<button class="layui-btn blue" type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					</form>

				</div>
			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">

					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="bianhao">
	<a href="###" class="zq-active zq-open">{{d.number}}</a>
</script>
<!-- 编号 -->

</body>
</html>