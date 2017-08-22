package com.upgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.upgo.dto.Board;
import com.upgo.dto.BoardAttach;
import com.upgo.dto.BoardComment;
import com.upgo.dto.Member;

public class BoardDao {

	public int insertBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null; // for insert
		PreparedStatement pstmt2 = null;// for select
		ResultSet rs = null;
		int newBoardNo = -1;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO board (boardno, title, writer, content, groupno, step)"
					+ "VALUES(board_sequence.nextval,?,?,?,board_sequence.currval ,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드

			// 위에서 insert된 글의 글번호 조회 ----------------------------> 글번호를 알기위해서 설정한 곳
			
			sql = "SELECT board_sequence.currval FROM DUAL"; // 마지막으로 호출된
																// nextval의 값을
																// 조회
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			rs.next();
			newBoardNo = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				pstmt2.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

		return newBoardNo;
	}

	public List<Board> selectBoard() {// 게시판 목록 띄우기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Board> boards = new ArrayList<>();
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT boardno, title, writer, regdate, readcount, deleted, groupno, step, depth "
					+ "FROM board " + "ORDER BY groupno DESC, step ASC";
			pstmt = conn.prepareStatement(sql);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setReadCount(rs.getInt(5));
				board.setDeleted(rs.getBoolean(6));
				board.setGroupNo(rs.getInt(7));
				board.setStep(rs.getInt(8));
				board.setDepth(rs.getInt(9));
				boards.add(board); // 각 게시글 데이터를 목록에 추가
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}

		}
		return boards;// 조회성공하면 목록 아니면 count가 0
	}

	public Board selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;// 조회된 데이터를 저장할 DTO 변수(단일 데이터라 null)

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT boardno, title, writer, regdate, readcount, groupno, step, depth, content "
					+ "FROM board " + "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setRegDate(rs.getDate(4));
				board.setReadCount(rs.getInt(5));
				board.setGroupNo(rs.getInt(6));
				board.setStep(rs.getInt(7));
				board.setDepth(rs.getInt(8));
				board.setContent(rs.getString(9));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}

		}
		return board;// 조회성공하면 목록 아니면 board, 아니면 null
	}

	public void updateBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board " + "SET title = ?, content = ? " + "WHERE boardno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public void deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board " + "SET deleted = '1' " + "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql); // 오라클에는 true false 가 없기에, 캐릭터
												// 사이즈를 1= true, 0 = false 로 대체
			pstmt.setInt(1, boardNo);

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public void updateReadCount(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board " + "SET readcount  = readcount + 1 " + "WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql); // 오라클에는 true false 가 없기에, 캐릭터
												// 사이즈를 1= true, 0 = false 로 대체
			pstmt.setInt(1, boardNo);

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}

	public void insertReply(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO board (boardno, title, writer, content, groupno, step, depth) "
					+ "VALUES(board_sequence.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getGroupNo());
			pstmt.setInt(5, board.getStep());
			pstmt.setInt(6, board.getDepth());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public void updateStep(int groupNo, int step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE board " + "SET step  = step + 1 " + "WHERE groupno = ? and step > ?";
			pstmt = conn.prepareStatement(sql); // 오라클에는 true false 가 없기에, 캐릭터
												// 사이즈를 1= true, 0 = false 로 대체
			pstmt.setInt(1, groupNo);
			pstmt.setInt(2, step);

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// 6. 연결 종료
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}
	
	
	
	public List<Board> selectBoardList2(int first, int last) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> boards = new ArrayList<Board>();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");

			sql.append("( ");
			sql.append("   SELECT ");
			sql.append("      rownum idx, s.* ");
			sql.append("   FROM ");

			sql.append("   ( ");
			sql.append("      SELECT ");
			sql.append("         boardno, title, writer, ");
			sql.append("         regdate, readcount, ");
			sql.append("         deleted, groupno, step, depth ");
			sql.append("      FROM ");
			sql.append("         board ");
			// sql.append(" WHERE ");
			// sql.append(" deleted = '0' ");
			sql.append("      ORDER BY groupno DESC, step ASC ");
			sql.append("   ) s ");

			sql.append(") ");

			sql.append("WHERE idx >= ? AND idx < ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt(2));
				board.setTitle(rs.getString(3));
				board.setWriter(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setReadCount(rs.getInt(6));
				board.setDeleted(rs.getBoolean(7));
				board.setGroupNo(rs.getInt(8));
				board.setStep(rs.getInt(9));
				board.setDepth(rs.getInt(10));

				boards.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception ex) {
				}
		}

		return boards;
	}

	public int getBoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);

		} catch (Exception ex) {
			count = 0;
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
		return count;
	}

	//////////////////////////////////////////////////////////////////

	public void insertBoardAttach(BoardAttach attach) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보
			String sql = "INSERT INTO boardattach " + "(attachno, boardno, savedfilename, userfilename) "
					+ "VALUES (boardattach_sequence.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attach.getBoardNo());
			pstmt.setString(2, attach.getSavedFileName());
			pstmt.setString(3, attach.getUserFileName());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}

	public ArrayList<BoardAttach> selectBoardAttachByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardAttach> attachments = new ArrayList<BoardAttach>();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보
			String sql = "SELECT attachno, boardno, savedfilename, userfilename "
					+ "FROM boardattach WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardAttach attachment = new BoardAttach();
				attachment.setAttachNo(rs.getInt(1));
				attachment.setBoardNo(rs.getInt(2));
				attachment.setSavedFileName(rs.getString(3));
				attachment.setUserFileName(rs.getString(4));
				attachments.add(attachment);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		return attachments;

	}

	public BoardAttach selectBoardAttachByAttachNo(int attachNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardAttach attachment = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보
			String sql = "SELECT attachno, boardno, savedfilename, userfilename "
					+ "FROM boardattach WHERE attachno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, attachNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				attachment = new BoardAttach();
				attachment.setAttachNo(rs.getInt(1));
				attachment.setBoardNo(rs.getInt(2));
				attachment.setSavedFileName(rs.getString(3));
				attachment.setUserFileName(rs.getString(4));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception ex) {
			}
			try {
				pstmt.close();
			} catch (Exception ex) {
			}
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		return attachment;

	}

	/////////////////////////////////////////////////////////////////

	public void insertComment(BoardComment comment) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보
			String sql = "INSERT INTO boardcomment " + "(commentno, boardno, writer, content) "
					+ "VALUES (boardcomment_sequence.nextVal, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setString(2, comment.getWriter());
			pstmt.setString(3, comment.getContent());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception ex) {
				}
		}
	}

	public void updateComment(BoardComment comment) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보

			String sql = "UPDATE boardcomment " + "SET content = ?" + "WHERE commentno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCommentNo());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception ex) {
				}
		}
	}

	public void deleteComment(int commentNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77");// 계정정보

			String sql = "DELETE FROM boardcomment " + "WHERE commentno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception ex) {
				}
		}
	}
	
	public ArrayList<BoardComment> selectCommentByBoardNo(int boardNo) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<BoardComment> comments = new ArrayList<>();
	
	try {
		//1. Driver 등록
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 연결 만들기
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결대상 
				"upgo", "knit77");//계정정보
		String sql = 
			"SELECT commentno, boardno, writer, content, regdate " + 
			"FROM boardcomment WHERE boardno = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardNo);
		rs = pstmt.executeQuery();
			
		while (rs.next()) {
			BoardComment comment = new BoardComment();
			comment.setCommentNo(rs.getInt(1));
			comment.setBoardNo(rs.getInt(2));
			comment.setWriter(rs.getString(3));
			comment.setContent(rs.getString(4));
			comment.setRegDate(rs.getDate(5));
			comments.add(comment);
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		try { rs.close(); } catch (Exception ex) {}
		try { pstmt.close(); } catch (Exception ex) {}
		try { conn.close(); } catch (Exception ex) {}
	}
	return comments;
}

}
