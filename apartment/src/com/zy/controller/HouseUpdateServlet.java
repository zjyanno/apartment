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

import com.zy.dao.HouseDao;
import com.zy.model.House;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;


@WebServlet("/houseUpdate")
public class HouseUpdateServlet extends HttpServlet{
	HouseService service=new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hid = Integer.parseInt(req.getParameter("hid"));
		//根据id查询数据库
		//House house=HouseDao.findHouseById(id);
		//调用业务层对象,将数据传递给业务层
		/*				boolean result=service.findUserById(hid);
						if (result) {
							
						}*/
		House house=service.findHouseById(hid);
		if (house!=null) {
			req.setAttribute("house", house);
			req.getRequestDispatcher("/view/flats/houseUpdate.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String hid = req.getParameter("hid");
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
		String haddTime = req.getParameter("haddTime");
	
		
		House house = new House();
		house.setHid(Integer.parseInt(hid));
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
		
		try {
			house.setHaddTime(new SimpleDateFormat("yyyy-MM-dd").parse(haddTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date hupdateTime = new Date();
		house.setHupdateTime(hupdateTime);
		service.updateHouse(house);
		req.getRequestDispatcher("/houseList").forward(req, resp);
	}
}


