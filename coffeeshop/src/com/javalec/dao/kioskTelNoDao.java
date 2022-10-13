package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.dto.kioskTelNoDto;
import com.javalec.util.DBConnect;

public class kioskTelNoDao {
	
	public static String custid;
	String custphone;
	
	public kioskTelNoDao() {
		// TODO Auto-generated constructor stub

	}

	public kioskTelNoDao(String custphone) {
		super();
		this.custphone = custphone;
	}

	public kioskTelNoDto checkCustPhone() {
		kioskTelNoDto dto = null;

		String whereStatement = "select custid from customer ";
		String whereStatement2 = "where custphone = " + "'" + custphone + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				String wkCid = rs.getString(1);

				dto = new kioskTelNoDto(wkCid);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
}
