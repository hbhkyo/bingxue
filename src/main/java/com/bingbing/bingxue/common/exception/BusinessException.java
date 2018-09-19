package com.bingbing.bingxue.common.exception;

public class BusinessException  extends RuntimeException{
	
	private static final long serialVersionUID = 1081433669641515924L;
	
	private String code ;
	
	public BusinessException(String code) {
		super();
		this.code = code;
	}
	
	public BusinessException(String code,String message) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
