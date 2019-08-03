package com.zensar.services.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;
import com.zensar.services.business.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
@Autowired	
	private ProductService productService;
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int productId) {
		return productService.findProductbyId(productId);
		
	}
	
	@PostMapping
	public String createProduct(@RequestParam("id")int productId,
			@RequestParam("name") String name,
			@RequestParam("brand") String brand,
			@RequestParam("price") float price) {
		Product product = new Product(productId,name,brand,price);
		productService.create(product);
		return "Product " + productId + " created successfully";
	}
	
@PutMapping
public String editProduct (@RequestBody Product product) {
	productService.edit(product);
	return "Product " + product.getProductId() + "edited successfully";
}

	
	 @DeleteMapping public String removeProduct (@RequestBody Product product) {
	  productService.remove(product); return "Product " + product.getProductId() +
	 "removed successfully"; }
	
	 @GetMapping("/count")
     public int getProductCount() {
    	 return productService.findAllProducts().size();
     }


}
