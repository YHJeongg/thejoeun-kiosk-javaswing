package com.javalec.dto;

public class kioskOrderDto {
	
	String productid;
	int productprice;
	String productcategory;
	String productinitdate;
	
	public kioskOrderDto() {
		
	}
	
	public kioskOrderDto(String productid, int productprice) {
		super();
		this.productid = productid;
		this.productprice = productprice;
	}
	
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getProductinitdate() {
		return productinitdate;
	}
	public void setProductinitdate(String productinitdate) {
		this.productinitdate = productinitdate;
	}
	

}
