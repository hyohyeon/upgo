package com.upgo.service;

import java.util.Date;
import java.util.List;

import com.upgo.dao.SchedulingDao;
import com.upgo.dto.Airplane;
import com.upgo.dto.Airseat;
import com.upgo.dto.Hotel;
import com.upgo.dto.ReserveAirseat;
import com.upgo.dto.ReserveRoom;
import com.upgo.dto.Room;
import com.upgo.dto.Scheduling;

public class SchedulingService {

	public void registerSchedule(Scheduling scheduling, String departregion, String interestregion) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.insertAndUpdateSchedule(scheduling,departregion,interestregion);
		
	}

	public void registerRegion(Scheduling scheduling) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.insertRegion(scheduling);
		
	}
	
	public Scheduling findSNo(int budget, int totalday, String customer) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		Scheduling scheduling = schedulingDao.getSNO(budget, totalday, customer);
		
		return scheduling;
		
	}


	public List<Airplane> findAirplaneList(Date dateS, String departregion, String interestregion) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Airplane> airplanes = schedulingDao.selectAirplane(dateS, departregion, interestregion);
		
		return airplanes;
	}

	public List<Airseat> loadAirseatList() {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Airseat> airseats = schedulingDao.selectAirseat();
		return airseats;
	}

	public List<ReserveAirseat> findReserveAirseatList() {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<ReserveAirseat> reserveAirseats = schedulingDao.selectReserveAirseat();
		
		return reserveAirseats;
	}

	public void registerReserveAirseat(ReserveAirseat reserveAirseat) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.insertReserveAirseat(reserveAirseat);
		
	}

	public List<Hotel> findHotel(String interestRegion) {
		
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Hotel> hotels = schedulingDao.selectHotelByInterestRegion(interestRegion);
		return hotels;
		
	}

	public String findInterestRegionBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		String interestRegion = schedulingDao.selectInterestRegionBysNo(sNo);
		return interestRegion;
	}

	public List<Room> findRoom() {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Room> rooms = schedulingDao.selectRoom();
		return rooms;
	}

	public List<ReserveRoom> findReserveRoom() {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<ReserveRoom> reserveRooms = schedulingDao.selectReserveRoom();
		return reserveRooms;
	}

	public Scheduling findScheduleBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		Scheduling scheduling = schedulingDao.selectScheduleBysNo(sNo);
		return scheduling;
	}

	public List<Integer> countRemainRoomByHotel(List<Hotel> hotels, Date dateS, Date dateF) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Integer> countRemainRoomByHotels = schedulingDao.selectRemainRoomByHotels(hotels,dateS,dateF);
		return countRemainRoomByHotels;
	}

	public void registerReserveRoom(ReserveRoom reserveRoom, Date dateS, Date dateF) {
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.insertReserveRoom(reserveRoom,dateS,dateF);
		
	}

	public List<Scheduling> findSchedulingsBycId(String cId) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Scheduling>schedulings = schedulingDao.selectSchedulingBycId(cId);
		return schedulings;
	}

	public List<Airplane> findAirplanesSBySchedulings(List<Scheduling> schedulings) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Airplane> airplanesS = schedulingDao.selectAirplanesSBySchedulings(schedulings);
		return airplanesS;
	}

	public List<Airplane> findAirplanesFBySchedulings(List<Scheduling> schedulings) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Airplane> airplanesF = schedulingDao.selectAirplanesFBySchedulings(schedulings);
		return airplanesF;
	}

	public List<Hotel> findHotelBySchedulings(List<Scheduling> schedulings) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Hotel> hotels = schedulingDao.selectHotelBySchedulings(schedulings);
		return hotels;
		
	}
	
	public List<Room> findRoomBySchedulings(List<Scheduling> schedulings) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Room> rooms = schedulingDao.selectRoomBySchedulings(schedulings);
		return rooms;
		
	}

	public List<Integer> calPriceFlightsBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Integer> priceFlights = schedulingDao.selectPriceFlightsBysNo(sNo);
		return priceFlights;
	}

	public int checkPriceRoomBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		int priceRoomPerDay = schedulingDao.selectPriceRoomPerDay(sNo);
		return priceRoomPerDay;
	}

	public void registerTotalPrice(int sNo, int totalPrice) {
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.updateTotalPriceByScheduling(sNo, totalPrice);
		
	}

	public void modifySchedule(Scheduling scheduling) {
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.updateScheduleByScheduling(scheduling);
		
	}

	public List<Integer> findAirseatBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Integer> rasNoList = schedulingDao.selectAirseatBysNo(sNo);
		return rasNoList;
	}

	public void modifyReserveAirseat(ReserveAirseat reserveAirseat) {
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.updateReserveAirseat(reserveAirseat);
		
	}

	public List<Integer> findRoomBysNo(int sNo) {
		SchedulingDao schedulingDao = new SchedulingDao();
		List<Integer> rrmNoList = schedulingDao.selectRoomBysNo(sNo);
		return rrmNoList;
	}

	public void modifyReserveRoom(ReserveRoom reserveRoom, Date dateS, Date dateF) {
		SchedulingDao schedulingDao = new SchedulingDao();
		schedulingDao.updateReserveRoom(reserveRoom, dateS, dateF);
		
	}
	
}
