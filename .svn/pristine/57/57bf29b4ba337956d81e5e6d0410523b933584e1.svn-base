$(document).ready(function() {
    layui.use(['form', 'table', 'layer', 'laydate'], function() {

        var layer = layui.layer,
            form = layui.form,
            laydate = layui.laydate,
            table = layui.table;

        // 日期
        laydate.render({
            elem: '#date' //指定元素
            ,range: '~'
        });

        // 获取货物类别
        axios.post('/goods/getGoodsCategoryList')
            .then(function(response){
                if(response.data.code == 0){
                    $.each(response.data.data,function(i,item){
                        $('select[name="category"]').append(`<option value="${item.key}">${item.value}</option>`)
                    });
                    form.render('select');
                }
            });
        // 获取品名
        axios.get('/inboundAndOutbound/getInboundAndOutboundAnalysisList')
            .then(function(response){
                let data = response.data;
                if(data.code == 0){
                    $.each(data.data.inboundAndOutboundAnalysisList,function(i,item){
                        $('select[name="goodsId"]').append(`<option value="${item.goodsId}">${item.goodsName}</option>`)
                    });
                    form.render('select');
                }
            });


        // 动态表格
        table.render({
            elem: '#idTest',
            // height: 600,
            limit: 10000,
            cellMinWidth: 80, // 定义所有常规单元格的最小宽度
            // url: '/inboundAndOutbound/getInboundAndOutboundAnalysisList',
            data: [],
            totalRow: true, //开启合计
            cols: [
                [
                    {field: 'goodsName',title: '名称',unresize: true,width:300,align: 'center',"rowspan": 2,style:'background:#16AFAC',totalRowText: '合计'}
                    ,{title: '入库',unresize: true,align: 'center',"colspan": 3}
                    ,{title: '出库',unresize: true,align: 'center',"colspan": 3}
                    ,{title: '结存',unresize: true,align: 'center',"colspan": 3}
                ],
                [
                    {field: 'inventoryQuantity',title: '入库数量',unresize: true,align: 'right',style:'background:#CADBD4',totalRow:true}
                    ,{field: 'inventoryUnitPrice',title: '入库单价',unresize: true,align: 'right',style:'background:#CADBD4',totalRow:true}
                    ,{field: 'inventoryAmount',title: '入库金额',unresize: true,align: 'right',style:'background:#CADBD4',totalRow:true}
                    ,{field: 'outboundQuantity',title: '出库数量',unresize: true,align: 'right',style:'background:#A3CB20',totalRow:true}
                    ,{field: 'outboundUnitPrice',title: '出库单价',unresize: true,align: 'right',style:'background:#A3CB20',totalRow:true}
                    ,{field: 'outboundAmount',title: '出库金额',unresize: true,align: 'right',style:'background:#A3CB20',totalRow:true}
                    ,{field: 'inStockQuantity',title: '在库数量',unresize: true,align: 'right',style:'background:#D7CA16',totalRow:true}
                    ,{field: 'inStockUnitPrice',title: '在库单价',unresize: true,align: 'right',style:'background:#D7CA16',totalRow:true}
                    ,{field: 'inStockAmount',title: '在库金额',unresize: true,align: 'right',style:'background:#D7CA16',totalRow:true}
                ]

            ],
            // parseData: function(res){
            //
            //     return {
            //         "code": res.code, //解析接口状态
            //         "msg": res.msg, //解析提示文本
            //         "data": res.data.inboundAndOutboundAnalysisList //解析数据列表
            //     }
            // },
            done: function(res){
                $('.layui-table-view .layui-table-body.layui-table-main').niceScroll({
                    cursorcolor: '#828e94',
                    cursorborder: "1px solid #828e94"
                });
            }
        });


        let field = {startTime:'',endTime:'',goodsId:'',category:''};
        function getData(){
            axios.get('/inboundAndOutbound/getInboundAndOutboundAnalysisList?startTime='+field.startTime+'&endTime='+field.endTime+'&goodsId='+field.goodsId+'&category='+field.category)
                .then(function (response) {
                    if(response.data.code == 0){
                        let data = response.data.data.inboundAndOutboundAnalysisList;
                        if(data.length > 10){
                            table.reload('idTest', {
                                height: 458,
                                data: data
                            });
                        }else{
                            table.reload('idTest', {
                                data: data
                            });
                        }
                    }
                })
        }
        getData();

        // 查询
        form.on('submit(*)', function(data) {
            let dateRange = data.field.dateRange;
            data.field.startTime = $.trim(dateRange.substring(0,dateRange.indexOf('~')));
            data.field.endTime = $.trim(dateRange.substring(dateRange.indexOf('~') + 1));
            field = data.field;
            getData();
            return false;
        });





        // 触发事件
        var active = {
            // 筛选
            screen: function () {
                $('.layui-form button[lay-filter="*"]').click();
            },
            // 导出
            export: function () {
               location.href='/inboundAndOutbound/exportInboundAndOutboundAnalysisList?startTime='+field.startTime+'&endTime='+field.endTime+'&goodsId='+field.goodsId+'&category='+field.category;
            }

        };
        // 点击调用
        $('body').on('click', '.zq-active', function() {
            var othis = $(this),
                type = othis.data('type');

            active[type] ? active[type].call(this, othis) : '';
        });



    })
});
