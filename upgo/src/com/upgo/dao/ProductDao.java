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
import com.upgo.dto.OrderProduct;
import com.upgo.dto.Product;
import com.upgo.dto.TBoardComment;
import com.upgo.dto.Board;

public class ProductDao {

	public void writeProduct(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null; // for insert
		ResultSet rs = null;

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO product (p_no, p_name, p_price, p_desc) "
					+ "	VALUES(product_sequence.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrdName());
			pstmt.setInt(2, product.getPrdPrice());
			pstmt.setString(3, product.getPrdDesc());

			// 4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
//			// 위에서 insert된 글의 상품번호 조회 ----------------------------> 글번호를 알기위해서
//			sql = "SELECT product_sequence.currval FROM DUAL"; // 마지막으로
//			
//			pstmt2 = conn.prepareStatement(sql);
//			rs = pstmt2.executeQuery();
//			rs.next();
//			newPrdNo = rs.getInt(1);
			
		
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


	}
		
//	public void writeOrderProduct(OrderProduct orderproduct) {
//		Connection conn = null;
//		PreparedStatement pstmt = null; // for insert
//		ResultSet rs = null;
//		
//		
//		try {
//			// 1. Driver 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			// 2. 연결 만들기
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
//					"upgo", "knit77"); // 계정정보
//			// 3. SQL 작성 및 명령 만들기
//			String sql = "INSERT INTO orderlist (op_no, op_products, op_prices) "
//					+ "	VALUES(product_sequence.nextval,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, orderproduct.getOrdNo());
//			pstmt.setString(2, orderproduct.getOrdProducts());
//			pstmt.setInt(3, orderproduct.getOrdPrices());
//
//			// 4. 명령 실행
//			pstmt.executeUpdate(); // insert, update, delete 구문 실행 메서드
////			// 위에서 insert된 글의 상품번호 조회 ----------------------------> 글번호를 알기위해서
////			sql = "SELECT product_sequence.currval FROM DUAL"; // 마지막으로
////			
////			pstmt2 = conn.prepareStatement(sql);
////			rs = pstmt2.executeQuery();
////			rs.next();
////			newPrdNo = rs.getInt(1);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			// 6. 연결 종료
//			try {
//				rs.close();
//			} catch (Exception ex) {
//			}
//			try {
//				pstmt.close();
//			} catch (Exception ex) {
//			}
//			try {
//				conn.close();
//			} catch (Exception ex) {
//			}
//		}
//
//	}
	public List<Product> selectProduct() {// 게시판 목록 띄우기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Product> products = new ArrayList<>();
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT p_no, p_name, p_price, p_desc "
					+ "FROM product ";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Product product = new Product();
				product.setPrdNo(rs.getInt(1));
				product.setPrdName(rs.getString(2));
				product.setPrdPrice(rs.getInt(3));
				product.setPrdDesc(rs.getString(4));
				
				products.add(product); // 각 게시글 데이터를 목록에 추가
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
		return products;// 조회성공하면 목록 아니면 count가 0
	}
	
	
	
	
	public List<Product> selectProductList(int first, int last) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<Product>();

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
			sql.append("			P_NO, P_NAME, ");
			sql.append("			P_PRICE, P_DESC ");
			sql.append("		FROM ");
			sql.append("			PRODUCT ");
			//sql.append("	WHERE p_no = ? ");
			sql.append("	) s ");

			sql.append(") ");

			sql.append("WHERE idx >= ? AND idx < ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setPrdNo(rs.getInt(2));
				product.setPrdName(rs.getString(3));
				product.setPrdPrice(rs.getInt(4));
				product.setPrdDesc(rs.getString(5));

				products.add(product);
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

		return products;
	}


	public void updateProduct(Product product) {// 게시글 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE product " + "SET P_NAME = ?, P_PRICE = ? , P_DESC =? " + "WHERE P_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrdName());
			pstmt.setInt(2, product.getPrdPrice());
			pstmt.setString(3, product.getPrdDesc());
			pstmt.setInt(4, product.getPrdNo());

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

	public void deleteProduct(int productNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			//3. SQL 작성 및 명령 만들기
			String sql = "UPDATE product " +
						 "SET deleted = '1' " +
						 "WHERE p_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			//4. 명령 실행
			pstmt.executeUpdate();//insert, update, delete 구문 실행 메서드
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
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


	public Product selectProductByProductNo(int prdNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;// 조회된 데이터를 저장할 DTO 변수(단일 데이터라 null)

		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 연결 만들기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.16.214.202:1521:xe", // 연결대상
					"upgo", "knit77"); // 계정정보
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT p_no, p_name, p_price, p_desc "
					+ "FROM product " + "WHERE p_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prdNo);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				product = new Product();
				product.setPrdNo(rs.getInt(1));
				product.setPrdName(rs.getString(2));
				product.setPrdPrice(rs.getInt(3));
				product.setPrdDesc(rs.getString(4));

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
		return product;// 조회성공하면 목록 아니면 board, 아니면 null
	}
	

	
	}

		