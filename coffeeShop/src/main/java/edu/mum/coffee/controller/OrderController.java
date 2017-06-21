package edu.mum.coffee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@Controller
public class OrderController {
    @Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	   public String getAllOrder(Model model){
		   model.addAttribute("orders",orderService.findAll());
		   return "orders";
	   }
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	   public String createOrder(Order order){
		orderService.save(order);
		   return "redirect:/orders";
	   }
}
