<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html lang="en">
<head>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title>회원탈퇴</title>
	
	
	<!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
   
   	<link rel="stylesheet" type="text/css" href="/inc/user/css/ko/help_member.css?20160314">
<link href="https://nid.naver.com/favicon_1024.png" rel="apple-touch-icon-precomposed" sizes="1024x1024" />
  
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    
 
</head>
<body>
	
	<div class="container">
    
			<jsp:include page="/WEB-INF/views/include/header.jsp" />

		<div id="container">
		<!-- CONTENTS -->
		<!-- CONTENTS -->
	<div id="content">
		<div class="c_header">
			<h2>탈퇴 안내</h2>
			<p class="contxt">회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</p>
		</div>

		<!-- [D] input type="text"에 focus 되었을때 class에 on 추가 (ie6,ie7 대응) -->
		<div class="section_delete">
			<h3 class="h_dropout">
						     	  사용하고 계신 아이디(
						     	  <% Member member = (Member)session.getAttribute("loginuser"); %>
                        		  <%=member.getMemberId() %>
                        		 
                        
						     	  )는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
						     </h3>
			<p class="dropout_dsc">
						     	  <em>탈퇴한 아이디는 본인과 타인 모두 재사용 및 복구가 불가</em>하오니 신중하게 선택하시기 바랍니다.
						     </p>
			<h3 class="h_dropout">탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</h3>
			<p class="dropout_dsc">
						     	  회원정보 및 메일 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.
			
			
			<form name="fm" id ="fm" method="post" action="delete.action">
				<input type="hidden" name="token_help" value="aW8bbBlG4K7VETF2" />
				<input type="hidden" name="lang" value="ko_KR" />
				<div class="dropout_agree_area">
					<p class="contxt">
						<strong>
						     	  탈퇴 후에는 아이디 <em>(
						     	  <input type="hidden" name="memberId" value="<%= member.getMemberId() %>" />
                        		  <%=member.getMemberId() %>
						     	  )</em> 로 다시 가입할 수 없으며 아이디와 데이터는 복구할 수 없습니다.
						     <br>
								 게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다.<br>또한, 네이버 아이디를 사용해 다른 서비스에 로그인 할 수 없게 됩니다. 
							</strong>
					</p>
					<input type="checkbox" id="dropoutAgree" name="dropoutAgree" onclick="clickcr(this,'otn.guideagree','','',event);" >
					<label for="dropoutAgree"><strong>안내 사항을 모두 확인하였으며, 이에 동의합니다.</strong></label>
				</div>
				<div class="btn_area_w">
					<p class="btn_area">
						<a id="delete" class="btn_model"><b class="btn3">확인</b></a>
					</p>
				</div>				
			</form>
		</div>
	</div>

		<jsp:include page="/WEB-INF/views/include/function.jsp" />
		
		<script type="text/javascript">
		
		$(function() {
		$(document).on("click", "#delete", function(event){
		if( $("#dropoutAgree").is(":checked")){
			$("#fm").submit();
		}else{
			alert("탈퇴 안내를 확인하고 동의해 주세요.");
			$("#dropoutAgree").focus();
		}
		
		});
	});

	</script>
	
	</div>
	
</body>
</html>