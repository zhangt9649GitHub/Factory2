<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/authorityManagement/open.css">
	<script type="text/javascript" src="/static/js/authorityManagement/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-card bg-1 ">
		<div class="layui-card-body">
			<form action="" class="layui-form layui-form-pane zq-form " lay-filter="formTest">
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="zq_closeIframe">关闭</button>

				</div>
				<div class="layui-row zq-form-wrap zq-margin-t30">
					<input type="hidden" name="groupId" value="${groupId}">
					<div class="layui-form-item">
						<label class="layui-form-label name">
							权限名称
						</label>
						<div class="layui-input-inline">
							<input type="text" name="groupName" readonly class="layui-input">
						</div>
					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">拥有权限</label>

						<div class="list">

						</div>

					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">
							权限描述
						</label>
						<div class="layui-input-block">
							<textarea name="groupText" readonly class="layui-textarea"></textarea>
						</div>


					</div>


				</div>
			</form>
		</div>
	</div>



</div>





</body>
</html>