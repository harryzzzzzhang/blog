package com.sim.model;

public class Passage {

	private int ID;
	private String title;
	private String content;
	private String style;
	private String publishTime;
	private String updateTime;
	private String userEmail;
	
	public Passage() {
		
	}
	
	public Passage(int ID, String title, String content, String style, String publishTime, String updateTime, String userEmail) {
		super();
		this.ID = ID;
		this.title = title;
		this.content = content;
		this.style = style;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.userEmail = userEmail;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
