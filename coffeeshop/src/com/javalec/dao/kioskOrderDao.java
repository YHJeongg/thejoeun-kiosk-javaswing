package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.kioskOrderDto;
import com.javalec.util.DBConnect;

public class kioskOrderDao {

	String productid;
	
	public kioskOrderDao() {
		// TODO Auto-generated constructor stub
	}

	// Table Click
	public kioskOrderDao(String productid) {
		super();
		this.productid = productid;
	}
	
	public ArrayList<kioskOrderDto> selectList() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListCoffeeIce() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'coffeeIce'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListCoffeeHot() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'coffeeHot'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListSmoothie() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'smoothie'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListAid() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'aid'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListTea() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'tea'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	public ArrayList<kioskOrderDto> selectListJucie() {

		ArrayList<kioskOrderDto> dtoList = new ArrayList<kioskOrderDto>();

		String whereStatement = "select productid, productprice from product where productcategory = 'jucie'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				kioskOrderDto kioskOrderDto = new kioskOrderDto(wkPid, wkPprice);
				dtoList.add(kioskOrderDto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;

	}

	// 테이블 클릭하였을 때
	public kioskOrderDto tableClick() {
		kioskOrderDto dto = null;

		String whereStatement = "select productid, productprice from product ";
		String whereStatement2 = "where productid = " + "'" + productid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				String wkPid = rs.getString(1);
				int wkPprice = rs.getInt(2);

				dto = new kioskOrderDto(wkPid, wkPprice);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

}
