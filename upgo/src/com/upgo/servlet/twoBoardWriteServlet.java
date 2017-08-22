package com.upgo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.twoBoard;
import com.upgo.service.twoBoardService;

@WebServlet(value = "/twoboard/twowrite.action")
public class twoBoardWriteServlet extends HttpServlet {
	
	@Override	//리스트화면에서 글쓰기 버튼을 눌렀을때 doget방식을 통해 tbwrite.jsp로 이동함!!!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/twoboard/twowrite.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//브라우저에서 전송된 데이터 읽기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		//사용자의 요청 데이터를 Board 객체에 저장
		twoBoard twoBoard = new twoBoard();
		twoBoard.setTitle(title);
		twoBoard.setContent(content);
		twoBoard.setWriter(writer);
		//사용자 등록 처리
		twoBoardService boardService = new twoBoardService();
		boardService.writeBoard(twoBoard);

		resp.sendRedirect("/upgo/twoboard/twolist.action");
	}
	
}




