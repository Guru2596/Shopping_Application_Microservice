package com.niit.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.product.model.Product;
import com.niit.product.repo.ProductRepository;
import com.niit.product.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/product/available")
	public ResponseEntity<List<Product>> getAvailableProducts(){
		return new ResponseEntity<List<Product>>(productService.getAllAvailableProducts(),HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> postProduct(@RequestBody Product product){
		productService.saveProducts(product);
		return new ResponseEntity<String>("Product Added",HttpStatus.OK);
	}
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		productService.updateProducts(product);
		return new ResponseEntity<String>("Product Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productid") int productid){
		productService.deleteProducts(productid);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}
}
