package com.upgo.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.upgo.dto.Airplane;
import com.upgo.dto.Airseat;
import com.upgo.dto.Hotel;
import com.upgo.dto.ReserveAirseat;
import com.upgo.dto.ReserveRoom;
import com.upgo.dto.Room;
import com.upgo.dto.Scheduling;

public class SchedulingDao {

	public void insertAndUpdateSchedule(Scheduling scheduling, String departregion, String interestregion) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE schedule " + "SET s_dateS = ?, s_dateF = ? , s_budget = ?, s_totalday = ?"
					+ "WHERE c_id = ? and s_departregion = ? and s_interestregion = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(scheduling.getDateS().getTime()));
			pstmt.setDate(2, new java.sql.Date(scheduling.getDateF().getTime()));
			pstmt.setInt(3, scheduling.getBudget());
			pstmt.setInt(4, scheduling.getTotalday());
			pstmt.setString(5, scheduling.getCustomer());
			pstmt.setString(6, departregion);
			pstmt.setString(7, interestregion);

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

	public void insertRegion(Scheduling scheduling) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO schedule (s_no, c_id, s_interestregion, s_departregion) "
					+ "VALUES (schedule_sequence.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scheduling.getCustomer());
			pstmt.setString(2, scheduling.getInterestregion());
			pstmt.setString(3, scheduling.getDepartregion());

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

	public List<Airplane> selectAirplane(Date dateS, String departregion, String interestregion) {// 게시판
																									// 목록
																									// 띄우기
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Airplane> airplanes = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		java.sql.Date departDate = new java.sql.Date(dateS.getTime());

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT a_no, a_airline, a_departtime, a_arrivaltime, a_departregion, a_arrivalregion, a_grade"
					+ " FROM airplane " + " WHERE a_departtime = ? and a_departregion = ? and a_arrivalregion = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, departDate);
			pstmt.setString(2, departregion);
			pstmt.setString(3, interestregion);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Airplane airplane = new Airplane();
				airplane.setaNo(rs.getInt(1));
				airplane.setaAirline(rs.getString(2));
				airplane.setaDepartDay(rs.getDate(3));
				airplane.setaArrivalDay(rs.getDate(4));
				airplane.setaDepartRegion(rs.getString(5));
				airplane.setaArrivalRegion(rs.getString(6));
				airplane.setaGrade(rs.getLong(7));
				airplanes.add(airplane); // 각 게시글 데이터를 목록에 추가
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
		return airplanes;// 조회성공하면 목록 아니면 count가 0
	}

	public List<Airseat> selectAirseat() {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Airseat> airseats = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT as_no, as_grade, as_price, as_seattype, a_no, as_realno" + " FROM airseat "
					+ " ORDER BY as_no ASC ";
			pstmt = conn.prepareStatement(sql);

			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Airseat airseat = new Airseat();
				airseat.setAsNo(rs.getInt(1));
				airseat.setAsGrade(rs.getInt(2));
				airseat.setAsPrice(rs.getInt(3));
				airseat.setAsSeatType(rs.getInt(4));
				airseat.setaNo(rs.getInt(5));
				airseat.setAsRealNo(rs.getInt(6));

				airseats.add(airseat); // 각 게시글 데이터를 목록에 추가
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
		return airseats;// 조회성공하면 목록 아니면 count가 0

	}

	public List<ReserveAirseat> selectReserveAirseat() {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<ReserveAirseat> reserveAirseats = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT ras_no, s_no, as_no" + " FROM reserveairseat " + " ORDER BY ras_no ASC ";
			pstmt = conn.prepareStatement(sql);

			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				ReserveAirseat reserveAirseat = new ReserveAirseat();
				reserveAirseat.setRasNo(rs.getInt(1));
				reserveAirseat.setsNo(rs.getInt(2));
				reserveAirseat.setAsNo(rs.getInt(3));

				reserveAirseats.add(reserveAirseat); // 각 게시글 데이터를 목록에 추가
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
		return reserveAirseats;// 조회성공하면 목록 아니면 count가 0

	}

