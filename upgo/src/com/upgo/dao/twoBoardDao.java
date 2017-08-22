package com.upgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.upgo.dto.twoBoard;
import com.upgo.dto.twoBoardComment;

public class twoBoardDao {

	public int insertBoard(twoBoard twoBoard) {
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
			pstmt.setString(1, twoBoard.getTitle());
			pstmt.setString(2, twoBoard.getWriter());
			pstmt.setString(3, twoBoard.getContent());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드

			// 위에서 insert된 글의 글번호 조회 ----------------------------> 글번호를 알기위해서
			// 설정한 곳
			sql = "SELECT board_sequence.currval FROM DUAL"; // 마지막으로
																	// 호출된//
																	// nextval의
																	// 값을// 조회
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

	public List<twoBoard> selectBoardList(int first, int last) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<twoBoard> twoBoards = new ArrayList<twoBoard>();

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
				twoBoard twoboard = new twoBoard();
				twoboard.setBoardNo(rs.getInt(2));
				twoboard.setTitle(rs.getString(3));
				twoboard.setWriter(rs.getString(4));
				twoboard.setRegDate(rs.getDate(5));
				twoboard.setReadCount(rs.getInt(6));
				twoboard.setDeleted(rs.getBoolean(7));
				twoboard.setGroupNo(rs.getInt(8));
				twoboard.setStep(rs.getInt(9));
				twoboard.setDepth(rs.getInt(10));
				twoboard.setContent(rs.getString(11));

				twoBoards.add(twoboard);
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

		return twoBoards;
	}

	public int getTBoardCount() {

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
			String sql = "SELECT COUNT(*) FROM TRAVELBOARD";
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

	public twoBoard selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		twoBoard twoboard = null;// 조회된 데이터를 저장할 DTO 변수

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
			rs = pstmt.executeQuery();// select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				twoboard = new twoBoard();
				twoboard.setBoardNo(rs.getInt(1));
				twoboard.setTitle(rs.getString(2));
				twoboard.setWriter(rs.getString(3));
				twoboard.setRegDate(rs.getDate(4));
				twoboard.setReadCount(rs.getInt(5));
				twoboard.setGroupNo(rs.getInt(6));
				twoboard.setStep(rs.getInt(7));
				twoboard.setDepth(rs.getInt(8));
				twoboard.setContent(rs.getString(9));
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

		return twoboard;// 조회 성공하면 Board 아니면 null
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			// 4. 명령 실행
			pstmt.executeUpdate();// insert, update, delete 구문 실행 메서드
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

	public void updateBoard(twoBoard twoboard) {// 게시글 수정
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
			pstmt.setString(1, twoboard.getTitle());
			pstmt.setString(2, twoboard.getContent());
			pstmt.setInt(3, twoboard.getBoardNo());
			// 4. 명령 실행
			pstmt.executeUpdate();// insert, update, delete 구문 실행 메서드
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			// 4. 명령 실행
			pstmt.executeUpdate();// insert, update, delete 구문 실행 메서드
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

	//////////////////// 게시판 디테일내 코멘트(리플)//////////////////////////////
	public void insertComment(twoBoardComment comment) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보

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

	public ArrayList<twoBoardComment> selectCommentByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<twoBoardComment> comments = new ArrayList<>();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			String sql = 
					"SELECT commentno, boardno, writer, content, regdate " + 
					"FROM boardcomment WHERE boardno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				twoBoardComment comment = new twoBoardComment();
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
		return comments;
	}

	public void deleteComment(int commentNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보

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

	public void updateComment(twoBoardComment comment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			
			String sql = "UPDATE boardcomment " + "SET content = ?" + "WHERE commentno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCommentNo());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}

	
	
	 
	    
}
