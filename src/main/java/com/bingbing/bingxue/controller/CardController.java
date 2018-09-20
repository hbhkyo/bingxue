package com.bingbing.bingxue.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bingbing.bingxue.common.log.Log;
import com.bingbing.bingxue.entity.Card;
import com.bingbing.bingxue.service.CardService;

@Controller
public class CardController {
	
	@Resource
	private CardService cardService;
	
	@RequestMapping(value = "/index2") 
	public String index(@ModelAttribute Card tempCard){
		Log.info("tempCard=="+tempCard);
		Card card = new Card();
		card.setUserId(1);
		card.setAmt(new BigDecimal(100));
		card.setCardName("建设银行");
		card.setCardNo("622666555666777666");
		card.setIsValid("1");
		card.setCreatUser("program");
		card.setCreatDate(new Timestamp(new Long(111111)));
		cardService.tiedCard(card);
		Log.info("第一个插入");
		Log.info("card == id=="+card);
		
		
		Card newCard = new Card();
		BeanUtils.copyProperties(card, newCard);
		newCard.setCardName("中国银行");
		newCard.setCardNo("622888999666888999");
		
		
		Card newCardnew = new Card();
		BeanUtils.copyProperties(card, newCardnew);
		newCardnew.setCardName("农业银行");
		newCardnew.setCardNo("622111222111222111");
		
		
		
		List<Card> cards = new ArrayList<Card>();
		cards.add(newCard);
		cards.add(newCardnew);
		cardService.tiedCardList(cards);
		return "index";
	}
	
}
