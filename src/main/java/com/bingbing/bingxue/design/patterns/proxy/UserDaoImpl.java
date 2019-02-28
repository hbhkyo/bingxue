package com.bingbing.bingxue.design.patterns.proxy;
public class UserDaoImpl implements UserDao{

	@Override
	public void save() {
		System.out.println("UserDaoImpl save");
	}
   
}