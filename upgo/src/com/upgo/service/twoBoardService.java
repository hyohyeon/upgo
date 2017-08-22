package com.upgo.service;

import java.util.ArrayList;
import java.util.List;

import com.upgo.dao.twoBoardDao;
import com.upgo.dto.twoBoard;
import com.upgo.dto.twoBoardComment;

public class twoBoardService {

	public int writeBoard(twoBoard board) {
		// 처리해야할 내용이 있는 경우 구현 ...
		twoBoardDao boardDao = new twoBoardDao();
		int newBoardNo = boardDao.insertBoard(board);
		return newBoardNo;

	}

	public List<twoBoard> findBoardList(int first, int last) {
		twoBoardDao dao = new twoBoardDao();
		List<twoBoard> twoBoards = dao.selectBoardList(first, last); 
		return twoBoards;
	}

	public int gettwoBoardCount() {
		twoBoardDao dao = new twoBoardDao();
		int count = dao.getTBoardCount();
		return count;
	}

	public twoBoard findBoardByBoardNo(int boardNo) {
		twoBoardDao boardDao = new twoBoardDao();
		twoBoard tboard = boardDao.selectBoardByBoardNo(boardNo);
		ArrayList<twoBoardComment> comments = 
		boardDao.selectCommentByBoardNo(boardNo);
		tboard.setComments(comments);
		return tboard;
	}

	public void increaseReadCount(int boardNo) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.updateReadCount(boardNo);

	}

	public void updateBoard(twoBoard twoboard) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.updateBoard(twoboard);

	}

	public void deleteBoard(int boardNo) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.deleteBoard(boardNo);
	}

	public void writeComment(twoBoardComment comment) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.insertComment(comment);
	}

	public void deleteComment(int commentNo) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.deleteComment(commentNo);
		
	}

	public void updateComment(twoBoardComment comment) {
		twoBoardDao boardDao = new twoBoardDao();
		boardDao.updateComment(comment);
		
	}
	

}
