package com.bingbing.bingxue.dao;

import java.util.List;

import com.bingbing.bingxue.entity.User;

public interface UserDAO {
	/**
	 * 新增单个用户
	 * @param user
	 * @return
	 */
	int insert(User user);
	
	/**
	 * 更新单个用户
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * 查询单个用户
	 * @param user
	 * @return
	 */
	User select(User user);
	
	/**
	 * 查询批量用户
	 * @return
	 */
	List<User> selectList();
	
	/**
	 * 删除单个用户
	 * @param user
	 * @return
	 */
	int delete(User user);
	
}
