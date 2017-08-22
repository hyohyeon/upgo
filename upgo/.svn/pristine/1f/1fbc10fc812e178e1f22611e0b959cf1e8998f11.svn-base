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
import com.upgo.ui.ThePager;

@WebServlet(value = "/board/list.action")
public class BoardListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int pageSize = 10; //페이지게시판이 출력하는값 글의수를 바뀌게 해준다
		int pagerSize = 3; //밑에 페이지 버튼수 
		int boardCount = 0;
		String linkUrl = "list.action";
		
		String page = req.getParameter("pageno");
		int currentPage = 1; // 요청된 페이지 번호가 없을 때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); // 요헝된 페이지 번호
		} catch (Exception ex) {}

		int first = (currentPage - 1) * pageSize + 1;
		int last = first + pageSize ;

		// 데이터 처리 ( 게시판 글 목록 조회)
		BoardService boardService = new BoardService();
		List<Board> boards = boardService.findBoardList(first,last);
		
		boardCount = boardService.getBoardCount();
		ThePager pager = new ThePager(boardCount, currentPage, pageSize, pagerSize, linkUrl);
		
		//JSP에서 사용할 수 있도록 request객체에 조회된 데이터 저장
		req.setAttribute("boards", boards);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		
		//list.jsp로 이동
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}
}
