<%@page import="com.upgo.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>


<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>

<html>
<head>
   <meta charset="utf-8" />
   <title>글쓰기</title>
   <link rel="Stylesheet" href="/upgo/styles/default.css" />
   <link rel="Stylesheet" href="/upgo/styles/input2.css" />
   <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
   <script type="text/javascript">
   $(function() {
      $('a#delete').on('click',function(event){
         var productNo = $(this).attr('data-productno');
         var ok = confirm(prductNo + '번 글을 삭제할까요?');
         if (오케이) {
         location.href = "productdelete.action?productdno=" + prductNo;
         }
         event.preventDefault(); //<a>의 기본동작 중단
      });
   });
   </script>

      <script type="text/javascript">
  
   
   </script>
   
</head>
<body>

   <div id="pageContainer">
      <div style="padding-top:25px;text-align:center">
      <div id="inputcontent">
          <div id="inputmain">
			<% Product product = (Product)request.getAttribute("pboard"); %>
              <div class="inputsubtitle">상품게시판 글 내용</div>
              <table>
                  <tr>
                      <th>상품번호</th>
                      <td><%= product.getPrdNo() %></td>
                  </tr>
                  <tr>
                      <th>이름</th>
                      <td><%= product.getPrdName() %></td>
                  </tr>
                  <tr>
                      <th>가격</th>
                      <td><%= product.getPrdPrice() %></td>
                  </tr>
                  <tr>
                      <th>상품설명</th>
                      <td><%= product.getPrdDesc() %></td>
                  </tr>
                 
              </table>
              <div class="buttons">
              
                 [&nbsp;<a href='productupdate.action?productno=<%= product.getPrdNo() %>&pageno=${ pageno }'>수정</a>&nbsp;]
                 [&nbsp;<a id="productdelete" href='#' data-productno="${ product.prdNo }">삭제</a>&nbsp;]
                 [&nbsp;<a href='productlist.action?pageno=${ pageno }'>목록보기</a>&nbsp;]
              </div>
          </div>
      </div>
    </div>
  </div>
</body>
</html>









