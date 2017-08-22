package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value= "/account/logout.action")
public class LogoutServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //로그아웃 처리 - Session에 저장된 데이터를 삭제
	   HttpSession session = req.getSession(); 
	   //session.setAttribute("loginuser", null); <- value 삭제
	   session.removeAttribute("loginuser"); // key-value set 삭제
	   //session.invalidate(); <- 모든 key-value set 삭제
	   
	   resp.sendRedirect("/upgo/home.action");
   }
}
  