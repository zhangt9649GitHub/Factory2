<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/employeeManagement/index.css">
	<script type="text/javascript" src="/static/js/employeeManagement/index.js"></script>

</head>
<body>

<div class="zq-wrap">


	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">员工管理 <span></span></h3>
				<div class="zq-btn-list">
					<#if insertStaff??>
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/employeeManagement/add">
						<i class="layui-icon layui-icon-add-1"></i>新增
					</button>
					</#if>
					<#if updateStaff??>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/employeeManagement/edit">
						<i class="layui-icon layui-icon-edit"></i>编辑
					</button>
					</#if>
					<#if deleteStaff??>
					<button class="layui-btn red zq-active" type="button" data-type="delete">
						<i class="layui-icon layui-icon-delete"></i>删除
					</button>
					</#if>
					<button class="layui-btn blue zq-active" data-type="reset">
						<i class="layui-icon layui-icon-refresh"></i>清空查询项
					</button>
					<#if updatePasswd??>
					<button class="layui-btn blue zq-active" type="button" data-type="resetPassword">
						重置密码
					</button>
					</#if>
					<#if 1??>
					<button class="layui-btn blue zq-active" type="button" data-type="popupPage1" data-href="/admin/employeeManagement/popupPage1">
						经验值管理
					</button>
					</#if>
					<#if getRecordById??>
					<button class="layui-btn blue zq-active" type="button" data-type="popupPage2" data-href="/admin/employeeManagement/popupPage2">
						调岗记录
					</button>
					</#if>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">
					<button type="reset" class="layui-btn layui-hide">重置</button>
					<div class="zq-search-wrap">
						<div class="zq-search search">
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="jobNumber" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input" >
							</div>

							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="role" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="phone" placeholder="请输入" autocomplete="off" class="layui-input">
							</div>
							<div class="item">
								<button type="button" lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i></button>
								<input type="text" name="entryTime" placeholder="请输入" autocomplete="off" class="layui-input" id="ruzhiriqi">
							</div>

						</div>
					</div>
				</form>
				<div class="zq-layui-table index-table ">
					<table id="idTest" lay-filter="demo" class="layui-table" lay-even lay-skin="nob"></table>
				</div>
			</div>
		</div>
	</div>


</div>


<!-- 编号 -->
<script type="text/html" id="jobNumber">
	<a href="###" class="zq-active zq-open" data-href="/admin/employeeManagement/open?staffId={{d.staffId}}" data-type="zq_newOpen">{{d.jobNumber}}</a>
</script>
<!-- 编号 -->

</body>
</html>