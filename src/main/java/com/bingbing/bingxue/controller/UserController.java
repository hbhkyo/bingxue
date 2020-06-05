package com.bingbing.bingxue.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bingbing.bingxue.common.log.Log;
import com.bingbing.bingxue.entity.User;
import com.bingbing.bingxue.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/index") 
	public String index(){
		Log.info("index");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	@ResponseBody
	public String login(){
		Log.info("login");
		return "login";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST) 
	public String login(@ModelAttribute User user){
		Log.info("login");
		return "detail";
	}
}
