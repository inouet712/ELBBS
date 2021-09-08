package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Comments;
import com.example.demo.domain.Post;
import com.example.demo.service.CommentsService;
import com.example.demo.service.PostService;

@Controller

@RequestMapping("/sentence")
public class CommentController {
	//作成したserviceを2つ使用するとき
	@Autowired
	PostService postService;
	@Autowired
	CommentsService commentsService;
	//**
	private Object get;
	//
	
	
	
	//スレッドの情報取得、コメント:すれっどのIDを使用して表示
	@GetMapping("/comment/{id}") 
		public String getPost(@PathVariable int id,@ModelAttribute Post post,@ModelAttribute Comments comments,Model model) {
		model.addAttribute("post", postService.select(id));
		System.out.println(id);
		//スレッドのIDを使用して表示
 		model.addAttribute("comments" , commentsService.findAllOrderBy(id));
 		//
		return "coment";
	}
			
	@PostMapping("/addcontent")
	public String contentAdd (@ModelAttribute Comments comments, @ModelAttribute Post post) {
		//コメントの中に格納したpost.idをcomment_idとして持ってくる
		int id = comments.getComment_id();
		//
		commentsService.insert(comments);
		return "redirect:/sentence/comment/" + id ;
	}
	//削除
	@PostMapping("{id}")
	public String deleteID (@RequestParam String comment_name,@ModelAttribute Comments comments,@PathVariable int id , @ModelAttribute Post post) {
		int postid = post.getId();
		commentsService.delete(comment_name);
		return "redirect:/sentence/comment/" + postid ;
	}
	
	//編集画面表示
	@PostMapping("/edit/{id}")
	public String editIndex (@PathVariable int id, Model model,@ModelAttribute Comments comments,@ModelAttribute Post post) {
			model.addAttribute("edit", postService.select(id));
		return "edit";
	}
	
	//コメント編集
	@PostMapping("/edit")
	public String update(@ModelAttribute Comments comments,Model model, @ModelAttribute Post post) {
		int id = comments.getComment_id();
		commentsService.update(comments);
		return "redirect:/sentence/comment/" + id ;
	}
}
