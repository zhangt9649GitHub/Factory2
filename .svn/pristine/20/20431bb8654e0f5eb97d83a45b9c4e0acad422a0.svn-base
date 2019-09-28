$(document).ready(function(){
    var myChart = echarts.init(document.getElementById('main'));
    var option = {

        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '2%',
            right: '2%',
            bottom: '2%',
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
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售金额',
                type:'bar',
                barWidth: '30%',
                data:[3000, 5200, 2000, 3340, 3900, 3300, 2200,3200,4800,2300,3400,4500]
            }
        ]
    };
    myChart.setOption(option);

});