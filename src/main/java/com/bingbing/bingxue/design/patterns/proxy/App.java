package com.bingbing.bingxue.design.patterns.proxy;
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDaoImpl();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();//执行的是代理的方法
        
        dynamic();
        
        dynamicCglib();
    }
    
    
    public static void dynamic() {
        // 目标对象
        UserDao target = new UserDaoImpl();
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();
    }
    
    public static void dynamicCglib() {
        // 目标对象
        UserDao target = new UserDaoImpl();
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        UserDao proxy = (UserDao) new ProxyFactoryCglib(target).getProxyInstance();
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();
    }
    
    
    
    /*如果加入容器的目标对象有实现接口,用JDK代理
  　　如果目标对象没有实现接口,用Cglib代理 　　
  　　如果目标对象实现了接口，且强制使用cglib代理，则会使用cglib代理。*/
}