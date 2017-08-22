<%@page import="com.upgo.dto.CouponReceived"%>
<%@ page language="java"
		 contentType="text/html; charset=utf-8"
  		 pageEncoding="utf-8"%>
		
		 <% String bgColor = request.getParameter("bg-color"); %>
		 <% if (bgColor != null) { %>
		 <div id='header' style='background-color:<%= bgColor %>'>
		 <% } else { %>
		 <div id="header">
		 <% } %>
		 
            <div class="title">
                <a href="/upgo/home.action">신규회원 할인쿠폰</a>
            </div>
            <div class="links">
            	
            	<a href="/upgo/account/login.action">로그인</a>
                <a href="/upgo/account/register.action">회원가입</a>
                <a href="/upgo/account/logout.action">로그아웃</a>
            
                </div>
            </div>
        </div>        
       
		