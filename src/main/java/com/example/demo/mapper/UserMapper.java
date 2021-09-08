package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    
    
    User select(int id);
    
    void insert(User user);
    
    void update(User user);
    
    void delete(int id);

	

	
    
	
}