$(document).ready(function(){
    layui.use(['layer','form','element'],function(){
        let layer = layui.layer,
            form = layui.form,
            element = layui.element;

        // 获取信息
        axios.get('/config/getConfigList')
            .then(function (response) {
                if(response.data.code == 0){
                    let data = response.data.data;
                    if(data){
                        for(i in data){
                            if(data[i].key == 'requiredQuantityGoodsInsufficient'){
                                if(data[i].value == 1 ){
                                    $('input[name ="requiredQuantityGoodsInsufficient"]').attr('checked',true)
                                }

                            }
                            if(data[i].key == 'logWrite'){
                                if(data[i].value == 'true'){
                                    $('input[name ="logWrite"]').attr('checked',true)
                                }

                            }
                        }

                    }
                    form.render('checkbox');
                }
            });


        // 提交
        form.on('submit(*)',function(data){
            let that = this;

            if(!data.field.requiredQuantityGoodsInsufficient){
                data.field.requiredQuantityGoodsInsufficient = 2;
            }
            if(!data.field.logWrite){
                data.field.logWrite = false;
            }

            // 禁止点击
            $(that).addClass('zq-submit-disabled');

            axios.post('/config/updateConfig', data.field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    if (response.data.code == 10008) {
                        setTimeout(function () {
                            window.href= location.reload();
                        }, 1000);
                    }else {
                        // 取消禁止点击
                        $(that).removeClass('zq-submit-disabled');
                    }
                });

            return false;
        })
    })
});