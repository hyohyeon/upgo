<%@page import="com.upgo.dto.CouponReceived"%>
<%@page import="java.util.List"%>
<%@page import="com.upgo.dto.CouponEvent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="/upgo/coupon/listcss/bootstrap.min.css">
<link rel="stylesheet" href="/upgo/coupon/listcss/font-awesome.css">

<link rel="stylesheet" href="/upgo/coupon/listcss/bootstrap.min.css">
<link rel="stylesheet" href="/upgo/coupon/listcss/font-awesome.css">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/upgo/css/stylish-portfolio2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/upgo/font-awesome/css/font-awesome.min.css"
   rel="stylesheet" type="text/css">
<link
   href="/upgo/fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
   rel="stylesheet" type="text/css">

<link rel="Stylesheet" href="/upgo/styles/default.css" />
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="js/list index.js"></script>
<script type="text/javascript">
   $(function() { //jquery의 메인 function 
      $('#write').on('click', function(event) { location.href = 'product.action'; });
   });
</script>
</head>
<title>Coupon roulette</title>
<!-- Bootstrap Core CSS -->
<link href="/upgo/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
<meta charset="utf-8">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="/upgo/js/jqueryroto.js"></script>
<body bgcolor="white" topmargin="50">
   <hr width='600' size='2' noshade>
   <% List<CouponReceived> couponList = (List<CouponReceived>) request.getAttribute("couponList"); %>
   <jsp:include page="/WEB-INF/views/include/header.jsp" />
   <h1 style="text-align: center">Up &amp; Go</h1>
   <h3 style="text-align: center">For your shopping</h3>
   <h2 style="text-align: center">UP & GO 는 항상 여러분의 여행을 지원합니다.</h2>
   <h2 style="text-align: center">발급된 쿠폰 정보입니다.</h2>
   <br /><br /><br /><br /><br />   

   <div style="width:300px;text-align:center;margin:0 auto">
      <img src="/upgo/img/niddle.png" id="n_id" style='position:relative;margin-left:200px;z-index: 10'>   
      <img src="/upgo/img/roulette1.png" id="image" style="position:relative">
      <br /><br /><br /><br /><br />   
      
      <br /><br /><br /><br /><br />   
      <input type='button' value='시작' id='start_btn'></input>
      <div id="result_id"></div>
      <div id="result_id2"></div>
      <div id="result_id3"></div>
   </div>
   <script>
      $(function() {
         $('#result_id').on('click', function(event) {//id가 result_id인 div를 클릭했을 때 호출될 함수 (이벤트)
            var message = $(this).text();
            if (message.indexOf('당첨') != -1) {
               //alert('쿠폰을 발급했습니다.');
               location.href = '/upgo/coupon/randomcoupon.action';//당첨 처리 서블릿으로 요청 전송
            }
         });
         
         var pArr = [ "0:다음기회에.", "1:다음기회에.", "2:다음기회에.", "3:다음기회에.",
               "4:당첨", "5:다음기회에.", "6:다음기회에.", "7:다음기회에.", "8:다음기회에.",
               "9:다음기회에." ];

         $('#start_btn').click(function() {
            rotation();
         });
         function rotation() {
            $("#image").rotate({
               angle : 0,
               animateTo : 360 * 5 + randomize(0, 360),
               center : [ "50%", "50%" ],
               easing : $.easing.easeInOutElastic,
               callback : function() {
                  var n = $(this).getRotateAngle();
                  endAnimate(n);
               },
               duration : 5000
            });
         }

         function endAnimate($n) {//룰렛이 다 돌았을 때 호출되는 함수
            var n = $n;
            var real_angle = n % 360 + 18;
            var part = Math.floor(real_angle / 36);
            if (pArr[part].indexOf('당첨') != -1) {
               $('#result_id').html('<h3>당첨 되었습니다. (여기를 눌러서 쿠폰을 받으세요)</h3>')
            } else { $('#result_id').html('<h3>다음 기회에</h3>')}
         }
         function randomize($min, $max) { return Math.floor(Math.random() * ($max - $min + 1)) + $min;
}
      });
   </script>

   <table width="75%" align="center" bgcolor="white">
      <hr width='600' size='2' noshade>   
        <h2 style="text-align: center">쿠폰 내역을 확인해주세요 .</h2>
      <tr bgcolor="white">
         <td align="center"><font color="black">쿠폰번호</font></td>
         <td align="center"><font color="black">쿠폰종류</font></td>
         <td align="center"><font color="black">쿠폰기한</font></td>
      </tr>
      <% for (CouponReceived couponRecived : couponList) { %>
      <tr style="height: 25px">
         <td style='text-align: center;'><%=couponRecived.getNo()%></td>
         <td style='text-align: center;'>
            <% if (couponRecived.getCuponNo() == 1) { %>    
            <big>기본신규회원쿠폰(5,000원)</big>
            <% } else if (couponRecived.getCuponNo() == 2) { %> 
            <big>첫 구매후 증정쿠폰(10,000원)</big> 
            <%    } else { %> 
            <big>쿠폰이벤트 증정쿠폰(100,000원)</big> 
            <%    } %>
         </td>
         <td style='text-align: center;'><%=couponRecived.getExpDate()%></td>
      </tr>
      <%}%>
   </table>
   <%--    <table width="75%" align="center" bgcolor="white">
         <hr width='600' size='2' noshade>   
              <h2 style="text-align: center">유효기간이 지난 쿠폰 내역입니다.</h2>
         <tr bgcolor="white">
         <td align="center"><font color="black">쿠폰번호</font></td>
         <td align="center"><font color="black">쿠폰종류</font></td>
         <td align="center"><font color="black">쿠폰기한</font></td>
         <h2 style="text-align: center">유효기간이 지난 쿠폰을 삭제하시겠습니까?</h2>
      </tr>
      <% for (CouponReceived couponRecived : couponList) { %>
      <tr style="height: 25px">
         <td style='text-align: center;'><%=couponRecived.getNo()%></td>
         <td style='text-align: center;'>
            <% if (couponRecived.getCuponNo() == 0) { %>    
            <big>기본신규회원쿠폰(5,000원)</big>
            <% } else if (couponRecived.getCuponNo() == 1) { %> 
            <big>첫 구매후 증정쿠폰(10,000원)</big> 
            <%    } else { %> 
            <big>쿠폰이벤트 증정쿠폰(100,000원)</big> 
            <%    } %>
         </td>
         <td style='text-align: center;'><%=couponRecived.getNo()%></td>
         <input type="checkbox" id="dropoutAgree" name="dropoutAgree" onclick="clickcr(this,'otn.guideagree','','',event);" > --%>         
         
 <br /><br /><br /><br /><br />   
      <input type='button' value='시작' id='start_btn'></input>
   
   
   <jsp:include page="/WEB-INF/views/include/function.jsp" />
</body>
</html>