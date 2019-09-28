$(document).ready(function(){
    layui.use(['form', 'table', 'layer', 'laydate',"table"], function() {

        var	layer = layui.layer,
            form = layui.form,
            laydate = layui.laydate,
            table = layui.table;
        var goodsList,
            oldSupplierId
            ,oldGoodsId;
        // 获取供应商
        function getSupplierNameList(){
           return axios.get('/general/getSupplierNameList')

        }

        // 获取编辑信息
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });

        axios.all([getSupplierNameList()])
            .then(axios.spread(function (acct) {
                // 供应商列表
                if(acct.data.code == 0){
                    $.each(acct.data.data, function(i,item){
                        $('select[name="supplierId"]').append(`<option value="${item.supplierId}">${item.supplierName}</option>`)
                    });
                    form.render('select')
                }
                // 获取信息
                var formdata = new FormData();
                formdata.append('ndid',$('input[name="ndid"]').val());
                axios.post(`/noteDocument/selectUpdateNoteDocumentInfo`,formdata)
                    .then(function(response){
                        let data = response.data;

                        oldSupplierId = data.data.supplierId;
                        oldGoodsId = data.data.goodsId;

                        if(data.code == 20029){
                            // 获取货物列表
                            axios.get('/general/getNoteDocumentList?supplierId='+data.data.supplierId)
                                .then(function(res){
                                    if(res.data.code == 0){
                                        goodsList = res.data.data;
                                        $.each(res.data.data, function(i,item){
                                            $('select[name="goodsId"]').append(`<option value="${item.goodsId}">${item.partsCd}</option>`)
                                        });
                                        form.render('select');
                                        // 表单赋值
                                        form.val('formTest',{
                                            noteDcNumber: data.data.noteDcNumber
                                            ,productionInstructionId: data.data.productionInstructionId
                                            ,supplierId: data.data.supplierId
                                            ,goodsId: data.data.goodsId
                                            ,count: data.data.count
                                            ,price: data.data.price
                                            ,money: data.data.money
                                        })
                                    }

                                });



                        }
                        layer.closeAll('loading'); //关闭加载层
                    });


            }));
        // 获取货物列表
        function getNoteDocumentList(val){
            $('select[name="goodsId"]').html(`<option value=""></option>`);
            form.render('select');
            if($.trim(val).length == 0){
                return false;
            }
            axios.get('/general/getNoteDocumentList?supplierId='+val)
                .then(function(res){
                    if(res.data.code == 0){
                        goodsList = res.data.data;
                        $.each(res.data.data, function(i,item){
                            $('select[name="goodsId"]').append(`<option value="${item.goodsId}">${item.partsCd}</option>`)
                        });
                        form.render('select');
                    }

                });
        }

        // 监听供应商选择
        form.on('select(supplierId)', function(data){
            // console.log(data.elem); //得到select原始DOM对象
            // console.log(data.value); //得到被选中的值
            // console.log(data.othis); //得到美化后的DOM对象

            if(oldSupplierId != data.value){

                form.val("formTest", {
                    goodsId: ''
                });
                getNoteDocumentList(data.value);
                oldSupplierId = data.value;
            }
        });
        // 监听货物选择
        form.on('select(goodsId)', function(data){
            // console.log(data.elem); //得到select原始DOM对象
            // console.log(data.value); //得到被选中的值
            // console.log(data.othis); //得到美化后的DOM对象

            if(oldGoodsId != data.value){
                $.each(goodsList,function(i,item){
                   if(data.value == item.goodsId){
                       // 表单赋值
                       var money = Number(item.aPrice)*Number($('input[name="count"]').val());
                       form.val('formTest',{
                           price: item.aPrice
                           ,money: money.toFixed(2)
                       })
                   }
                });
                oldGoodsId = data.value;
            }
        });

        // 监听数量被改变
        $('input[name="count"]').change(function(){
            if(!isNaN($(this).val())){
                var money = Number($(this).val())*Number($('input[name="price"]').val());
                form.val('formTest',{
                    money: money.toFixed(2)
                })
            }else{
                layer.msg('请输入数字');
                form.val('formTest',{
                    count: 1,
                    money: $('input[name="price"]').val()
                })
            }
        });
        // 监听价格被改变
        $('input[name="price"]').change(function(){
            if(!isNaN($(this).val())){
                var money = Number($(this).val())*Number($('input[name="count"]').val());
                form.val('formTest',{
                    money: money.toFixed(2)
                })
            }else{
                layer.msg('请输入数字');
                form.val('formTest',{
                    price: 1,
                    money: $('input[name="count"]').val()
                })
            }
        });



        // 监听表单提交
        form.on('submit(*)', function(data) {
            let that = this;

            if(data.field.count <= 0){
                layer.msg('数量不能小于等于0');
                return false;
            }

            // 禁止点击
            $(that).addClass('zq-submit-disabled');
            axios.post('/noteDocument/updateNoteDocumentInfo', data.field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    if (response.data.code == 20005) {
                        setTimeout(function () {
                            window.parent.location.reload(); //刷新父页面
                        }, 1000);
                    }else {
                        // 取消禁止点击
                        $(that).removeClass('zq-submit-disabled');
                    }
                }).catch(function (error) {
                console.log(error);
            });

            return false;
        });






    })
});
