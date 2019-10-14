<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionPlanAnalysis/index.css">
	<script type="text/javascript" src="/static/js/productionPlanAnalysis/index.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">
		<div class="bg-1 layui-card">
			<div class="layui-card-header layui-clear">
				<h3 class="left">生产计划分析 <span></span></h3>

				<div class="zq-btn-list">
					<form action="" class="layui-form">

						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="partsCd" class="layui-input" placeholder="部品CD">
							</div>
						</div>
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" name="goodsName" class="layui-input" placeholder="商品名">
							</div>
						</div>
						<button class="layui-btn blue" lay-submit lay-filter="formDemo"><i class="layui-icon layui-icon-search"></i>搜索</button>
						<button class="layui-btn blue" type="reset"><i class="layui-icon layui-icon-refresh"></i>清空查询项</button>
					</form>

				</div>

			</div>
			<div class="layui-card-body index-body">
				<div class="thead">
					<table class="layui-table" lay-skin="nob">
						<colgroup>
							<col width="40">
							<col width="150">
							<col width="100">
							<col>
							<col width="100">
							<col width="120">
							<col width="100">
							<col width="100">
							<col width="100">
							<col>
						</colgroup>
						<thead>
						<tr>
							<th></th>
							<th>编号</th>
							<th>部品CD</th>
							<th>商品名</th>
							<th>月贩卖量</th>
							<th>商品在库量</th>
							<th>总任务量</th>
							<th>剩余量</th>
							<th>新增任务</th>
						</tr>
						</thead>

					</table>
				</div>
				<div class="tbody">
					<table class="layui-table" lay-skin="nob">
						<colgroup>
							<col width="40">
							<col width="150">
							<col width="100">
							<col>
							<col width="100">
							<col width="120">
							<col width="100">
							<col width="100">
							<col width="100">
							<col>
						</colgroup>
						<tbody id="view">

						</tbody>

					</table>
				</div>
				<div id="demo"></div>
			</div>
		</div>
	</div>



</div>

<#-- 数据 -->
<script id="trData" type="text/html">
	{{# if(d){ }}
		{{#  layui.each(d, function(index, item){ }}

			<tr>
				<td class="cursor-pointer" data-id="{{item.productionOrderDetailsId}}">
					<i class="layui-icon layui-icon-right"></i>
				</td>
				<td>{{item.serialNumber}}</td>
				<td>{{item.partsCd}}</td>
				<td>{{item.goodsName}}</td>
				<td>{{item.monthlySalesVolume}}</td>
				<td>{{item.skgCount}}</td>
				<td>{{item.totalTaskAmount}}</td>
				<td>{{item.remainingAmount}}</td>
				<td>{{item.newTask}}</td>
			</tr>

		{{#  }); }}
	{{#  } }}
</script>

<#-- 详细数据 -->
<script id="details" type="text/html">
	{{# if(d){ }}

		<tr data-id="{{d.productionOrderDetailsId}}">
			<td colspan="9" class="expanded">

				<table class="layui-table ">
					<thead>
						<tr>
							<th>对应完成品</th>
							<th>任务量</th>
							<th>成型周期</th>
							<th>所需班次</th>
							<th>对应成品在库量</th>
						</tr>
					</thead>
					<tbody>
					{{# if(d.finishedProductList.length != 0){ }}
					{{#  layui.each(d.finishedProductList, function(index, item){ }}

						<tr>
							<td>{{ item.goodsName }}</td>
							<td>{{ item.taskAmount }}</td>
							<td>{{ item.cycle }}</td>
							<td>{{ item.shift }}</td>
							<td>{{ item.finishedAmount }}</td>
						</tr>

					{{#  }); }}

					{{# }else{ }}
						<tr>
							<td colspan="5" align="center">
								没有数据
							</td>
						</tr>
					{{#  } }}
					</tbody>
				</table>

				<table class="layui-table">
					<thead>
					<tr>
						<th>对应成型品</th>
						<th>任务量</th>
						<th>成型周期</th>
						<th>累计完成量</th>
						<th>所需班次</th>
					</tr>
					</thead>
					<tbody>
					{{# if(d.moldingProductionList.length != 0){ }}
					{{#  layui.each(d.moldingProductionList, function(index, item){ }}

					<tr>
						<td>{{ item.goodsName }}</td>
						<td>{{ item.taskAmount }}</td>
						<td>{{ item.cycle }}</td>
						<td>{{ item.cumulativeCompletion }}</td>
						<td>{{ item.shift }}</td>
					</tr>

					{{#  }); }}

					{{# }else{ }}
					<tr>
						<td colspan="5" align="center">
							没有数据
						</td>
					</tr>
					{{#  } }}
					</tbody>
				</table>


				<table class="layui-table">
					<thead>
					<tr>
						<th>所需材料</th>
						<th>所需数量</th>
						<th>在库数量</th>
					</tr>
					</thead>
					<tbody>
					{{# if(d.materialList.length != 0){ }}
					{{#  layui.each(d.materialList, function(index, item){ }}

					<tr>
						<td>{{ item.material }}</td>
						<td>{{ item.amount }}</td>
						<td>{{ item.skgCount }}</td>
					</tr>

					{{#  }); }}

					{{# }else{ }}
					<tr>
						<td colspan="3" align="center">
							没有数据
						</td>
					</tr>
					{{#  } }}
					</tbody>
				</table>

			</td>
		</tr>


	{{#  } }}
</script>


</body>
</html>