package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	
	@Autowired
	private ProductRepository repo;
	
	//method to add a new product.
	public void addProduct(ProductDTO dto) {
		Product p = new Product();
		p.setProductName(dto.getProductName());
		p.setPrice(dto.getPrice());
		p.setQuantity(dto.getQuantity());
		
		repo.save(p);
		
		
	}
	//fetching records
	public void getProduct() {
		List<Product> products = repo.findAll();
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("Number of records :" + repo.count());
	}
	
	
	//fetch by Id
	public void getProductById() throws Exception{
		Optional<Product> op = repo.findById(5);
		Product product = op.orElseThrow(()->new Exception("Record is not found"));
//		Product product = op.get();
		System.out.println(product);
	}
	
	//update product
	public void updateProduct(Integer id) {
		     Optional<Product> op = repo.findById(id);
		     Product product = op.get();
		     product.setProductName("Eraser");
		     product.setPrice(5);
		     repo.save(product);
	}
	
	
//delete a product
	public void delete() {
		Product p = new Product();
		p.setProductId(4);
		repo.delete(p);
		System.out.println("Record is deleted");
	}

	//query approach(method name)
	public void printfindByproductName(String name) {
		List<Product> product = repo.findByProductName(name);
		System.out.println(product);
	}
	
	public void printfindByProductNameContaining(String name) {
		List<Product> product = repo.findByProductNameContaining(name);
		System.out.println(product);
	}
	
	public void printfindByProductNameAndPriceGreaterThanOrderByProductIdDesc(String pName, Integer price) {
		List<Product> p = repo.findByProductNameAndPriceGreaterThanOrderByProductIdDesc(pName, price);
		System.out.println(p);
	}
	
	public void printgetByProductNameLike(String pattern) {
		List<Product> p = repo.getByProductNameLike(pattern);
		System.out.println(p);
	}
	
	
	public void printdeleteByProductName(String pName) {
		int count = repo.deleteByProductName(pName);
		System.out.println(count + " no of rown deleted");
	}
	
	
	//query approach
	public void printgetByName(String name, Integer price) {
		List<Product> p = repo.getByName(name, price);
		System.out.println(p);
	}
	
	public void printfindByPrice(Integer price) {
		List<Product> p = repo.findByPrice(price);
		System.out.println(p);
	}
	
	public void printupdateProduct(String name, Integer price) {
		int c = repo.updateProduct(name, price);
		System.out.println(c + " rows affected");
	}
	public void printfindByProductQuantity(Integer quantity) {
		List<Product> p = repo.findByProductQuantity(quantity);
		System.out.println(p);
	}
	
	
	
	//paging and sorting
	public Page<Product> findAll(Pageable page){
		return repo.findAll(page);
		
	}
	
	public Iterable<Product> findAll(Sort sort){
		return repo.findAll(sort);
	}
}

