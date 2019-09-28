<#include "../public_header.ftl">


	<link rel="stylesheet" type="text/css" href="/static/css/employeeManagement/add.css">
	<script type="text/javascript" src="/static/js/employeeManagement/add.js"></script>

</head>
<body>

<div class="zq-wrap">
	<div class="layui-card bg-1 layui-form">
		<div class="layui-card-header layui-clear">
			<h3 class="left">新增-员工信息 <span></span></h3>
			<div class="zq-btn-list">
				<button class="layui-btn green zq-active" lay-submit lay-filter="*">提交</button>
				<button class="layui-btn blue zq-active" type="button" data-type="zq_return">返回列表</button>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-tab layui-tab-brief">
				<ul class="layui-tab-title">
					<li class="layui-this">个人信息</li>
					<li>工资标准及社保</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<div class="zq-form-container ">
							<div class="gerenxinxi zq-margin-t30">
								<!-- 照片 -->
								<div class="photo">
									<div class="layui-col-md12">
										<div class="image">
											<img src="" alt="" id="upload-image">
											<input type="hidden" name="ufId" id="upload-value" lay-verify="required" lay-reqtext="请上传员工照片">
										</div>
										<p>个人照片</p>
									</div>
								</div>

								<!-- 照片 -->

								<div class="content">

									<div class="layui-row info">
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">工号</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input" name="jobNumber" autocomplete="off" lay-verify="required">
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">姓名</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input"  name="name" autocomplete="off" lay-verify="required">
												</div>
											</div>

										</div>

										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">性别</label>
												<div class="layui-input-block">
													<select  name="gender" lay-search lay-verify="required">
														<option value=""></option>
														<option value="男">男</option>
														<option value="女">女</option>
													</select>
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">身份证号</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input"  name="cardNumber" autocomplete="off" lay-verify="required">
												</div>
											</div>

										</div>

										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">电话</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input"  name="phone" autocomplete="off" lay-verify="required">
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">地址</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input"  name="address" autocomplete="off" lay-verify="required">
												</div>
											</div>

										</div>

										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">入职日期</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input" readonly id="entryTime"  name="entryTime" autocomplete="off" lay-verify="required">
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">离职日期</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input" readonly id="departureTime"  name="departureTime" autocomplete="off">
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">状态</label>
												<div class="layui-input-block">
													<select name="state" lay-search lay-verify="required">
														<option value=""></option>
														<option value="1">离职</option>
														<option value="2">在职</option>
													</select>
												</div>
											</div>

										</div>

										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">是否转正</label>
												<div class="layui-input-block">
													<select  name="isTurnPositive" lay-search lay-verify="required">
														<option value=""></option>
														<option value="1">是</option>
														<option value="2">否</option>
													</select>
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">转正日期</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input" readonly id="positiveTime"  name="positiveTime" autocomplete="off"/>
												</div>
											</div>

										</div>

										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">所在部门</label>
												<div class="layui-input-block">
													<select name="department" lay-search lay-verify="required">
														<option value=""></option>
													</select>
												</div>
											</div>
										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">角色</label>
												<div class="layui-input-block">
													<select name="role" lay-search lay-verify="required">
														<option value=""></option>
													</select>
												</div>
											</div>

										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">岗位</label>
												<div class="layui-input-block">
													<select name="post" lay-search lay-verify="required">
														<option value=""></option>
													</select>
												</div>
											</div>

										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">权限组</label>
												<div class="layui-input-block">
													<select name="groupId" lay-search lay-verify="required">
														<option value=""></option>
													</select>
												</div>
											</div>

										</div>
										<div class="layui-col-md6">
											<div class="layui-form-item">
												<label class="layui-form-label">保险公司</label>
												<div class="layui-input-block">
													<input type="text" class="layui-input" name="insuranceCompany" autocomplete="off">
												</div>
											</div>
										</div>
										<div class="layui-col-md12">
											<div class="layui-form-item layui-form-text">
												<label class="layui-form-label">备注</label>
												<div class="layui-input-block">
													<textarea class="layui-textarea"  name="comment"></textarea>
												</div>

											</div>
										</div>

									</div>

								</div>

							</div>


						</div>
					</div>
					<div class="layui-tab-item">
						<div class="zq-form-container ">
							<div class="wage-standard">
								<div class="title">工资标准：</div>
								<table class="layui-table wages">
									<tbody>
										<tr>
											<td>实习工资</td>
											<td>基本工资</td>
											<td>支付劳动局管理费</td>
											<td>岗位津贴</td>
											<td>伙食扣款</td>
											<td>天津工厂扣款</td>
										</tr>
										<tr>
											<td>
												<div>
													<input type="text" name="trainSalary" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="basicSalary" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="managementFee" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="postAllowance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="foodDeduction" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="tjFactoryDeduction" value="0">
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								<div class="list">
									<label class="label">社保：</label>
									<div class="block">
										<input type="radio" name="issocial" lay-filter="issocial" value="1" title="有" checked>
										<input type="radio" name="issocial" lay-filter="issocial" value="0" title="无" >
									</div>
								</div>
								<div class="social-insurance">
									<div class="title">社保公积金标准（个人）：</div>
									<table class="layui-table personal">
										<tbody>
										<tr>
											<td>保险补助</td>
											<td>养老</td>
											<td>医疗</td>
											<td>失业</td>
											<td>个人社保合计</td>
											<td>个人公积金</td>
											<td>个人社保公积金合计</td>
										</tr>
										<tr>
											<td>
												<div>
													<input type="text" name="personalInsuranceBenefits" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalEndowmentInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalMedicalInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalUnemploymentInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalInsuranceTotal" value="0" readonly>
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalAccumulationFund" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="personalTotalIndividual" value="0" readonly>
												</div>
											</td>
										</tr>
										</tbody>
									</table>
									<div class="title">社保公积金标准（公司）：</div>
									<table class="layui-table company">
										<tbody>
										<tr>
											<td>养老</td>
											<td>医疗</td>
											<td>失业</td>
											<td>工伤</td>
											<td>生育</td>
											<td>单位社保合计</td>
											<td>单位公积金</td>
											<td>单位社保与公积金合计</td>
										</tr>
										<tr>
											<td>
												<div>
													<input type="text" name="companyEndowmentInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="companyMedicalInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="companyUnemploymentInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="inductrialInjuryInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="fertilityInsurance" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="companyInsuranceTotal" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="companyAccumulationFund" value="0">
												</div>
											</td>
											<td>
												<div>
													<input type="text" name="companyTotalIndividual" value="0">
												</div>
											</td>
										</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>





</body>
</html>