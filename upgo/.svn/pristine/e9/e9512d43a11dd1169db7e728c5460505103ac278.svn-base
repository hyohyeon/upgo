package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.common.Util;
import com.upgo.dao.CouponDao;
import com.upgo.dto.CouponReceived;
import com.upgo.dto.Member;
import com.upgo.service.MemberService;

@WebServlet(value= "/product/product.action")
public class ProductServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		
	   //home으로 이동
 		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/product/product.jsp");
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
		   resp.sendRedirect("/upgo/account/login.action");
	   } else { //로그인 성공
		   
		   //로그인 처리 - Session 객체에 로그인 데이터 저장
		   HttpSession session = req.getSession();
		   session.setAttribute("loginuser", member);
		   
		   //홈으로 이동
		   resp.sendRedirect("/upgo/home.action");
	   }
	}
}

