<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionReceipt/open.css">
	<script type="text/javascript" src="/static/js/productionReceipt/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-生产入库单 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form" lay-filter="formTest">
						<input type="hidden" name="productionEntryId" value="${productionEntryId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="productionEntryNumber" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="addTime" class="layui-input" readonly >
								</div>
							</div>
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>仓库：</label>
									<input type="text" name="warehouseName" readonly class="layui-input">
								</div>
							</div>

							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>批号：</label>
									<input type="text" name="lotNumber" readonly >
								</div>
							</div>



							<div class="zq-datatable">
								<div class="zq-item">生产列表</div>
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
							<!-- 备注 -->
							<div class="remarks">
								<textarea name="comment" class="layui-textarea" readonly></textarea>
							</div>
							<div class="zq-datatable">
								<div class="zq-item">消耗列表</div>
								<table id="idTest1" lay-filter="demo1" class="layui-table"></table>
							</div>


							<div class="layui-col-md6">
								<div class="zq-item">
									<label>创建人：</label>
									<input type="text" name="name" readonly >
								</div>
							</div>


						</div>

					</form>


				</div>



			</div>

		</div>

	</div>



</div>





</body>
</html>