package com.upgo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@WebServlet(value = "/scheduling/modifyschedule.action")
public class ModifyScheduleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ssNo = req.getParameter("sNo");
		int sNo = Integer.parseInt(ssNo);
		
		ArrayList<String> regions = new ArrayList<String>(){{
			add("AL");add("AK");add("AZ");add("AR");add("CA");add("CO");add("CT");add("DE");add("FL");add("GA");
			add("HI");add("ID");add("IL");add("IN");add("IA");add("KS");add("KY");add("LA");add("ME");add("MD");
			add("MA");add("MI");add("MN");add("MS");add("MO");add("MT");add("NE");add("NV");add("NH");add("NJ");
			add("NM");add("NY");add("NC");add("ND");add("OH");add("OK");add("OR");add("PA");add("RI");add("SC");
			add("SD");add("TN");add("TX");add("UT");add("VT");add("VA");add("WA");add("WV");add("WI");add("WY");
		}};
		
		ArrayList<String> fullnameregions = new ArrayList<String>(){{
			add("Alabama");add("Alaska");add("Arizona");add("Arkansas");add("California");add("Colorado");add("Connecticut");add("Delaware");add("Florida");add("Georgia");
			add("Hawaii");add("Idaho");add("Illinois");add("Indiana");add("Iowa");add("Kansas");add("Kentucky");add("Louisiana");add("Maine");add("Maryland");
			add("Massachusetts");add("Michigan");add("Minnesota");add("Mississippi");add("Missouri");add("Montana");add("Nebraska");add("Nevada");add("New Hampshire");add("New Jersey");
			add("New Mexico");add("New York");add("North Carolina");add("North Dakota");add("Ohio");add("Oklahoma");add("Oregon");add("Pennsylvania");add("Rhode Island");add("South Carolina");
			add("South Dakota");add("Tennessee");add("Texas");add("Utah");add("Vermont");add("Virginia");add("Washington");add("West Virginia");add("Wisconsin");add("Wyoming");
		}};

		req.setAttribute("regions", regions);
		req.setAttribute("fullnameregions", fullnameregions);
		req.setAttribute("sNo", sNo);
				

		
//		HttpSession session = req.getSession();
//		Member member = (Member) session.getAttribute("loginuser");
//		String cId = member.getMemberId();
//		SchedulingService schedulingService = new SchedulingService();
//		
//		List<Scheduling> schedulings = schedulingService.findSchedulingsBycId(cId);
//		List<Airplane> airplanesS = schedulingService.findAirplanesSBySchedulings(schedulings);
//		List<Airplane> airplanesF = schedulingService.findAirplanesFBySchedulings(schedulings);
//		List<Hotel> hotels = schedulingService.findHotelBySchedulings(schedulings);
//		//List<Room> rooms = schedulingService.findRoomBySchedulings(schedulings);
		
//		
//		System.out.println(schedulings.size());
//		System.out.println(airplanesS.size());
//		System.out.println(airplanesF.size()); 
//		System.out.println(hotels.size());
		//System.out.println(rooms.size());
//		
//		req.setAttribute("schedulings", schedulings);
//		req.setAttribute("airplanesS", airplanesS);
//		req.setAttribute("airplanesF", airplanesF);
//		req.setAttribute("hotels",hotels);
//		//req.setAttribute("rooms", rooms);
//		
		
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/modifyschedule.jsp");
		dispatcher.forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 
		String ssNo = req.getParameter("sNo");
		String departregion = req.getParameter("departregion");
		String interestregion = req.getParameter("interestregion");
		String sdateS = req.getParameter("datepickerS");
		String sdateF = req.getParameter("datepickerF");
		String sbudget = req.getParameter("amount");
		
		SimpleDateFormat transFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date dateS = new Date();
		Date dateF = new Date();
		long ltotalday = 0;
		try {
			dateS = transFormat.parse(sdateS);
			dateF = transFormat.parse(sdateF);
			long diff = dateF.getTime() - dateS.getTime();
	        ltotalday = diff / (24 * 60 * 60 * 1000);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int budget = Integer.parseInt(sbudget);
		int totalday = (int)ltotalday;
		int sNo = Integer.parseInt(ssNo);
		
		Scheduling scheduling = new Scheduling();
		scheduling.setNo(sNo);
		scheduling.setDepartregion(departregion);
		scheduling.setInterestregion(interestregion);
		scheduling.setBudget(budget);
		scheduling.setDateS(dateS);
		scheduling.setDateF(dateF);
		scheduling.setTotalday(totalday);
		
		SchedulingService schedulingService = new SchedulingService();
		schedulingService.modifySchedule(scheduling);
		
		resp.sendRedirect(String.format("/upgo/scheduling/reserveairseat.action?datepickerS=%s&datepickerF=%s&departregion=%s&interestregion=%s&sNo=%d",sdateS,sdateF,departregion,interestregion,sNo ));
	}
	
}
