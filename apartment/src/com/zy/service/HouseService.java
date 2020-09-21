package com.zy.service;

import java.util.ArrayList;

import com.zy.model.House;

public interface HouseService {

	ArrayList<House> findAll();

	House findInfoById(int hid);

	void delHouseById(int hid);

	House findHouseById(int hid);

	void updateHouse(House house);

	int houseInsert(House house);

	ArrayList<House> findUserAndWords(String field, String keywords);

	ArrayList<House> findAll(int start, int end);

	int count();


}
