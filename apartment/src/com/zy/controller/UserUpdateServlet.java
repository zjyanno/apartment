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
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet{
	UserService service=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		User user =service.findUserById(uid);
		if (user!=null) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("view/flats/userUpdate.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uid = req.getParameter("uid");
		String uname = req.getParameter("uname");
		String upassword = req.getParameter("upassword");
		String urealname = req.getParameter("urealname");
		
		String ustatus = req.getParameter("ustatus");
		
		User user = new User();
		user.setUid(Integer.parseInt(uid));
		user.setUname(uname);
		user.setUpassword(upassword);
		user.setUrealname(urealname);
		Date uaddTime = new Date();
		user.setUaddTime(uaddTime);
		user.setUstatus(Integer.parseInt(ustatus));
		
		service.updateUser(user);
		req.getRequestDispatcher("/userList").forward(req, resp);
	}
}
