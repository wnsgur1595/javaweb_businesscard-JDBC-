package kr.or.connect.BusinessCard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.BusinessCard.dto.BusinessCard;

public class BusinessCardDao {
	private static String dbUrl = "jdbc:mysql://localhost:3306/businessdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbPasswd = "connect123!@#";
	
	public Integer setBusinessCard(String name1, String phone1, String companyName1, java.sql.Date createDate1) {
		int Count = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO BusinessCard (name, phone, companyName, createDate) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, name1);
			ps.setString(2, phone1);
			ps.setString(3, companyName1);
			ps.setDate(4, (java.sql.Date) createDate1);
			Count = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Count;
	}
	
	public List<BusinessCard> getBusinessCard(String name) {
		BusinessCard bc = null;
		List<BusinessCard> bclist = new ArrayList<BusinessCard>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String sql = "SELECT * FROM BusinessCard WHERE name = ?";
		
		try(Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, name);
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name1 = rs.getString("name"); 
					String phone1 = rs.getString("phone");
					String companyName1 = rs.getString("companyName");
					java.sql.Date createDate1 = rs.getDate("createDate");
					bc = new BusinessCard(name1, phone1, companyName1, createDate1);
					bclist.add(bc);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bclist;
	}

}
