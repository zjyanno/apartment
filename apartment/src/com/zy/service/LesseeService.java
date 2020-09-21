package com.zy.service;

import java.util.ArrayList;

import com.zy.model.Lessee;

public interface LesseeService {

	ArrayList<Lessee> findAll();

	Lessee findInfoById(int lid);

	int add(Lessee lessee);

	Lessee findLesseeById(int lid);

	void updateLessee(Lessee lessee);

	void delLesseeById(int lid);

	

}
