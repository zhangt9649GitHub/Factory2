<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/inventoryBalanceSheet/open.css">
	<script type="text/javascript" src="/static/js/inventoryBalanceSheet/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">库存流水 <span></span></h3>
				<div class="zq-btn-list">
				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form" lay-filter="formTest">
						<input type="hidden" name="goodsId" value="${goodsId}">
						<div class="layui-row">
							<table class="zq-table">
								<tbody>
								<tr>
									<th>
										<div>
											部品CD
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="partsCd" readonly class="layui-input">
										</div>
									</td>
									<th>
										<div>
											品名
										</div>
									</th>
									<td >
										<div>
											<input type="text" name="goodsName" readonly class="layui-input">
										</div>
									</td>
								</tr>
								<tr>
									<th>
										<div>
											规格
										</div>
									</th>
									<td colspan="3">
										<div>
											<input type="text" name="specification" readonly class="layui-input">
										</div>
									</td>

								</tr>
								</tbody>
							</table>
							<div class="zq-datatable">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
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