package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.service.LesseeService;
import com.zy.service.LesseeServiceImpl;
@WebServlet("/lesseeDel")
public class LesseeDelServlet extends HttpServlet{
	LesseeService service=new LesseeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lid = Integer.parseInt(req.getParameter("lid"));
		service.delLesseeById(lid);
		req.getRequestDispatcher("/lesseeList").forward(req, resp);
	}
}
