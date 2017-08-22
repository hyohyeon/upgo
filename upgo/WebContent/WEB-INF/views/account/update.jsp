<%@page import="com.upgo.dto.Member"%>
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
    
   <title>사용자등록</title>
   
   <!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
   
   <link rel="Stylesheet" href="/upgo/styles/input.css" />
   
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   
   <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
	
	function openDaumPostcode() {
	    var width = 500; //팝업창이 실행될때 위치지정
	    var height = 600; //팝업창이 실행될때 위치지정
	    new daum.Postcode({
	        width : width, //팝업창이 실행될때 위치지정
	        height : height, //팝업창이 실행될때 위치지정
	        oncomplete: function(data) {
	             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	 
	            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	 
	            // 법정동명이 있을 경우 추가한다.
	            if(data.bname !== ''){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있을 경우 추가한다.
	            if(data.buildingName !== ''){
	                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	            if(fullRoadAddr !== ''){
	                fullRoadAddr += extraRoadAddr;
	            }
	             
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById("post1").value = data.postcode1;
	            document.getElementById("post2").value = data.postcode2;
	            document.getElementById("addr1").value = fullRoadAddr;
	            document.getElementById("addr2").value = data.jibunAddress;
	 
	            document.getElementById('addr2').focus();
	        }
	    }).open({
	        left : (window.screen.width / 2) - (width / 2), //팝업창이 실행될때 위치지정
	        top : (window.screen.height / 2) - (height / 2) //팝업창이 실행될때 위치지정
	    });
	}

	</script>

                <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
				<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
				<script type="text/javascript">
				
				$( function() {
			  	    $( document ).tooltip();
			  	  });
				
                 $(function(){
                    $('#update').on('click',function(event){
                       
                       var passwd = $('input#passwd').val();
                       var pwdExpr = /^[a-zA-Z0-9]{8,20}$/; //정규표현식 -> /표현식/
                       var result = pwdExpr.test(passwd);
                       if (!result) {
                    	   alert('비밀번호는 8~20의 영문자 숫자 조합');
                    	   $('input#passwd').focus();
                    	   
                    	   return false;
                       }
                       
                       var passwd = $('input#passwd').val();
                       var confirm = $('input#confirm').val();
                       if (passwd != confirm) {
                    	   alert('비밀번호를 동일하게 입력하세요.');
                    	   return false;
                       }
                       
                       var email = $('input#email').val();
                       var emailExpr = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
                       result = emailExpr.test(email);
                       if (!result) {
                    	   alert('이메일 형식 오류');
                    	   $('input#email').focus();
                    	   return false;
                       }
                       
                       var phoneNumber = $('input#phoneNumber').val();
                       var phnExpr = /^[0-9]{8,20}$/;
                       result = phnExpr.test(phoneNumber);
                       if (!result) {
                    	   alert('휴대전화는 숫자만 입력하세요');
                    	   $('input#phoneNumber').focus();
                    	   return false;
                       }
                       
                       var address = $('input#address').val();
                       var adsExpr = /^{1,200}$/;
                       result = adsExpr.test(address);
                       if (!result) {
                    	   alert('주소 형식 오류');
                    	   $('input#address').focus();
                    	   return false;
                       }
                       
                      
                   		
                   		$('form#updateform').submit();
                   		
                     });
                   		
              });
                 
                 
                   	

                       
                      
                 </script>
</head>
<body>

   <div id="pageContainer">
   
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
      
      <div class="container">

<div class="row">
<br><br><br><br>
<div style="text-align:center"><a href="/upgo/home.action"><img src="../img/upgotitle.png" /></a></div>
 <br><br><br>
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form id="updateform" action="update.action" method="post" role="form">
			<h2>Please Sign Up <small>It's free and always will be.</small></h2>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<% Member member = (Member)session.getAttribute("loginuser"); %>
					<input type="hidden" name="memberId" value="<%= member.getMemberId() %>" />		
							<h4>	<%= member.getMemberId() %> </h4>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="passwd" id="passwd" class="form-control input-lg" placeholder="Password" tabindex="3"
						title="새로운 비밀번호를 입력하세요.">
						<input type="hidden" name="memberId" value="<%= member.getPasswd() %>" />	
					</div>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="confirm" id="confirm" class="form-control input-lg" placeholder="Confirm Password" tabindex="3"
						title="새로운 비밀번호를 입력하세요.">
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<input type="text" name="name" id="name" class="form-control input-lg" placeholder="Display Name" tabindex="3"
				value="<%= member.getName() %>" title="새로운 이름을 입력하세요."/>
			
			</div>
			
			<div class="form-group">
				<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4"
				value="<%= member.getEmail() %>" title="새로운 이메일을 입력하세요."/>
			
			</div>
			
			<div class="form-group">
				<input type="text" name="phoneNumber" id="phoneNumber" class="form-control input-lg" placeholder="Phone Number" tabindex="4"
				value="<%= member.getPhoneNumber() %>" title="새로운 연락처를 입력하세요."/>
			</div>
			
			
			
			<div class="form-group">
				<input id="post1" readonly="" size="5" name="post1"> - <input id="post2" readonly="" size="5" name="post2">
				<input onclick="openDaumPostcode()" type="button" value="우편번호찾기"><br>
				<span style="LINE-HEIGHT: 10%"><br></span>
				<input id="addr1" readonly="" size="40" name="addr1" placeholder="도로명주소"><br>
				<span style="LINE-HEIGHT: 10%"><br></span>
				<input id="addr2" size="40" name="addr2" placeholder="지번주소" value="<%= member.getAddress() %>" >
			</div>
			
			<div class="form-group">
				<input type="text" name="gender" id="gender" class="form-control input-lg" placeholder="Gender" tabindex="4"
				value="<%= member.getGender() %>" />
			
			</div>
			
			
			<hr class="colorgraph">
			<div class="buttons">
				<div class="col-md-6"><input id="update" type="submit" value="수정" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				<div class="col-md-6"><input id="cancel" type="button" value="이전" class="btn btn-success btn-block btn-lg"
					onclick="location.href='/upgo/account/information.action';" /></div>	
				
						
			</div>
		</form>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
			</div>
			<div class="modal-body">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</div>
   
   	<jsp:include page="/WEB-INF/views/include/function.jsp" />
   	
  
   	
   </div>

</body>
</html>