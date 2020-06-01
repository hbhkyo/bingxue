package com.bingbing.bingxue.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class User {
	
	private Integer id ;
	/*private String name ;
	private String nickname ;*/
	private Integer age ;
	private Date birthday ;
	private String mobile;
	private String idNo;
	private String isValid;
	private String creatUser;
	private String updateUser;
	private Timestamp creatDate;
	private Timestamp updateDate;
	private List<Card> cards;
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}*/
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
		return "User [id=" + id + ", name=" + "" + ", nickname=" + "" + ", age=" + age + ", birthday="
				+ birthday + ", mobile=" + mobile + ", idNo=" + idNo + ", isValid=" + isValid + ", creatUser="
				+ creatUser + ", updateUser=" + updateUser + ", creatDate=" + creatDate + ", updateDate=" + updateDate
				+ ", cards=" + cards + "]";
	}
}
