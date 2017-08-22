package com.upgo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upgo.dto.Airplane;
import com.upgo.dto.Airseat;
import com.upgo.dto.Hotel;
import com.upgo.dto.Member;
import com.upgo.dto.ReserveAirseat;
import com.upgo.dto.ReserveRoom;
import com.upgo.dto.Room;
import com.upgo.dto.Scheduling;
import com.upgo.service.SchedulingService;

@WebServlet(value = "/scheduling/reserveroom.action")
public class ReserveRoomServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ssNo = req.getParameter("sNo");
		int sNo = Integer.parseInt(ssNo);
		
		Scheduling scheduling = new Scheduling();
		SchedulingService schedulingService = new SchedulingService();
		scheduling = schedulingService.findScheduleBysNo(sNo);
		
//		String interestRegion = schedulingService.findInterestRegionBysNo(sNo);
//		System.out.println(interestRegion);
//		System.out.println();
		Date dateS = scheduling.getDateS();
		Date dateF = scheduling.getDateF();
		
		
		List<Hotel> hotels = schedulingService.findHotel(scheduling.getInterestregion());
		List<Room> rooms = schedulingService.findRoom();
		List<ReserveRoom> reserveRooms = schedulingService.findReserveRoom();
		
		//List<Integer> countRemainRoomByHotels = schedulingService.countRemainRoomByHotel(hotels,dateS,dateF);
//		for (Hotel hotel : hotels){
//		countRemainRoomByHotels.get(hotel.getNo());
//		};
		//servlet작성하면됨
		
		if(hotels.isEmpty()){
			System.out.println("hotels at interest region is empty");
		}
		if(rooms.isEmpty()){
			System.out.println("rooms is empty");
		}
		if(reserveRooms.isEmpty()){
			System.out.println("reserveRooms is empty");
		}
//		if(countRemainRoomByHotels.isEmpty()){
//			System.out.println("count is empty");
//		}
//		System.out.println(countRemainRoomByHotels.size());
		System.out.println(hotels.size());
		System.out.println(rooms.size());
		System.out.println(reserveRooms.size());
		
		
		//req.setAttribute("countremainroombyhotels", countRemainRoomByHotels);
		req.setAttribute("hotels", hotels);
		req.setAttribute("rooms", rooms);
		req.setAttribute("reserverooms", reserveRooms);
		req.setAttribute("interestregion",scheduling.getInterestregion());
		req.setAttribute("scheduling", scheduling);
		
		
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/reserveroom.jsp");
		dispatcher.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 
		String srmNo = req.getParameter("reserveroom");
		String ssNo = req.getParameter("sNo");
		int rmNo = Integer.parseInt(srmNo);
		int sNo = Integer.parseInt(ssNo);
		System.out.println(rmNo);
		System.out.println(sNo);
		
		Scheduling scheduling = new Scheduling();
		SchedulingService schedulingService = new SchedulingService();
		scheduling = schedulingService.findScheduleBysNo(sNo);
		
		Date dateS = scheduling.getDateS();
		Date dateF = scheduling.getDateF();
		
		ReserveRoom reserveRoom = new ReserveRoom();
		reserveRoom.setRmNo(rmNo);
		reserveRoom.setsNo(sNo);
		
		boolean isReservedRoomAlreadyExist = true;
		
		List<Integer> rrmNoList= schedulingService.findRoomBysNo(sNo);  
		if(rrmNoList.isEmpty()){
			isReservedRoomAlreadyExist = false;
		}
		
		if(isReservedRoomAlreadyExist==true){
			reserveRoom.setRrmNo(rrmNoList.get(0));
			schedulingService.modifyReserveRoom(reserveRoom,dateS,dateF);
		}else{
			schedulingService.registerReserveRoom(reserveRoom,dateS,dateF);	
		}
		
		
		
		List<Integer> priceFlights = schedulingService.calPriceFlightsBysNo(sNo);
		int priceRoomPerDay = schedulingService.checkPriceRoomBysNo(sNo);
		int totalPriceRoom = priceRoomPerDay*scheduling.getTotalday();
		int totalPrice = priceFlights.get(0) + priceFlights.get(1) + totalPriceRoom;
		schedulingService.registerTotalPrice(sNo,totalPrice);
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("loginuser");
		
		resp.sendRedirect(String.format("/upgo/scheduling/schedulelist.action?cid=%s",member.getMemberId()));
	}
	
}
