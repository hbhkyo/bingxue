package com.bingbing.bingxue.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bingbing.bingxue.common.log.Log;
import com.bingbing.bingxue.entity.User;
import com.bingbing.bingxue.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/index") 
	public String index(){
		User u = new User();
		u.setMobile("18627058835");
		userService.login(u);
		Log.info("第一个查询");
		return "index";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET) 
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST) 
	public String login(@ModelAttribute User user){
		Log.info(user.toString());
		return "index";
	}
}
