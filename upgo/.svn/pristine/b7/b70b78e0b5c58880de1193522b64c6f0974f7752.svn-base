package com.upgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.upgo.dto.Member;

public class MemberDao {
	
private static MemberDao instance;
    
    // 싱글톤 패턴
	public MemberDao(){}
    public static MemberDao getInstance(){
        if(instance==null)
            instance=new MemberDao();
        return instance;
    }
    
    
    public boolean duplicateIdCheck(String id)
    {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean x= false;
        
        try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결 대상
					"upgo", "knit77"); //계정 정보
			//conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT C_ID FROM customer WHERE C_ID=?";
         
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            
            rs = pstm.executeQuery();
            
            if(rs.next()) x= true; //해당 아이디 존재
            
            return x;
            
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstm != null ){ pstm.close(); pstm=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end duplicateIdCheck()
    





	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결 대상
					"upgo", "knit77"); //계정 정보
			//conn = ConnectionHelper.getConnection("oracle"); //이 한 줄만 써도 됨
		
			//3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO customer (C_ID, C_PASSWD, C_EMAIL, C_NAME, C_PHONE, C_GENDER, C_ADDRESS ) " +
						 "VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getPhoneNumber());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getAddress());
		
			
			//4. 명령 실행
			pstmt.executeUpdate(); //insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
			
		}
		
	}

	public Member selectMemberByIdAndPasswd(String memberId, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null; //조회된 데이터를 저장할 DTO 변수
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결 대상
					"upgo", "knit77"); //계정 정보
			//conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT C_ID, C_EMAIL, C_REGDATE, C_NAME, C_GENDER, C_ADDRESS, C_PHONE " +
						 "FROM customer " +
						 "WHERE C_ID = ? AND C_PASSWD = ? AND C_DELETED = '0'";	 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, passwd);
			
			//4. 명령 실행
			rs = pstmt.executeQuery(); //select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) {//조회된 데이터가 있다면
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setRegDate(rs.getDate(3));
				member.setName(rs.getString(4));
				member.setGender(rs.getString(5));
				member.setAddress(rs.getString(6));
				member.setPhoneNumber(rs.getString(7));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 정료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
			
		}
		
		return member; //조회가 성공하면 조회된 데이터 아니면 null
	}

	
	public void updateMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE customer " + "SET C_PASSWD = ?, C_EMAIL = ?, C_NAME = ?, C_PHONE = ?, C_ADDRESS = ?, C_GENDER = ? " 
			+ "WHERE C_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhoneNumber());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getMemberId());
			
			

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

	public void deleteMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE customer " + "SET C_DELETED = '1' " + "WHERE C_ID = ?";
			pstmt = conn.prepareStatement(sql); // 오라클에는 true false 가 없기에, 캐릭터
												// 사이즈를 1= true, 0 = false 로 대체
			pstmt.setString(1, member.getMemberId());

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

	public Member findMyPasswd(String memberId, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null; //조회된 데이터를 저장할 DTO 변수
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.16.214.202:1521:xe", //연결 대상
					"upgo", "knit77"); //계정 정보
			//conn = ConnectionHelper.getConnection("oracle");
			//3. SQL 작성 및 명령 만들기
			String sql = "SELECT C_ID, C_EMAIL, C_REGDATE, C_NAME, C_GENDER, C_ADDRESS, C_PHONE " +
						 "FROM customer " +
						 "WHERE C_ID = ? AND C_EMAIL = ? AND C_DELETED = '0'";	 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, email);
			
			//4. 명령 실행
			rs = pstmt.executeQuery(); //select 구문 실행 메서드
			//5. 결과가 있을 경우 처리
			if (rs.next()) {//조회된 데이터가 있다면
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setRegDate(rs.getDate(3));
				member.setName(rs.getString(4));
				member.setGender(rs.getString(5));
				member.setAddress(rs.getString(6));
				member.setPhoneNumber(rs.getString(7));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 정료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
			
		}
		
		return member; //조회가 성공하면 조회된 데이터 아니면 null
	
	}

	public void newPassword(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE customer " + "SET C_PASSWD = ? " 
			+ "WHERE C_ID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getMemberId());
			
			

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

	


}
		
	


