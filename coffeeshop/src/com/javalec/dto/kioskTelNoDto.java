package com.javalec.dto;

import com.javalec.dao.kioskTelNoDao;

public class kioskTelNoDto {
	String custphone;
	public static String custid;
	

	public kioskTelNoDto(String custphone) {
		super();
		this.custphone = custphone;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	
	public static String getCustid() {
		return custid;
	}

	public static String setCustid(String custid) {
		kioskTelNoDao.custid = custid;
		return custid;
	}
	
}
