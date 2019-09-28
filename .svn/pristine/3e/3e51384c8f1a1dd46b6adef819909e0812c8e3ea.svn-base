//数据字典
$(document).ready(function() {

    layui.use(['form', 'layer'], function() {

        var layer = layui.layer,
            form = layui.form;



        // 获取编辑信息
        var formdata = new FormData();
        formdata.append('id', parseInt($('input[name="accessId"]').val()));
        axios.post('/staffAccess/getStaffAccessById', formdata
        ).then(function (response) {
            let data = response.data;
            if(data.code == 0){

                form.val('formTest',{
                    'accessName': data.data.accessName,
                    'permissions': data.data.permissions,
                    'url': data.data.url,
                    'accessModuleId': data.data.accessModuleId,
                })

            }

        }).catch(function (error) {
            console.log(error);
        });




        // 监听表单提交
        form.on('submit(*)', function(data) {
            let that = this;
            // 禁止点击
            data.field.accessName = $.trim(data.field.accessName);
            data.field.permissions = $.trim(data.field.permissions);
            data.field.url = $.trim(data.field.url);
            data.field.accessModuleId = $.trim(data.field.accessModuleId);
            $(that).addClass('zq-submit-disabled');

            axios.post('/staffAccess/updateStaffAccess', data.field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    if (response.data.code == 30006) {
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
