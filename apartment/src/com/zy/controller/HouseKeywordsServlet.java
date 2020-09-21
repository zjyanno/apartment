package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.House;
import com.zy.model.User;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;
@WebServlet("/houseKeywords")
public class HouseKeywordsServlet extends HttpServlet{
	HouseService service=new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数-->关键字
		String keywords = req.getParameter("keywords");
		//接收参数-->查询字段
		String field = req.getParameter("field");
		System.out.println("接收keywords="+keywords);
		System.out.println("接收field="+field);
		//调用业务层传参数
		ArrayList<House> house = service.findUserAndWords(field,keywords);
		req.setAttribute("house", house);
		//页面跳转
		req.getRequestDispatcher("/view/flats/houseList.jsp").forward(req, resp);
	}
}
