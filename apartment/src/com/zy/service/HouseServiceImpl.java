package com.zy.service;

import java.util.ArrayList;

import com.zy.dao.HouseDao;
import com.zy.model.House;

public class HouseServiceImpl implements HouseService {

	
	HouseDao dao = new HouseDao();

	@Override
	public ArrayList<House> findAll() {
		
		return dao.findAll();
	}

	@Override
	public House findInfoById(int hid) {
		return dao.findInfoById(hid);
	}

	@Override
	public void delHouseById(int hid) {
		dao.delHouseById(hid);
	}

	@Override
	public House findHouseById(int hid) {
		return dao.findHouseById(hid);
	}

	@Override
	public void updateHouse(House house) {
		dao.updateHouse(house);
	}

	@Override
	public int houseInsert(House house) {
		return dao.insert(house);
		
	}

	@Override
	public ArrayList<House> findUserAndWords(String field, String keywords) {
		ArrayList<House> house=null;
		if (keywords==null||"".equals(keywords)) {
			house=dao.findAll();
			return house;
		}
		house=dao.findHouseAndWords(field,keywords);
		return house;
	}

	@Override
	public ArrayList<House> findAll(int start, int end) {
		return dao.findAll(start,end);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}
}
