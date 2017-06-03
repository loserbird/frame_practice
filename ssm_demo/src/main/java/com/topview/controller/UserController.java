package com.topview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topview.model.User;
import com.topview.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/getUser")
	@ResponseBody
	public User getUser(@RequestParam("id") int id){
		User user = this.userService.getUser(id);
		return user;
	}
}
