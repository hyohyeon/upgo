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

@WebServlet(value = "/scheduling/regionchoiceto.action")
public class RegionChoiceToServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =
 				req.getRequestDispatcher("/WEB-INF/views/scheduling/regionchoiceto.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String customer = req.getParameter("customer");
		String departregion = req.getParameter("departregion");
		String interestregion = req.getParameter("interestregion");
		System.out.println(departregion);
		System.out.println(interestregion);
		//req.getSession();
		//Member member = (Member)session.getAttribute("loginuser");
		//Member = req.getSession().getAttribute("loginuser");
		
		Scheduling scheduling = new Scheduling();
		scheduling.setCustomer(customer);
		scheduling.setInterestregion(interestregion);
		scheduling.setDepartregion(departregion);
		
		SchedulingService schedulingService = new SchedulingService();
		schedulingService.registerRegion(scheduling);
		
		
		
		
		
		
		resp.sendRedirect(String.format("/upgo/scheduling/scheduling.action?departregion=%s&interestregion=%s",departregion,interestregion )); //이건 확인필요
		
		
	}
	
}
