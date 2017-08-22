package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.common.Util;
import com.upgo.dto.Board;
import com.upgo.dto.Member;
import com.upgo.service.BoardService;
import com.upgo.service.MemberService;

@WebServlet(value = "/board/reply.action")
public class BoardReplyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*//로그인 하지 않은 경우 로그인 화면으로 이동
		HttpSession session = req.getSession();
		if (session.getAttribute("loginuser") == null) {
			resp.sendRedirect("/upgo/account/login.action");
			return;
		} --> 다음 인증코드는 필터로 구현함 그래서 주석으로 겁니다.*/
	
		
		// 요청데이터 (브라우저에서 전송한 데이터) 읽기 , -boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");

		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception e) {
			resp.sendRedirect("/upgo/board/list.action");
			return;
		}
		
		req.setAttribute("boardno", boardNo);
		
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/board/reply.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		  //브라우저에서 전송된 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String title = req.getParameter("title");
		String writer = req.getParameter("writer"); //방법 2
		
		String content = req.getParameter("content");
		
		//사용자의 요청 데이터를 Board 객체에 저장
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		//사용자 등록 처리
		BoardService boardService = new BoardService();
		boardService.replyBoard(board);

		resp.sendRedirect("/upgo/board/list.action");
	}
	
}