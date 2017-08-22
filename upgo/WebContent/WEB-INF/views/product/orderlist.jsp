<%@page import="com.upgo.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
       <center> <h1> Up &amp; Go </h1></center>
         <center> <h3>  Buy a New Thing &amp; Get More Happiness </h3></center>
    	 <hr width='600' size='2' noshade>
 	 	<center><h2>상품결재창</h2></center>
  		<hr width='600' size='2' noshade>
 <meta charset="utf-8">
    <link rel="Stylesheet" href="/upgo/styles/default.css" />
   	<link rel="Stylesheet" href="/upgo/styles/input2.css" />	
   <style type = "text/css">
		a { text-decoration: none}
	</style>
   <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
     <!-- Bootstrap Core CSS -->
    <link href="/upgo/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/upgo/css/stylish-portfolio2.css" rel="stylesheet">

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
<body bgcolor="white" topmargin="50">
<div class="button" style="height:10px" align="center" >
	<a href="/upgo/product/product.action">*상품 다시 선택하기*</a>
	
</div>
   <div id="pageContainer">
      <jsp:include page="/WEB-INF/views/include/header.jsp" />
  <div class="text-center">
      <div style="padding-top: 25px; text-align: center">
       <input id= "write" type="button" value="상품결제하기" 
            style="width:300px;height:25px"/>
    <br><br>
   <% List<Product> Products = 
            (List<Product>)request.getAttribute("products"); %>
         <table border="1" align="center">
            <tr style="background-color: beige; height: 25px">
               <th style="width: 50px">상품번호</th>
              <th style="width: 300px">상품명</th>
               <th style="width: 150px">상품설명</th>
               <th style="width: 120px">상품가격</th>
               <th style="width: 80px">부가설명</th>
            </tr>
            <% for (Product Product : Products) { %>
            <tr style="height: 25px">
               <td style='text-align: center'><%= Product.getPrdNo()%></td>
               <td style='text-align: left; padding: 5px'>
               <% if (Product.isPrdDeleted()) { //삭제된 글인 경우%>
                  <span id="deleted-message">[ 삭제된 글 ]</span>
               <% } else { //삭제되지 않은 글 %>
                  <a href='productdetail.action?prdno=<%= Product.getPrdNo() %>&pageno=<%= request.getAttribute("pageno") %>' style='text-decoration: none'>
                     <%= Product.getPrdName() %>
                  </a>
               <% } %>
               </td>
               <td style='text-align: center'><%= Product.getPrdName() %></td>
               <td style='text-align: center'><%= Product.getPrdPrice() %></td>
               <td style='text-align: center'><%= Product.getPrdDesc() %></td>
               <% } %>
            </tr>
         </table>
         <br>
         <br>
         <%= request.getAttribute("pager").toString() %>
      </div>
   </div>
   		<jsp:include page="/WEB-INF/views/include/function.jsp" />
   
    </div>
    <table>
   
</table>
    
</body>
</html>

