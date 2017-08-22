package com.upgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.service.TBoardService;

@WebServlet(value = "/board2/deletecomment.action")
public class TBcommentDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//요청 데이터(브라우저에서 전송한 데이터) 읽기
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");		
		//commentno로 데이터 삭제 (BoardService 사용)
		TBoardService boardService = new TBoardService();
		boardService.deleteComment(commentNo);		
		//3. detail.action으로 이동
		resp.sendRedirect(String.format(
			"tbdetail.action?boardno=%s&pageno=%s", 
			sBoardNo, sPageNo));
	}
	
}
