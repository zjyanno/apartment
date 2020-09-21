package com.zy.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.model.Lessee;
import com.zy.service.LesseeService;
import com.zy.service.LesseeServiceImpl;
@WebServlet("/lesseeUpdate")
public class LesseeUpdateServlet extends HttpServlet{
	LesseeService service=new LesseeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lid = Integer.parseInt(req.getParameter("lid"));
		Lessee lessee=service.findLesseeById(lid);
		if (lessee!=null) {
			req.setAttribute("lessee", lessee);
			req.getRequestDispatcher("view/flats/lesseeUpdate.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String lid = req.getParameter("lid");
		String lname = req.getParameter("lname");
		String ltel = req.getParameter("ltel");
		String lsex = req.getParameter("lsex");
		String lnp = req.getParameter("lnp");
		String lidCard = req.getParameter("lidCard");
		
		Lessee lessee = new Lessee();
		lessee.setLid(Integer.parseInt(lid));
		lessee.setLname(lname);
		lessee.setLtel(ltel);
		lessee.setLsex(Integer.parseInt(lsex));
		lessee.setLnp(lnp);
		lessee.setLidCard(lidCard);
		Date laddTime = new Date();
		lessee.setLaddTime(laddTime);
		
		service.updateLessee(lessee);
		req.getRequestDispatcher("/lesseeList").forward(req, resp);
	}
}
