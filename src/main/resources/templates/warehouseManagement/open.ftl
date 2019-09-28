<#include "../public_header.ftl">


	<script type="text/javascript" src="/static/js/warehouseManagement/open.js"></script>

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
					<input type="hidden" name="warehouseId" value="${warehouseId}">
					<div class="layui-form-item">
						<label class="layui-form-label">
							仓库名称
						</label>
						<div class="layui-input-block">
							<input type="text" name="warehouseName" class="layui-input" readonly value="仓位名称"/>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							联系人
						</label>
						<div class="layui-input-block">
							<input type="text" name="staffId" class="layui-input" readonly value="所属仓库"/>
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">
							状态
						</label>
						<div class="layui-input-block">
							<input type="text" name="state" class="layui-input" readonly value="状态"/>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">
							备注
						</label>
						<div class="layui-input-block">
							<textarea name="comment" placeholder="请输入内容" readonly class="layui-textarea"></textarea>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>





</body>
</html>