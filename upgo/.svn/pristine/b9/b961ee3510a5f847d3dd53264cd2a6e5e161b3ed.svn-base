package com.upgo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.upgo.dto.CouponEvent;
import com.upgo.dto.CouponReceived;

public class CouponDao<RandomCoupon> {

	public void insertCouponEvent(CouponEvent couponEvent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = ConnectionHelper.getConnection("oracle");
			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO CouponEvent (cp_no, cp_price, cp_text, cp_condition) "
					+ "VALUES (board_sequence.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, couponEvent.getCpPrice());
			pstmt.setString(2, couponEvent.getCpText());
			pstmt.setInt(3, couponEvent.getCpCondition());
			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
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

	// couponreceived 테이블에 데이터 삽입하는 내용으로 변경
	public void insertReceivedCoupon(CouponReceived couponReceived) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = ConnectionHelper.getConnection("oracle");
			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO CouponReceived (cr_no, c_id, cp_no,cp_expdate) "
					+ "VALUES (coupon_sequence.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, couponReceived.getId());
			pstmt.setInt(2, couponReceived.getNo());
			pstmt.setDate(3, new java.sql.Date(couponReceived.getExpDate().getTime()));

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
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

	// couponreceived 테이블에 데이터를 가져오는 내용
	public ArrayList<CouponReceived> selectCouponReceivedByMemberId(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CouponReceived> couponReceiveds = new ArrayList<CouponReceived>();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = ConnectionHelper.getConnection("oracle");
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT cr_no, cp_no, cp_expdate FROM Couponreceived WHERE c_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CouponReceived couponReceived = new CouponReceived();
				couponReceived.setNo(rs.getInt(1));
				couponReceived.setCuponNo(rs.getInt(2));
				couponReceived.setExpDate(rs.getDate(3));
				couponReceiveds.add(couponReceived);
				
			}

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
		return couponReceiveds;

	}
}
/*	public String RandomCoupon selectRandomCoupondByCouponNo(String RandomCoupon) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String  randomcoupons = new RandomCoupon();

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = ConnectionHelper.getConnection("oracle");
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT cp_no, " + "FROM Couponreceived " + "WHERE c_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, );
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RandomCoupon randomcoupons = new RandomCoupon();
				randomcoupons.setNo(rs.getInt(1));
				
			}

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
		return randomCoupons;

	}
}*/