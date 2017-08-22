package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.dto.Board;
import com.upgo.service.BoardService;
import com.upgo.service.ProductService;

@WebServlet(value = "/product/productdelete.action")
public class ProductDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 아래 인증코드는 필터로 구현합니다.
		// //1. 로그인 하지 않았을 경우에 로그인 화면으로 이동(로그인 확인 여부)
		// HttpSession session = req.getSession();
		// if (session.getAttribute("loginuser")==null) {
		// resp.sendRedirect("/demoweb/account/login.action");
		// return;
		// }

		// 1. 요청 데이터 읽기= 브라우저에서 전송한 데이터 읽기(boardno)
		// - boardno가 비정상인 경우 list.action 으로 이동
		String sProductNo = req.getParameter("productno");
		int productNo = -1;
		try {
			productNo = Integer.parseInt(sProductNo);
		} catch (Exception ex) {
			resp.sendRedirect("/upgo/Product/productlist.action");
			return;
		}

		// 2. productno 로 데이터 삭제(ProductService 사용)
		ProductService productService = new ProductService();
		productService.deleteProduct(productNo);

		// 3. list.action 으로 이동

		// resp.sendRedirect("/demoweb/board/list.action");
		resp.sendRedirect("/productlist.action");

		// resp.sendRedirect("/demoweb/board/list.action");
		resp.sendRedirect("list.action");

		// resp.sendRedirect("/upgo/product/productlist.action");
		resp.sendRedirect("productlist.action");

	}
}
