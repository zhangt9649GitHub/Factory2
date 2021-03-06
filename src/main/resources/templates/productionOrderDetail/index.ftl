<#include "../public_header.ftl">



	<script type="text/javascript" src="/static/js/productionOrderDetail/index.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">排产单明细 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" data-type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					<#if updateProductionOrderDetailsIsRead??>
					<button class="layui-btn blue zq-active" data-type="setRead">设为已读</button>
					</#if>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">



							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="productionOrderNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<#-- 状态 -->
							<div class="item">
								<#--<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>-->
								<#--<input type="text" name="serialNumber" placeholder="请输入" autocomplete="off" class="layui-input">-->
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="partsCd" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="goodsName" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="specification" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="unit" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="totalTaskAmount" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="salesBooking" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="skgCount" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="quantity" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="cycle" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="shift" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="producedAmount" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="newStorageAmount" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>
							<#--<div class="item">-->
								<#--<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>-->
								<#--<select name="isNew" lay-search>-->
									<#--<option value=""></option>-->
									<#--<option value="0">无</option>-->
									<#--<option value="1">有</option>-->
								<#--</select>-->
							<#--</div>-->
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="serialNumber" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script type="text/html" id="partsCd">
	<a href="###" class="zq-active zq-open" >{{d.partsCd}}</a>
</script>
<!-- 编号 -->

<#-- 有无新增入库 -->
<script type="text/html" id="isNew">

	{{#  if(d.isNew == 1){ }}
		有
	{{#  } }}

	{{#  if(d.isNew == 0){ }}
		无
	{{#  } }}

</script>
<#-- 有无新增入库 -->


<#-- 状态 -->
	<script type="text/html" id="color">

		{{#  if(d.color === 1){ }}
		<span class="layui-btn layui-btn-xs " style="background-color: yellow;color: #333;">已领料</span>
		{{#  } }}

		{{#  if(d.color === 2){ }}
		<span class="layui-btn layui-btn-xs" style="background-color: red">资材不足</span>
		{{#  } }}
		{{#  if(d.color === 3){ }}
		<span class="layui-btn layui-btn-xs1" style="background-color: green">已完成</span>
		{{#  } }}
		{{#  if(d.color === 4){ }}
		<span class="layui-btn layui-btn-xs" style="background-color: #4a49ec">原料足够</span>
		{{#  } }}
		{{#  if(d.color === 5){ }}
		<span class="layui-btn layui-btn-xs" style="background-color: #b0a4e3">原料不足</span>
		{{#  } }}
		<#--{{#  if(d.color === null){ }}-->
		<#--<span class="layui-btn layui-btn-xs" >原料不足</span>-->
		<#--{{#  } }}-->

	</script>
<#-- 有无新增入库 -->

</body>
</html>