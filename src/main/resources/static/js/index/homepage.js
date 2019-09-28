$(document).ready(function(){
    layui.use(['form', 'table', 'layer','upload'], function() {

        var layer = layui.layer,
            form = layui.form,
            table = layui.table,
            upload = layui.upload;
        // 上传
        upload.render({
            elem: '#upload-file',
            done: function(res){
                layer.msg('上传成功',{icon:1})
            },
            error: function(){
                layer.msg('上传失败',{icon:2})
            }

        });

        //总资产
        var myChart1 = echarts.init(document.getElementById('main1'));

        var option1 = {
            title: {
                // text: '总资产',
                // subtext: '虚构数据',
                left: 'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                // orient: 'vertical',
                // top: 'middle',
                bottom: 10,
                left: 'center',
                data: ['现金', '代收账款','应收账款','固定资产','其他']
            },
            series : [
                {
                    type: 'pie',
                    radius : '65%',
                    center: ['50%', '40%'],
                    selectedMode: 'single',
                    data:[
                        {value:1548,name: '现金', },
                        {value:535, name: '代收账款'},
                        {value:510, name: '应收账款'},
                        {value:634, name: '固定资产'},
                        {value:735, name: '其他'}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        myChart1.setOption(option1);

        //采购分析
        var myChart2 = echarts.init(document.getElementById('main2'));
        var option2 = {
            color: ['#FE832E'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '0%',
                right: '0%',
                bottom: '0%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : ['2018-01', '2018-02', '2018-03', '2018-04', '2018-05', '2018-06', '2018-06','2018-08','2018-09','2018-10','2018-11','2018-12'],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value',

                }
            ],
            series : [
                {
                    name:'销售金额',
                    type:'bar',
                    barWidth: '40%',
                    data:[3000, 5200, 2000, 3340, 3900, 3300, 2200,3200,4800,2300,3400,4500]
                }
            ]
        };
        myChart2.setOption(option2);


        // 领料明细
        table.render({
            elem: '#idTest',
            height: 300,
            cellMinWidth: 80 ,// 定义所有常规单元格的最小宽度
            url: '/homePage/getPickingInfoList',
            cols: [
                [
                    {
                        field: 'partsCd',
                        title: '部品CD',
                        unresize: true
                    }, {
                        field: 'goodsName',
                        title: '品名',
                        unresize: true
                    }, {
                        field: 'quantity',
                        title: '数量',
                        unresize: true
                    }, {
                        field: 'name',
                        title: '领料人',
                        unresize: true
                    }, {
                        field: 'outWarehouseName',
                        title: '领出仓库',
                        unresize: true
                    }, {
                        field: 'intoWarehouseName',
                        title: '领入仓库',
                        unresize: true
                    }, {
                        field: 'addTime',
                        title: '日期',
                        unresize: true
                    }, {
                        field: 'pickingNumber',
                        title: '领料单编号',
                        unresize: true,
                        width: 100
                    }, {
                        field: 'lotNumber',
                        title: '批号',
                        unresize: true
                    }
                ]
            ],
            done: function(){
                $('.table .layui-table-view .layui-table-body.layui-table-main').niceScroll({
                    cursorcolor: '#828e94',
                    cursorborder: '0',
                    zindex: '120'
                });
            }
        });

        // 排产单
        table.render({
            elem: '#idTest1',
            height: 300,
            cellMinWidth: 80 ,// 定义所有常规单元格的最小宽度
            url: '/homePage/getProductionOrderInfoList',
            cols: [
                [
                    {field: 'productionOrderNumber',title: '编号', unresize: true}
                    ,{field: 'addTime',title: '创建时间',unresize: true}
                    ,{field: 'serialNumber',title: '指示书编号',unresize: true}
                    ,{field: 'name',title: '创建人',unresize: true}
                    ,{field: 'state',title: '状态',unresize: true,templet: '#ProductionOrder'}
                ]
            ],
            done: function(){
                $('.table1 .layui-table-view .layui-table-body.layui-table-main').niceScroll({
                    cursorcolor: '#828e94',
                    cursorborder: '0',
                    zindex: '120'
                });
            }
        });



        // 排产单
        table.render({
            elem: '#idTest2',
            height: 500,
            cellMinWidth: 120 ,// 定义所有常规单元格的最小宽度
            // url: './data2.json',
            data: [],
            cols: [
                [
                    {field: 'field1',title: '作成日期', unresize: true,"rowspan": 2,align: 'center'}
                    ,{title: '天津large·在库date',unresize: true,"colspan": 5,align: 'center'}
                    ,{title: '生产计划数据',unresize: true,"colspan": 4,align: 'center'}
                    ,{field: 'field2',title: '日付',unresize: true,"rowspan": 2,align: 'center'}
                    ,{title: '天津送出',unresize: true,"colspan": 2,align: 'center'}
                    ,{title: '人员状况',unresize: true,"colspan": 3,align: 'center'}
                ],
                [
                    {field: 'field3',title: '当前在库（商品）', unresize: true,align: 'center',width: 150,style:'background:#7cdedc'}
                    ,{field: 'field4',title: '当前在库',unresize: true,align: 'center',style:'background:#7cdedc'}
                    ,{field: 'field5',title: '订货剩余',unresize: true,align: 'center',style:'background:#7cdedc'}
                    ,{field: 'field6',title: '准备资材',unresize: true,align: 'center',style:'background:#7cdedc'}
                    ,{field: 'field7',title: '自由在库',unresize: true,align: 'center',style:'background:#7cdedc'}
                    ,{field: 'field8',title: '生产剩余',unresize: true,align: 'center',style:'background:#CADBD4'}
                    ,{field: 'field9',title: '销售剩余（商品）',unresize: true,align: 'center',width: 150,style:'background:#CADBD4'}
                    ,{field: 'field10',title: '合计',unresize: true,align: 'center',style:'background:#CADBD4'}
                    ,{field: 'field11',title: '增减',unresize: true,align: 'center',style:'background:#CADBD4'}
                    ,{field: 'field12',title: '送往天津',unresize: true,align: 'center'}
                    ,{field: 'field13',title: '从天津退回',unresize: true,align: 'center'}
                    ,{field: 'field14',title: '人数',unresize: true,align: 'center'}
                    ,{field: 'field15',title: '每月生产额',unresize: true,align: 'center'}
                    ,{field: 'field16',title: '生产剩余月数',unresize: true,align: 'center',width: 150}
                ]

            ],
            done: function(response){
                $('.table2 .layui-table-view .layui-table-body.layui-table-main').niceScroll({
                    cursorcolor: '#828e94',
                    cursorborder: '0',
                    zindex: '120'
                });

                // 设置搜索滚动

                $('.table2 .wrap .list').width($('.table2 .layui-table-view .layui-table-header table thead').width());
                var oldLeft = '0px';
                $('.table2 .layui-table-view .layui-table-body').scroll(function (e) {

                    var newLeft = $('#ascrail2002-hr .nicescroll-cursors').css('left');
                    if(oldLeft != newLeft){
                        $('.table2 .wrap .list').css('margin-left',-$(this).scrollLeft());
                        // $('.zq-search-form ').getNiceScroll(0).doScrollLeft($(this).scrollLeft());
                        oldLeft = newLeft;
                    }

                });

                // 判断字段
                //定位当前table视图
                var tableView = this.elem.next();
                //response.data获取后端返回的JSON格式数据
                $.each(response.data,function (index,item) {

                    //逻辑判断
                    console.log((item.field11).indexOf('-'))
                    if((item.field11).indexOf('-') != -1){
                        tableView.find('tbody tr[data-index="'+ index +'"] td[data-field="field11"]').css('color','red');
                    }
                });

            }
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
