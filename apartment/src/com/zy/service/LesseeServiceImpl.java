package com.zy.service;

import java.util.ArrayList;

import com.zy.dao.LesseeDao;
import com.zy.model.Lessee;

public class LesseeServiceImpl implements LesseeService {
	LesseeDao dao=new LesseeDao();
	@Override
	public ArrayList<Lessee> findAll() {
		return dao.findAll();
	}
	@Override
	public Lessee findInfoById(int lid) {
		return dao.findInfoById(lid);
	}
	@Override
	public int add(Lessee lessee) {
		return dao.add(lessee);
	}
	@Override
	public Lessee findLesseeById(int lid) {
		return dao.findLesseeById(lid);
	}
	@Override
	public void updateLessee(Lessee lessee) {
		dao.updateLessee(lessee);
		
	}
	@Override
	public void delLesseeById(int lid) {
		dao.delLesseeById(lid);
	}


}
