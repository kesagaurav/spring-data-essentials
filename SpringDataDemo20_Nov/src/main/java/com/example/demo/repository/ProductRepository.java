package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	//select * from Product where product_name = ? -> sql
	//select p form Product p where p.productName = ? -> HPQL
	public List<Product> findByProductName(String name);
	
	public List<Product> findByProductNameContaining(String name);
	
	//select all products whose name is given nameand whose price is greatwer than the given value.
	public List<Product> findByProductNameAndPriceGreaterThanOrderByProductIdDesc(String pName, Integer price);
	
	//select * from Product where productName LIKE '%t'
	//select all products whose name ends with t 
	public List<Product> getByProductNameLike(String pattern);
	
	
	public int deleteByProductName(String pName);
	
	
	//positional params
	//Query approach
	//select * from product where product_name =? and price =?
	@Query("select p from Product p where p.productName = ?1 and p.price =?2")
	public List<Product> getByName(String name, Integer price);
	
	//named param
	@Query(value="select * from product where price > :price", nativeQuery = true)
	List<Product> findByPrice(Integer price);
	
	//update pname based on price
	@Modifying
	@Query(value = "update product set product_name = :name where price = :price", nativeQuery = true)
	int updateProduct(String name, Integer price);
	
	//NamedQuey
	List<Product> findByProductQuantity(Integer quantity);

	
	
}
