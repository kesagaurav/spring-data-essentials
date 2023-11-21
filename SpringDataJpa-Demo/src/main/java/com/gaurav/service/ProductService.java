package com.gaurav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gaurav.dto.ProductDTO;
import com.gaurav.model.Product;
import com.gaurav.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public void addProduct(ProductDTO dto) {
		Product p=new Product();
		p.setPrice(dto.getPrice());
		p.setProdName(dto.getProdName());
		p.setQuantity(dto.getQuantity());
		
		repo.save(p);
	}
	
	
//	public List<ProductDTO> getAllProducts(){
//		List<Product> p=repo.findAll();
//		return p;
//	}
	
	
	public void getProduct() {
		List<Product> product=repo.findAll();
		for(Product p:product) {
			System.out.println(p);
		}
		
		System.out.println("no of records" + repo.count());
	}
	
	
	
//	public void delete(int id) {
//		repo.deleteById(id);
//		System.out.println("deleted the records " + repo.count());
//	}
	
	//pagning and sorting
	public Page<Product> findAll(Pageable page){
		return repo.findAll(page);
	}
	
	public Iterable<Product> findAll(Sort sort){
		return repo.findAll(sort);
}
}