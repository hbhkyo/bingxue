package com.bingbing.bingxue.design.patterns.singleton;
public class Singleton2 {  
  
	private static volatile Singleton2 instance = null;//jdk5以上
    /* 私有构造方法，防止被实例化 */  
    private Singleton2() {  
    }  
  
    /* 获取实例 */  
    public static Singleton2 getInstance() {  
        if (instance == null) {  
            synchronized (instance) {  
                if (instance == null) {  
                    instance = new Singleton2();  
                }  
            }  
        }  
        return instance;  
    } 
}  