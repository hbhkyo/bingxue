package com.bingbing.bingxue.design.patterns.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactoryCglib{

	private Object target;

    public ProxyFactoryCglib(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(new MethodInterceptor(){
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			   System.out.println("开始事务...");
			   //执行目标对象的方法
		       Object returnValue = method.invoke(target, args);
		       System.out.println("提交事务...");
			   return returnValue;
			}
        });
        //4.创建子类(代理对象)
        return en.create();
    }
}