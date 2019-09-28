$(document).ready(function(){

    layui.use(['laypage','form','laytpl'],function(){
        var laypage = layui.laypage,
            form = layui.form,
            laytpl = layui.laytpl;

        var recordLimit = 10,    // 当前页的数据数量
            recordPage,     // 当前页码
            recordData,     // 当前页数据
            recordField,    // 进行排序的字段
            recordSort;         // 升序还是降序

        // 添加滚动条
        $('.zq-container .divtable.table1 .body .wrap').niceScroll({
            cursorcolor: '#828e94'
        });

        $('.zq-container dl.datalist').on('click','dd',function(e){

            $(this).siblings().removeClass('datalist-click');
            $(this).addClass('datalist-click');
        });


        //数字对象排序-正序
        function compareAsc(pro) {
            return function (obj1, obj2) {
                var val1 = obj1[pro];
                var val2 = obj2[pro];
                if (val1 > val2 ) { //正序
                    return 1;
                } else if (val1 < val2 ) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        // 数字对象排序-倒序
        function compareDesc(pro) {
            return function (obj1, obj2) {
                var val1 = obj1[pro];
                var val2 = obj2[pro];
                if (val1 < val2 ) { //倒序
                    return 1;
                } else if (val1 > val2 ) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        // 获取货物类别
        axios.post(`/goods/getGoodsCategoryList`)
            .then(function(response){
                let data = response.data;
                if(data.code == 0){
                    $.each(data.data,function(i,item){
                        $('select[name="category"]').append(`<option value="${item.key}">${item.value}</option>`)
                    });
                    form.render('select');
                }
            });

        // 首次加载数据
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
        axios.get('/productionScheduleAnalysis/getProductionScheduleAnalysisList?limit='+recordLimit+'&page=1')
            .then(function (response) {
                if(response.data.code == 0){
                    var data = response.data.data;
                    // 循环数据
                    $.each(data,function (i,item) {

                        if(i == 0){
                            // 排序
                            item.productionProcessList.sort(compareAsc('order'));
                            // 日期
                            var date = document.getElementById('date').innerHTML;
                            laytpl(date).render(item.productionProcessList, function(html){
                               $('.table1 .header .list.date .generate').remove();
                                $('.table1 .header .list.date').append(html);
                            });
                            // 状态
                            var state = document.getElementById('state').innerHTML;
                            laytpl(state).render(item.productionProcessList, function(html){
                                $('.table1 .header .list.state .generate').remove();
                                $('.table1 .header .list.state').append(html);
                            });

                            // 生产指示书
                            var serialNumber = document.getElementById('serialNumber').innerHTML;
                            laytpl(serialNumber).render(item.productionProcessList, function(html){
                                $('.table1 .header .list.serialNumber .generate').remove();
                                $('.table1 .header .list.serialNumber').append(html);
                            });

                        }

                        // 排序
                        item.productionProcessRateList.sort(compareAsc('order'));
                    });

                    //记录数据
                    recordData = data;
                    // console.log(data);
                    // 表格数据
                    var tableData = document.getElementById('table-data').innerHTML;

                    laytpl(tableData).render(data, function(html){
                        $('.table1 .body .wrap').html(html);
                    });

                    var count = response.data.count;
                    // 分页
                    laypage.render({
                        elem: 'demo'
                        ,count: count //数据总数，从服务端得到
                        ,limit: recordLimit
                        ,groups: 1
                        ,theme: '#00a2d9'
                        ,first: false
                        ,last: false
                        ,layout: ['prev', 'page', 'next','skip', 'count']
                        ,jump: function(obj, first){
                            //obj包含了当前分页的所有参数，比如：
                            // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            // console.log(obj.limit); //得到每页显示的条数

                            recordPage = obj.curr;

                            //首次不执行
                            if(!first){

                                pageData(obj.curr,obj.limit);
                            }
                        }
                    });
                    layer.closeAll('loading'); //关闭加载层
                }
            });

        // 分页数据
        function pageData(page,limit,field){
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            var category = '';
            var goodsName = '';
            if(field){
                category = field.category;
                goodsName = $.trim(field.goodsName)
            }
            axios.get('/productionScheduleAnalysis/getProductionScheduleAnalysisList?limit='+ limit + '&page='+ page
            + '&category=' + category + '&goodsName=' + goodsName)
                .then(function (response) {
                    if(response.data.code == 0){
                        var data = response.data.data;
                        // 循环数据
                        $.each(data,function (i,item) {

                            if(i == 0){
                                // 排序
                                item.productionProcessList.sort(compareAsc('order'));
                                // 日期
                                var date = document.getElementById('date').innerHTML;
                                laytpl(date).render(item.productionProcessList, function(html){
                                    $('.table1 .header .list.date .generate').remove();
                                    $('.table1 .header .list.date').append(html);
                                });
                                // 状态
                                var state = document.getElementById('state').innerHTML;
                                laytpl(state).render(item.productionProcessList, function(html){
                                    $('.table1 .header .list.state .generate').remove();
                                    $('.table1 .header .list.state').append(html);
                                });

                                // 生产指示书
                                var serialNumber = document.getElementById('serialNumber').innerHTML;
                                laytpl(serialNumber).render(item.productionProcessList, function(html){
                                    $('.table1 .header .list.serialNumber .generate').remove();
                                    $('.table1 .header .list.serialNumber').append(html);
                                });

                            }

                            // 排序
                            item.productionProcessRateList.sort(compareAsc('order'));
                        });

                        //记录数据
                        recordData = data;

                        var datas = recordData.slice();

                        switch (recordSort) {
                            case 'ase':
                                datas.sort(compareAsc(recordField));
                                break;
                            case 'desc':
                                datas.sort(compareDesc(recordField));
                                break;
                        }

                        // 表格数据
                        var tableData = document.getElementById('table-data').innerHTML;

                        laytpl(tableData).render(datas, function(html){
                            $('.table1 .body .wrap').html(html);
                        });
                        layer.closeAll('loading'); //关闭加载层
                    }
                })
        }


        //  搜索
        form.on('submit(*)', function(data) {
            pageData(recordPage,recordLimit,data.field);
            return false;
        });

        // 升序
        function ascending(){
            console.log('升序');
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            var data = recordData.slice();
            data.sort(compareAsc(recordField));

            // 表格数据
            var tableData = document.getElementById('table-data').innerHTML;

            laytpl(tableData).render(data, function(html){
                $('.table1 .body .wrap').html(html);
            });
            layer.closeAll('loading'); //关闭加载层
        }
        // 降序
        function descending(){
            console.log('降序');
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            var data = recordData.slice();
            data.sort(compareDesc(recordField));

            // 表格数据
            var tableData = document.getElementById('table-data').innerHTML;

            laytpl(tableData).render(data, function(html){
                $('.table1 .body .wrap').html(html);
            });
            layer.closeAll('loading'); //关闭加载层
        }

        // 正常
        function normal(){
            console.log('正常');
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            var data = recordData;

            // 表格数据
            var tableData = document.getElementById('table-data').innerHTML;

            laytpl(tableData).render(data, function(html){
                $('.table1 .body .wrap').html(html);
            });
            layer.closeAll('loading'); //关闭加载层
        }

        // 排序
        $('.zq-container .divtable.table1').on('click','.header .item .layui-table-sort .layui-edge',function(e){


            recordField = $(this).parents('.item').data('field');


            if($(this).hasClass('layui-table-sort-asc')){

                if(typeof($(this).parent().attr('lay-sort')) == "undefined" || $(this).parent().attr('lay-sort') =='desc'){
                    $(this).parents('.item').siblings().find('.layui-table-sort').removeAttr('lay-sort');
                    $(this).parent().attr('lay-sort', 'asc');
                    recordSort = 'asc';
                    //升序
                    ascending();
                }else {
                    $(this).parent().removeAttr('lay-sort');
                    recordSort = '';
                    normal();
                }

            }
            if($(this).hasClass('layui-table-sort-desc')){
                if(typeof($(this).parent().attr('lay-sort')) == "undefined" || $(this).parent().attr('lay-sort') =='asc'){
                    $(this).parents('.item').siblings().find('.layui-table-sort').removeAttr('lay-sort');
                    $(this).parent().attr('lay-sort', 'desc');
                    recordSort = 'desc';
                    // 降序
                    descending();
                }else{
                    $(this).parent().removeAttr('lay-sort');
                    recordSort = '';
                    normal();
                }
            }

        });





        // 获取table2的数据
        function getTable2Data(goodsId){
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            axios.get('/productionScheduleAnalysis/getInfoByGoodsId?goodsId=' + Number(goodsId)+
                '&limit=' + recordLimit + '&page=' + recordPage)
                .then(function (response) {
                    // console.log(response);
                    if(response.data.code == 0){
                        var data = response.data.data;
                        // 循环数据
                        $.each(data,function (i,item) {
                            if(i == 0){
                                // 排序
                                item.productionProcessList.sort(compareAsc('order'));
                                // 生产指示书

                                var tr2 = `<div class="item tit">物品名（下位1）</div>
											<div class="item tit">平均月贩</div>
											<div class="item tit" title="不包括运送中">在库月数(日本)</div>
											<div class="item tit" >库存/最低库存</div>
											<div class="item">压缩</div>`;
                                var serialNumber = document.getElementById('serialNumber').innerHTML;
                                laytpl(serialNumber).render(item.productionProcessList, function(html){
                                    $('.table2 .header .list.tr2').html(tr2);
                                    $('.table2 .header .list.tr2').append(html);
                                });

                            }
                            // 排序
                            item.productionProcessRateList.sort(compareAsc('order'));
                        });

                        // 表格数据
                        var tableData = document.getElementById('table-data').innerHTML;

                        laytpl(tableData).render(data, function(html){
                            $('.table2 .body').html(html);
                        });
                    }
                    layer.closeAll('loading'); //关闭加载层
                })
        }

        // table1物品名点击
        $('.zq-container .divtable.table1 .body').on('click','.list .item:first-child',function(e){
            $(this).parent().siblings().removeClass('divtable-click');
            $(this).parent().addClass('divtable-click');

            // 记录选中
            var goodsId = $(this).data('id');
            $.each(recordData,function (i,item) {
                if(item.goodsId == goodsId){
                    item.selected = true;
                }
            });
            // 更改table2数据


            getTable2Data(goodsId);

        });


        // table1表头点击
        $('.zq-container .divtable.table1').on('click','.header .tr2 .item-click',function(e){

            $(this).toggleClass('divtable-click');
        });



        // table2物品名点击
        $('.zq-container .divtable.table2 .body ').on('click','.item:first-child',function(e){
            $(this).parent().siblings().removeClass('divtable-click');
            $(this).parent().addClass('divtable-click');
            // 记录选中
            var goodsId = $(this).data('id');
            // 更改table2数据
            getTable3Data(goodsId)
        });

        // 获取table3的数据
        function getTable3Data(goodsId){
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            axios.get('/productionScheduleAnalysis/getInfoByGoodsId?goodsId=' + Number(goodsId)+
                '&limit=' + recordLimit + '&page=' + recordPage)
                .then(function (response) {
                    // console.log(response);
                    if(response.data.code == 0){
                        var data = response.data.data;
                        // 循环数据
                        $.each(data,function (i,item) {
                            if(i == 0){
                                // 排序
                                item.productionProcessList.sort(compareAsc('order'));
                                // 生产指示书

                                var tr2 = `<div class="item tit">物品名（下位1）</div>
											<div class="item tit">平均月贩</div>
											<div class="item tit" title="不包括运送中">在库月数(日本)</div>
											<div class="item tit" >库存/最低库存</div>
											<div class="item">压缩</div>`;
                                var serialNumber = document.getElementById('serialNumber').innerHTML;
                                laytpl(serialNumber).render(item.productionProcessList, function(html){
                                    $('.table3 .header .list.tr2').html(tr2);
                                    $('.table3 .header .list.tr2').append(html);
                                });

                            }
                            // 排序
                            item.productionProcessRateList.sort(compareAsc('order'));
                        });

                        // 表格数据
                        var tableData = document.getElementById('table-data').innerHTML;

                        laytpl(tableData).render(data, function(html){
                            $('.table3 .body').html(html);
                        });
                    }
                    layer.closeAll('loading'); //关闭加载层
                })
        }



        // 移入显示具体的状态数据
        $('.zq-container .divtable .body').on('mouseover','.item.item-hover',function (e) {

            $(this).find('ol').show();

            $(this).find('ol').css('left',$(this).position().left);
            $(this).find('ol').css('top',$(this).position().top + $(this).outerHeight());

        });
        $('.zq-container .divtable .body').on('mouseout','.item.item-hover',function () {
            $(this).find('ol').hide();
        });



        // 触发事件
        var active = {
            // 显隐table2/table3
            showAndHide: function () {
                $('.zq-container .divtable.table2').toggleClass('layui-hide');
                $('.zq-container .divtable.table3').toggleClass('layui-hide');
            }
        };

        // 点击调用
        $('body').on('click', '.zq-active', function() {
            var othis = $(this),
                type = othis.data('type'),
                href = othis.data('href');
            active[type] ? active[type].call(this, othis, href) : '';
        });
    });





});