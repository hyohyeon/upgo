package com.upgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.upgo.common.Util;
import com.upgo.dao.MemberDao;
import com.upgo.dto.CouponReceived;
import com.upgo.dto.Member;
import com.upgo.service.CouponService;
import com.upgo.service.MemberService;

public class MemberIdCheckAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        String id = request.getParameter("id");
        MemberDao dao = MemberDao.getInstance();
        
        boolean result = dao.duplicateIdCheck(id);
        
        response.setContentType("text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();
 
        if(result)    out.println("0"); // 아이디 중복
        else        out.println("1");
        
        out.close();
        
        return null;
    }
}


  