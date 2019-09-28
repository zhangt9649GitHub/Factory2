$(document).ready(function(){


	//漂亮的滚动条
	$('.layui-textarea').niceScroll({
		cursorcolor: '#828e94'
	});


	layui.use(['element', 'layer','upload'], function() {
		var element = layui.element,
			layer = layui.layer,
			upload = layui.upload;

		// 监听导航点击（左边导航）
		element.on('nav(filter)', function(elem) {
			// console.log(elem); //得到当前点击的DOM对象

			// 判断是否有二级菜单
			if (elem.siblings('.layui-nav-child').length != 0) {
				return false;
			}

			var title = elem.text(); // 获取栏目标题


			var dataHref = elem.attr('data-href'); // 获取跳转地址

			if(!elem.attr('data-href')){
				layer.msg('页面开发中');
				return false;
			}

			// 判断如果已经打开页面就切换
			var stop = false;
			$('.zq-main .iframe').each(function(i, item) {

				if ($(item).attr('tab-id') == dataHref) {
					stop = true;
					active.zq_tabChange(dataHref);
					return false;
				}
			});
			if(stop){
				return false;
			}
			active.zq_tabAdd(title, dataHref, dataHref);
			active.zq_tabChange(dataHref);

		});

		// 监听选项卡切换（页面选项卡）
		element.on('tab(demo)', function(data) {
			var layId = this.getAttribute('lay-id');

			$('.zq-sidebar .layui-nav a').each(function(i,item) {

				if ($(item).attr('data-href') == layId) {

					$('.zq-sidebar .layui-nav dd').removeClass('layui-this');
					$('.zq-sidebar .layui-nav li').removeClass('layui-this');
					$(item).parent().addClass('layui-this');
				}

			})


		});


		// 上传图片
		upload.render({
			elem: '#upload-image',
			accept: 'images',
			url: '/multipleFileUpload/importFile',
			acceptMime: 'image/*', // 只显示图片
			auto: true, // 自动上传
			size: 2000, //文件最大可允许上传的大小，单位 KB
			done: function(res, index, upload){

				if(res.code == 10006){
					$('#upload-image').attr('src', res.data.ufSavePath);
					$('#upload-value').val(res.data.ufId);
				}
			}
		});




		// 触发事件

		var active = {
			//新增一个Tab项
			zq_tabAdd: function(title, url, id) {
				element.tabAdd('demo', {
					title: title,
					content: '<iframe tab-id="' + id + '" frameborder="0" src="' + url +
						'" scrolling="yes" class="iframe"></iframe>',
					id: id
				});



			},
			//切换到指定Tab项
			zq_tabChange: function(id) {
				// 获取容器的宽度
				var wrapWidth = $('.wrap').width() - 160;

				// 获取所有选项卡的总宽度
				var liWidths = 0;
				$('.zq-nav li').each(function(i,item){

					liWidths = liWidths + $(item).innerWidth()
				});

				// 判断大于触发设置偏移的值
				if(wrapWidth < liWidths){
					var chaZhi = wrapWidth - liWidths;
					var left = -80;

					$('.zq-nav li').each(function(i,item){

						left = left + $(item).innerWidth();
						if(Math.abs(chaZhi) < left){

							return false;
						}

					});

					var leftPx = -left + 'px';

					$('.zq-nav').css('margin-left',leftPx)
				}


				element.tabChange('demo', id); //切换到：用户管理
			},
			// 关闭全部
			zq_closeAllTabs: function() {
				$('.zq-nav li').each(function() {
					if($(this).attr('lay-id') != 1){
						element.tabDelete('demo', $(this).attr('lay-id'));
						$('.zq-operation .layui-nav-child').removeClass('layui-show');
						$('.zq-nav').css('margin-left','80px');
					}

				});
			},
			// 关闭其它标签
			zq_closeOtherTabs: function() {
				$('.zq-nav li').each(function(i,item) {
					if (!($(item).hasClass('layui-this'))) {

						element.tabDelete('demo', $(this).attr('lay-id'));
						$('.zq-operation .layui-nav-child').removeClass('layui-show');
						$('.zq-nav').css('margin-left','80px');
					}
				});
			},
			// 关闭当前
			zq_closeCurrentTab: function(){


				$('.zq-nav li').each(function(i,item) {
					if ($(item).hasClass('layui-this') && $(item).attr('lay-id') != 1) {

						element.tabDelete('demo', $(this).attr('lay-id'));
						$('.zq-operation .layui-nav-child').removeClass('layui-show');
					}
				});
			},

			// 刷新当前页
			zq_reloadCurrentTab: function(){

				$('.zq-content .layui-tab-item.layui-show iframe').attr('src' ,$('.content .layui-tab-item.layui-show iframe').attr('src'));
				$('.zq-operation .layui-nav-child').removeClass('layui-show');
			},

			// 显示第一个选项卡
			zq_leftPage: function(){
				$('.zq-nav').css('margin-left','80px')
			},

			// 显示最后的选项卡
			zq_rightPage: function(){
				// 获取容器的宽度
				var wrapWidth = $('.wrap').width() - 160;

				// 获取所有选项卡的总宽度
				var liWidths = 0;
				$('.zq-nav li').each(function(i,item){

					liWidths = liWidths + $(item).innerWidth()
				});

				// 判断大于触发设置偏移的值
				if(wrapWidth < liWidths){
					var chaZhi = wrapWidth - liWidths;
					var left = -80;

					$('.zq-nav li').each(function(i,item){

						// 获取不包含最后两个标签的宽度
						if(i == ($('.zq-nav li').length - 2)){
							return false;
						}
						left = left + $(item).innerWidth();

					});

					var leftPx = -left + 'px';

					$('.zq-nav').css('margin-left',leftPx)
				}
			},

			// 打开查看页面
			zq_newOpen: function(othis,url,title){

				var href = url;
				// 判断如果已经打开页面就切换
				var stop = false;
				parent.$('.zq-main .iframe').each(function(i, item) {

					if ($(item).attr('tab-id') == href) {
						stop = true;
						active.zq_openTabChange(href);
						return false;
					}
				});
				if(stop){
					return false;
				}

				active.zq_openTabAdd(title, href, href);
				active.zq_openTabChange(href);
			},
			//新增一个Tab项（查看）
			zq_openTabAdd: function(title, url, id) {
				parent.layui.element.tabAdd('demo', {
					title: title,
					content: '<iframe tab-id="' + id + '" frameborder="0" src="' + url +
						'" scrolling="yes" class="iframe"></iframe>',
					id: id
				});

			},
			//切换到指定Tab项（查看）
			zq_openTabChange: function(id) {
				// 获取容器的宽度
				var wrapWidth = $('.wrap').width() - 160;

				// 获取所有选项卡的总宽度
				var liWidths = 0;
				$('.zq-nav li').each(function(i,item){

					liWidths = liWidths + $(item).innerWidth()
				});

				// 判断大于触发设置偏移的值
				if(wrapWidth < liWidths){
					var chaZhi = wrapWidth - liWidths;
					var left = -80;

					$('.zq-nav li').each(function(i,item){

						left = left + $(item).innerWidth();
						if(Math.abs(chaZhi) < left){

							return false;
						}

					});

					var leftPx = -left + 'px';

					$('.zq-nav').css('margin-left',leftPx)
				}


				parent.layui.element.tabChange('demo', id); //切换到：用户管理
			},
			// 关闭页面弹出（Iframe）
			zq_closeIframe: function(){
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index);
			},
			// 刷新当前页面(重置)
			zq_reloadPage: function(){
				location.replace(location.href);
			},
			// 返回上一页
			zq_return: function(){

				parent.$('.zq-content .layui-tab-item.layui-show iframe').attr('src' ,parent.$('.content .layui-tab-item.layui-show iframe').attr('src'));
				parent.$('.zq-operation .layui-nav-child').removeClass('layui-show');
			},
			// 关闭弹出ceng
			zq_closeOpen: function(){
				layer.closeAll('page');
			}


		};




		// 点击调用
		$('body').on('click','.zq-active', function() {
			var othis = $(this),
				type = othis.data('type'),
				url = othis.data('href'),
				title;
			if(othis.data('title')){
				title = othis.data('title');
			}else{
				title = othis.text();
			}

			active[type] ? active[type].call(this, othis,url,title) : '';
		});


	});


});

