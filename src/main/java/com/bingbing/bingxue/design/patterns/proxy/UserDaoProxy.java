package com.bingbing.bingxue.design.patterns.proxy;
public class UserDaoProxy implements UserDao{
    //接收保存目标对象
    private UserDao target;
    public UserDaoProxy(UserDao target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}