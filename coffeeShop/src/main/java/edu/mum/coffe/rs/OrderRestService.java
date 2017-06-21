package edu.mum.coffe.rs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Order;

import edu.mum.coffee.service.OrderService;

@RestController
public class OrderRestService {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/orderR" ,method=RequestMethod.POST)
	public Order save(Order order){
		return orderService.save(order);
	}
	
	@RequestMapping("/ordersR")
	public List<Order> findAll(){
		return orderService.findAll();
	}
}
