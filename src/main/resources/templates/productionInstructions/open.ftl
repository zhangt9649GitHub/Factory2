<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/productionInstructions/open.css">
	<script type="text/javascript" src="/static/public/jquery.jqprint.js"></script>
	<script type="text/javascript" src="/static/js/productionInstructions/open.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-row">

		<div class="layui-card bg-1 ">

			<div class="layui-card-header layui-clear">
				<h3 class="left">查看-生成指示书 <span></span></h3>
				<div class="zq-btn-list">
					<button class="layui-btn blue zq-active" type="button" data-type="print">打印</button>
					<button class="layui-btn blue zq-active" type="button" data-type="returnOperation">返品操作</button>
				</div>
			</div>
			<div class="layui-card-body" id="ddd">

				<div class="zq-container zq-min-h800">

					<form action="" class="layui-form">
						<input type="hidden" name="productionInstructionId" value="${productionInstructionId}">
						<div class="layui-row">

							<div class="wrap" id="view">

							</div>

						</div>

					</form>


				</div>



			</div>

		</div>

	</div>
</div>

<!-- 弹出层 -->
<div class="zq-wrap zq-display-none " id="open">
	<div class="layui-row">
		<div class="layui-card">
			<div class="layui-card-body">
				<form action="" class="layui-form layui-form-pane">

					<div class="zq-form-wrap">
						<div class="layui-form-item">
							<label class="layui-form-label">
								部品名称
							</label>
							<div class="layui-input-block">
								<select name="" lay-search>
									<option value=""></option>
								</select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">
								返品数量
							</label>
							<div class="layui-input-block">
								<input type="text" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">
								备注
							</label>
							<div class="layui-input-block">
								<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
							</div>
						</div>
						<div class="zq-btn-list">
							<button class="layui-btn green" lay-submit="" lay-filter="open">提交</button>
							<button class="layui-btn blue zq-active" type="button" data-type="zq_closeOpen">关闭</button>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<#-- 加载模块 -->
<script type="text/html" id="demo">
{{# if(d){ }}

	{{#  layui.each(d, function(index, item){ }}
	{{# if(index == 0 ){ }}
	<h3 class="title"><span>生产指示书（第{{ item.serialNumber === null ? '' : item.serialNumber}}回）</span></h3>
	{{# } }}
	<div class="list">
		<div class="item">
			<div class="zq-item">{{ item.productName === null ? '' : item.productName}}</div>
			<table class="zq-table" >
				<tbody>
				<tr>
					<th><div>连接NO</div></th>
					<th><div>父NO</div></th>
					<th><div>品种</div></th>
					<th><div>生产预定数</div></th>
					<th><div>返品数量</div></th>
					<th><div>单位</div></th>
					<th><div>箱数/1捆</div></th>
					<th><div>个数/1箱</div></th>
					<th><div>物品CD</div></th>
				</tr>
				<tr>

					<td class="zq-text-align-c"><div>{{ item.connectionNo === null ? '' : item.connectionNo}}</div></td>
					<td class="zq-text-align-c"><div>{{ item.parentNo === null ? '' : item.parentNo}}</div></td>
					<td class="zq-text-align-c"><div>{{ item.variety === null ? '' : item.variety}}</div></td>
					<td class="zq-text-align-r"><div>{{ item.productionSchedule === null ? '' : item.productionSchedule}}</div></td>
					<td class="zq-text-align-r"><div>{{ item.returnQuantity === null ? '' : item.returnQuantity}}</div></td>
					<td class="zq-text-align-c"><div>{{ item.unit === null ? '' : item.unit}}</div></td>
					<td class="zq-text-align-r"><div>{{ item.boxesNumber === null ? '' : item.boxesNumber}}</div></td>
					<td class="zq-text-align-r"><div>{{ item.number === null ? '' : item.number}}</div></td>
					<td><div class="zq-text-align-c">{{ item.partsCd === null ? '' : item.partsCd}}</div></td>
				</tr>
				</tbody>
			</table>
			{{# if(item.productionInstructionDetailList){ }}
				<table class="zq-table table-2">
					<tbody>
					<tr>
						<th><div>NO</div></th>
						<th><div></div></th>
						<th><div>使用部品名</div></th>
						<th><div>类别</div></th>
						<th><div>必要数</div></th>
						<th><div>单位</div></th>
						<th><div>备考</div></th>
					</tr>
					{{#  layui.each(item.productionInstructionDetailList, function(indexs, items){ }}
					<tr>
						<td><div class="zq-text-align-c">{{ indexs + 1 }}</div></td>
						<td><div class="zq-text-align-c">{{ items.partsCd === null ? '' : items.partsCd}}</div></td>
						<td><div>{{ items.productName === null ? '' : items.productName}}</div></td>
						<td><div class="zq-text-align-c">{{ items.categoryName === null ? '' : items.categoryName}}</div></td>
						<td><div class="zq-text-align-c">{{ items.productionSchedule === null ? '' : items.productionSchedule}}</div></td>
						<td><div class="zq-text-align-c">{{ items.unit === null ? '' : items.unit }}</div></td>
						<td><div>{{ items.comment === null ? '' : items.comment}}</div></td>
					</tr>
					{{#  }) }}
					</tbody>
				</table>

			{{#  } }}
		</div>
	</div>
	{{#  }) }}
{{#  } }}
</script>

</body>
</html>