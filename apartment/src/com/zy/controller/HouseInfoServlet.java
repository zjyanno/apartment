package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.dao.HouseDao;
import com.zy.model.House;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;
@WebServlet("/houseInfo")
public class HouseInfoServlet extends HttpServlet{
	HouseService service=new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int hid = Integer.valueOf(req.getParameter("hid"));
		House house = service.findInfoById(hid);
		req.setAttribute("house", house);
		req.getRequestDispatcher("/view/flats/houseInfo.jsp").forward(req, resp);
	}
}
