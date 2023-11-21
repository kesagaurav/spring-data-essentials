package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
//@Table(name="Products")
@NamedQuery(name = "Product.findByProductQuantity", query = "select p from Product p where p.quantity= ?1")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//generate the ids automatically2
	private Integer productId;
   // @Column(name="pName")
	private String productName;
	private Integer price;
	private Integer quantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, Integer price, Integer quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	
}
