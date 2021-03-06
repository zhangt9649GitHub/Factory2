// 经验值管理
$(document).ready(function(){
	layui.use(['form', 'table', 'layer'], function() {
	
		var $ = layui.$,
			layer = layui.layer,
			form = layui.form,
			table = layui.table;

		// 获取货物列表
		function getAllGoodsList(){
			return axios.get('/general/getGoodsNameList')
		}
		// 获取经验值列表
		function getStaffExperienceList(){
			return axios.get('/staff/getStaffExperienceList?staffId='+ $('input[name="staffId"]').val())

		}
        // 获取编辑信息
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
		// 记录货物
        let goodsList ;
        axios.all([getAllGoodsList(), getStaffExperienceList()])
            .then(axios.spread(function (acct, perms) {
                // 两个请求现在都执行完成
                goodsList = acct.data.data;
				let tableData = [];
				$.each(perms.data.data,function (i,item) {

					let arr = {
                        goodsId: item.goodsId,
                        experienceValue: item.experienceValue,
                        goodsList: acct.data.data
					};
                    tableData.push(arr)
                });

                table.reload('idTest', {
                    data: tableData
                });
                layer.closeAll('loading'); //关闭加载层
            }));

		table.render({
			elem: '#idTest',
            limit: 10000,
			height: 312,
			cellMinWidth: 80 ,// 定义所有常规单元格的最小宽度
			data: [],
			cols: [
				[
                    {
                        width: 70,
                        align: 'center',
                        toolbar: '#barDemo',
                        unresize: true,
                        fixed: 'left'
                    },
                    {
						field: 'goodsId',
						title: '货物名称',
						unresize: true,
						templet: '#goodsId'
					}, {
						field: 'experienceValue',
						title: '经验值',
                    	edit: 'text',
						unresize: true
					}
				
				]
			],
			done: function(){
                layui.each($('select'), function (index, item) {
                    let elem = $(item);
                    elem.val(elem.data('value')).parents('div.layui-table-cell').css('overflow', 'visible');
                });

                form.render();

				$('.layui-table-view .layui-table-body').niceScroll({
					cursorcolor: '#828e94',
					cursorborder: "1px solid #828e94",
				});
			}
		});
        // 监听下拉框点击
        $(document).on('click','.layui-select-title',function () {
            $(".layui-table-view .layui-table-body").getNiceScroll().resize();
        });
		// 监听数据表格行单击事件
		table.on('row(demo)', function(obj) {
			//标注选中样式
			// console.log(obj.data) //得到当前行数据
			var row = obj.data;
			obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
		});

        // 监听表格工具栏操作
        table.on('tool(demo)', function(obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            // 获取动态表格的数据
            var tableBak = table.cache['idTest'];

            if (layEvent === 'addRow') {
                // 新增行

                tableBak.push({goodsList:goodsList,goodsId: ''});

                table.reload('idTest', {
                    data: tableBak
                });

            } else if (layEvent === 'daleteRow') {
                // 删除行

                tableBak.splice(tr.attr('data-index'), 1);
                table.reload('idTest', {
                    data: tableBak
                });

            }
        });



        // 监听修改update到表格中
        form.on('select(goodsId)', function (data) {
            // debugger;
            var elem = $(data.elem);
            var trElem = elem.parents('tr');
            var tableData = table.cache['idTest'];
            // 更新到表格的缓存数据中，才能在获得选中行等等其他的方法中得到更新之后的值
            tableData[trElem.data('index')][elem.attr('name')] = data.value;
            // 其他的操作看需求 TODO
        });

        //监听提交
        form.on('submit(*)', function(data){

        	let that = this;

            let tableBak = table.cache['idTest'];
            let staffExperienceList = [];
            for(let i in tableBak){
                if(tableBak[i].goodsId){

                	let arr = {
                		goodsId: tableBak[i].goodsId,
                        experienceValue: tableBak[i].experienceValue,
					};

                    staffExperienceList.push(arr);
                }
            }
			data.field.staffExperienceList = staffExperienceList;
            // 禁止点击
            $(that).addClass('zq-submit-disabled');

            axios.post('/staff/insertStaffExperience', data.field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    $(that).removeClass('zq-submit-disabled');
                    // if (response.data.code == 30004) {
                    //     setTimeout(function () {
                    //         window.location.reload(); //刷新父页面
					//
                    //     }, 1000);
                    // }else {
                    //     // 取消禁止点击
                    //
                    // }
                });
            return false;
        });

	
		// 触发事件
		var active = {
			
		};
		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				href = othis.data('href');
			active[type] ? active[type].call(this, othis, href) : '';
		});
	
	
	})
	
});