<%@page import="com.upgo.dto.CouponReceived"%>
<%@page import="java.util.List"%>
<%@page import="com.upgo.dto.CouponEvent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="ko">
<head>
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
<style>
#image {margin: 50px 50px;z-index: 10;}
#n_id {position: absolute; left: 270px; top: 50px; z-index: 20;}
</style>

</head>
<body bgcolor="white" topmargin="50">

		<img src="/upgo/img/roulette1.png" id="image">
		<img src="/upgo/img/niddle.png" id="n_id"> 
		<input type='button' value='시작' id='start_btn'></input>
		<div id="result_id"></div>
		<div id="result_id2"></div>
		<div id="result_id3"></div>
		<script> window.onload = function() {
				var pArr = [ "0:다음기회에.", "1:다음기회에.", "2:다음기회에.", "3:다음기회에.","4:당첨", "5:다음기회에.", "6:다음기회에.", "7:다음기회에.", "8:다음기회에.","9:다음기회에." ];

				$('#start_btn').click(function() {rotation();});
				function rotation() { $("#image").rotate({ angle : 0,
						animateTo : 360 * 5 + randomize(0, 360),
						center : [ "50%", "50%" ],
						easing : $.easing.easeInOutElastic,
						callback : function() { var n = $(this).getRotateAngle(); endAnimate(n);},
						duration : 5000	});
				}

				function endAnimate($n) {
					var n = $n;
					$('#result_id').html("/upgo/coupon/randomcoupon.action"/* "<p>행운의 숫자입니다." + n + "</p>" */);
					var real_angle = n % 360 + 18;
					var part = Math.floor(real_angle / 36);

				/* 	$('#result_id2').html("<p>상품범위:" + part + "</p>");

					if (part < 1) {$('#result_id3').html("<p>당첨내역:" + pArr[0] + "</p>");
						return;}
					if (part >= 10) {	$('#result_id3').html("<p>당첨내역:" + pArr[pArr.length - 1] + "</p>");
						return;}
					$('#result_id3').html("<p>당첨내역:" + pArr[part] + "</p>"); */
					
					alert(pArr[part])
				}
				function randomize($min, $max) {
					return Math.floor(Math.random() * ($max - $min + 1)) + $min; }
			};
		</script>
</body>
</html>


