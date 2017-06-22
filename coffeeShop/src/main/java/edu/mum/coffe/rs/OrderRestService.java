package edu.mum.coffe.rs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;

import edu.mum.coffee.service.OrderService;

@RestController
@RequestMapping("/or")
public class OrderRestService {
	
	@Autowired
	private OrderService orderService;

	@PostMapping(path="/orderR",consumes="application/json",
			produces="application/json")
	public Order save(Order order){
		return orderService.save(order);
	}
	@GetMapping(path="/ordersR", produces="application/json")
	public List<Order> findAll(){
		return orderService.findAll();
	}
}
