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

import com.upgo.dto.Airplane;
import com.upgo.dto.Airseat;
import com.upgo.dto.Member;
import com.upgo.dto.ReserveAirseat;
import com.upgo.dto.Scheduling;
import com.upgo.service.SchedulingService;

@WebServlet(value = "/scheduling/reserveairseat.action")
public class ReserveAirseatServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String departregion = req.getParameter("departregion");
		String interestregion = req.getParameter("interestregion");
		String sdateS = req.getParameter("datepickerS");
		String sdateF = req.getParameter("datepickerF");
		SimpleDateFormat transFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date dateS = new Date();
		Date dateF = new Date();
		try {
			dateS = transFormat.parse(sdateS);
			dateF = transFormat.parse(sdateF);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SchedulingService schedulingService = new SchedulingService();
		List<Airplane> airplanesS = schedulingService.findAirplaneList(dateS,departregion,interestregion);
		List<Airplane> airplanesF = schedulingService.findAirplaneList(dateF,interestregion,departregion);
		List<Airseat> airseats = schedulingService.loadAirseatList();
		List<ReserveAirseat> reserveAirseats = schedulingService.findReserveAirseatList();
		
		req.setAttribute("airplanesS", airplanesS);
		req.setAttribute("airplanesF", airplanesF);
		req.setAttribute("airseats", airseats);
		req.setAttribute("reserveairseats", reserveAirseats);
		
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/reserveairseat.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 
		
		String sasNoS = req.getParameter("reserveAirseatS");
		String sasNoF = req.getParameter("reserveAirseatF");
		String ssNo = req.getParameter("sNo");
		int asNoS = Integer.parseInt(sasNoS);
		int asNoF = Integer.parseInt(sasNoF);
		int sNo = Integer.parseInt(ssNo);
		
		ReserveAirseat reserveAirseat = new ReserveAirseat();
		reserveAirseat.setAsNo(asNoS);
		reserveAirseat.setsNo(sNo);
		
		ReserveAirseat reserveAirseat2 = new ReserveAirseat();
		reserveAirseat2.setAsNo(asNoF);
		reserveAirseat2.setsNo(sNo);
		
		SchedulingService schedulingService = new SchedulingService();
		
		boolean isAirseatAlreadyExist = true;
		
		List<Integer> rasNoList= schedulingService.findAirseatBysNo(sNo);  
		if(rasNoList.isEmpty()){
			isAirseatAlreadyExist = false;
		}
		
		if(isAirseatAlreadyExist==true){
			reserveAirseat.setRasNo(rasNoList.get(0));
			reserveAirseat2.setRasNo(rasNoList.get(1));
			schedulingService.modifyReserveAirseat(reserveAirseat);
			schedulingService.modifyReserveAirseat(reserveAirseat2);
		}else{
			schedulingService.registerReserveAirseat(reserveAirseat);
			schedulingService.registerReserveAirseat(reserveAirseat2);	
		}
		
		
		resp.sendRedirect(String.format("/upgo/scheduling/reserveroom.action?sNo=%d",sNo));
	}
	
}
