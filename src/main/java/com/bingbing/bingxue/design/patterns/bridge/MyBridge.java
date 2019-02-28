package com.bingbing.bingxue.design.patterns.bridge;
public class MyBridge extends Bridge {  
    public void method(){  
        getSource().method();  
    }  
} 