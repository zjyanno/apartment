package com.zy.service;

import java.util.ArrayList;

import com.zy.model.User;

public interface UserService {

	ArrayList<User> findAll();

	User findInfoById(int uid);

	int add(User user);

	User findUserById(int uid);

	void updateUser(User user);

	void delUserById(int uid);

	ArrayList<User> findUserAndWords(String field,String keywords);
}
