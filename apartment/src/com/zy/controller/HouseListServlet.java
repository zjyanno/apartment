package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.dao.HouseDao;
import com.zy.model.House;
import com.zy.service.HouseService;
import com.zy.service.HouseServiceImpl;

@WebServlet("/houseList")
public class HouseListServlet extends HttpServlet{
	HouseService service = new HouseServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//pageSize是客户给定的
		int pageSize=3;
		int end=pageSize;
		String pageNoStr = req.getParameter("pageNo");
		//pageNo是当前页
		if (pageNoStr==null||"".equals(pageNoStr)) {
			pageNoStr="1";
		}
		int pageNo=Integer.parseInt(pageNoStr);
		//总条数=调用service,查询数据库,计算总条数
		int total=service.count();
		System.out.println("查到的total"+total);
		//pageCount是总页数
		int pageCount=total%pageSize==0 ? total/pageSize : total/pageSize+1;
		System.out.println("解析过的,页面接受的当前页码:"+pageNo);
		
		int start=(pageNo-1)*pageSize;
		ArrayList<House> house = service.findAll(start,end);
		//将查询的数据返回
		req.setAttribute("house", house);
		//将分页数据返回
		req.setAttribute("pageNo",pageNo );//当前页
		req.setAttribute("pageCount",pageCount );//总页数
		req.setAttribute("total",total );//总条数
		req.getRequestDispatcher("/view/flats/houseList.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
