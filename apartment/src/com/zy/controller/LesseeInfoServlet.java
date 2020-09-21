package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.Lessee;
import com.zy.service.LesseeService;
import com.zy.service.LesseeServiceImpl;


@WebServlet("/lesseeInfo")
public class LesseeInfoServlet extends HttpServlet{
	LesseeService service=new LesseeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lid = Integer.parseInt(req.getParameter("lid"));
		Lessee lessee=service.findInfoById(lid);
		req.setAttribute("lessee", lessee);
		req.getRequestDispatcher("/view/flats/lesseeInfo.jsp").forward(req, resp);
	}
}
