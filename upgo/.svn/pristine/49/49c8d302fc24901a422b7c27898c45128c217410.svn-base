package com.upgo.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/boardimgup2.action")
public class BoardImageUploadServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sFileInfo = "";
		//파일명 - 싱글파일업로드와 다르게 멀티파일업로드는 HEADER로 넘어옴 
		String name = req.getHeader("file-name");
		String ext = name.substring(name.lastIndexOf(".")+1);
		//파일 기본경로
		String defaultPath = req.getServletContext().getRealPath("/");
		//파일 기본경로 _ 상세경로
		String path = defaultPath + "upload" + File.separator;
		File file = new File(path);
		if(!file.exists()) {
		    file.mkdirs();
		}
		String realname = UUID.randomUUID().toString() + "." + ext;
		InputStream is = req.getInputStream();
		OutputStream os=new FileOutputStream(path + realname);
		int numRead;
		// 파일쓰기
		byte b[] = new byte[Integer.parseInt(req.getHeader("file-size"))];
		while((numRead = is.read(b,0,b.length)) != -1){
		    os.write(b,0,numRead);
		}
		if(is != null) {
		    is.close();
		}
		os.flush();
		os.close();
		sFileInfo += "&bNewLine=true&sFileName="+ name+"&sFileURL="+"/upgo/upload/"+realname;
		
		PrintWriter out = resp.getWriter();
		
		out.println(sFileInfo);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
