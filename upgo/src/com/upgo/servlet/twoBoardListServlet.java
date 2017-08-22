package com.upgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.twoBoard;
import com.upgo.service.twoBoardService;
import com.upgo.ui.ThePager;

@WebServlet(value= "/twoboard/twolist.action")
public class twoBoardListServlet extends HttpServlet {
	
	//list.jsp 로 이동
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageSize = 3; // 페이지를 얼마씩 짜를지 설정
		int pagerSize= 5; // 링크의 갯수
		int boardCount = 0;
		String linkUrl = "twolist.action";
		
		String page = req.getParameter("pageno");
		int currentPage = 1; // 요청된 페이지가 없을때 사용할 번호
		try {
			currentPage = Integer.parseInt(page); // 요청된 페이지 번호
		} catch (Exception ex) {
		}
		
		int first = (currentPage - 1) * pageSize + 1; // 페이지 번호를 기준으로 시작번호 가져오기
		int last = first + pageSize;
		
		//데이터 처리 (게시판 목록 조회)
		twoBoardService twoBoardService = new twoBoardService();
		List<twoBoard> twoBoards = twoBoardService.findBoardList(first, last);
		
		for (twoBoard board : twoBoards) {
			String imgPath = extractImagePathFromContent(board.getContent());
			if (imgPath == null) {
				imgPath = "/upgo/img/noimage.jpg";
			}
			board.setContent(imgPath);
		}
		
		boardCount = twoBoardService.gettwoBoardCount();
		ThePager pager = new ThePager(boardCount, currentPage, pageSize, pagerSize, linkUrl);

		//JSP에서 사용할 수있도록 REQUEST 객체에 조회된 데이터 저장
		req.setAttribute("twoboards", twoBoards);
		req.setAttribute("pager", pager);
		req.setAttribute("pageno", currentPage);
		
		//tblist.jsp로 이동
		RequestDispatcher dispatcher = 
			req.getRequestDispatcher("/WEB-INF/views/twoboard/twolist.jsp");
		dispatcher.forward(req,resp);
	}
	
	String extractImagePathFromContent(String content) {
		
		int from = content.indexOf("<img");
		if (from == -1) {
			return null;
		}
		int to = content.indexOf(">", from);
		String imgTagString = content.substring(from, to + 1);// <img alt='lhsl' src=';asldka;slkd' >
		
		imgTagString = imgTagString.toLowerCase().replace("\"", "'");
		
		from = imgTagString.indexOf("src");
		if (from == -1) {
			return null;
		}
		from = imgTagString.indexOf("'", from);
		to = imgTagString.indexOf("'", from + 1);
		
		String imgPath = imgTagString.substring(from + 1, to);
				
		
		return imgPath;
	}


}