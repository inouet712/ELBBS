package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class TourokuController {
	@Autowired
     UserService userService; 
	 

	@GetMapping("/home")
	public String home (){
		return "home";
	}
	
	
	
	@PostMapping("/add")
	public String userAdd(@ModelAttribute User user) {
		userService.insert(user);
		return "redirect:/post/sred";
		}
	
	@GetMapping("/info")
	public String findAll(Model model,@ModelAttribute User user) {
		model.addAttribute("user",userService.findAll());
 		return "info";
	}
	
	@GetMapping("/info/{id}")
	public String findOne (Model model,@ModelAttribute User user, @PathVariable int id ) {
		model.addAttribute("info", userService.select(id));
		return "userInfo";
	}
	
	@PostMapping("/edit/{id}")
	public String editindex (@PathVariable int id,Model model, @ModelAttribute User user) {
		model.addAttribute("edit",userService.select(id) );
		return "infoedit";
	}
	
	@PostMapping("edit")
	public String edituser (@ModelAttribute User user,Model model) {
		int id = user.getId();
		userService.update(user);
		return "redirect:/user/info/" + id ; 
	}
	
	@PostMapping("{id}")
	public String deleteuser (@ModelAttribute User user,@PathVariable int id) {
		userService.delete(id);
		return "redirect:info";
	}

}
