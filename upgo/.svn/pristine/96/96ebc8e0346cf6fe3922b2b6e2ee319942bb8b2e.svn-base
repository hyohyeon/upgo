package com.upgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.upgo.dto.TBoard;
import com.upgo.dto.TBoardComment;

public class TBoardDao {

	public int insertBoard(TBoard TBoard) {
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
			String sql = "INSERT INTO TRAVELBOARD (TBRD_NO, TBRD_TITLE, C_ID, TBRD_CONTENT, TBRD_GROUP, TBRD_STEP)"
					+ "VALUES(travelboard_sequence.nextval,?,?,?,travelboard_sequence.currval, 1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TBoard.getTitle());
			pstmt.setString(2, TBoard.getWriter());
			pstmt.setString(3, TBoard.getContent());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드

			// 위에서 insert된 글의 글번호 조회 ----------------------------> 글번호를 알기위해서
			// 설정한 곳
			sql = "SELECT TRAVELBOARD_sequence.currval FROM DUAL"; // 마지막으로
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

	public List<TBoard> selectBoardList(int first, int last, HashMap<String, Object> listopt) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TBoard> tboards = new ArrayList<TBoard>();
		String opt = (String)listopt.get("opt");
		String searchflag = (String)listopt.get("searchflag");

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
				sql.append("	SELECT ");
				sql.append("		rownum idx, s.* ");
				sql.append("	FROM ");

				sql.append("	( ");
				sql.append("		SELECT ");
				sql.append("			TBRD_NO, TBRD_TITLE, C_ID, ");
				sql.append("			TBRD_REGDATE, TBRD_READCOUNT, ");
				sql.append("			TBRD_DELETED, TBRD_GROUP, TBRD_STEP, TBRD_DEPTH, TBRD_CONTENT ");
				sql.append("		FROM ");
				sql.append("			TRAVELBOARD ");
				
				if (opt == null) { //옵션이 null값이면 기본값
				}else if (opt.equals("0")){
					sql.append("        WHERE ");
					sql.append("            UPPER(TBRD_TITLE) LIKE UPPER(?) ");
				}else if (opt.equals("1")){
					sql.append("        WHERE ");
					sql.append("            UPPER(TBRD_CONTENT) LIKE ? ");	
					}else if (opt.equals("2")){
					sql.append("        WHERE ");
					sql.append("            UPPER(TBRD_TITLE) LIKE UPPER(?) OR UPPER(TBRD_CONTENT) LIKE UPPER(?) ");
					}else if (opt.equals("3")){
					sql.append("        WHERE ");
					sql.append("            UPPER(C_ID) LIKE UPPER(?) ");}
				sql.append("		ORDER BY TBRD_GROUP DESC, TBRD_STEP ASC ");
				sql.append("	) s ");

				sql.append(") ");

				sql.append("WHERE idx >= ? AND idx < ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				if (opt == null){
					pstmt.setInt(1, first);
					pstmt.setInt(2, last);
					
				}else if(opt.equals("0") || opt.equals("1") || opt.equals("3")){
					pstmt.setString(1, "%" + searchflag + "%");
					pstmt.setInt(2, first);
					pstmt.setInt(3, last);	
				}else{
					pstmt.setString(1, "%" + searchflag + "%");
					pstmt.setString(2, "%" + searchflag + "%");
					pstmt.setInt(3, first);
					pstmt.setInt(4, last);
				}
				
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TBoard tboard = new TBoard();
				tboard.setBoardNo(rs.getInt(2));
				tboard.setTitle(rs.getString(3));
				tboard.setWriter(rs.getString(4));
				tboard.setRegDate(rs.getDate(5));
				tboard.setReadCount(rs.getInt(6));
				tboard.setDeleted(rs.getBoolean(7));
				tboard.setGroupNo(rs.getInt(8));
				tboard.setStep(rs.getInt(9));
				tboard.setDepth(rs.getInt(10));
				tboard.setContent(rs.getString(11));

				tboards.add(tboard);
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

		return tboards;
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

	public TBoard selectBoardByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TBoard tboard = null;// 조회된 데이터를 저장할 DTO 변수

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT TBRD_NO, TBRD_TITLE, C_ID, TBRD_REGDATE, TBRD_READCOUNT, TBRD_GROUP, TBRD_STEP, TBRD_DEPTH, TBRD_CONTENT "
					+ "FROM TRAVELBOARD " + "WHERE TBRD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			// 4. 명령 실행
			rs = pstmt.executeQuery();// select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				tboard = new TBoard();
				tboard.setBoardNo(rs.getInt(1));
				tboard.setTitle(rs.getString(2));
				tboard.setWriter(rs.getString(3));
				tboard.setRegDate(rs.getDate(4));
				tboard.setReadCount(rs.getInt(5));
				tboard.setGroupNo(rs.getInt(6));
				tboard.setStep(rs.getInt(7));
				tboard.setDepth(rs.getInt(8));
				tboard.setContent(rs.getString(9));
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

		return tboard;// 조회 성공하면 Board 아니면 null
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
			String sql = "UPDATE TRAVELBOARD " + "SET TBRD_READCOUNT = TBRD_READCOUNT + 1 " + "WHERE TBRD_NO = ?";
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

	public void updateBoard(TBoard tboard) {// 게시글 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE TRAVELBOARD " + "SET TBRD_TITLE = ?, TBRD_CONTENT = ? " + "WHERE TBRD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tboard.getTitle());
			pstmt.setString(2, tboard.getContent());
			pstmt.setInt(3, tboard.getBoardNo());
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
			String sql = "UPDATE TRAVELBOARD " + "SET TBRD_DELETED = '1' " + "WHERE TBRD_GROUP = ?";
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
	public void insertComment(TBoardComment comment) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보

			String sql = "INSERT INTO TRAVELBOARDCOMMENT " + "(TBC_NO, TBRD_NO, C_ID, TBC_CONTENT) "
					+ "VALUES (TRAVELBOARDCOMMENT_sequence.nextVal, ?, ?, ?)";
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

	public ArrayList<TBoardComment> selectCommentByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TBoardComment> comments = new ArrayList<>();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			String sql = "SELECT TBC_NO, TBRD_NO, C_ID, TBC_CONTENT, TBC_REGDATE "
					+ "FROM TRAVELBOARDCOMMENT WHERE TBRD_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TBoardComment comment = new TBoardComment();
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

			String sql = "DELETE FROM TRAVELBOARDCOMMENT " + "WHERE TBC_NO = ?";
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

	public void updateComment(TBoardComment comment) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보

			String sql = "UPDATE TRAVELBOARDCOMMENT " + "SET TBC_CONTENT = ?" + "WHERE TBC_NO = ?";
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

	public ArrayList<TBoard> getBoardlist(String keyField, String keyWord) {

		ArrayList<TBoard> list = new ArrayList<TBoard>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보

			String sql = "select * from travelboard ";

			if (keyWord != null && !keyWord.equals("")) {
				sql += "WHERE " + keyField.trim() + " LIKE '%" + keyWord.trim() + "%' order by c_id";
			} else {// 모든 레코드 검색
				sql += "order by c_id";
			}
			System.out.println("sql = " + sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("sql = " + sql);

			while (rs.next()) {
				TBoard tboard = new TBoard();

				tboard.setBoardNo(rs.getInt(1));
				tboard.setContent(rs.getString(2));
				tboard.setWriter(rs.getString(3));
				tboard.setTitle(rs.getString(4));

				list.add(tboard);
			}
		} catch (Exception e) {
			System.out.println(e + "=> getMemberlist fail");
		} finally {

		}
		return list;
	}
}
