package com.multi.todolist.user.model.dto;

import java.sql.Date;

public  class UserDTO {
	
	private String userId;
	private String pw;
	private String name;
	private String phone;
	private Date createdDate;
	private String isdeleted;
	private Date deletedDate;
	
	public UserDTO() {
		
	};
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", createdDate="
				+ createdDate + ", isdeleted=" + isdeleted + ", deletedDate=" + deletedDate + "]";
	}


	

}
