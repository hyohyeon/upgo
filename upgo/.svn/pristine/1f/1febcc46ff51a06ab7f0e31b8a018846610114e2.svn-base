package com.upgo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.dto.Member;
import com.upgo.service.MemberService;

@WebServlet(value= "/account/delete.action")
public class DeleteServlet extends HttpServlet {
   
	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   		//home으로 이동
	 		RequestDispatcher dispatcher =
	 				req.getRequestDispatcher("/WEB-INF/views/account/delete.jsp");
			dispatcher.forward(req, resp);
			
	}
	
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
			
			// 1. 브라우저에서 전송된 데이터 읽기	
			String memberId = req.getParameter("memberId");			
			
			Member member = new Member();
			member.setMemberId(memberId);
			
			// 2. memberId로 데이터 삭제 (MemberService 사용)
			MemberService memberSevice = new MemberService();
			memberSevice.deleteMember(member);
		
			//로그아웃 처리 - Session에 저장된 데이터를 삭제
			HttpSession session = req.getSession(); 
			   //session.setAttribute("loginuser", null); <- value 삭제
			session.removeAttribute("loginuser"); // key-value set 삭제
			   //session.invalidate(); <- 모든 key-value set 삭제   
			
			// 4. home.action으로 이동
			resp.sendRedirect("/upgo/home.action");
	   }
	}