package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.House;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;
@WebServlet("/houseDel")
public class HouseDelServlet extends HttpServlet{
	HouseService service=new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hid = Integer.parseInt(req.getParameter("hid"));
		service.delHouseById(hid);
		req.getRequestDispatcher("/houseList").forward(req, resp);
		
	}

}
