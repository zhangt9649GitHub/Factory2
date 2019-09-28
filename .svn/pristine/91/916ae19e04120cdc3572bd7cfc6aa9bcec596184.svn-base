<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/outboundDatabaseAnalysisTable/index.css">
	<script type="text/javascript" src="/static/js/outboundDatabaseAnalysisTable/index.js"></script>

</head>
<body>

<div class="zq-wrap">

    <div class="layui-row">

        <div class="layui-card bg-1">

            <div class="layui-card-header layui-clear">
                <h3 class="left">出入库分析表 <span></span></h3>
                <div class="zq-btn-list">
                    <button class="layui-btn blue zq-active" type="button" data-type="screen">
                        <i class="layui-icon layui-icon-search"></i>查询
                    </button>
                    <button class="layui-btn blue zq-active" type="button" data-type="export">
                        <i class="layui-icon layui-icon-download-circle"></i>导出
                    </button>
                </div>
            </div>

            <div class="layui-card-body">
                <div class="zq-container zq-min-h800">


                        <div class="layui-row layui-col-space10 layui-form">
                            <button class="layui-btn layui-hide" lay-submit lay-filter="*">提交</button>
                            <div class="layui-col-md4">
                                <div class="item">
                                    <label class="item-label">日期</label>
                                    <div class="item-input">
                                        <input type="text" name="dateRange" class="layui-input" autocomplete="off" id="date">
                                    </div>
                                </div>

                            </div>
                            <div class="layui-col-md4">
                                <div class="item">
                                    <label class="item-label">部品名称</label>
                                    <div class="item-input">
                                        <select name="goodsId" lay-search="">
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <div class="layui-col-md4">
                                <div class="item">
                                    <label class="item-label">分类</label>
                                    <div class="item-input">
                                        <select name="category" lay-search="">
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>

                            </div>

                        </div>
                        <#--<div class="layui-row layui-col-space10">-->
                            <div class="zq-datatable">
                                <table id="idTest" lay-filter="demo" class="layui-table"></table>
                            </div>



                        <#--</div>-->




                </div>
            </div>


        </div>

    </div>


</div>

</body>
</html>