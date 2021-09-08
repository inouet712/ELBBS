package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Comments;

@Repository
@Mapper
public interface CommentsMapper {
	
	 List<Comments> selectAll();
	
	List<Comments> findAllOrderBy(int comment_id);
	
	void insert(Comments comments);
	
	Comments select(int comment_id);
	
	Comments selectOne(String comment_name);

	void update(Comments comments);
	
	void delete(String comment_name);

}
