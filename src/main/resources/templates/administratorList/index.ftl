<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/administratorList/index.css">
	<script type="text/javascript" src="/static/js/administratorList/index.js"></script>

</head>
<body>

<div class="zq-wrap">


	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">管理员列表 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="add" data-href="/admin/administratorList/add"><i class="layui-icon layui-icon-add-1"></i>新增</button>
					<button class="layui-btn blue zq-active" type="button" data-type="edit" data-href="/admin/administratorList/edit"><i class="layui-icon layui-icon-edit"></i>编辑</button>
					<button class="layui-btn red zq-active" type="button" data-type="delete"><i class="layui-icon layui-icon-delete"></i>删除</button>
					<button class="layui-btn blue zq-active" type="button" data-type="enableDisabling"></i>启用/禁用</button>
					<!--<button class="layui-btn lay-submit lay-filter="*"><i class="layui-icon layui-icon-search"></i>查询</button>-->
					<button class="layui-btn blue" type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
				</div>

			</div>
			<div class="layui-card-body index-body">

				<form class="layui-form zq-search-form">

                    <div class="zq-search-wrap">
                        <div class="zq-search search">
                            <div class="item">
                                <button type="button"><i class="layui-icon layui-icon-search"></i></button>
                                <input type="text" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                            <div class="item">
                                <button type="button"><i class="layui-icon layui-icon-search"></i></button>
                                <input type="text" placeholder="请输入" autocomplete="off" class="layui-input" >
                            </div>
                            <div class="item">
                                <button type="button"><i class="layui-icon layui-icon-search"></i></button>
                                <select name="" lay-search>
                                    <option value=""></option>
                                </select>
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
<script type="text/html" id="bianhao">
	<a href="###" class="zq-active zq-open">{{d.field1}}</a>
</script>
<!-- 编号 -->


</body>
</html>