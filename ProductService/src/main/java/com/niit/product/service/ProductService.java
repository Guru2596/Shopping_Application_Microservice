package com.niit.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.product.model.Product;
import com.niit.product.repo.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	public void saveProducts(Product product) {
		productRepo.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public void deleteProducts(int productid) {
		productRepo.deleteById(productid);
	}
	
	public void updateProducts(Product product) {
		productRepo.deleteById(product.getProductid());
		productRepo.save(product);
	}

	public List<Product> getAllAvailableProducts() {
		return productRepo.findAllByAvailableIgnoreCase("Yes");
	}
}
