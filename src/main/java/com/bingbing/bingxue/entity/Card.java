package com.bingbing.bingxue.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Card {
	
	private Integer id ;
	private Integer userId ;
	private String cardNo ;
	private String cardName ;
	private BigDecimal amt ;
	private String isValid;
	private String creatUser;
	private String updateUser;
	private Timestamp creatDate;
	private Timestamp updateDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getCreatUser() {
		return creatUser;
	}
	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Timestamp getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Timestamp creatDate) {
		this.creatDate = creatDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", userId=" + userId + ", cardNo=" + cardNo + ", cardName=" + cardName + ", amt="
				+ amt + ", isValid=" + isValid + ", creatUser=" + creatUser + ", updateUser=" + updateUser
				+ ", creatDate=" + creatDate + ", updateDate=" + updateDate + "]";
	}
}
