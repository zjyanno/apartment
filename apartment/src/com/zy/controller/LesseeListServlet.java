package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.Lessee;
import com.zy.service.LesseeService;
import com.zy.service.LesseeServiceImpl;

@WebServlet("/lesseeList")
public class LesseeListServlet extends HttpServlet{
	LesseeService service=new LesseeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Lessee> lessee=service.findAll();
		req.setAttribute("lessee", lessee);
		req.getRequestDispatcher("/view/flats/lesseeList.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
