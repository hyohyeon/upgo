<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>상품등록</title>
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<link rel="Stylesheet" href="/upgo/styles/input2.css" />	
	<style type = "text/css">
		a { text-decoration: none}
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js">
	</script>
	<!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/upgo/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
	
	
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type = "text/javascript">
	$(function() { //jquery의 메인 function
	$('a#write').on('click', function(event) {
		$('form#writeform').submit();
		event.preventDefault();// <a> 의 기본 기능 수행을 막는 코드
	});
});
	
	</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div id="pageContainer">

		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">상품등록 글 쓰기</div>
		        <form id= "writeform" action="productwrite.action" method="post">
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                <input type="text" name="title" style="width:280px"/>
		                </td>
		            </tr>
		            <tr>
		            <th>작성자</th>
		                <td>
		               <% Member member = (Member)session.getAttribute("loginuser"); %>
                         <%= member.getMemberId() %>
                         <!--  input type="hidden" : 서버로 전송은 하지만 브라우저에서는 표시되지 않는 요소  -->
                         <input type="hidden" name="writer" value="<%= member.getMemberId() %>" /> <%-- 브라우저에서 입력요소 만들기 --%>
                      </td>
		           </tr>
		            <tr>
		                <th>상품명</th>
		                <td>
		                    <input type="text" name="productname" style="width:280px" />
		                </td>
		            </tr>
		             <tr>
		                <th>상품가격</th>
		                <td>
		                    <input type="text" name="productprice" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>상품설명</th>
		                <td>		                    
		                    <textarea 
		                    	name="productdesc" cols="76" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        		        	
		        	<a id= "write" href="#">상품등록</a>
		        	&nbsp;&nbsp;
		        	<a href="/upgo/product/productlist.action">상품목록보기</a>
		        </div>
		        </form>
		    </div>
		</div>   	
		<jsp:include page="/WEB-INF/views/include/function.jsp" />
	</div>
	</div>
</body>
</html>