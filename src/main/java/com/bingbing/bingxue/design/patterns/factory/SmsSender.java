package com.bingbing.bingxue.design.patterns.factory;
public class SmsSender implements Sender {  
  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
} 