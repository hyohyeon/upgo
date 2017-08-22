package com.upgo.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.upgo.common.Util;
import com.upgo.dto.Product;
import com.upgo.service.ProductService;


@WebServlet(value = "/product/productwrite.action")
public class ProductWriteServlet extends HttpServlet {
	
	@Override	//리스트화면에서 글쓰기 버튼을 눌렀을때 doget방식을 통해 write.jsp로 이동함!!!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/product/productwrite.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//브라우저에서 전송된 데이터 읽기
			
		
			String writer = req.getParameter("writer");
			String productName = req.getParameter("productname");
			String sproductPrice = req.getParameter("productprice");
			int productPrice = Integer.parseInt(sproductPrice);
			String productDesc = req.getParameter("productdesc");
		
			System.out.println(productPrice);
			
			//사용자의 요청 데이터를 Board 객체에 저장
			Product product = new Product();
			product.setPrdName(productName);
			product.setPrdPrice(productPrice);
			product.setPrdDesc(productDesc);

			System.out.println(product.getPrdPrice());
			
			//사용자 등록 처리
			ProductService productService = new ProductService();
			productService.writeProduct(product);

			resp.sendRedirect("/upgo/product/productlist.action");
	}
}
		