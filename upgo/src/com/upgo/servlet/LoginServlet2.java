package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.common.Util;
import com.upgo.dto.Member;
import com.upgo.service.MemberService;

@WebServlet(value= "/account/login2.action")
public class LoginServlet2 extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		//home으로 이동
 		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/account/login2.jsp");
		dispatcher.forward(req, resp);
   }
   
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 요청 데이터 읽기
	   String memberId = req.getParameter("memberId");
	   String passwd = req.getParameter("passwd");
	   passwd = Util.getHashedString(passwd, "SHA-256");
	   
	   //2. 데이터 조회
	   MemberService memberService = new MemberService();
	   Member member = memberService.authenticate(memberId, passwd);
	   
	   //3. 로그인 처리
	   if (member == null) { //로그인 실패
		   resp.sendRedirect("/upgo/account/login2.action");
	   } else { //로그인 성공
		   
		   
		   //내정보 이동
		   resp.sendRedirect("/upgo/account/information.action");
	   }
	}
}
  