	public Scheduling getSNO(int budget, int totalday, String customer) {
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		java.sql.PreparedStatement pstmt = null;
		Scheduling scheduling = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT s_no" + " FROM schedule " + " WHERE s_budget = ? and s_totalday = ? and c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, budget);
			pstmt.setInt(2, totalday);
			pstmt.setString(3, customer);
			// 4. 명령 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				scheduling = new Scheduling();
				scheduling.setNo(rs.getInt(1));

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
		return scheduling;// 조회성공하면 목록 아니면 count가 0
	}

	public void insertReserveAirseat(ReserveAirseat reserveAirseat) {
		
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO reserveairseat (ras_no, s_no, as_no) "
					+ "VALUES (reserveairseat_sequence.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserveAirseat.getsNo());
			pstmt.setInt(2, reserveAirseat.getAsNo());
			

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

	public List<Hotel> selectHotelByInterestRegion(String interestRegion) {
		
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Hotel> hotels = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT htl_no, htl_name, htl_grade, htl_price, htl_address"
						+ " FROM hotel "
						+ " Where htl_region = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, interestRegion);

			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Hotel hotel = new Hotel();
				hotel.setNo(rs.getInt(1));
				hotel.setName(rs.getString(2));
				hotel.setGrade(rs.getInt(3));
				hotel.setPrice(rs.getInt(4));
				hotel.setAddress(rs.getString(5));

				hotels.add(hotel);
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
		return hotels;// 조회성공하면 목록 아니면 count가 0

		
	}

	public String selectInterestRegionBysNo(int sNo) {
		
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		java.sql.PreparedStatement pstmt = null;
		String interestRegion = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT s_interestregion"
					+ " FROM schedule " + " WHERE s_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while(rs.next()){
				interestRegion = rs.getString(1);
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
		
		return interestRegion;
	}

	public List<Room> selectRoom() {
		
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Room> rooms = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT htl_no, rm_floor, rm_grade, rm_no, rm_price, rm_realno FROM room ";
			pstmt = conn.prepareStatement(sql);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Room room = new Room();
				room.sethNo(rs.getInt(1));
				room.setFloor(rs.getInt(2));
				room.setGrade(rs.getInt(3));
				room.setNo(rs.getInt(4));
				room.setPrice(rs.getInt(5));
				room.setRealNo(rs.getInt(6));
				
				rooms.add(room);
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
		return rooms;
	}

	public List<ReserveRoom> selectReserveRoom() {
		
		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<ReserveRoom> reserveRooms = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT rm_no, rrm_checkindate, rrm_checkoutdate, rrm_no, s_no FROM reserveroom ";
			pstmt = conn.prepareStatement(sql);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				ReserveRoom reserveRoom = new ReserveRoom();
				reserveRoom.setRmNo(rs.getInt(1));
				reserveRoom.setRrmCheckInDate(rs.getDate(2));
				reserveRoom.setRrmCheckOutDate(rs.getDate(3));
				reserveRoom.setRrmNo(rs.getInt(4));
				reserveRoom.setsNo(rs.getInt(5));
				reserveRooms.add(reserveRoom);
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
		return reserveRooms;
	}

	public Scheduling selectScheduleBysNo(int sNo) {
		
		Connection conn = null;
		ResultSet rs = null;
		Scheduling scheduling = new Scheduling();
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT c_id, s_budget, s_datef, s_dates, s_departregion, s_interestregion, s_no, s_totalday FROM schedule WHERE s_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				scheduling.setCustomer(rs.getString(1));
				scheduling.setBudget(rs.getInt(2));
				scheduling.setDateF(rs.getDate(3));
				scheduling.setDateS(rs.getDate(4));
				scheduling.setDepartregion(rs.getString(5));
				scheduling.setInterestregion(rs.getString(6));
				scheduling.setNo(rs.getInt(7));
				scheduling.setTotalday(rs.getInt(8));
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
		return scheduling;
	}

	public List<Integer> selectRemainRoomByHotels(List<Hotel> hotels, Date dateS, Date dateF) {

		Connection conn = null;
		ResultSet rs = null;
		int defaultRemainRoom=100;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Integer> remainRoomByHotels = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT hotel.htl_defaultremainroom-count(reserveroom.rrm_no) "
						+" FROM reserveroom "
						+" inner join room on room.rm_no=reserveroom.rm_no"
						+" inner join hotel on hotel.htl_no=room.htl_no"
						+" where room.rm_no=reserveroom.rm_no and reserveroom.rrm_checkindate<= ? and reserveroom.rrm_checkoutdate>= ?"
						+" group by hotel.htl_no "
						+" order by hotel.htl_no asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(dateF.getTime()));
			pstmt.setDate(2, new java.sql.Date(dateS.getTime()));
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Integer remainRoomByHotel;
				remainRoomByHotel = defaultRemainRoom-rs.getInt(1);
				remainRoomByHotels.add(remainRoomByHotel);
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
		return remainRoomByHotels;
	}

	public void insertReserveRoom(ReserveRoom reserveRoom, Date dateS, Date dateF) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "INSERT INTO reserveroom (rrm_no, rrm_checkindate, s_no, rm_no, rrm_checkoutdate) "
					+ "VALUES (reserveroom_sequence.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(dateS.getTime()));
			pstmt.setInt(2, reserveRoom.getsNo());
			pstmt.setInt(3, reserveRoom.getRmNo());
			pstmt.setDate(4, new java.sql.Date(dateF.getTime()));
			

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

	public List<Scheduling> selectSchedulingBycId(String cId) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Scheduling> schedulings = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT s_no, s_dates, s_datef, s_budget, s_totalday, s_interestregion, s_departregion, s_totalprice "
						+" FROM schedule "
						+" where c_id = ?";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			
			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				Scheduling scheduling = new Scheduling();
				scheduling.setNo(rs.getInt(1));
				scheduling.setDateS(rs.getDate(2));
				scheduling.setDateF(rs.getDate(3));
				scheduling.setBudget(rs.getInt(4));
				scheduling.setTotalday(rs.getInt(5));
				scheduling.setInterestregion(rs.getString(6));
				scheduling.setDepartregion(rs.getString(7));
				scheduling.setTotalPrice(rs.getInt(8));
				
				schedulings.add(scheduling);
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
		return schedulings;
	}

	public List<Airplane> selectAirplanesSBySchedulings(List<Scheduling> schedulings) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Airplane> airplanesS = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			for(Scheduling scheduling : schedulings){
				String sql = "SELECT airplane.a_no, airplane.a_airline, airplane.a_model, airplane.a_departtime, airplane.a_arrivaltime, airplane.a_departregion, airplane.a_arrivalregion, airplane.a_grade, airplane.a_flyingtime"
							+" FROM airplane "  
							+" inner join airseat on airplane.a_no = airseat.a_no "
							+" inner join reserveairseat on airseat.as_no = reserveairseat.as_no "
							+" inner join schedule on reserveairseat.s_no = schedule.s_no"
							+" where schedule.s_no = ? and airplane.a_departtime = ?";
				
				java.sql.Date dateS = new java.sql.Date(scheduling.getDateS().getTime());
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, scheduling.getNo());
				pstmt.setDate(2, dateS);
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					Airplane airplane = new Airplane();
					airplane.setaNo(rs.getInt(1));
					airplane.setaAirline(rs.getString(2));
					airplane.setaModel(rs.getString(3));
					airplane.setaDepartDay(rs.getDate(4));
					airplane.setaArrivalDay(rs.getDate(5));
					airplane.setaDepartRegion(rs.getString(6));
					airplane.setaArrivalRegion(rs.getString(7));
					airplane.setaGrade(rs.getLong(8));
					airplane.setaFlyingTime(rs.getShort(9));
					
					airplanesS.add(airplane); 
				}
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
		return airplanesS;
	}
	public List<Airplane> selectAirplanesFBySchedulings(List<Scheduling> schedulings) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Airplane> airplanesF = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			for(Scheduling scheduling : schedulings){
				String sql = "SELECT airplane.a_no, airplane.a_airline, airplane.a_model, airplane.a_departtime, airplane.a_arrivaltime, airplane.a_departregion, airplane.a_arrivalregion, airplane.a_grade, airplane.a_flyingtime "
							+" FROM airplane "
							+" inner join airseat on airplane.a_no = airseat.a_no "
							+" inner join reserveairseat on airseat.as_no = reserveairseat.as_no "
							+" inner join schedule on reserveairseat.s_no = schedule.s_no"
							+" where schedule.s_no = ? and airplane.a_departtime = ?";
				
				java.sql.Date dateF = new java.sql.Date(scheduling.getDateF().getTime());
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, scheduling.getNo());
				pstmt.setDate(2, dateF);
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					Airplane airplane = new Airplane();
					airplane.setaNo(rs.getInt(1));
					airplane.setaAirline(rs.getString(2));
					airplane.setaModel(rs.getString(3));
					airplane.setaDepartDay(rs.getDate(4));
					airplane.setaArrivalDay(rs.getDate(5));
					airplane.setaDepartRegion(rs.getString(6));
					airplane.setaArrivalRegion(rs.getString(7));
					airplane.setaGrade(rs.getLong(8));
					airplane.setaFlyingTime(rs.getShort(9));
					
					airplanesF.add(airplane);
				}
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
		return airplanesF;
	}

	public List<Hotel> selectHotelBySchedulings(List<Scheduling> schedulings) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Hotel> hotels = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			for(Scheduling scheduling : schedulings){
				String sql = "SELECT hotel.htl_no, hotel.htl_region, hotel.htl_rating, hotel.htl_phone, hotel.htl_checkin, hotel.htl_address, hotel.htl_checkout, hotel.htl_grade, hotel.htl_name, hotel.htl_price "
							+" FROM hotel "
							+" inner join room on hotel.htl_no = room.htl_no "
							+" inner join reserveroom on room.rm_no = reserveroom.rm_no"
							+" inner join schedule on reserveroom.s_no = schedule.s_no"
							+" where schedule.s_no = ? ";
							
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, scheduling.getNo());
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					Hotel hotel = new Hotel();
					hotel.setNo(rs.getInt(1));
					hotel.setRegion(rs.getString(2));
					hotel.setRating(rs.getLong(3));
					hotel.setPhoneNo(rs.getLong(4));
					hotel.setCheckIn(rs.getInt(5));
					hotel.setAddress(rs.getString(6));
					hotel.setCheckOut(rs.getInt(7));
					hotel.setGrade(rs.getShort(8));
					hotel.setName(rs.getString(9));
					hotel.setPrice(rs.getInt(10));
					
					
					hotels.add(hotel);
				}
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
		return hotels;
	}
	
	public List<Room> selectRoomBySchedulings(List<Scheduling> schedulings) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Room> rooms = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			for(Scheduling scheduling : schedulings){
				String sql = "SELECT room.rm_no, room.rm_price, room.rm_grade, room.rm_floor, room.rm_realno "
							+" FROM room "
							+" inner join reserveroom on room.rm_no = reserveroom.rm_no"
							+" inner join schedule on reserveroom.s_no = schedule.s_no"
							+" where schedule.s_no = ? ";
							
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, scheduling.getNo());
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					Room room = new Room();
					room.setNo(rs.getInt(1));
					room.setPrice(rs.getInt(2));
					room.setGrade(rs.getInt(3));
					room.setFloor(rs.getInt(4));
					room.setRealNo(rs.getInt(5));
					
					rooms.add(room);
				}
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
		return rooms;
	}

	public List<Integer> selectPriceFlightsBysNo(int sNo) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Integer> priceFlights = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
				String sql = "SELECT airseat.as_price "
							+" FROM airseat "
							+" inner join airplane on airplane.a_no = airseat.a_no "
							+" inner join reserveairseat on airseat.as_no = reserveairseat.as_no "
							+" inner join schedule on reserveairseat.s_no = schedule.s_no"
							+" where schedule.s_no = ?";
							
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sNo);
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					int priceFlight;
					priceFlight = rs.getInt(1);
					
					priceFlights.add(priceFlight);
				
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
		
		return priceFlights;
	}

	public int selectPriceRoomPerDay(int sNo) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		int priceRoomPerDay=0;
		java.sql.PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			
				String sql = "SELECT room.rm_price"
							+" FROM room "
							+" inner join reserveroom on room.rm_no = reserveroom.rm_no"
							+" inner join schedule on reserveroom.s_no = schedule.s_no"
							+" where schedule.s_no = ? ";
							
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sNo);
				
				// 4. 명령 실행
				rs = pstmt.executeQuery(); // select 구문 실행 메서드
				// 5. 결과가 있을 경우 처리
				while (rs.next()) { // 조회된 데이터가 있다면
					
					priceRoomPerDay = rs.getInt(1);
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

		return priceRoomPerDay;
	}

	public void updateTotalPriceByScheduling(int sNo, int totalPrice) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE schedule " + "SET s_totalprice = ?"
					+ "WHERE s_no = ?";

			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, totalPrice);
			pstmt.setInt(2, sNo);

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

	public void updateScheduleByScheduling(Scheduling scheduling) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE schedule  SET s_departregion = ?, s_interestregion = ?, s_dates = ?, s_dateF = ? , s_budget = ?, s_totalday = ?"
					+ "WHERE s_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, scheduling.getDepartregion());
			pstmt.setString(2, scheduling.getInterestregion());
			pstmt.setDate(3, new java.sql.Date(scheduling.getDateS().getTime()));
			pstmt.setDate(4, new java.sql.Date(scheduling.getDateF().getTime()));
			pstmt.setInt(5, scheduling.getBudget());
			pstmt.setInt(6, scheduling.getTotalday());
			pstmt.setInt(7, scheduling.getNo());
			
			
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

	public List<Integer> selectAirseatBysNo(int sNo) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Integer> rasNoList = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT ras_no " + " FROM reserveairseat " + " where s_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);

			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				
				int rasNo;
				rasNo = rs.getInt(1);
				
				rasNoList.add(rasNo); // 각 게시글 데이터를 목록에 추가
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
		return rasNoList;
	}

	public void updateReserveAirseat(ReserveAirseat reserveAirseat) {
		
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE reserveairseat SET as_no = ? "
					+ " where s_no = ? and ras_no = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserveAirseat.getAsNo());
			pstmt.setInt(2, reserveAirseat.getsNo());
			pstmt.setInt(3, reserveAirseat.getRasNo());

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

	public List<Integer> selectRoomBysNo(int sNo) {

		Connection conn = null;
		ResultSet rs = null;
		// 조회된 데이터를 저장할 DTO 변수(여러 건 이므로 컬렉션 형식)
		ArrayList<Integer> rrmNoList = new ArrayList<>();
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨
			// 3. SQL 작성 및 명령 만들기
			String sql = "SELECT rrm_no " + " FROM reserveroom " + " where s_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNo);

			// 4. 명령 실행
			rs = pstmt.executeQuery(); // select 구문 실행 메서드
			// 5. 결과가 있을 경우 처리
			while (rs.next()) { // 조회된 데이터가 있다면
				
				int rrmNo;
				rrmNo = rs.getInt(1);
				
				rrmNoList.add(rrmNo); // 각 게시글 데이터를 목록에 추가
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
		return rrmNoList;
	}

	public void updateReserveRoom(ReserveRoom reserveRoom, Date dateS, Date dateF) {
		Connection conn = null;
		java.sql.PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle"); // 이 한 줄만 써도 됨

			// 3. SQL 작성 및 명령 만들기
			String sql = "UPDATE reserveroom SET rrm_no = ? , rm_no = ?, rrm_checkindate = ? , rrm_checkoutdate = ? "
					+ "where s_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserveRoom.getRrmNo());
			pstmt.setInt(2, reserveRoom.getRmNo());
			pstmt.setDate(3, new java.sql.Date(dateS.getTime()));
			pstmt.setDate(4, new java.sql.Date(dateF.getTime()));
			pstmt.setInt(5, reserveRoom.getsNo());
			

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
	
}
