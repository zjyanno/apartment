package com.zy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.Contract;
import com.zy.service.ContractService;
import com.zy.service.ContractServiceImpl;
@WebServlet("/contractKeywords")
public class ContractKeywordsServlet extends HttpServlet{
	ContractService service=new ContractServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keywords = req.getParameter("keywords");
		String field = req.getParameter("field");
		ArrayList<Contract> contract=service.findContractAndWords(field,keywords);
		req.setAttribute("contract", contract);
		req.getRequestDispatcher("/view/flats/contractList.jsp").forward(req, resp);
	}
}
