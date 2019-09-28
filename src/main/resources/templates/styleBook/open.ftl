<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/styleBook/open.css">
	<script type="text/javascript" src="/static/js/styleBook/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-式样书 <span></span></h3>
				<div class="zq-btn-list">

				</div>
			</div>
			<div class="layui-card-body">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">
						<input type="hidden" name="styleBookId" value="${styleBookId}">
						<div class="layui-row">
							<div class="layui-col-md6">
								<div class="zq-item">
									<label>编号：</label>
									<input type="text" name="styleBookNumber" readonly>
								</div>
							</div>
							<div class="layui-col-md6 zq-text-align-r">
								<div class="zq-item">
									<label>日期：</label>
									<input type="text" name="date" readonly >
								</div>
							</div>

							<div class="layui-col-md12">
								<table class="zq-table">
									<tbody>
									<tr>
										<th>
											<div>
												品名
											</div>
										</th>
										<td>
											<div>
												<input type="text" name="goodsName" readonly />
											</div>
										</td>
										<th>
											<div>
												创建人
											</div>
										</th>
										<td>
											<div>
												<input type="text" name="staffId" readonly class="layui-input"/>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="4" class="">
											<div id="editor" class="layui-hide">
											</div>
											<div id="editor1"></div>
										</td>
									</tr>
									</tbody>
								</table>
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