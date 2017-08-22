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
import com.upgo.service.twoBoardService;

@WebServlet(value = "/twoboard/twodelete.action")
public class twoBoardDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		//로그인 하지 않은 경우 로그인 화면으로 이동
//		HttpSession session = req.getSession();
//		if (session.getAttribute("loginuser") == null) {
//			resp.sendRedirect("/demoweb/account/login.action");
//			return;
//		}	
		
		//1. 요청 데이터(브라우저에서 전송한 데이터) 읽기 (boardno)
		//   - boardno가 비정상인 경우 list.action으로 이동
		String sBoardNo = req.getParameter("boardno");		
		int boardNo = -1;
		try {
			boardNo = Integer.parseInt(sBoardNo);
		} catch (Exception ex) {
			resp.sendRedirect("/upgo/twoboard/twolist.action");
			return;
		}
		
		//2. boardno로 데이터 삭제 (BoardService 사용)
		twoBoardService boardService = new twoBoardService();
		boardService.deleteBoard(boardNo);
		
		//3. list.action으로 이동
		//resp.sendRedirect("/demoweb/board/list.action");
		resp.sendRedirect("twolist.action");
	}
	
}
