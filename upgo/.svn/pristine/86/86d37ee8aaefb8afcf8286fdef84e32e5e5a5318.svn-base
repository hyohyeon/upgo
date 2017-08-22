package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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
import com.upgo.dto.Product;
import com.upgo.service.MemberService;
import com.upgo.service.ProductService;
import com.upgo.ui.ThePager;

@WebServlet(value= "/product/orderlist.action")
public class OrderListServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   		
	   int pageSize = 9; // 페이지를 얼마씩 짜를지 설정
		int pagerSize= 1; // 링크의 갯수
		int productCount = 0;
		String linkUrl = "ordertlist.action";
		
		String page = req.getParameter("pageno");
		int currentPage = 1; // 요청된 페이지가 없을때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); // 요청된 페이지 번호
		} catch (Exception ex) {
		}
		
		int first = (currentPage - 1) * pageSize + 1; // 페이지 번호를 기준으로 시작번호 가져오기
		int last = first + pageSize;
		
		//데이터 처리 (게시판 목록 조회)
		ProductService productService = new ProductService();
		List<Product> products = productService.selectProductList(first, last);
		
		ThePager pager = new ThePager(productCount, currentPage, pageSize, pagerSize, linkUrl);

		//JSP에서 사용할 수있도록 REQUEST 객체에 조회된 데이터 저장
		req.setAttribute("products", products);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/product/orderlist.jsp");
		dispatcher.forward(req,resp);
	}
}