// 在当前页打开弹层
function zqDivShow(title, url, w, h) {

	if (title == null || title == '') {
		title = false;
	};
	if (w == null || w == '') {
		w = ($(window).width() * 0.7);
	};
	if (h == null || h == '') {
		h = ($(window).height() * 0.8);
	};
	if(h > $(window).height()){
		h = ($(window).height() * 0.8);
	}
	if(w > $(window).width()){
		w = ($(window).width() * 0.7);
	}
	layer.open({
		type: 1,
		area: [w + 'px', h + 'px'],
		filed: false,
		maxmin: false ,// 默认不显示最大小化按钮。需要显示配置maxmin: true即可
		closeBtn: 1, // 改变关闭按钮样式，0为不显示
		resize: false, // 不允许拉伸
		shadeClose: true,
		shade: 0.4,
		title: title,
		content: $(url),
		success:function(dom){
			// $('.layui-layer-content').niceScroll({
			// 	cursorcolor: '#828e94'
			// });
		}
	})
}
// 在当前页打开新的页面（在新增/编辑页面打开数据表格）
function zqIframeShow(title, url, w, h) {

	if (title == null || title == '') {
		title = false;
	};
	if (url == null || url == '') {
		url = "404.html";
	};
	if (w == null || w == '') {
		w = ($(window).width() * 0.7);
	};

	if (h == null || h == '') {
		h = ($(window).height() * 0.6);
	};

	if(h > $(window).height()){
		h = ($(window).height() * 0.8);
	}
	if(2 > $(window).width()){
		w = ($(window).width() * 0.7);
	}


	layer.open({
		type: 2 ,// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
		area: [w + 'px', h + 'px'] ,// 在默认状态下，layer是宽高都自适应的，但当你只想定义宽度时，你可以area: '500px'，高度仍然是自适应的。当你宽高都要定义时，你可以area: ['500px', '300px']
		filed: false ,// 即鼠标滚动时，层是否固定在可视区域。如果不想，设置fixed: false即可
		maxmin: false ,// 默认不显示最大小化按钮。需要显示配置maxmin: true即可
		closeBtn: 1, // 改变关闭按钮样式，0为不显示
		resize: false, // 不允许拉伸
		shadeClose: true ,// 可以设定shadeClose来控制点击弹层外区域关闭
		shade: 0.4 ,// 默认是0.3透明度的黑色背景（'#000'）。如果你想定义别的颜色，可以shade: [0.8, '#393D49']；如果你不想显示遮罩，可以shade: 0
		title: title ,// title :'我是标题'，那么只会改变标题文本；若你还需要自定义标题区域样式，那么你可以title: ['文本', 'font-size:18px;']
		content: url ,// 内容
		success:function(dom){
			// 给子页面传参
			// let $iframeDom=$(dom[0]).find("iframe").eq(0).contents();
			// $iframeDom.find('input[name="dataIndex"]').val(dataIndex)
		}
	})
};


