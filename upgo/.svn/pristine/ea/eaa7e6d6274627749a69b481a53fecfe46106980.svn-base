package com.upgo.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.common.Util;
import com.upgo.dto.CouponReceived;
import com.upgo.dto.Member;
import com.upgo.service.CouponService;
import com.upgo.service.MemberService;


@WebServlet(value = "/account/register.action")

public class RegisterServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	   RequestDispatcher dispatcher = 
			   req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
	   dispatcher.forward(req, resp);
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
      req.setCharacterEncoding("utf-8");
                     //브라우저에서 전송된 데이터 읽기
     
      String memberId = req.getParameter("id");
      String passwd = req.getParameter("passwd");
      String confirm = req.getParameter("confirm");
      String name = req.getParameter("name");
      String email = req.getParameter("email");
      String phoneNumber = req.getParameter("phoneNumber");
      String address = req.getParameter("addr1");
      String gender = req.getParameter("gender");
      
      
      
//      resp.setContentType("text/plain;charset=utf-8");
//      PrintWriter out = resp.getWriter();
//      out.println(memberId + " / " + passwd + " / " + 
//               confirm + " / " + email);
      
      //사용자의 요청 데이터를 Member 객체에 저장
      Member member = new Member();
      member.setMemberId(memberId);
      passwd = Util.getHashedString(passwd, "SHA-256");
      member.setPasswd(passwd);
      member.setEmail(email);
      member.setName(name);
      member.setPhoneNumber(phoneNumber);
      member.setGender(gender);
      member.setAddress(address);
      member.setRegDate(new Date());
      	
      MemberService memberService = new MemberService();
      memberService.registerMember(member);
      
     CouponReceived newCoupon = new CouponReceived();
     newCoupon.setId(memberId);
     newCoupon.setNo(1);
     Calendar c = Calendar.getInstance();//오늘날짜
     c.add(Calendar.MONTH, 1);//1개월 후로 설정
     newCoupon.setExpDate(c.getTime());
     
      CouponService couponService = new CouponService();
      couponService.issueCoupon(newCoupon);
      //home으로 이동
      
//      RequestDispatcher dispatcher =
//    		  req.getRequestDispatcher("/Web_INF/views/home.jsp");
//      dispatcher.forward(req,resp);
      
      //resp.sendRedirect("/demoweb/WEB-INF/views/home.jsp");
      
      HttpSession session = req.getSession();
	  session.setAttribute("loginuser", member);
      
      resp.sendRedirect("/upgo/home.action");
}

}