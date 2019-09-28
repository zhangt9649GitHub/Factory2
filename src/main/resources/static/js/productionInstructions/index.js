// 生产指示书-列表
$(document).ready(function() {
	layui.use(['form', 'table', 'layer', 'upload','laydate'], function() {

		var layer = layui.layer,
			form = layui.form,
			upload = layui.upload,
			laydate = layui.laydate,
			table = layui.table,
			row;


		// 创建时间
		laydate.render({
			elem: '#laydate-1'
		});

		// 上传
		upload.render({
			elem: '#upload-file',
			url: '/productionInstruction/importProductionInstructionZip',
			field: 'file', // 设定文件域的字段名
			accept: 'file', // 指定允许上传时校验的文件类型
			before: function(){
				layer.load(1, {
					shade: [0.5,'#fff'] //0.1透明度的白色背景
				});
			},
			done: function(res) {
				layer.closeAll('loading'); //关闭加载层
				if(res.code == 10014){
					layer.msg(res.msg, {
						icon: 1
					});
					layui.table.reload('idTest')
					row = '';
				}else{
					layer.msg(res.msg, {
						icon: 2
					});
				}

			},
			error: function() {
				layer.msg('上传失败', {
					icon: 2
				})
			}

		});

		table.render({
			elem: '#idTest',
			height: 520,
			page: true,
			cellMinWidth: 120, // 定义所有常规单元格的最小宽度
			url: '/productionInstruction/getProductionInstructionList',
			cols: [
				[
					{
						field: 'serialNumber',
						title: '编号',
						unresize: true,
						templet: '#serialNumber'
					}, {
						field: 'createTime',
						title: '创建时间',
						unresize: true
					}, {
						field: 'state',
						title: '状态',
						unresize: true,
						templet: '#state'
					}

				]
			],
			done: function(response){

				row = '';
				//初始化
				$('.zq-search-form .search').css('margin-left',0);
				$(".layui-table-body.layui-table-main").scrollLeft(0);

				// 设置搜索滚动
				$('.zq-search-form .search').width($('.layui-table-view .layui-table-header table').width());


				// 监听查询滚动条的变化
				$(".layui-table-body.layui-table-main").scroll(function() {
					console.log();
					$('.zq-search-form .search').css('margin-left',-($(this).scrollLeft()));
				});

			}
		});

		// 监听数据表格行单击事件

		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});


		form.on('submit(*)', function(data){
			//执行重载
			table.reload('idTest', {
				page: {
					curr: 1 //重新从第 1 页开始
				}
				,where: {
					serialNumber: $.trim(data.field.serialNumber),
					createTime: $.trim(data.field.createTime),
					state: $.trim(data.field.state)
				}
			});
			return false;
		});


		// 触发事件
		var active = {
			// 更新状态
			updateState: function(that, href) {
				if (row) {
					if (href) {
						let url = `${href}?productionInstructionId=${row.productionInstructionId}`;
						zqIframeView('更新状态',url,400,500)
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择生产指示书')
				}
			},
			delete: function() {
				if (row) {
					layer.confirm('您确定删除此生产指示书吗?', {
						icon: 3,
						title: '提示'
					}, function(index, layero) {
						layer.load(1, {
							shade: [0.5,'#fff'] //0.1透明度的白色背景
						});
						var formdata = new FormData();
						formdata.append('productionInstructionId ', parseInt(row.productionInstructionId ));
						axios.post('/productionInstruction/deleteProductionInstructionById',formdata
						).then(function (response) {
							layer.closeAll('loading'); //关闭加载层
							layer.close(index);
							layer.msg(response.data.msg);
							if(response.data.code == 10004){

								layui.table.reload('idTest');
							}

						});
					});

				} else {
					layer.msg('请选择生产指示书')
				}
			},
			open: function(that, href) {
				if (row) {
					if (href) {
						location.href = `${href}?productionInstructionId=${row.productionInstructionId}`;
					} else {
						layer.msg('页面开发中')
					}
				} else {
					layer.msg('请选择生产指示书')
				}
			},
			// 重置
			reset: function () {
				$('.zq-search-form button[type="reset"]').click();
			}
		};
		// 点击调用
		$('body').on('click', '.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});


	})

});
