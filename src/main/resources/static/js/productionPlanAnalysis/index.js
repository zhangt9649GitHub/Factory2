// 生产计划分析
$(document).ready(function() {

    layui.config({
        base: '/static/public/layui/treetable-js/',
    });
	layui.use(['form', 'layer','laydate','laytpl','treeTable','laypage'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
            treeTable = layui.treeTable,
            laypage = layui.laypage,
            laytpl = layui.laytpl,
			row;

        var recordLimit = 10,    // 当前页的数据数量
            recordPage = 1,     // 当前页码
            fieldObject = { 	// 搜索值
                partsCd: '',
                goodsName: ''
			};
		laydate.render({
			elem: '#riqi'
		});


		// 设置滚动条
        $('.tbody').niceScroll({
            cursorcolor: '#828e94',
            cursorborder: "0",
            zindex: '10001'
        });




        // 首次加载数据
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
		axios.get(`/productionPlanningAnalysis/getProductionPlanningAnalysisList?limit=${recordLimit}&page=${recordPage}`)
			.then(function(response){
				if(response.data.code == 0){
					//
                    // 分页
                    let count = response.data.count;
                    laypage.render({
                        elem: 'demo'
                        ,count: count //数据总数，从服务端得到
                        ,limit: recordLimit
                        ,groups: 5
                        ,theme: '#00a2d9'
                        ,first: false
                        ,last: false
                        ,prev: '<i class="layui-icon layui-icon-left"></i>'
                        ,next: '<i class="layui-icon layui-icon-right"></i>'
                        ,layout: ['prev', 'page', 'next','skip', 'count']
                        ,jump: function(obj, first){
                            //obj包含了当前分页的所有参数，比如：
                            // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            // console.log(obj.limit); //得到每页显示的条数

                            recordPage = obj.curr;
                            recordLimit = obj.limit;
                            //首次不执行
                            if(!first){

                                pageData();
                            }
                        }
                    });

                    renderTable(response.data.data);
				}

			});


        // 记录数据
        var tableData;
        let renderTable = function(data){
            tableData = data;
            var getTpl = trData.innerHTML
                ,view = document.getElementById('view');

            laytpl(getTpl).render(data, function(html){

                view.innerHTML = html;
            });
            // 重置滚动条
            $('.tbody').getNiceScroll().resize();
            layer.closeAll('loading'); //关闭加载层
        };


		// 获取分页查询数据
		let pageData = function(type){
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            axios.get(`/productionPlanningAnalysis/getProductionPlanningAnalysisList?limit=${recordLimit}&page=${recordPage}&partsCd=${fieldObject.partsCd}&goodsName=${fieldObject.goodsName}`)
                .then(function(response){
                    if(response.data.code == 0){
                        //
                        renderTable(response.data.data);
                    }

                });
		};

		// 监听点击
        $('.tbody').on('click','.cursor-pointer',function(){
            var that = this;

            var productionOrderDetailsId = $(that).data('id');
            var getTpl = details.innerHTML;
            // 设置显示
            if($(that).find('i').hasClass('layui-icon-down')){
                // 隐藏
                $(that).find('i').removeClass('layui-icon-down');

                $('.tbody tr').each(function(index,item){
                    console.log($(item));
                    console.log($(item).data('id'));
                    if(productionOrderDetailsId === $(item).data('id')){
                        $(item).remove();
                    }
                })

            }else{
                // 显示
                $(that).find('i').addClass('layui-icon-down');
                // 循环获取数据

                $.each(tableData,function (index,item) {

                    if(productionOrderDetailsId == item.productionOrderDetailsId){


                        laytpl(getTpl).render(item, function(html){

                            $(that).parent().after(html);
                        });
                    }
                });
            }





            $('.tbody').getNiceScroll().resize();



        });



        //监听提交
        form.on('submit(formDemo)', function(data){

            fieldObject = {
                partsCd: $.trim(data.field.partsCd),
                goodsName: $.trim(data.field.goodsName)
			};
            recordPage = 1;
            pageData();
            return false;
        });

		// 触发事件
		var active = {

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
