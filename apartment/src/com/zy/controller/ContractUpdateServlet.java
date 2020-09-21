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
@WebServlet("/contractUpdate")
public class ContractUpdateServlet extends HttpServlet{
	ContractService service =new ContractServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		Contract contract=service.findContractById(cid);
		System.out.println("查到的contract="+contract);
		if (contract!=null) {
			req.setAttribute("contract", contract);
			req.getRequestDispatcher("view/flats/contractUpdate.jsp").forward(req, resp);			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cid = req.getParameter("cid");
		String cnum = req.getParameter("cnum");
		String chid = req.getParameter("chid");
		String clid = req.getParameter("clid");
		//ctime
		String cstartTime = req.getParameter("cstartTime");
		String cendTime = req.getParameter("cendTime");
		String ctotalMoney = req.getParameter("ctotalMoney");
		String cpayType = req.getParameter("cpayType");
		
		Contract contract = new Contract();
		contract.setCid(Integer.parseInt(cid));
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
		contract.setCtotalMoney(Double.parseDouble(ctotalMoney));
		contract.setCpayType(Integer.parseInt(cpayType));
		service.updateContract(contract);
		req.getRequestDispatcher("/contractList").forward(req, resp);
		
	}
}
