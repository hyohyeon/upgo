package com.upgo.service;

import java.util.ArrayList;
import java.util.List;

import com.upgo.dao.BoardDao;
import com.upgo.dao.MemberDao;
import com.upgo.dto.Board;
import com.upgo.dto.BoardAttach;
import com.upgo.dto.BoardComment;
import com.upgo.dto.Member;

public class BoardService {

	public int writeBoard(Board board) {
		// 처리해야할 내용이 있는 경우 구현 ...
		BoardDao boardDao = new BoardDao();
		int newBoardNo = boardDao.insertBoard(board);
		return newBoardNo;
	}

	public List<Board> findBoardList() {
		BoardDao boardDao = new BoardDao();
		List<Board> boards = boardDao.selectBoard();
		return boards;
	}

	public Board findBoardByBoardNo(int boardNo) {
		BoardDao boardDao = new BoardDao();
		Board board = boardDao.selectBoardByBoardNo(boardNo);
		ArrayList<BoardAttach> attachments = boardDao.selectBoardAttachByBoardNo(boardNo);
		board.setAttachments(attachments);
		ArrayList<BoardComment> comments = boardDao.selectCommentByBoardNo(boardNo);
		board.setComments(comments);
		return board;
	}

	public void updateBoard(Board board) {
		BoardDao boardDao = new BoardDao();
		boardDao.updateBoard(board);
	}

	public void deleteBoard(int boardNo) {
		BoardDao boardDao = new BoardDao();
		boardDao.deleteBoard(boardNo);
	}

	public static void increaseRedCount(int boardNo) {
		BoardDao boardDao = new BoardDao();
		boardDao.updateReadCount(boardNo);
	}

	public void replyBoard(Board board) {
		BoardDao boardDao = new BoardDao();
		Board parent = boardDao.selectBoardByBoardNo(board.getBoardNo()); // 원
																			// 글의
																			// 정보
																			// 조회
		// 같은 그룹에 포함되 기존 글의 순서번호 (step) 증가
		boardDao.updateStep(parent.getGroupNo(), parent.getStep());
		board.setGroupNo(parent.getGroupNo());
		board.setStep(parent.getStep() + 1);
		board.setDepth(parent.getDepth() + 1);
		boardDao.insertReply(board);

	}

	public List<Board> findBoardList(int first, int last) {
		BoardDao dao = new BoardDao();
		List<Board> boards = dao.selectBoardList2(first, last);
		return boards;
	}

	public int getBoardCount() {
		BoardDao dao = new BoardDao();
		int count = dao.getBoardCount();
		return count;
	}

	public void saveBoardAttach(BoardAttach attachment) {
		BoardDao dao = new BoardDao();
		dao.insertBoardAttach(attachment);
	}

	public BoardAttach findBoardAttachByAttachNo(int attachNo) {
		BoardDao dao = new BoardDao();
		BoardAttach attachment = dao.selectBoardAttachByAttachNo(attachNo);
		return attachment;
	}

	public void writeComment(BoardComment comment) {
		BoardDao dao = new BoardDao();
		dao.insertComment(comment);
	}

	public void deleteComment(int commentNo) {
		BoardDao dao = new BoardDao();
		dao.deleteComment(commentNo);

	}

	public void updateComment(BoardComment comment) {
		BoardDao dao = new BoardDao();
		dao.updateComment(comment);

	}
}
