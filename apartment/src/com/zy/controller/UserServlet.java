package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zy.dao.UserDao;
import com.zy.model.User;


@WebServlet("/login")
public class UserServlet extends HttpServlet{
	private static Logger logger = Logger.getLogger(UserServlet.class.getName());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upassword = req.getParameter("upassword");
		System.out.println("日志 --> 用户名="+uname+",密码="+upassword);
		
		logger.debug("This is debug message.");
		logger.info("This is info message.");
		logger.warn("This is warn message.");
		logger.error("This is error message.");
		UserDao dao = new UserDao();
		User user = dao.findUserByUsernameAndPassword(uname, upassword);
		System.out.println("日志 --> 根据参数,查询到的用户信息"+user);
		if (user!=null) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		} else {
			System.out.println("日志 --> 用户名或密码错误");
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
