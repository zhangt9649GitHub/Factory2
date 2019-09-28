<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionInstructions/updateState.css">
	<script type="text/javascript" src="/static/js/productionInstructions/updateState.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-card bg-1">
		<div class="layui-card-body">
			<form action="" class="layui-form layui-form-pane zq-form">
				<input type="hidden" name="productionInstructionId" value="${productionInstructionId}">
				<div class="zq-btn-list">
					<button class="layui-btn green" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_closeIframe">关闭</button>
				</div>
				<div class="layui-row zq-form-wrap zq-margin-t30">
					<div class="layui-form-item">
						<label class="layui-form-label">
							编号
						</label>
						<div class="layui-input-block">
							<input type="text" name="serialNumber" readonly class="layui-input"/>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							状态
						</label>
						<div class="layui-input-block">
							<select name="state" lay-scarch  lay-verify="required">
								<option value=""></option>
								<option value="1">已创建</option>
								<option value="2">部分完成</option>
								<option value="3">已完成</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">
							备注
						</label>
						<div class="layui-input-block">
							<textarea name="comment" placeholder="请输入内容" class="layui-textarea"></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>





</body>
</html>