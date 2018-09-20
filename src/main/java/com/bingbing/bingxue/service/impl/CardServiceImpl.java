package com.bingbing.bingxue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bingbing.bingxue.common.exception.BusinessException;
import com.bingbing.bingxue.entity.Card;
import com.bingbing.bingxue.mapper.CardMapper;
import com.bingbing.bingxue.service.CardService;

@Service
public class CardServiceImpl implements CardService {
	
	@Resource
	private CardMapper cardMapper;

	@Override
	public void tiedCard(Card card) throws BusinessException {
		cardMapper.insert(card);
	}

	@Override
	public void tiedCardList(List<Card> cards) throws BusinessException {
		cardMapper.insertList(cards);
	}
	

}
