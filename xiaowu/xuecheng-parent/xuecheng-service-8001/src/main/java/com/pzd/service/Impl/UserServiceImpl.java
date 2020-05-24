package com.pzd.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzd.bean.User;
import com.pzd.mapper.UserMapper;
import com.pzd.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermapper;
	
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return usermapper.list();
	}

	@Override
	public Boolean add(User user) {
		// TODO Auto-generated method stub
		return usermapper.add(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return usermapper.updateByPrimaryKey(user);
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		usermapper.deleteByPrimaryKey(id);
		return true;
	}

}
