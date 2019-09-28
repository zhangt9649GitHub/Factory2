<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/outboundOrder/edit.css">
	<script type="text/javascript" src="/static/js/outboundOrder/edit.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-出库单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" type="button" >提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">

						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" class="layui-input" value="1929831239">
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" class="layui-input" autocomplete="off" id="date">
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>仓库：</label>
									<select lay-search>
										<option value="">请选择</option>
										<option value="组装车库">组装车库</option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4">
								<div class="zq-item">
									<label>出库类型：</label>
									<select lay-search>
										<option value="">请选择</option>
										<option value ="盘亏出库">盘亏出库</option>
										<option value ="销售出库">销售出库</option>
										<option value ="调拨出库">调拨出库</option>
										<option value ="退货出库">退货出库</option>
										<option value ="领料出库">领料出库</option>
									</select>
								</div>
							</div>
							<div class="layui-col-md4 zq-text-align-r">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="namber">
								</div>
							</div>

							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->

							<div class="remarks">
								<textarea placeholder="备注信息" class="layui-textarea"></textarea>
							</div>

							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<select lay-scarch>
										<option value=""></option>
										<option value="1">丽丽</option>
										<option value="2">琪琪</option>
									</select>
								</div>
							</div>


						</div>

					</form>


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


</body>
</html>