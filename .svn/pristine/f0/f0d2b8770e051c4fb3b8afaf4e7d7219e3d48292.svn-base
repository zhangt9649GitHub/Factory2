$(document).ready(function() {
    layui.use(['form', 'table', 'layer', 'laydate'], function() {

        var $ = layui.$,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            laydate = layui.laydate;

        // 弹出层的表格
        table.render({
            elem: '#idTest',
            limit: 10000,
            cellMinWidth: 80, // 定义所有常规单元格的最小宽度
            totalRow: true, //开启合计行区域
            data: [],
            cols: [
                [
                    {
                        field: 'partsCd',
                        title: '部品CD',
                        unresize: true,
                        totalRowText: '合计（小写）',
                        width: 120
                    }, {
                        field: 'goodsName',
                        title: '品名',
                        unresize: false
                    }, {
                        field: 'unit',
                        title: '单位',
                        unresize: true
                    }, {
                        field: 'quantity',
                        title: '数量'
                    }, {
                        field: 'inQuantity',
                        title: '已入库数量'
                    },  {
                        field: 'purchasePrice',
                        title: '单价',
                        unresize: true
                    }, {
                        field: 'excludingTaxAmount',
                        title: '不含税金额',
                        unresize: true
                    }, {
                        field: 'taxRate',
                        title: '税率',
                        unresize: true
                    }, {
                        field: 'tax',
                        title: '税额',
                        unresize: true
                    }, {
                        field: 'taxIncludedAmount',
                        title: '含税金额',
                        unresize: true,
                        totalRow: true
                    }, {
                        field: 'financeMoney',
                        title: '财务金额',
                        unresize: true,
                        edit: 'text',
                        totalRow: true
                    }
                ]
            ],
            done: function(){
                $('.layui-table-view .layui-table-body').niceScroll({
                    cursorcolor: '#828e94',
                    cursorborder: "1px solid #828e94",
                });
            }
        });

        let formdata = new FormData();
        formdata.append('purchaseOrderId',$('input[name="purchaseOrderId"]').val());
        axios.post('/purchaseOrder/getPurchaseOrderById',formdata)
            .then(function(response){
                if(response.data.code == 0){
                    let data = response.data.data;
                    form.val('formTest',{
                        'purchaseOrderNumber': data.purchaseOrderNumber,
                        'salesOrderId': data.salesOrderNumber,
                        'defineDate': data.defineDate,
                        'deliveryDate': data.deliveryDate,
                        'supplierId': data.supplierName,
                        'purchaseType': data.purchaseType,
                        'capital': data.capital,
                        'comment': data.comment
                    });
                    let purchaseOrderDetailsList = [];
                    $.each(data.purchaseOrderDetailsList,function(i,item){
                        let arr = {
                            goodsId: item.goods.goodsId,
                            purchaseOrderDetailsId: item.purchaseOrderDetailsId,
                            partsCd: item.goods.partsCd,
                            goodsName: item.goods.goodsName,
                            unit: item.goods.unit,
                            quantity: item.quantity,
                            inQuantity: item.inQuantity,
                            purchasePrice: item.purchasePrice,
                            excludingTaxAmount: item.excludingTaxAmount,
                            taxRate: item.taxRate,
                            tax: item.tax,
                            taxIncludedAmount: item.taxIncludedAmount,
                            financeMoney: item.financeMoney

                        };
                        purchaseOrderDetailsList.push(arr);
                    });

                    table.reload('idTest', {
                        data: purchaseOrderDetailsList
                    });
                }
            });


        // 监听数据表格单元格编辑
        var editOldValue;
        table.on('edit(demo)', function(obj) {
            // console.log(obj.value); //得到修改后的值
            // console.log(obj.field); //当前编辑的字段名
            // console.log(obj.data); //所在行的所有相关数据

            let data = obj.data;
            let tr = obj.tr; //获得当前行 tr 的DOM对象
            // 获取动态表格的数据
            let tableBak = table.cache['idTest'];
            //	财务金额
            if(obj.field == 'financeMoney'){
                if(isNaN(obj.value)){
                    data.financeMoney = editOldValue;
                    tableBak.splice(tr.attr('data-index'), 1, data);
                    table.reload('idTest', {
                        data: tableBak
                    });
                    layer.msg('财务金额只能是数字', {
                        icon: 5
                    });
                }else{
                    table.reload('idTest', {
                        data: tableBak
                    });
                }
            }

        });

        // 监听数据表格编辑框选中
        $('.zq-datatable').on('focus', '.layui-table-edit', function() {
            // 删除放大镜与输入框
            $('.zq-datatable .zq-fangdajing').remove();
            $('.zq-datatable .zq-input').remove();
            var that = $(this);

            // 报错编辑前的值
            editOldValue = $(that).val();
            //标注选中样式
            that.parents('tr').addClass('layui-table-click').siblings().removeClass('layui-table-click');
            // 记录当前选中行的坐标
            var dataIndex = $(this).parents('tr').attr('data-index');
            var dataField = $(this).parents('td').attr('data-field');

            switch (dataField) {
                case 'partsCd':
                    let html =
                        `<i class="zq-fangdajing" onclick="active.zqIframeShow(${dataIndex})" >
											<svg class="zq-icon" aria-hidden="true">
												<use xlink:href="#iconfangdajing"></use>
											</svg>
										</i>`;
                    that.parent().append(html);
                    break;
            }
        });



        // 监听表单提交
        form.on('submit(*)', function(data) {
            let that = this;

            // 获取动态表格的数据
            let tableBak = table.cache['idTest'];
            let purchaseOrderDetailsList  = [];
            for(let i in tableBak){
                let arr ={
                    purchaseOrderDetailsId: tableBak[i].purchaseOrderDetailsId,
                    financeMoney: tableBak[i].financeMoney
                };
                purchaseOrderDetailsList.push(arr);
            }

            let field = {};
            field.purchaseOrderDetailsList = purchaseOrderDetailsList;
            field.purchaseOrderId = data.field.purchaseOrderId;
            // 财务金额总计小写
            field.financeMoneySum = $('.layui-table-total td[data-field="financeMoney"]').text();
            // 禁止点击
            $(that).addClass('zq-submit-disabled');

            axios.post('/purchaseOrder/updatePurchaseOrderFinance', field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    if (response.data.code == 20005) {
                        setTimeout(function () {
                            // active.zq_return();
                            location.href="/admin/purchaseOrder/index";  //刷新父页面
                        }, 1000);
                    }else {
                        // 取消禁止点击
                        $(that).removeClass('zq-submit-disabled');
                    }
                });
            return false;
        });




        // 触发事件
        var active = {



        };
        // 点击调用
        $('body').on('click','.zq-active', function() {
            var othis = $(this),
                type = othis.data('type');
            console.log(type)
            active[type] ? active[type].call(this, othis) : '';
        });



    })

});
