<%@page import="com.upgo.dto.Product"%>
<%@page import="com.upgo.dto.Member"%>
<%@ page language="java" 
	contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>상품등록하기</title>
	<link rel="Stylesheet" href="/upgo/styles/default.css" />
	<link rel="Stylesheet" href="/upgo/styles/input2.css" />	
	<style type = "text/css">
		a { text-decoration: none}
	</style>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script type = "text/javascript">
	$(function() { //jquery의 메인 function
	$('a#update').on('click', function(event) {
		$('form#updateform').submit();
		event.preventDefault();// <a> 의 기본 기능 수행을 막는 코드
	});
});
	</script>

</head>
<body>

	<div id="pageContainer">
	
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">상품 글 수정</div>
		        <form id= "updateform" action="productupdate.action" method="post">
		        <% Product product = (Product)request.getAttribute("product"); %>
		        <table>
		         	<tr>
		                <th>상품번호</th>
		                <td>
		             	   <%= product.getPrdNo() %>
		                    <input type="hidden" name="productno" 
		                    	value ="<%= product.getPrdNo() %>"/>
		                </td>
		            </tr>
		            <tr>
		                <th>이름</th>
		                <td>
		                    <input type="text" name="name" style="width:280px" 
		                    value ="<%= product.getPrdName() %>"/>
		                </td>
		            </tr>
		            <tr>
		                <th>가격</th>
		                <td>		                    
		                    <textarea 
		                    	name="price" cols="76" rows="15"><%= product.getPrdPrice() %></textarea>
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td>		                    
		                    <textarea 
		                    	name="desc" cols="76" rows="15"><%= product.getPrdDesc() %></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        		        	
		        	<a id="update" href="#">글수정</a>
		        	&nbsp;&nbsp;
		        	<a href='/upgo/product/productdetail.action?productno=<%= product.getPrdNo() %>&pageno=<%= request.getAttribute("pageno")%>'>취소</a>
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>