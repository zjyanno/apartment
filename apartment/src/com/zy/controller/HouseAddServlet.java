package com.zy.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zy.model.House;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;

@WebServlet("/houseAdd")
public class HouseAddServlet extends HttpServlet{
	
	HouseService service=new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/flats/houseAdd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//int hid = Integer.valueOf(req.getParameter("hid"));
		String haddress = req.getParameter("haddress");
		String hfloor = req.getParameter("hfloor");
		String hroomNum = req.getParameter("hroomNum");
		String harea = req.getParameter("harea");
		String hdir = req.getParameter("hdir");
		String hdeco = req.getParameter("hdeco");
		String hair = req.getParameter("hair");
		String hprice = req.getParameter("hprice");
		String hrentStatus = req.getParameter("hrentStatus");
		String himage = req.getParameter("himage");
				
		
		
		House house = new House();
		house.setHaddress(haddress);
		house.setHfloor(hfloor);
		house.setHroomNum(Integer.parseInt(hroomNum));
		house.setHarea(harea);
		house.setHdir(hdir);
		house.setHdeco(Integer.parseInt(hdeco));
		house.setHair(Integer.parseInt(hair));
		house.setHprice(Double.parseDouble(hprice));
		house.setHrentStatus(Integer.parseInt(hrentStatus));
		house.setHimage(himage);
		Date haddTime = new Date();
		house.setHaddTime(haddTime);
		
//		Date hupdateTime = new Date();
//		house.setHupdateTime(hupdateTime);
		
		int num=service.houseInsert(house);
		if (num>0) {
			req.getRequestDispatcher("/houseList").forward(req, resp);
		}
	}	
}
