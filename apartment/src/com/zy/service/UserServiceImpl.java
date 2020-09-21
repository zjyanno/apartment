package com.zy.service;

import java.util.ArrayList;

import com.zy.dao.UserDao;
import com.zy.model.User;

public class UserServiceImpl implements UserService {
	UserDao dao=new UserDao();
	@Override
	public ArrayList<User> findAll() {
		return dao.findAll();
	}
	@Override
	public User findInfoById(int uid) {
		
		return dao.findInfoById(uid);
	}
	@Override
	public int add(User user) {
		
		return dao.add(user);
	}
	@Override
	public User findUserById(int uid) {
		return dao.findUserById(uid);
	}
	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}
	@Override
	public void delUserById(int uid) {
		dao.delUserById(uid);
		
	}
	@Override
	public ArrayList<User> findUserAndWords(String field,String keywords) {
		
		ArrayList<User> user=null;
		//如果关键字为空,直接查全部
		if (keywords==null||"".equals(keywords)) {
			user=dao.findAll();
			return user;
		}
		user=dao.findUserAndWords(field,keywords);
		return user;
	}


}
