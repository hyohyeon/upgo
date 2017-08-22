package com.upgo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.dto.Member;



@WebFilter(value = "*.action") // 서플릿으로 향하는 모든 요청에 대해
public class AuthFilter2 implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;

		String uri = req.getRequestURI();
		if (uri.contains("/board2/")) {
			// if(uri.contains("/list.action")== false){ //목록 페이지가 아닌 경우
			if (!uri.contains("/tblist.action")) { // 목록 페이지가 아닌 경우
				HttpSession session = req.getSession();
				Member member = (Member) session.getAttribute("loginuser");
				if (member == null) {// 로그인하지 않는 경우
					resp.sendRedirect("/upgo/account/login.action");
					return;
				}
			}
		}
		arg2.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
