package com.upgo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.upgo.dao.TBoardDao;
import com.upgo.dto.TBoard;
import com.upgo.dto.TBoardComment;

public class TBoardService {

	public int writeBoard(TBoard board) {
		// 처리해야할 내용이 있는 경우 구현 ...
		TBoardDao boardDao = new TBoardDao();
		int newBoardNo = boardDao.insertBoard(board);
		return newBoardNo;

	}

	public List<TBoard> findBoardList(int first, int last, HashMap<String, Object> listopt) {
		TBoardDao dao = new TBoardDao();
		List<TBoard> TBoards = dao.selectBoardList(first, last, listopt);
		return TBoards;
	}

	public int getTBoardCount() {
		TBoardDao dao = new TBoardDao();
		int count = dao.getTBoardCount();
		return count;
	}

	public TBoard findBoardByBoardNo(int boardNo) {
		TBoardDao boardDao = new TBoardDao();
		TBoard tboard = boardDao.selectBoardByBoardNo(boardNo);
		ArrayList<TBoardComment> comments = 
		boardDao.selectCommentByBoardNo(boardNo);
		tboard.setComments(comments);
		return tboard;
	}

	public void increaseReadCount(int boardNo) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.updateReadCount(boardNo);

	}

	public void updateBoard(TBoard tboard) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.updateBoard(tboard);

	}

	public void deleteBoard(int boardNo) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.deleteBoard(boardNo);
	}

	public void writeComment(TBoardComment comment) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.insertComment(comment);
	}

	public void deleteComment(int commentNo) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.deleteComment(commentNo);
		
	}

	public void updateComment(TBoardComment comment) {
		TBoardDao boardDao = new TBoardDao();
		boardDao.updateComment(comment);
		
	}
	

}
