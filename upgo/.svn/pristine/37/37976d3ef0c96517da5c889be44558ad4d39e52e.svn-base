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

@WebServlet(value = "/scheduling/scheduledetail.action")
public class ScheduleDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("loginuser");
		String cId = member.getMemberId();
		String si = req.getParameter("schedulesequencebycustomer");
		int i = Integer.parseInt(si);
		
		SchedulingService schedulingService = new SchedulingService();
		
		List<Scheduling> schedulings = schedulingService.findSchedulingsBycId(cId);
		List<Airplane> airplanesS = schedulingService.findAirplanesSBySchedulings(schedulings);
		List<Airplane> airplanesF = schedulingService.findAirplanesFBySchedulings(schedulings);
		List<Hotel> hotels = schedulingService.findHotelBySchedulings(schedulings);
		//List<Room> rooms = schedulingService.findRoomBySchedulings(schedulings);
		
		System.out.println(schedulings.size());
		System.out.println(airplanesS.size());
		System.out.println(airplanesF.size()); 
		System.out.println(hotels.size());
		//System.out.println(rooms.size());
		
		req.setAttribute("schedulings", schedulings);
		req.setAttribute("airplanesS", airplanesS);
		req.setAttribute("airplanesF", airplanesF);
		req.setAttribute("hotels",hotels);
		//req.setAttribute("rooms", rooms);
		req.setAttribute("schedulesequencebycustomer", i);
		
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/scheduledetail.jsp");
		dispatcher.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
	
}
