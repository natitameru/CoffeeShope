package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	@GetMapping({"/", "/index"})
	public String homePage(Model model) {
//		System.out.println("am here");
//		List<Product> products = new RestTemplate().getForObject("http://localhost:8080/productsR", ArrayList.class);
//		System.out.println(products);
//		model.addAttribute("products",products);
		  model.addAttribute("products",productService.getAllProduct());
		return "index";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
