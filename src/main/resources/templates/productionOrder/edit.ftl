<#include "../public_header.ftl">


<link rel="stylesheet" type="text/css" href="/static/css/productionOrder/edit.css">


</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 layui-form" lay-filter="formTest">

			<div class="layui-card-header layui-clear">
				<h3 class="left">编辑-排产单 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn green zq-active" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form>
						<input type="hidden" name="productionOrderId" value="${productionOrderId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="productionOrderNumber" class="layui-input" readonly lay-verify="required">
								</div>
							</div>

							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" class="layui-input" readonly lay-verify="required" id="laydate-1">
								</div>
							</div>

							<div class="layui-col-md12">
								<div class="zq-datatable">
									<div class="zq-item">
										销售订单

									</div>
									<div>
										<input type="checkbox" name="isCreatePicking" value="1" lay-skin="primary" title="自动生成领料单">
									</div>
									<table id="idTest" lay-filter="demo" class="layui-table"></table>
								</div>
								<!-- 备注 -->

								<div class="remarks">
									<textarea name="comment" placeholder="备注信息" class="layui-textarea"></textarea>
								</div>

								<div class="layui-col-md6">
									<div class="zq-item">
										<label>创建人：</label>
										<input type="hidden" name="staffId" value="${(Session.user.staffId)!''}">
										<input type="text" name="staffName" readonly value="">
									</div>
								</div>
							</div>






						</div>

					</form>


				</div>



			</div>

		</div>

	</div>



</div>

<script type="text/javascript" src="/static/js/productionOrder/edit.js"></script>
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