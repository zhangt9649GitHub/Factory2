$(document).ready(function () {


    $('.layui-btn.blue').click(function () {
        parent.location.href = '/admin/index/login';
    });

    let time = 5;
    function settime_s() {
        if(time == 0){
            parent.location.href = '/admin/index/login';
        }else{
            $('.text span').html( time );
            time--;
            setTimeout(function() {
                settime_s()
            },1000)
        }
    }
    settime_s();

});