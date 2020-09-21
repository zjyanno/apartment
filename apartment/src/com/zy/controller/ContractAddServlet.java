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

import com.zy.model.Contract;
import com.zy.service.ContractService;
import com.zy.service.ContractServiceImpl;
@WebServlet("/contractAdd")
public class ContractAddServlet extends HttpServlet{
	ContractService service=new ContractServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/flats/contractAdd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		
		String cnum = req.getParameter("cnum");
		String chid = req.getParameter("chid");
		String clid = req.getParameter("clid");
		//ctime
		String cstartTime = req.getParameter("cstartTime");
		String cendTime = req.getParameter("cendTime");
		String ctotalMoney = req.getParameter("ctotalMoney");
		String cpayType = req.getParameter("cpayType");
		
		Contract contract = new Contract();
		
		contract.setCnum(cnum);
		contract.setChid(Integer.parseInt(chid));
		contract.setClid(Integer.parseInt(clid));
		Date ctime = new Date();
		contract.setCtime(ctime);
		try {
			contract.setCstartTime(new SimpleDateFormat("yyyy-MM-dd").parse(cstartTime));
			contract.setCendTime(new SimpleDateFormat("yyyy-MM-dd").parse(cendTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("contract添加到的数据"+contract);
		
		contract.setCtotalMoney(Double.parseDouble(ctotalMoney));
		contract.setCpayType(Integer.parseInt(cpayType));
		
		int num=service.add(contract);
		if (num>0) {
			req.getRequestDispatcher("/contractList").forward(req, resp);
		}
	}
}
