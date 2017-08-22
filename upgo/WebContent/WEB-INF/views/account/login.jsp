<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html lang="en">
<head>
<style>
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title>로그인</title>
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
   	
   	
  
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
     <script type="text/javascript">
     
     $( function() {
  	    $( document ).tooltip();
  	  });
     
     $(document).ready(function(){
    	    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    	    var userInputId = getCookie("memberId");
    	    $("input[name='memberId']").val(userInputId); 
    	     
    	    if($("input[name='memberId']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
    	        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    	    }
    	     
    	    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
    	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
    	            var userInputId = $("input[name='memberId']").val();
    	            setCookie("memberId", userInputId, 7); // 7일 동안 쿠키 보관
    	        }else{ // ID 저장하기 체크 해제 시,
    	            deleteCookie("memberId");
    	        }
    	    });
    	     
    	    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    	    $("input[name='memberId']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
    	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
    	            var userInputId = $("input[name='memberId']").val();
    	            setCookie("memberId", userInputId, 7); // 7일 동안 쿠키 보관
    	        }
    	    });
    	});
    	 
    	function setCookie(cookieName, value, exdays){
    	    var exdate = new Date();
    	    exdate.setDate(exdate.getDate() + exdays);
    	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    	    document.cookie = cookieName + "=" + cookieValue;
    	}
    	 
    	function deleteCookie(cookieName){
    	    var expireDate = new Date();
    	    expireDate.setDate(expireDate.getDate() - 1);
    	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    	}
    	 
    	function getCookie(cookieName) {
    	    cookieName = cookieName + '=';
    	    var cookieData = document.cookie;
    	    var start = cookieData.indexOf(cookieName);
    	    var cookieValue = '';
    	    if(start != -1){
    	        start += cookieName.length;
    	        var end = cookieData.indexOf(';', start);
    	        if(end == -1)end = cookieData.length;
    	        cookieValue = cookieData.substring(start, end);
    	    }
    	    return unescape(cookieValue);
    	} 
     
    	
     </script>
     
</head>
<body>
	
	
	<div class="container">
   
			<jsp:include page="/WEB-INF/views/include/header.jsp" />
		

		<div class="container">
	<br><br><br><br>
<div style="text-align:center"><a href="/upgo/home.action"><img src="../img/upgotitle.png" /></a></div>
 <br><br><br>
<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form form action="login.action" method="post" role="form">
			<fieldset>
				<h2>Please Sign In</h2>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="text" name="memberId" class="form-control input-lg" placeholder="ID"
                    title="아이디를 입력하세요.">
				</div>
				<div class="form-group">
                    <input type="password" name="passwd" class="form-control input-lg" placeholder="Password"
                    title="비밀번호를 입력하세요.">
				</div>
				<span class="button-checkbox">
						<div class="checkbox">
						<label>
							<input type="checkbox" id="idSaveCheck"> Remember me
						</label>
					</div> <!-- /.checkbox -->
                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
					<a href="/upgo/account/findpasswd.action" class="btn btn-link pull-right">Forgot Password?</a>
				</span>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-lg btn-success btn-block" value="로그인">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="/upgo/account/register.action" class="btn btn-lg btn-primary btn-block">Register</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>

		<jsp:include page="/WEB-INF/views/include/function.jsp" />

	</div>
	
</body>
</html>