package com.fishinwater.situp.beans;

public class UserBean {
	
	private String user_id;
	
	private String user_name;
	
	private String user_password;
	
	private String user_introduction;
	
	private String user_head_img;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_introduction() {
		return user_introduction;
	}

	public void setUser_introduction(String user_introduction) {
		this.user_introduction = user_introduction;
	}

	public String getUser_head_img() {
		return user_head_img;
	}

	public void setUser_head_img(String user_head_img) {
		this.user_head_img = user_head_img;
	}

	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_introduction=" + user_introduction + ", user_head_img=" + user_head_img + "]";
	}

}
