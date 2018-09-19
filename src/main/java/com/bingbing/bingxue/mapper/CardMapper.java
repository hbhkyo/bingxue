package com.bingbing.bingxue.mapper;

import java.util.List;

import com.bingbing.bingxue.entity.Card;
import com.bingbing.bingxue.entity.User;

public interface CardMapper {

	/**
	 * 新增单个卡
	 * @param card
	 * @return
	 */
	int insert(Card card);
	
	/**
	 * 新增批量卡
	 * @param cards
	 * @return
	 */
	int insertList(List<Card> cards);
	
	/**
	 * 更新单个卡
	 * @param card
	 * @return
	 */
	int update(Card card);
	
	/**
	 * 查询单个卡
	 * @param card
	 * @return
	 */
	Card select(Card card);
	
	/**
	 * 查询批量卡
	 * @return
	 */
	List<Card> selectList(User user);
	
	/**
	 * 删除单个卡
	 * @param card
	 * @return
	 */
	int delete(Card card);
	
	/**
	 * 删除批量卡
	 * @param cards
	 * @return
	 */
	int deleteList(User user);
	
}
