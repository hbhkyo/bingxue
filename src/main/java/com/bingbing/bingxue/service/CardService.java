package com.bingbing.bingxue.service;

import java.util.List;

import com.bingbing.bingxue.common.exception.BusinessException;
import com.bingbing.bingxue.entity.Card;

public interface CardService {
	
	public void tiedCard(Card card) throws BusinessException;
	
	public void tiedCardList(List<Card> cards) throws BusinessException;
	
}