// 打开新增/编辑页面
function zqIframeView(title, url, w, h) {

	if (title == null || title == '') {
		title = false;
	};
	if (url == null || url == '') {
		url = "404.html";
	};
	if (w == null || w == '') {
		w = ($(window).width() * 0.9);
	};
	if(h > $(window).height()){
		h = ($(window).height() * 0.8);
	}
	if (h == null || h == '') {
		h = ($(window).height() * 0.8);
	};

	layer.open({
		type: 2 ,// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
		area: [w + 'px', h + 'px'] ,// 在默认状态下，layer是宽高都自适应的，但当你只想定义宽度时，你可以area: '500px'，高度仍然是自适应的。当你宽高都要定义时，你可以area: ['500px', '300px']
		filed: false ,// 即鼠标滚动时，层是否固定在可视区域。如果不想，设置fixed: false即可
		maxmin: false ,// 默认不显示最大小化按钮。需要显示配置maxmin: true即可
		closeBtn: 1, // 改变关闭按钮样式，0为不显示
		resize: false, // 不允许拉伸
		shadeClose: true ,// 可以设定shadeClose来控制点击弹层外区域关闭
		shade: 0.4 ,// 默认是0.3透明度的黑色背景（'#000'）。如果你想定义别的颜色，可以shade: [0.8, '#393D49']；如果你不想显示遮罩，可以shade: 0
		title: title ,// title :'我是标题'，那么只会改变标题文本；若你还需要自定义标题区域样式，那么你可以title: ['文本', 'font-size:18px;']
		content: url // 内容
	})
}

// 返回当前时间
Date.prototype.Format = function (fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份
		"d+": this.getDate(), //日
		"H+": this.getHours(), //小时
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度
		"S": this.getMilliseconds() //毫秒
	};
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};

// 数字转中文大写
function number_chinese(str) {
	var num = parseFloat(str);
	var strOutput = "",
		strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
	num += "00";
	var intPos = num.indexOf('.');
	if (intPos >= 0){
		num = num.substring(0, intPos) + num.substr(intPos + 1, 2);
	}
	strUnit = strUnit.substr(strUnit.length - num.length);
	for (var i=0; i < num.length; i++){
		strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(num.substr(i,1),1) + strUnit.substr(i,1);
	}
	return strOutput.replace(/零角零分$/, '整').replace(/零[仟佰拾]/g, '零').replace(/零{2,}/g, '零').replace(/零([亿|万])/g, '$1').replace(/零+元/, '元').replace(/亿零{0,3}万/, '亿').replace(/^元/, "零元")

}
