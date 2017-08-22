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
import com.upgo.dto.Product;
import com.upgo.service.BoardService;
import com.upgo.service.ProductService;

@WebServlet(value= "/product/productupdate.action")
public class ProductUpdateServlet extends HttpServlet {
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //1. 요청 데이터 읽기= 브라우저에서 전송한 데이터 읽기(boardno)
      // - boardno가 비정상인 경우 list.action 으로 이동
      String sPrdNo = req.getParameter("productno");
      int prdNo = -1;
      try {
         prdNo = Integer.parseInt(sPrdNo);
      } catch (Exception ex) {
         resp.sendRedirect("/upgo/product/productlist.action");
         return;
      }
      //2. prdno 로 데이터 조회(ProductService 사용)
      // 조회가 실패하면(결과가 null) productlist.action 으로 이동
      ProductService productService = new ProductService();
      Product product = productService.findProductByProductNo(prdNo);
      if (product == null) {
         resp.sendRedirect("/upgo/product/productlist.action");
         return;
      }
      // 현재페이지 번호 읽기
            String page = req.getParameter("pageno");
            int currentPage = 1; // 요청된 페이지가 없을때 사용할 번호
            try {
               currentPage = Integer.parseInt(page); // 요청된 페이지 번호
            } catch (Exception ex) {
               
         }
      //3. 조회 결과를 request 객체에 저장(jsp 에서 사용하기 위해)
      req.setAttribute("product", product);
      req.setAttribute("pageno", currentPage);

      //4. productdetail.jsp 으로 이동
      
      RequestDispatcher dispatcher = 
         req.getRequestDispatcher("/WEB-INF/views/product/productedit.jsp");
         dispatcher.forward(req,resp);

   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");
      //브라우저에서 전송된 데이터 읽기
      String sProductNo = req.getParameter("productno");
      int productNo = Integer.parseInt(sProductNo);
      String name= req.getParameter("name"); 
      String desc= req.getParameter("desc"); 
      String sPrice = req.getParameter("price");
      int price = Integer.parseInt(sPrice);
      
   //관리자의 요청데이터를 product 객체에 저장하는 작업
      Product product = new Product();
      product.setPrdNo(productNo);
      product.setPrdName(name);
      product.setPrdDesc(desc);
      product.setPrdPrice(price);

   //사용자 수정 처리
   ProductService productService = new ProductService();
   productService.updateProduct(product);

   
   resp.sendRedirect("/upgo/product/productlist.action?productno=" + productNo);
   
   }
   
}