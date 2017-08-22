package com.upgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.twoBoardComment;
import com.upgo.service.twoBoardService;

@WebServlet(value = "/twoboard/twoupdatecomment.action")
public class twocommentUpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		
		//요청 데이터(브라우저에서 전송한 데이터) 읽기
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");
		String sContent = req.getParameter("content");
		
		//commentno로 데이터 수정 (BoardService 사용)
		twoBoardComment comment = new twoBoardComment();
		comment.setCommentNo(commentNo);
		comment.setContent(sContent);
		twoBoardService boardService = new twoBoardService();
		boardService.updateComment(comment);		
		
		//3. detail.action으로 이동
		resp.sendRedirect(String.format(
				"twodetail.action?boardno=%s&pageno=%s", 
				sBoardNo, sPageNo));
	}
	
}
