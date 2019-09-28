//数据字典
$(document).ready(function() {

    layui.use(['form', 'layer'], function() {

        var layer = layui.layer,
            form = layui.form;







        // 监听表单提交
        form.on('submit(*)', function(data) {
            let that = this;
            // 禁止点击

            data.field.parentId = $.trim(data.field.parentId);
            $(that).addClass('zq-submit-disabled');

            axios.post('/bizd/insert', data.field)
                .then(function (response) {
                    layer.msg(response.data.msg);
                    if (response.data.code == 30004) {
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
