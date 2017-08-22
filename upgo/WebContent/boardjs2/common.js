$(document).ready(function(){
	//메인 메뉴
	$(".depth01").hover(
		function(){
			$alldisp = $(".all_menu").css("display");
			
			//전체 메뉴가 보일 때에는 서브메뉴 안보이게.
			if( $alldisp == "none"){
				$(".depth02").hide();
				$(this).next(".depth02").show();
			}else{
				$(".depth02").hide();
			}	
		}
	);

	$(".depth01").mouseleave(function(){
		$(".depth02").hide();
	});

	$(".depth02").hover(
		function(){
			$(this).mouseenter(function(){
				$(this).show();
			});
		},
		function(){
			$(".depth02").hide();
		}
	);

	//오른쪽 메뉴 닫힘
	$(".bt_q_close").click(function(){
		$("#quickmenu").hide();
		$("#quickmenu_default").show();

	});

	//오른쪽 메뉴 열림
	$(".bt_q_open").click(function(){
		$("#quickmenu").show();
		$("#quickmenu_default").hide();

	});

	get_today_good(1);

	$('#bookmarkme').on('click', function(e) {
		var bookmarkURL = window.location.href;
		var bookmarkTitle = document.title;
		var triggerDefault = false;

		if (window.sidebar && window.sidebar.addPanel) {
			// Firefox version < 23
			window.sidebar.addPanel(bookmarkTitle, bookmarkURL, '');
		} else if ((window.sidebar && (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)) || (window.opera && window.print)) {
			// Firefox version >= 23 and Opera Hotlist
			var $this = $(this);
			$this.attr('href', bookmarkURL);
			$this.attr('title', bookmarkTitle);
			$this.attr('rel', 'sidebar');
			$this.off(e);
			triggerDefault = true;
		} else if (window.external && ('AddFavorite' in window.external)) {
			// IE Favorite
			window.external.AddFavorite(bookmarkURL, bookmarkTitle);
		} else {
			// WebKit - Safari/Chrome
			alert((navigator.userAgent.toLowerCase().indexOf('mac') != -1 ? 'Cmd' : 'Ctrl') + '+D 키를 눌러 즐겨찾기에 등록하실 수 있습니다.');
		}

		return triggerDefault;
	});

});

function fnc_SearchCheck(){

	var f = document.frm_allsch;
	if(f.gm.value.split(" ").join("")==""){
		alert("검색어를 입력하세요");
		f.gm.value="";
		f.gm.focus();
		return false;
	}

}

function get_today_good(page) {
	var params = "page="+ page;
	$.ajax({
	
		success: function(data) {
			$("#taday_list").html(data);
		},		
		error: function() {
		},
		type: "POST",
		url: "/Goods/ajax_TodayGoodView.asp",
		data: params
	});	
}