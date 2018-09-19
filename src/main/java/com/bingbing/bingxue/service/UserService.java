package com.bingbing.bingxue.service;

import com.bingbing.bingxue.common.exception.BusinessException;
import com.bingbing.bingxue.entity.User;

public interface UserService {
	
	public void login(User user) throws BusinessException;
	
	public void register(User user) throws BusinessException;
	
}
