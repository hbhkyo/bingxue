package com.bingbing.bingxue.design.patterns.factory;
public class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
} 