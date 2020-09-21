package com.zy.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.User;
import com.zy.service.UserService;
import com.zy.service.UserServiceImpl;
@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet{
	UserService service=new UserServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/flats/userAdd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uname = req.getParameter("uname");
		String upassword = req.getParameter("upassword");
		String urealname = req.getParameter("urealname");
		//uaddTime用new Date生成
		String ustatus = req.getParameter("ustatus");
		
		User user = new User();
		user.setUname(uname);
		user.setUpassword(upassword);
		user.setUrealname(urealname);
		Date uaddTime = new Date();
		user.setUaddTime(uaddTime);
		user.setUstatus(Integer.parseInt(ustatus));
		
		int num=service.add(user);
		if (num>0) {
			req.getRequestDispatcher("/userList").forward(req, resp);
		}
	}

}
