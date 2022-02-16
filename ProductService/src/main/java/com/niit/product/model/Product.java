package com.niit.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	int productid;
	String productname;
	String productdesc;
	String available;
	double price;
	
	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Product(int productid, String productname, String productdesc, String available, double price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productdesc = productdesc;
		this.available = available;
		this.price = price;
	}
	
	public Product() {}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productdesc=" + productdesc
				+ ", available=" + available + ", price=" + price + "]";
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
