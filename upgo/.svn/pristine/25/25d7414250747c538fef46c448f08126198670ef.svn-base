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

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.upgo.common.Util;
import com.upgo.dto.Member;
import com.upgo.service.MemberService;

@WebServlet(value= "/account/findpasswd.action")
public class findpasswdServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		//home으로 이동
 		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/account/findpasswd.jsp");
		dispatcher.forward(req, resp);
   }
   
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   req.setCharacterEncoding("utf-8");
		//1. 요청 데이터 읽기
	   String memberId = req.getParameter("memberId");
	   String email = req.getParameter("email");
	  
	   //2. 데이터 조회
	   MemberService memberService = new MemberService();
	   Member member = memberService.findpasswd(memberId, email);
	   
	   if (member == null) { //로그인 실패
		   resp.sendRedirect("/upgo/account/findpasswd.action");
	   } else { //로그인 성공
		   
		   //로그인 처리 - Session 객체에 로그인 데이터 저장
		   HttpSession session = req.getSession();
		   session.setAttribute("finduser", member);
	   
		   //새 비밀번호 입력창으로 이동
		   resp.sendRedirect("/upgo/account/newpasswd.action");
	   }
	}
}

  