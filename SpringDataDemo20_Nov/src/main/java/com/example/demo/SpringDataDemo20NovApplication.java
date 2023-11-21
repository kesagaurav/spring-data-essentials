package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@SpringBootApplication
public class SpringDataDemo20NovApplication implements CommandLineRunner {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemo20NovApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ProductDTO dto1 = new ProductDTO("Pen",10,5);
		ProductDTO dto2 = new ProductDTO("Pencil",15,10);
		ProductDTO dto3 = new ProductDTO("Wheat",20,40);
		ProductDTO dto4 = new ProductDTO("Wheat",30,60);
		ProductDTO dto5 = new ProductDTO("Rice",40,30);
		ProductDTO dto6 = new ProductDTO("Sharpener",60,90);
		ProductDTO dto7 = new ProductDTO("Wheat",70,10);
		
//		service.addProduct(dto1);
		//service.addProduct(dto2);
		//service.addProduct(dto3);
//		service.addProduct(dto4);
//		service.addProduct(dto5);
//		service.addProduct(dto6);
//		service.addProduct(dto7);
//		service.addProduct(dto1);
		//System.out.println("Product added succesfully");
		
//		service.getProduct();
//		service.getProductById();
//		service.updateProduct(3);
//		service.delete();
//		service.printfindByproductName("Wheat");
//		service.printfindByProductNameContaining("ser");
//		service.printfindByProductNameAndPriceGreaterThanOrderByProductIdDesc("Wheat", 3);
//		service.printgetByProductNameLike("%t");
//		service.printdeleteByProductName("Rice");
//		service.printgetByName("Pen", 10);
//		service.printfindByPrice(10);
//		service.printupdateProduct("Pencil",10);
//		service.printfindByProductQuantity(10);
		
		long count = repo.count(); //counted no of rows //7
		for(int i = 0; i<=count; i++) {
			Pageable page = PageRequest.of(i,3); //creating pageable object
			System.out.println();
			Page<Product> p = service.findAll(page);
			for(Product prod: p) {
				System.out.println(prod);
			}
		}
		
		
		System.out.println("Sorted Records");
		Iterable<Product> p = service.findAll(Sort.by(Sort.Direction.DESC, "productName"));
		for(Product product : p) {
			System.out.println(product);
		}
	}

}
