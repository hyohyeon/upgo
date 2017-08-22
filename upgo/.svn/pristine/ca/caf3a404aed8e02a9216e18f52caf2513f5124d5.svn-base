package com.upgo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upgo.dto.Member;
import com.upgo.dto.Scheduling;
import com.upgo.service.SchedulingService;

@WebServlet(value = "/scheduling/scheduling.action")
public class SchedulingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/scheduling.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 
		Member member = (Member)req.getSession().getAttribute("loginuser");
		String customer = member.getMemberId();
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
		
		
		Scheduling scheduling = new Scheduling();
		scheduling.setBudget(budget);
		scheduling.setDateS(dateS);
		scheduling.setDateF(dateF);
		scheduling.setTotalday(totalday);
		scheduling.setCustomer(customer);
		
		SchedulingService schedulingService = new SchedulingService();
		schedulingService.registerSchedule(scheduling,departregion,interestregion);
		
		Scheduling scheduling2 = schedulingService.findSNo(budget, totalday, customer);
		int sNo = scheduling2.getNo();
		
		System.out.println(sNo);
		
		resp.sendRedirect(String.format("/upgo/scheduling/reserveairseat.action?datepickerS=%s&datepickerF=%s&departregion=%s&interestregion=%s&sNo=%d",sdateS,sdateF,departregion,interestregion,sNo )); //이건 확인필요
		
	}
	
}
