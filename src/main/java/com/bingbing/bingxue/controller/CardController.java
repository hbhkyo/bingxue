package com.bingbing.bingxue.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingbing.bingxue.entity.Card;
import com.bingbing.bingxue.service.CardService;

@Controller
public class CardController {
	
	@Resource
	private CardService cardService;
	
	@RequestMapping(value = "/vue") 
	public String index(@ModelAttribute Card tempCard){
		return "vue";
	}
	
}
