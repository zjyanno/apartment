package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.dao.UserDao;
import com.zy.model.User;
import com.zy.service.UserService;
import com.zy.service.UserServiceImpl;
@WebServlet("/userList")
public class UserListServlet extends HttpServlet{
	UserService service=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<User> user=service.findAll();
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/view/flats/userList.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
