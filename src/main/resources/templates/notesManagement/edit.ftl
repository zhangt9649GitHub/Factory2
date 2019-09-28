<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/notesManagement/edit.css">
	<script type="text/javascript" src="/static/js/notesManagement/edit.js"></script>

</head>
<body>
<div class="zq-wrap">

	<div class="layui-card bg-1 ">
		<div class="layui-card-body">
			<form action="" class="layui-form zq-form" lay-filter="formTest">
				<div class="zq-btn-list">
					<button class="layui-btn green" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_closeIframe">关闭</button>

				</div>
				<div class="layui-row zq-form-wrap zq-margin-t30">
					<input type="hidden" name="ndid" value="${ndid}">
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								注文书号
							</label>
							<div class="layui-input-block">
								<input type="text" name="noteDcNumber" readonly  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								回次
							</label>
							<div class="layui-input-block">
								<input type="text" name="productionInstructionId" readonly  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								供应商
							</label>
							<div class="layui-input-block">
								<select name="supplierId" lay-filter="supplierId" lay-search lay-verify="required">
									<option value=""></option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								部品CD
							</label>
							<div class="layui-input-block">
								<select name="goodsId" lay-filter="goodsId" lay-search lay-verify="required">
									<option value=""></option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								采购数量
							</label>
							<div class="layui-input-block">
								<input type="text" name="count" lay-verify="required"  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								预计单价
							</label>
							<div class="layui-input-block">
								<input type="text" name="price" lay-verify="required"  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								合计
							</label>
							<div class="layui-input-block">
								<input type="text" name="money" readonly  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>

				</div>
			</form>
		</div>
	</div>



</div>




</body>
</html>