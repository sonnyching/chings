package com.chings.core.model;

public class User {
	private String userid;
	private String username;
	private String nickname;
	private String sex;
	private int age;
	private String info;
	
	public User() {
	}
	public User(String userid, String username, String nickname, String sex, int age, String info) {
		super();
		this.userid = userid;
		this.username = username;
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
		this.info = info;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
