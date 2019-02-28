package com.bingbing.bingxue.design.patterns.factory;
public class SendMailFactory implements Provider {  
      
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  