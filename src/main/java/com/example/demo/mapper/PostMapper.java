package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Post;

@Repository
@Mapper
public interface PostMapper {
	
		
	List<Post> selectAll();
	
	Post select (int id);
		
	void insert (Post post);
	
	void delete (int id);
	
	void update (Post post);
	 
	
}



