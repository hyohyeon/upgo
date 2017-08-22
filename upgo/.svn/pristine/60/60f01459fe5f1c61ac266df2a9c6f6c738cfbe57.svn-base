package com.upgo.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.BoardComment;
import com.upgo.dto.Member;
import com.upgo.service.BoardService;

@WebServlet(value = "/board/writecomment.action")
public class CommentWriteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		// 브라우저에서 전송된 요청 데이터 읽기
		String sBoardNo = req.getParameter("boardno");
		int boardNo = Integer.parseInt(sBoardNo);
		String sPageNo = req.getParameter("pageno");
		int pageNo = Integer.parseInt(sPageNo);
		String content = req.getParameter("content");

		// 데이터베이스에 데이터 저장
		BoardComment comment = new BoardComment();
		comment.setBoardNo(boardNo);
		comment.setContent(content);
		Member member = (Member)req.getSession().getAttribute("loginuser");
		comment.setWriter(member.getMemberId());
		
		BoardService sevice = new BoardService();
		sevice.writeComment(comment);
		

		// 이동
		resp.sendRedirect(String.format("detail.action?boardno=%s&pageno=%s", sBoardNo, sPageNo));
	}
}
