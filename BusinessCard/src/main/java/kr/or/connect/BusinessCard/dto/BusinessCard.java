package kr.or.connect.BusinessCard.dto;


public class BusinessCard {
	private String name;
	private String phone;
	private String companyName;
	private java.sql.Date createDate;
	
	public BusinessCard() {}
	public BusinessCard(String name, String phone, String companyName, java.sql.Date createDate) {
		this.name = name;
		this.phone = phone;
		this.companyName = companyName;
		this.createDate = createDate;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public java.sql.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "BusinessCard [name=" + name + ", phone=" + phone + ", companyName=" + companyName + ", createDate="
				+ createDate + "]";
	}
}
