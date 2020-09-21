package com.zy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.service.ContractService;
import com.zy.service.ContractServiceImpl;
@WebServlet("/contractDel")
public class ContractDelServlet extends HttpServlet{
	ContractService service=new ContractServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		service.delContractById(cid);
		req.getRequestDispatcher("/contractList").forward(req, resp);
	}
}
