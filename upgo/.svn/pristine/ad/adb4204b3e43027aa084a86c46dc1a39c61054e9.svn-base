
var GnbNav={		
	$nav: null,			
	params: null,		

	Init: function() {
		var oThis = this;		
	
		oThis.$nav = $("div#nav")
		oThis.$util_list3 = $("ul.util_list3")
		oThis.$all_menu = oThis.$nav.find("div.all_menu, div.all_menu_europe");

		oThis.allMenuDisp();
		oThis.navUrlLink();		
	},

	allMenuDisp: function() {		
		var oThis = this;				
		
		oThis.$util_list3.find("a.gnb_all_menu").bind('click', function(){ 	
			$(".depth02").hide();
			oThis.$all_menu.show();
		});

		oThis.$all_menu.find("a.bt-close").bind('click', function(){ 	
			oThis.$all_menu.hide();
		});			
	},

	navUrlLink: function() {		
		var oThis = this;		
		
		oThis.$nav.find("a").bind("click", function(){
			if ($(this).attr("link_key") != undefined){
				var parmArry =  $(this).attr("link_key").split("/");				
				oThis.params = $.parseJSON('{"go_cd":"'+ parmArry[0] +'","good_type_cd":"'+ parmArry[1] +'","area_cd":"'+ parmArry[2] +'","sub_area_cd":"'+ parmArry[3] +'","go_detail_cd":"'+ parmArry[4] +'"}');
				location.href=HTTP_URL+'/Goods/GoodsList.asp?'+$.param(oThis.params);
			}			
		});
	}
}

var HeaderSearch = {
	$loding: null,			
	$container: null,
	$key_word: null,

	init: function() {
		var oThis = this;
		oThis.$loding = "<p class=\"loading\"><img src=\"/Comm_ttm/images/ajax-loader.gif\" alt=\"Loading...\" /></p>";		
		oThis.$container = $("div#header").find("div.sch_box");		
	},

	send: function() {
		var oThis = this;		
		oThis.$key_word = oThis.$container.find("input[name='key_word']");	

		if (oThis.$key_word.val() == ""){
			alert("");
			return false;
		}

		location.href="/Goods/GoodsSearchList.asp?"+$.param($.parseJSON('{"key_word":"'+ oThis.$key_word.val() +'"}'));		
	},

	sendV1: function(params) {
		var oThis = this;		

		location.href="/Goods/GoodsSearchList.asp?"+$.param($.parseJSON('{"key_word":"'+ params +'"}'));		
	}
}


$(document).ready(function(){
	GnbNav.Init();	
	HeaderSearch.init();

	function depth4MenuEvent(){		
		var $li = $(".gnb > li");
		var $li2 = $(".depth02 > li");

		$li.on({
			mouseenter : function(){
				$li.find(".depth").hide();
				$(this).find(".depth").show();
				$li.find(">a").removeClass("on");
				$(this).find(">a").addClass("on")
				$("#on").addClass("active");
				$("#on").next().removeClass("active");
				$("#menutab1").show();
				$("#menutab2").hide();
			},
			mouseleave : function(){
				$li.find(".depth").hide();
				$li.find(">a").removeClass("on");
				$("#on").addClass("active");
				$("#on").next().removeClass("active");
				$("#menutab1").show();
				$("#menutab2").hide();
			}
		});

		$li2.on({
			mouseenter : function(){
				$li2.find(">a").removeClass("active");
				$(this).find(">a").addClass("active");
			}
		});
		$(".list2 .depth3 > li").mouseenter(function(){
			$(".depth4").hide()
			$(this).find(">ul").show();
		});
		$(".btn_close").click(function(){
			$li.find(".depth").hide();
			$li.find(".depth3").hide();
			$li.find(".depth4").hide();
			$li.find("a").removeClass("on");
			$li.find("a").removeClass("active");
			$("#on").addClass("active");
		});
		$(".depth2 > li").mouseenter(function(){
			$(".depth3").hide();
			$(this).find(".depth3").show();
		});
		$(".depth3 > li").mouseenter(function(){
			$(".depth4").hide();
			$(this).find(".depth4").show();
			$(".depth3 > li").find("a").removeClass("active")
			$(this).find(">a").addClass("active");
		});		
		$(".menu_2_tab a").click(function(){
			var tabItem = $(".list2 ul");
			var i = $(this).index() + 1;
			
			$(".menu_2_tab a").removeClass("active");
			$(this).addClass("active");
			tabItem.hide();
			 $("#menutab"+i+"").show();			
		});			
	}


	function honeyMenuEvent(){
		var $honeyMenu = $(".honeygnb > li");

		$honeyMenu.mouseenter(function(){
			
			$honeyMenu.find(">a").removeClass("on");
			$honeyMenu.children("div").hide()

			$(this).find(">a").addClass("on");
			$(this).children("div").show();

		});

		$honeyMenu.mouseleave(function(){
			 $honeyMenu.find(">a").removeClass("on");
			 $honeyMenu.children("div").hide()
		});

		$(".close_btn").click(function(){
			 $honeyMenu.find(">a").removeClass("on");
			 $honeyMenu.children("div").hide();

			 return false;
		});
	}

	function freeMenuEvent(){
		$(".tmenu").on({
			mouseenter : function(){
				$(".tmenu").find(">a").removeClass("on");
				$(this).find(">a").addClass("on");
				$(".submenu").hide();
				$(this).find(".submenu").show()
			},
			mouseleave : function(){
				$(".tmenu").find(">a").removeClass("on");
				$(".submenu").hide();
			}
		});

		$(".allfreemenu").click(function(){
			$(".allmenu_wrap").show();
		});

		$(".close_btn").click(function(){
			$(".allmenu_wrap").hide();
		});
	}

	if (GnbNav.$nav.find("ul#gnb").attr("class") == "gnb"){
		depth4MenuEvent();
	}else if (GnbNav.$nav.find("ul#gnb").attr("class") == "honeygnb"){
		honeyMenuEvent();
	}else if (GnbNav.$nav.find("ul#gnb").attr("class") == "freegnb"){	
		freeMenuEvent();
	}else{
		depth4MenuEvent();
	}
 });