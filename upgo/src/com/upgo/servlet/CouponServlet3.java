package com.upgo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
import com.upgo.dto.RandomCoupon;
import com.upgo.service.CouponService;
import com.upgo.service.MemberService;

@WebServlet(value = "/coupon/randomcoupon.action")

public class CouponServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("loginuser");
		
		CouponService couponService = new CouponService();
//		if (Math.random() < 0.1) {
//			CouponReceived newCoupon = new CouponReceived();
//			newCoupon.setId(member.getMemberId());
//			newCoupon.setNo(3);
//			Calendar c = Calendar.getInstance();// 오늘날짜
//			c.add(Calendar.MONTH, 1);// 1개월 후로 설정
//			newCoupon.setExpDate(c.getTime());
//			couponService.issueCoupon(newCoupon);
//		}
		CouponReceived newCoupon = new CouponReceived();
		newCoupon.setId(member.getMemberId());
		newCoupon.setNo(3);
		Calendar c = Calendar.getInstance();// 오늘날짜
		c.add(Calendar.MONTH, 1);// 1개월 후로 설정
		newCoupon.setExpDate(c.getTime());
		couponService.issueCoupon(newCoupon);
		
		ArrayList<CouponReceived> couponList = couponService.findReceivedCoupon(member.getMemberId());

		// 조회된 데이터를 JSp에서 읽을수 있도록 requst객체에 저장
		req.setAttribute("couponList", couponList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/coupon/coupon.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");

		// 2. 데이터 조회
		MemberService memberService = new MemberService();
		Member member = memberService.authenticate(memberId, passwd);

		// 3. 로그인 처리
		if (member == null) { // 로그인 실패
			resp.sendRedirect("/upgo/account/login.action");
		} else { // 로그인 성공

			// 로그인 처리 - Session 객체에 로그인 데이터 저장
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", member);

			// 홈으로 이동
			resp.sendRedirect("/upgo/home.action");
		}
	}
}
