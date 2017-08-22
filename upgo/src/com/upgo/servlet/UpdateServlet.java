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

@WebServlet(value= "/account/update.action")
public class UpdateServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		//home으로 이동
 		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/account/update.jsp");
		dispatcher.forward(req, resp);
   
   }
   
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		  //브라우저에서 전송된 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		String name = req.getParameter("name"); 
		String phoneNumber = req.getParameter("phoneNumber");
		String address = req.getParameter("addr2");
		String gender = req.getParameter("gender");
		
		//사용자의 요청 데이터를 Member 객체에 저장
		Member member = new Member();
		member.setMemberId(memberId);
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);
		member.setEmail(email);
		member.setName(name);
		member.setPhoneNumber(phoneNumber);
		member.setAddress(address);
		member.setGender(gender);
		
		//사용자 수정 처리
		MemberService memberService = new MemberService();
		memberService.updateMember(member);

		resp.sendRedirect("/upgo/home.action");
	}	
}
  