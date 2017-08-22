<%@page import="com.upgo.dto.Member"%>
<%@ page language="java"
       contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
         
         
      <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
<nav id="sidebar-wrapper">
    <ul class="sidebar-nav">
        
         <div class="links">
         <% Member member = (Member)session.getAttribute("loginuser"); %>
               <% if (member == null) { %>
        <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
        <li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>UP &amp; GO</a></li>
         <br>
        <li><a href="/upgo" onclick=$("#menu-close").click();>Home</a></li>
        <li><a href="/upgo/account/login.action" onclick=$("#menu-close").click();>로그인</a></li>
        <li><a href="/upgo/account/register.action" onclick=$("#menu-close").click();>회원가입</a></li>
        <li><a href="/upgo/product/product.action" onclick=$("#menu-close").click();>상품구매</a></li>
        <li><a href="/upgo/board2/tblist.action" onclick=$("#menu-close").click();>생생후기</a></li>
        <li><a href="/upgo/board/list.action" onclick=$("#menu-close").click();>고객센터</a></li>
        
         
        <% } else if (member.getMemberId().equals("kang12345")) { %>
        <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
        <li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>UP &amp; GO</a></li>
        
        <li class="sidebar-brand"><%= member.getMemberId() %>님 환영합니다. </li>
        <li><a href="/upgo" onclick=$("#menu-close").click();>Home</a></li>
        <li><a href="#portfolio" onclick=$("#menu-close").click();>포트폴리오</a></li>
        <li><a href="/upgo/board2/tblist.action" onclick=$("#menu-close").click();>생생후기</a></li>
        <li><a href="/upgo/product/product.action" onclick=$("#menu-close").click();>상품구매</a></li>
        <li><a href="/upgo/coupon/coupon.action" onclick=$("#menu-close").click();>나의 할인쿠폰</a></li>
        <li><a href="/upgo/account/login2.action" onclick=$("#menu-close").click();>회원정보</a></li>
        <li><a href="/upgo/account/logout.action" onclick=$("#menu-close").click();>로그아웃</a></li>
        <li><a href="/upgo/board/list.action" onclick=$("#menu-close").click();>고객센터</a></li>
        <li><a href="/upgo/product/productlist.action" onclick=$("#menu-close").click();>관리자전용</a></li>
       
        <% } else {%>
        
        <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
        <li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>UP &amp; GO</a></li>
        
        <li class="sidebar-brand" ><a href="#top" onclick=$("#menu-close").click();> <%= member.getMemberId() %>님 환영합니다. </a></li>
        <li><a href="/upgo" onclick=$("#menu-close").click();>Home</a></li>
        <li><a href="/upgo/scheduling/schedulelist.action?cid=<%= member.getMemberId() %>" onclick=$("#menu-close").click();>Schedule List</a></li>
        <li><a href="/upgo/board2/tblist.action" onclick=$("#menu-close").click();>생생후기</a></li>
        <li><a href="/upgo/product/product.action" onclick=$("#menu-close").click();>상품구매</a></li>
        <li><a href="/upgo/coupon/coupon.action" onclick=$("#menu-close").click();>나의 할인쿠폰</a></li>
        <li><a href="/upgo/account/login2.action" onclick=$("#menu-close").click();>회원정보</a></li>
        <li><a href="/upgo/account/logout.action" onclick=$("#menu-close").click();>로그아웃</a></li>
        <li><a href="/upgo/board/list.action" onclick=$("#menu-close").click();>고객센터</a></li>
              
         <% }  %>
       
        </div>
    </ul>
</nav>