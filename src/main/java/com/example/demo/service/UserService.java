package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Service

public class UserService {
	@Autowired
     UserMapper userMapper;
	
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
	@Transactional
	public User select (int id) {
		return userMapper.select(id);
	}
	
	
	@Transactional
    public  void insert(User user) {
        userMapper.insert(user);
    }
	
	@Transactional
	public void update (User user) {
		userMapper.update(user);
	}
	
	@Transactional
	public void delete (int id) {
		userMapper.delete(id);
	}
}
