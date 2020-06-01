package com.bingbing.bingxue.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bingbing.bingxue.common.exception.BusinessException;
import com.bingbing.bingxue.common.log.Log;
import com.bingbing.bingxue.common.util.JsonUtils;
import com.bingbing.bingxue.entity.User;
import com.bingbing.bingxue.mapper.UserMapper;
import com.bingbing.bingxue.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public void login(User user) throws BusinessException {
		user = userMapper.select(user);
		Log.info("user=="+JsonUtils.obj2json(user));
	}

	@Override
	public void register(User user) throws BusinessException {

	}

}
