package edu.mum.coffe.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ProductRestService {
	
	@Autowired
	private ProductService  productService;
	@RequestMapping(value ="/productsR", method = RequestMethod.GET,produces ="application/json")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@RequestMapping(value="/productR",method=RequestMethod.POST)
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}

	@RequestMapping(value="/productR",method=RequestMethod.DELETE)
	public String delete(@RequestBody Product product) {
		productService.delete(product);
		return "product deleted";
	}

	@RequestMapping(value="/productR",method=RequestMethod.PUT)
	public Product update(@RequestBody Product product) {
		return productService.save(product);
	}
	
}
