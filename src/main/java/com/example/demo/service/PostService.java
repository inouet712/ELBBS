package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Post;
import com.example.demo.mapper.PostMapper;

@Service
public class PostService {

	@Autowired
	PostMapper postMapper;
	
	@Transactional
	public List<Post> selectAll() {
	return postMapper.selectAll();
	}
	
	@Transactional
	public void insert(Post post) {
		postMapper.insert(post);
	}
	
	@Transactional
	public Post select (int id) {
		return postMapper.select(id);
	}
	
	@Transactional
	public void delete (int id) {
		 postMapper.delete(id);
	}
	
	@Transactional
	public void update (Post post) {
		postMapper.update(post);
	}
}
