package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Comments;
import com.example.demo.mapper.CommentsMapper;
@Service
public class CommentsService {
	
	@Autowired
	CommentsMapper commentsMapper;
	
	
	@Transactional
	public List<Comments> selectAll(){
	return commentsMapper.selectAll();
	}
	
	@Transactional
	public List<Comments> findAllOrderBy(int comment_id){
	return commentsMapper.findAllOrderBy(comment_id);
	}
	
	@Transactional
	public void insert (Comments comments) {
	 commentsMapper.insert(comments);
	}
	
	@Transactional
	public Comments select(int comment_id) {
	return	commentsMapper.select(comment_id);
	}
	
	@Transactional
	public Comments selectOne(String comment_name) {
		return commentsMapper.selectOne(comment_name);
	}
	
	@Transactional
	public void delete (String comment_name) {
		commentsMapper.delete(comment_name);
	}
	
	@Transactional
	public void update (Comments comments) {
		commentsMapper.update(comments);
	}
}
