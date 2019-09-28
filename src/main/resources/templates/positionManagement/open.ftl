<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/positionManagement/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-card bg-1">
		<div class="layui-card-body">
			<form action="" class="layui-form layui-form-pane zq-form">
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="zq_closeIframe">关闭</button>

				</div>
				<div class="layui-row zq-form-wrap zq-margin-t30">
					<input type="hidden" name="wpId" value="${wpId}">
					<div class="layui-form-item">
						<label class="layui-form-label">
							仓位名称
						</label>
						<div class="layui-input-block">
							<input type="text" name="wpName" readonly class="layui-input"/>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							所属仓库
						</label>
						<div class="layui-input-block">
							<input type="text" name="warehouseId" readonly class="layui-input">
						</div>
					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">
							备注
						</label>
						<div class="layui-input-block">
							<textarea name="comment" readonly placeholder="请输入内容"  class="layui-textarea"></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>



</div>





</body>
</html>