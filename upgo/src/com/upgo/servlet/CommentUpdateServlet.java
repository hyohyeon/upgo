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
import com.upgo.dto.BoardComment;
import com.upgo.dto.Member;
import com.upgo.service.BoardService;
import com.upgo.service.MemberService;

@WebServlet(value = "/board/updatecomment.action")
public class CommentUpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		// 1. 요청 데이터 (브라우저에서 전송한 데이터) 읽기 
		String sCommentNo = req.getParameter("commentno");
		int commentNo = Integer.parseInt(sCommentNo);
		String sBoardNo = req.getParameter("boardno");
		String sPageNo = req.getParameter("pageno");
		String sContent = req.getParameter("content");

		// 2. commentno로 데이터 수정 (BoardService 사용)
		BoardComment comment = new BoardComment();
		comment.setCommentNo(commentNo);
		comment.setContent(sContent);
		BoardService boardSevice = new BoardService();
		boardSevice.updateComment(comment);
		
		// 3. list.action으로 이동
			resp.sendRedirect(String.format("detail.action?boardno=%s&pageno=%s", sBoardNo,sPageNo));
			
	}
}
