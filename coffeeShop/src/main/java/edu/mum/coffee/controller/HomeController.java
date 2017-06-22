package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	@RequestMapping({"/", "/index"})
	public String homePage(Model model) {
	
		
		
//		System.out.println("am here");
//		List<Product> products =new RestTemplate().getForObject("http://localhost:8080/pro/productsR", ArrayList.class);
//		System.out.println(products);
		//model.addAttribute("products",products.toArray());
		  model.addAttribute("products",productService.getAllProduct());
		return "index";
	}

	@RequestMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
