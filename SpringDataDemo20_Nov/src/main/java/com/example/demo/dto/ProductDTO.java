package com.example.demo.dto;

public class ProductDTO {
private Integer productId;
private String productName;
private Integer price;
private Integer quantity;


public ProductDTO() {
	super();
	// TODO Auto-generated constructor stub
}


public ProductDTO(String productName, Integer price, Integer quantity) {
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
	return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
			+ quantity + "]";
}


}
