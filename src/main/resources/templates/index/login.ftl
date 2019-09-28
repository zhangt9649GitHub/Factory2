<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/index/login.css">
	<script type="text/javascript" src="/static/js/index/login.js"></script>

</head>
<body>

<div class="wrap">

	<div class="content">
		<div class="logo">
			<h3 class="title">
				<img src="/static/img/logo.png" alt="">
			</h3>
		</div>
		<form action="" class="layui-form form">
			<h3 class="title">登录</h3>

			<div class="layui-form-item error-prompt zq-display-none">
				<i class="layui-icon layui-icon-close"></i>
				<span>Error,请输入账号获密码！</span>
			</div>

			<div class="layui-form-item ">
				<input type="text" name="jobNumber" autocomplete="off" placeholder="用户名" class="layui-input">
			</div>
			<div class="layui-form-item ">
				<input type="password" name="password" autocomplete="off" placeholder="密码" class="layui-input">
			</div>

			<div class="layui-form-item zq-text-align-c ">
				<button type="button" class="layui-btn submit" lay-submit lay-filter="*">登录</button>
			</div>
		</form>
	</div>

</div>

</body>
</html>