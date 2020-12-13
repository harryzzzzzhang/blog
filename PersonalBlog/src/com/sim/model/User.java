package com.sim.model;

public class User {

	private String userEmail;
	private String userNickname;
	private String userPassword;
	private String userName;
	private String userSex;
	private String userBriefIntroduction;
	private String userState;
	
	public User() {
		
	}
	
//	public User(String userEmail, String userState) {
//		super();
//		this.userEmail=userEmail;
//		this.userState=userState;
//	}
	
	public User(String userEmail, String userPassword,String userNickname) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
	}
	
	public User(String userNickname, String userName, String userSex,
			String userBriefIntroduction, String userState) {
		super();
		this.userNickname = userNickname;
		this.userName = userName;
		this.userSex = userSex;
		this.userBriefIntroduction = userBriefIntroduction;
		this.userState = userState;
	}
	

	//管理员只有邮箱和密码 登陆时只需要用户名和密码
	public User(String userEmail, String userPassword) {
		// TODO Auto-generated constructor stub
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBriefIntroduction() {
		return userBriefIntroduction;
	}
	public void setUserBriefIntroduction(String userBriefIntroduction) {
		this.userBriefIntroduction = userBriefIntroduction;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
}
