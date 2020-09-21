package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.service.UserService;
import com.zy.service.UserServiceImpl;
@WebServlet("/userDel")
public class UserDelServlet extends HttpServlet{
	UserService service=new UserServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		service.delUserById(uid);
		req.getRequestDispatcher("/userList").forward(req, resp);
	}
}
