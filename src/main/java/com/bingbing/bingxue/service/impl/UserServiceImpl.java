package com.bingbing.bingxue.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bingbing.bingxue.common.exception.BusinessException;
import com.bingbing.bingxue.dao.UserDAO;
import com.bingbing.bingxue.entity.User;
import com.bingbing.bingxue.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDAO userDAO;

	@Override
	public void login(User user) throws BusinessException {
		userDAO.select(user);
	}

	@Override
	public void register(User user) throws BusinessException {

	}

}
