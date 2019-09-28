// 生产计划分析
$(document).ready(function() {

    layui.config({
        base: '/static/public/layui/treetable-js/',
    });
	layui.use(['form', 'layer','laydate','laytpl','treeTable','laypage'], function() {

		var layer = layui.layer,
			form = layui.form,
			laydate = layui.laydate,
            treeTable = layui.treeTable,
            laypage = layui.laypage,
			row;

        var recordLimit = 2,    // 当前页的数据数量
            recordPage = 1,     // 当前页码
            fieldObject = { 	// 搜索值
                partsCd: '',
                goodsName: ''
			};
		laydate.render({
			elem: '#riqi'
		});


		let renderTable = function(data){
            treeTable.render({
                elem: '#tree-table',
                data: data,
                icon_key: 'partsCd',
                cols: [
                    {
                        key: 'partsCd',
                        title: '部品CD',
                        width: '100px',
                    },
                    {
                        key: 'goodsName',
                        title: '商品名',
						width: '300px'
                    },
                    {
                        key: 'monthlySalesVolume',
                        title: '月贩卖量',
                        width: '80px',
                    },
                    {
                        key: 'skgCount',
                        title: '商品在库量',
                        width: '80px',
                    },
                    {
                        key: 'totalTaskAmount',
                        title: '总任务量',
                        width: '80px',
                    },
                    {
                        key: 'remainingAmount',
                        title: '剩余量',
                        width: '80px',
                    },
                    {
                        key: 'newTask',
                        title: '新增任务',
                        width: '80px',
                    },

                    {
                        key: 'finishedProductGoodsName',
                        title: '对应完成品',
                    },
                    {
                        key: 'finishedProductTaskAmount',
                        title: '任务量',
                        width: '80px',
                    },
                    {
                        key: 'finishedProductCycle',
                        title: '成型周期',
                        width: '80px',
                    },
                    {
                        key: 'finishedProductShift',
                        title: '所需班次',
                        width: '80px',
                    },
                    {
                        key: 'finishedProductFinishedAmount',
                        title: '对应成品在库量',
                        width: '100px',
                    },

                    {
                        key: 'moldingProductionGoodsName',
                        title: '对应成型品',
                    },
                    {
                        key: 'moldingProductionTaskAmount',
                        title: '任务量',
                        width: '80px',
                    },
                    {
                        key: 'moldingProductionCycle',
                        title: '成型周期',
                        width: '80px',
                    },
                    {
                        key: 'moldingProductionCumulativeCompletion',
                        title: '累计完成量',
                        width: '100px',
                    },
                    {
                        key: 'moldingProductionShift',
                        title: '所需班次',
                        width: '80px',
                    },
                    {
                        key: 'materialMaterial',
                        title: '所需材料',
                    },
                    {
                        key: 'materialAmount',
                        title: '所需数量',
                        width: '80px',
                    },
                ],
				end: function (e) {
                    layer.closeAll('loading'); //关闭加载层
                    $('.wrap').niceScroll({
                        cursorcolor: '#828e94',
                        cursorborder: '0',
                        zindex: '120'
                    });
                }
            });

            // 监听展开关闭
            treeTable.on('tree(flex)',function(data){
                // layer.msg('监听12');

                $(".wrap").getNiceScroll().resize();
            })
		};


        // 首次加载数据
        layer.load(1, {
            shade: [0.5,'#fff'] //0.1透明度的白色背景
        });
		axios.get(`/productionPlanningAnalysis/getProductionPlanningAnalysisList?limit=${recordLimit}&page=${recordPage}`)
			.then(function(response){
				if(response.data.code == 0){
					//
					let tableData = [];
					$.each(response.data.data,function (i,item) {

						// 第一条
                       	let itemData = {
							id: item.productionOrderDetailsId,
                            pid: 0,
                            partsCd: item.partsCd,
                            goodsName: item.goodsName,
                            monthlySalesVolume: item.monthlySalesVolume,
                            skgCount: item.skgCount,
                            totalTaskAmount: item.totalTaskAmount,
                            remainingAmount: item.remainingAmount,
                            newTask: item.newTask,

							// 完成品
                            finishedProductGoodsName:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].goodsName,
                            finishedProductTaskAmount:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].taskAmount,
                            finishedProductCycle:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].cycle,
                            finishedProductShift:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].shift,
                            finishedProductFinishedAmount:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].finishedAmount,

                            // 成型品
                            moldingProductionGoodsName:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].goodsName,
                            moldingProductionTaskAmount:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].taskAmount,
                            moldingProductionCycle:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].cycle,
                            moldingProductionCumulativeCompletion:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].cumulativeCompletion,
                            moldingProductionShift:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].shift,

                            // 材料
                            materialMaterial:  item.materialList.length == 0 ? '' : item.materialList[0].material,
                            materialAmount:  item.materialList.length == 0 ? '' : item.materialList[0].amount
					   	};
                       	tableData.push(itemData);

                        if(item.maxListName == 'moldingProductionList'){
                        	$.each(item[item.maxListName], function(index){
                                if(index != 0){

                                    let itemsData = {
                                        id: (index).toString() + item.productionOrderDetailsId,
                                        pid: item.productionOrderDetailsId,
                                        partsCd: '',
                                        goodsName: '',
                                        monthlySalesVolume: '',
                                        skgCount: '',
                                        totalTaskAmount: '',
                                        remainingAmount: '',
                                        newTask: '',

                                        // 完成品
                                        finishedProductGoodsName:  item.finishedProductList.length > index ?  item.finishedProductList[index].goodsName : '',
                                        finishedProductTaskAmount:  item.finishedProductList.length > index ?  item.finishedProductList[index].taskAmount: '',
                                        finishedProductCycle:  item.finishedProductList.length > index ?  item.finishedProductList[index].cycle: '',
                                        finishedProductShift:  item.finishedProductList.length > index ?  item.finishedProductList[index].shift: '',
                                        finishedProductFinishedAmount:  item.finishedProductList.length > index ? item.finishedProductList[index].finishedAmount: '',

                                        // 成型品
                                        moldingProductionGoodsName: item.moldingProductionList[index].goodsName,
                                        moldingProductionTaskAmount:  item.moldingProductionList[index].taskAmount,
                                        moldingProductionCycle: item.moldingProductionList[index].cycle,
                                        moldingProductionCumulativeCompletion: item.moldingProductionList[index].cumulativeCompletion,
                                        moldingProductionShift:  item.moldingProductionList[index].shift,

                                        // 材料
                                        materialMaterial:  item.materialList.length > index ? item.materialList[index].material : '',
                                        materialAmount: item.materialList.length > index ? item.materialList[index].amount : ''
                                    };
                                    tableData.push(itemsData);
								}
							})
						}else
							// 材料
						if(item.maxListName == 'materialList'){
							$.each(item[item.maxListName],function (index,items) {
                                if(index != 0){

                                    let itemsData = {
                                        id: (index).toString() + item.productionOrderDetailsId,
                                        pid: item.productionOrderDetailsId,
                                        partsCd: '',
                                        goodsName: '',
                                        monthlySalesVolume: '',
                                        skgCount: '',
                                        totalTaskAmount: '',
                                        remainingAmount: '',
                                        newTask: '',

                                        // 完成品
                                        finishedProductGoodsName:  item.finishedProductList.length > index ?  item.finishedProductList[index].goodsName : '',
                                        finishedProductTaskAmount:  item.finishedProductList.length > index ?  item.finishedProductList[index].taskAmount: '',
                                        finishedProductCycle:  item.finishedProductList.length > index ?  item.finishedProductList[index].cycle: '',
                                        finishedProductShift:  item.finishedProductList.length > index ?  item.finishedProductList[index].shift: '',
                                        finishedProductFinishedAmount:  item.finishedProductList.length > index ? item.finishedProductList[index].finishedAmount: '',


                                        // 成型品
                                        moldingProductionGoodsName: item.moldingProductionList.length > index ? item.moldingProductionList[index].goodsName : '',
                                        moldingProductionTaskAmount: item.moldingProductionList.length > index ? item.moldingProductionList[index].taskAmount : '',
                                        moldingProductionCycle: item.moldingProductionList.length > index ? item.moldingProductionList[index].cycle : '',
                                        moldingProductionCumulativeCompletion: item.moldingProductionList.length > index ? item.moldingProductionList[index].cumulativeCompletion : '',
                                        moldingProductionShift: item.moldingProductionList.length > index ? item.moldingProductionList[index].shift : '',

                                        // 材料
                                        materialMaterial:  item.materialList[index].material,
                                        materialAmount: item.materialList[index].amount
                                    };
                                    tableData.push(itemsData);
                                }
                            })
						}else
							// 完成品
						if(item.maxListName == 'finishedProductList'){
                            $.each(item[item.maxListName],function (index,items) {
                                if(index != 0){

                                    let itemsData = {
                                        id: (index).toString() + item.productionOrderDetailsId,
                                        pid: item.productionOrderDetailsId,
                                        partsCd: '',
                                        goodsName: '',
                                        monthlySalesVolume: '',
                                        skgCount: '',
                                        totalTaskAmount: '',
                                        remainingAmount: '',
                                        newTask: '',

                                        // 完成品
                                        finishedProductGoodsName:  item.finishedProductList[index].goodsName,
                                        finishedProductTaskAmount: item.finishedProductList[index].taskAmount,
                                        finishedProductCycle:  item.finishedProductList[index].cycle,
                                        finishedProductShift:  item.finishedProductList[index].shift,
                                        finishedProductFinishedAmount:  item.finishedProductList[index].finishedAmount,


                                        // 成型品
                                        moldingProductionGoodsName: item.moldingProductionList.length > index ? item.moldingProductionList[index].goodsName : '',
                                        moldingProductionTaskAmount: item.moldingProductionList.length > index ? item.moldingProductionList[index].taskAmount : '',
                                        moldingProductionCycle: item.moldingProductionList.length > index ? item.moldingProductionList[index].cycle : '',
                                        moldingProductionCumulativeCompletion: item.moldingProductionList.length > index ? item.moldingProductionList[index].cumulativeCompletion : '',
                                        moldingProductionShift: item.moldingProductionList.length > index ? item.moldingProductionList[index].shift : '',

                                        // 材料
                                        materialMaterial:  item.materialList.length > index ? item.materialList[index].material : '',
                                        materialAmount: item.materialList.length > index ? item.materialList[index].amount : ''
                                    };
                                    tableData.push(itemsData);
                                }
                            })
						}

                    });

                    // 分页
                    let count = response.data.count;
                    laypage.render({
                        elem: 'demo'
                        ,count: count //数据总数，从服务端得到
                        ,limit: recordLimit
                        ,groups: 5
                        ,theme: '#00a2d9'
                        ,first: false
                        ,last: false
                        ,prev: '<i class="layui-icon layui-icon-left"></i>'
                        ,next: '<i class="layui-icon layui-icon-right"></i>'
                        ,layout: ['prev', 'page', 'next','skip', 'count']
                        ,jump: function(obj, first){
                            //obj包含了当前分页的所有参数，比如：
                            // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            // console.log(obj.limit); //得到每页显示的条数

                            recordPage = obj.curr;
                            recordLimit = obj.limit;
                            //首次不执行
                            if(!first){

                                pageData();
                            }
                        }
                    });

                    renderTable(tableData);
				}

			});

		// 获取分页查询数据
		let pageData = function(type){
            layer.load(1, {
                shade: [0.5,'#fff'] //0.1透明度的白色背景
            });
            axios.get(`/productionPlanningAnalysis/getProductionPlanningAnalysisList?limit=${recordLimit}&page=${recordPage}&partsCd=${fieldObject.partsCd}&goodsName=${fieldObject.goodsName}`)
                .then(function(response){
                    if(response.data.code == 0){
                        //
                        let tableData = [];
                        $.each(response.data.data,function (i,item) {

                            // 第一条
                            let itemData = {
                                id: item.productionOrderDetailsId,
                                pid: 0,
                                partsCd: item.partsCd,
                                goodsName: item.goodsName,
                                monthlySalesVolume: item.monthlySalesVolume,
                                skgCount: item.skgCount,
                                totalTaskAmount: item.totalTaskAmount,
                                remainingAmount: item.remainingAmount,
                                newTask: item.newTask,

                                // 完成品
                                finishedProductGoodsName:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].goodsName,
                                finishedProductTaskAmount:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].taskAmount,
                                finishedProductCycle:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].cycle,
                                finishedProductShift:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].shift,
                                finishedProductFinishedAmount:  item.finishedProductList.length == 0 ? '' : item.finishedProductList[0].finishedAmount,

                                // 成型品
                                moldingProductionGoodsName:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].goodsName,
                                moldingProductionTaskAmount:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].taskAmount,
                                moldingProductionCycle:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].cycle,
                                moldingProductionCumulativeCompletion:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].cumulativeCompletion,
                                moldingProductionShift:  item.moldingProductionList.length == 0 ? '' : item.moldingProductionList[0].shift,

                                // 材料
                                materialMaterial:  item.materialList.length == 0 ? '' : item.materialList[0].material,
                                materialAmount:  item.materialList.length == 0 ? '' : item.materialList[0].amount
                            };
                            tableData.push(itemData);

                            if(item.maxListName == 'moldingProductionList'){
                                $.each(item[item.maxListName], function(index){
                                    if(index != 0){

                                        let itemsData = {
                                            id: (index).toString() + item.productionOrderDetailsId,
                                            pid: item.productionOrderDetailsId,
                                            partsCd: '',
                                            goodsName: '',
                                            monthlySalesVolume: '',
                                            skgCount: '',
                                            totalTaskAmount: '',
                                            remainingAmount: '',
                                            newTask: '',

                                            // 完成品
                                            finishedProductGoodsName:  item.finishedProductList.length > index ?  item.finishedProductList[index].goodsName : '',
                                            finishedProductTaskAmount:  item.finishedProductList.length > index ?  item.finishedProductList[index].taskAmount: '',
                                            finishedProductCycle:  item.finishedProductList.length > index ?  item.finishedProductList[index].cycle: '',
                                            finishedProductShift:  item.finishedProductList.length > index ?  item.finishedProductList[index].shift: '',
                                            finishedProductFinishedAmount:  item.finishedProductList.length > index ? item.finishedProductList[index].finishedAmount: '',

                                            // 成型品
                                            moldingProductionGoodsName: item.moldingProductionList[index].goodsName,
                                            moldingProductionTaskAmount:  item.moldingProductionList[index].taskAmount,
                                            moldingProductionCycle: item.moldingProductionList[index].cycle,
                                            moldingProductionCumulativeCompletion: item.moldingProductionList[index].cumulativeCompletion,
                                            moldingProductionShift:  item.moldingProductionList[index].shift,

                                            // 材料
                                            materialMaterial:  item.materialList.length > index ? item.materialList[index].material : '',
                                            materialAmount: item.materialList.length > index ? item.materialList[index].amount : ''
                                        };
                                        tableData.push(itemsData);
                                    }
                                })
                            }else
                            // 材料
                            if(item.maxListName == 'materialList'){
                                $.each(item[item.maxListName],function (index,items) {
                                    if(index != 0){

                                        let itemsData = {
                                            id: (index).toString() + item.productionOrderDetailsId,
                                            pid: item.productionOrderDetailsId,
                                            partsCd: '',
                                            goodsName: '',
                                            monthlySalesVolume: '',
                                            skgCount: '',
                                            totalTaskAmount: '',
                                            remainingAmount: '',
                                            newTask: '',

                                            // 完成品
                                            finishedProductGoodsName:  item.finishedProductList.length > index ?  item.finishedProductList[index].goodsName : '',
                                            finishedProductTaskAmount:  item.finishedProductList.length > index ?  item.finishedProductList[index].taskAmount: '',
                                            finishedProductCycle:  item.finishedProductList.length > index ?  item.finishedProductList[index].cycle: '',
                                            finishedProductShift:  item.finishedProductList.length > index ?  item.finishedProductList[index].shift: '',
                                            finishedProductFinishedAmount:  item.finishedProductList.length > index ? item.finishedProductList[index].finishedAmount: '',


                                            // 成型品
                                            moldingProductionGoodsName: item.moldingProductionList.length > index ? item.moldingProductionList[index].goodsName : '',
                                            moldingProductionTaskAmount: item.moldingProductionList.length > index ? item.moldingProductionList[index].taskAmount : '',
                                            moldingProductionCycle: item.moldingProductionList.length > index ? item.moldingProductionList[index].cycle : '',
                                            moldingProductionCumulativeCompletion: item.moldingProductionList.length > index ? item.moldingProductionList[index].cumulativeCompletion : '',
                                            moldingProductionShift: item.moldingProductionList.length > index ? item.moldingProductionList[index].shift : '',

                                            // 材料
                                            materialMaterial:  item.materialList[index].material,
                                            materialAmount: item.materialList[index].amount
                                        };
                                        tableData.push(itemsData);
                                    }
                                })
                            }else
                            // 完成品
                            if(item.maxListName == 'finishedProductList'){
                                $.each(item[item.maxListName],function (index,items) {
                                    if(index != 0){

                                        let itemsData = {
                                            id: (index).toString() + item.productionOrderDetailsId,
                                            pid: item.productionOrderDetailsId,
                                            partsCd: '',
                                            goodsName: '',
                                            monthlySalesVolume: '',
                                            skgCount: '',
                                            totalTaskAmount: '',
                                            remainingAmount: '',
                                            newTask: '',

                                            // 完成品
                                            finishedProductGoodsName:  item.finishedProductList[index].goodsName,
                                            finishedProductTaskAmount: item.finishedProductList[index].taskAmount,
                                            finishedProductCycle:  item.finishedProductList[index].cycle,
                                            finishedProductShift:  item.finishedProductList[index].shift,
                                            finishedProductFinishedAmount:  item.finishedProductList[index].finishedAmount,


                                            // 成型品
                                            moldingProductionGoodsName: item.moldingProductionList.length > index ? item.moldingProductionList[index].goodsName : '',
                                            moldingProductionTaskAmount: item.moldingProductionList.length > index ? item.moldingProductionList[index].taskAmount : '',
                                            moldingProductionCycle: item.moldingProductionList.length > index ? item.moldingProductionList[index].cycle : '',
                                            moldingProductionCumulativeCompletion: item.moldingProductionList.length > index ? item.moldingProductionList[index].cumulativeCompletion : '',
                                            moldingProductionShift: item.moldingProductionList.length > index ? item.moldingProductionList[index].shift : '',

                                            // 材料
                                            materialMaterial:  item.materialList.length > index ? item.materialList[index].material : '',
                                            materialAmount: item.materialList.length > index ? item.materialList[index].amount : ''
                                        };
                                        tableData.push(itemsData);
                                    }
                                })
                            }

                        });


                        // 分页
                        if(type == 1){
                            let count = response.data.count;
                            laypage.render({
                                elem: 'demo'
                                ,count: count //数据总数，从服务端得到
                                ,limit: recordLimit
                                ,groups: 5
                                ,theme: '#00a2d9'
                                ,first: false
                                ,last: false
                                ,prev: '<i class="layui-icon layui-icon-left"></i>'
                                ,next: '<i class="layui-icon layui-icon-right"></i>'
                                ,layout: ['prev', 'page', 'next','skip', 'count']
                                ,jump: function(obj, first){
                                    //obj包含了当前分页的所有参数，比如：
                                    // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                                    // console.log(obj.limit); //得到每页显示的条数

                                    recordPage = obj.curr;
                                    recordLimit = obj.limit;
                                    //首次不执行
                                    if(!first){

                                        pageData();
                                    }
                                }
                            });
                        }


                        renderTable(tableData);

                    }

                });
		};


        //监听提交
        form.on('submit(formDemo)', function(data){

            fieldObject = {
                partsCd: $.trim(data.field.partsCd),
                goodsName: $.trim(data.field.goodsName)
			};
            pageData(1);
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
