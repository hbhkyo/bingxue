package com.bingbing.bingxue;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bingbing.bingxue.webservice.client.ArrayOfString;
import com.bingbing.bingxue.webservice.client.IpAddressSearchWebServiceSoap;
import com.bingbing.bingxue.webservice.client.WeatherWebServiceSoap;

public class AppTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {  
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cxf-client.xml");  
		
        try {
			IpAddressSearchWebServiceSoap client = (IpAddressSearchWebServiceSoap) ctx.getBean("client");  
			ArrayOfString result = client.getCountryCityByIp("120.202.26.116") ;
			System.out.println(result);
		} catch (BeansException e) {
			e.printStackTrace();
		}  
		System.out.println("--------------------------------------------------------------------------");
		try {
			WeatherWebServiceSoap client2 = (WeatherWebServiceSoap) ctx.getBean("client2");  
			 ArrayOfString result2 = client2.getWeatherbyCityName("武汉");
			System.out.println(result2);
		} catch (BeansException e) {
			e.printStackTrace();
		}  
    }  
}
