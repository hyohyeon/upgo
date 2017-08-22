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

@WebServlet(value = "/board/delete.action")
public class BoardDeleteServlet extends HttpServlet {

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

		// 2. boardno로 데이터 삭제 (BoardService 사용)
		BoardService boardSevice = new BoardService();
		boardSevice.deleteBoard(boardNo);
		
		
		// 3. list.action으로 이동
			resp.sendRedirect("list.action");

	}
}
