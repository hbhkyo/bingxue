package com.bingbing.bingxue.common.log;

import org.apache.log4j.Logger;

public class Log {
	
	private static Logger log = Logger.getLogger(Log.class);
	 
	public static void info(String msg){
		log.info(getAction() + msg);
	}
 
	public static void error(String msg){
		log.error(getAction() + msg);
	}

	public static void error(String msg,Throwable e){
		log.error(getAction() + msg , e);
	}

	private static String getAction() {
		StackTraceElement elements = Thread.currentThread().getStackTrace()[3];
		return elements.getClassName() + "." + elements.getMethodName()+"() LineNumber=="+elements.getLineNumber() +" ";
	}
}
