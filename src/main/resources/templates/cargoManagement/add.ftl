<#include "../public_header.ftl">

    <link rel="stylesheet" href="/static/public/layui/formSelects/formSelects-v4.css">
	<script type="text/javascript" src="/static/js/cargoManagement/add.js"></script>

</head>
<body>

<div class="zq-wrap">

	<div class="layui-card bg-1 ">
		<div class="layui-card-body">
			<form action="" class="layui-form zq-form" lay-filter="formTest">
				<div class="zq-btn-list">
					<button class="layui-btn green" lay-submit lay-filter="*">提交</button>
					<button class="layui-btn blue zq-active" type="button" data-type="zq_closeIframe">关闭</button>

				</div>
				<div class="layui-row zq-form-wrap zq-margin-t30">

					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								部品CD
							</label>
							<div class="layui-input-block">
								<input type="text" name="partsCd" lay-verify="required"  autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								品名
							</label>
							<div class="layui-input-block">
								<input type="text" name="goodsName" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								品种
							</label>
							<div class="layui-input-block">
								<select name="varietyValue" lay-search lay-verify="required">
									<option value=""></option>
								</select>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								单位
							</label>
							<div class="layui-input-block">
								<input type="text" name="unit" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								规格
							</label>
							<div class="layui-input-block">
								<input type="text" name="specification" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								重量
							</label>
							<div class="layui-input-block">
								<input type="text" name="weight" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								日元单价
							</label>
							<div class="layui-input-block">
								<input type="text" name="unitPrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								a单价（进货价）
							</label>
							<div class="layui-input-block">
								<input type="text" name="aPrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								b单价（加工价）
							</label>
							<div class="layui-input-block">
								<input type="text" name="bPrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								采购起订量
							</label>
							<div class="layui-input-block">
								<input type="text" name="purchaseOrderQuantity" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								销售价格
							</label>
							<div class="layui-input-block">
								<input type="text" name="sellingPrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								批发价格
							</label>
							<div class="layui-input-block">
								<input type="text" name="wholesalePrices" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								最低库存
							</label>
							<div class="layui-input-block">
								<input type="text" name="minimumStock" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								采购预备库存指数
							</label>
							<div class="layui-input-block">
								<input type="text" name="procurementReserveStockIndex" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								日本侧库存
							</label>
							<div class="layui-input-block">
								<input type="text" name="japanStock" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								天津侧库存
							</label>
							<div class="layui-input-block">
								<input type="text" name="tjStock" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								进货价
							</label>
							<div class="layui-input-block">
								<input type="text" name="purchasePrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								工资单价
							</label>
							<div class="layui-input-block">
								<input type="text" name="salaryPrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								平均单价
							</label>
							<div class="layui-input-block">
								<input type="text" name="averagePrice" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								装箱标准
							</label>
							<div class="layui-input-block">
								<input type="text" name="boxesNumber" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								月贩卖量
							</label>
							<div class="layui-input-block">
								<input type="text" name="monthlySalesVolume" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								贩卖月数
							</label>
							<div class="layui-input-block">
								<input type="text" name="sellingMonths" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								净重
							</label>
							<div class="layui-input-block">
								<input type="text" name="netWeight" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								毛重
							</label>
							<div class="layui-input-block">
								<input type="text" name="grossWeight" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								体积
							</label>
							<div class="layui-input-block">
								<input type="text" name="volume" lay-verify="required" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								在库月数
							</label>
							<div class="layui-input-block">
								<input type="text" name="monthsInStock" lay-verify="required|number" autocomplete="off" class="layui-input"/>
							</div>
						</div>
					</div>
					<div class="layui-col-md6 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								货物类别
							</label>
							<div class="layui-input-block">
								<select name="category" lay-verify="required" lay-search>
									<option value=""></option>
								</select>
							</div>
						</div>
					</div>
                    <div class="layui-col-md6 ">
                        <div class="layui-form-item">
                            <label class="layui-form-label">
                                <b>*</b>
                                仓位
                            </label>
                            <div class="layui-input-block">
                                <select name="wpId" lay-search lay-verify="required">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>
                    </div>
					<div class="layui-col-md12 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								供应商
							</label>
							<div class="layui-input-block">
								<select name="supplierId" lay-verify="required" xm-select="supplierId" xm-select-search>
									<option value=""></option>
								</select>
							</div>
						</div>
					</div>

					<div class="layui-col-md12 ">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								图片
							</label>
							<div class="layui-input-block">
								<div class="zq-img-file">
									<img src="/static/img/dj.jpg" alt="" id="upload-image">
									<input type="hidden" name="ufId" id="upload-value" lay-verify="required" lay-reqText="请上传货物照片">
								</div>
							</div>
						</div>
					</div>
					<div class="layui-col-md12">
						<div class="layui-form-item">
							<label class="layui-form-label">
								<b>*</b>
								阶梯价格
							</label>
							<div class="layui-input-block">
								<table id="idTest" lay-filter="demo" class="layui-table"></table>
							</div>
						</div>
					</div>





				</div>
			</form>
		</div>
	</div>



</div>

<!-- 添加删除图标按钮 -->
<script type="text/html" id="barDemo">
	<div>

		<span class="iconfont iconhao green"  lay-event="addRow"></span>

		&nbsp;

		<span class="iconfont icon-hao red"  lay-event="daleteRow"></span>

	</div>
</script>



</body>
</html>