package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;


@Controller
@RequestMapping("/post")
public class NewController {
	@Autowired
	PostService postService;
	//新規作成
	@GetMapping("/new")
	public String home (){
		return "new";
	}
	
	
	@PostMapping("/new")
	public String postNew (@ModelAttribute Post post) {
		postService.insert(post);
		return "redirect:/post/sred";
	}
	
	@GetMapping("/sred")
	public String selectAll(@ModelAttribute Post post, Model model) {
		List<Post> posts = postService.selectAll();
		model.addAttribute("post", posts);
		return "sred";
	}
	//投稿削除
	@PostMapping("{id}")
	public String postDelete (@ModelAttribute Post post,@RequestParam int id) {
		postService.delete(id);
		return "redirect:/post/sred";
	}
	//投稿編集画面
	@PostMapping("/edit/{id}")
	public String indexPost (@ModelAttribute Post post,Model model,@PathVariable int id) {
		model.addAttribute("edit", postService.select(id));
		return "srededit";
	}
	
	//投稿編集
	@PostMapping("/edit")
	public String editPost(@ModelAttribute Post post,Model model) {
		postService.update(post);
		return "redirect:/post/sred";
	}
}
