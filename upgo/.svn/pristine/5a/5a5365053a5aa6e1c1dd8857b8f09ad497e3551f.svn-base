package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.BoardComment;
import com.upgo.service.BoardService;

@WebServlet(value= "/home.action")

public class HomeServlet extends HttpServlet {
   
	  @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   //회원가입 화면 응답
	   resp.setContentType("text/html;charset=utf-8");
	   PrintWriter out = resp.getWriter();
	   		//home으로 이동
	   
	 		RequestDispatcher dispatcher =
	 				req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			dispatcher.forward(req, resp);
	   
   }
}
  