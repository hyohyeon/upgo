<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
	String ctx = request.getContextPath(); //콘텍스트명 얻어오기.
%>

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
	
	
	<!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
   
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
     <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript">
    
  				  $( function() {
  	 			   	$( document ).tooltip();
  	  				});
    
                 $(function checkValue(){
                    $('#update').on('click',function(event){
                    	
                    	var passwd = $('input#passwd').val();
                        var confirm = $('input#confirm').val();
                        if (passwd != confirm) {
                     	   alert('비밀번호를 동일하게 입력하세요.');
                     	   return false;
                        }
                    });
                 });
                    
               </script>
    
</head>
<body>
	
	<div class="container">
    
			<jsp:include page="/WEB-INF/views/include/header.jsp" />
<br><br><br><br>
<div style="text-align:center"><a href="/upgo/home.action"><img src="../img/upgotitle.png" /></a></div>
 <br><br><br>
<div class="row" style="margin-top:20px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form action="newpasswd.action" method="post" role="form">
			<fieldset>
			
				<center><h2>새로운 비밀번호 설정</h2></center>
				<hr class="colorgraph">
				
				<div class="form-group">
						<% Member member = (Member)session.getAttribute("finduser"); %>
                         
                         <%--  input type="hidden" : 서버로 전송은 하지만 브라우저에서는 표시되지 않는 요소  --%>
                         <input type="hidden" name="memberId" value="<%= member.getMemberId() %>" /> <%-- 브라우저에서 입력요소 만들기 --%>
                         <input type="password" id="passwd" name="passwd" class="form-control input-lg" placeholder="Password"
                         title="새로운 비밀번호를 입력하세요.">
				</div>
	
				<div class="form-group">
						
                         <input type="password" id="confirm" name="confirm" class="form-control input-lg" placeholder="confirm Password"
                         title="새로운 비밀번호를 입력하세요.">
				</div>
				
					
				
					<input id="update"  type="submit" class="btn btn-lg btn-success btn-block" value="확인">

			</fieldset>
		</form>
		</div>
		</div>



		<jsp:include page="/WEB-INF/views/include/function.jsp" />

	</div>
	
</body>
</html>