package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.User;
import com.zy.service.UserService;
import com.zy.service.UserServiceImpl;
@WebServlet("/userkeywords")
public class UserKeywordsServlet extends HttpServlet{
	UserService service=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数-->关键字
		String keywords = req.getParameter("keywords");
		//接收参数-->查询字段
		String field = req.getParameter("field");
		//调用业务层传参数
		ArrayList<User> user = service.findUserAndWords(field,keywords);
		req.setAttribute("user", user);
		//页面跳转
		req.getRequestDispatcher("/view/flats/userList.jsp").forward(req, resp);
	}
}
