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
import javax.xml.soap.Detail;

import com.upgo.common.Util;
import com.upgo.dto.Board;
import com.upgo.dto.Member;
import com.upgo.service.BoardService;
import com.upgo.service.MemberService;

@WebServlet(value = "/board/update.action")
public class BoardUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
		//로그인 하지 않은 경우 로그인 화면으로 이동
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/upgo/account/login.action");
			return;
		}		*/
		
		// 1. 요청 데이터 (브라우저에서 전송한 데이터) 읽기 (boardno)
		String sBoardNo = req.getParameter("boardno");

		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception e) {
			resp.sendRedirect("/upgo/board/list.action");
			return;
		}

		// 2. boardno로 데이터 조회 (BoardService 사용)
		BoardService boardSevice = new BoardService();
		Board board = boardSevice.findBoardByBoardNo(boardNo);
		if (board == null){
			resp.sendRedirect("/upgo/board/list.action");
			return;
		}
		// 현재 페이지 번호 읽기
		 String page = req.getParameter("pageno");
			int currentPage = 1; // 요청된 페이지 번호가 없을 때 사용할 번호
			try {
				currentPage = Integer.parseInt(page); // 요헝된 페이지 번호
			} catch (Exception ex) {
			}
		
		// 3. 조회결과를 request 객체에 저장 (JSP에서 사용하도록)
		req.setAttribute("board", board);
		req.setAttribute("pageno", currentPage);

		// 4. detail.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		  //브라우저에서 전송된 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String title = req.getParameter("title"); //방법 2
		String content = req.getParameter("content");
		//사용자의 요청 데이터를 Board 객체에 저장
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		
		//사용자 수정 처리
		BoardService boardService = new BoardService();	
		boardService.updateBoard(board);

		resp.sendRedirect("/upgo/board/list.action?boardno=" + boardNo);
		
	}	
}

