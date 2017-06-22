package edu.mum.coffe.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping("/pro")
public class ProductRestService {
	
	@Autowired
	private ProductService  productService;
	
	@GetMapping(path="/productsR", produces="application/json")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	@PostMapping(path="/productsR",consumes="application/json",
			produces="application/json")	
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	@DeleteMapping(path="/productsR",consumes="application/json",
			produces="application/json")
	public String delete(@RequestBody Product product) {
		productService.delete(product);
		return "product deleted";
	}
	@PutMapping(path="/productsR",consumes="application/json",
			produces="application/json")
	public Product update(@RequestBody Product product) {
		return productService.save(product);
	}
	
}
