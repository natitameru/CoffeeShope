package edu.mum.coffee.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
    @Autowired
    private PersonService personService; 
    @Autowired
    private ProductService productService;
    private List<Orderline> list=new ArrayList<Orderline>();
	
	public List<Orderline> getList() {
		return list;
	}

	public void setList(List<Orderline> list) {
		this.list = list;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	   public String getAllOrder(Principal principal,Model model){
		System.out.println(principal.getName());
		   model.addAttribute("products",productService.getAllProduct());
		   return "listOfOrders";
	   }
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	   public String createOrder(Order order){
		orderService.save(order);
		   return "redirect:/orders";
	   }
	@RequestMapping(value="/order", method=RequestMethod.GET)
	   public String orderForm(Model model,Principal principal){
		   Order newOrder=new Order();
		   Orderline newOrederline=new Orderline();
		   newOrder.setPerson(personService.findByEmail(principal.getName()).get(0));
		   newOrder.setOrderLines(list);
		   model.addAttribute("newOrder",newOrder);
		   model.addAttribute("newOrederline",newOrederline);
		   model.addAttribute("products",productService.getAllProduct());
		   return "listOfProduct";
	   }
	@RequestMapping(value="/addToCart/{id}",method=RequestMethod.POST)
	public String addCart(@PathVariable int id ,@ModelAttribute("newOrder") Order newOrder,@ModelAttribute("newOrederline") Orderline newOrederline,Model model){
		
		newOrederline.setProduct(productService.getProduct(id));
		list.add(newOrederline);
		newOrder.setOrderLines(list);
		orderService.save(newOrder);
		model.addAttribute("orders",orderService.findAll());
		 return "redirect:/home";
	}
	@RequestMapping(value="/processOrder",method=RequestMethod.GET)
	public String processOrder(Principal principal,Model model){
		double totalPayment=0;
		for(Orderline o:list){
			totalPayment+=o.getProduct().getPrice();
		}
		model.addAttribute("totalPayment",totalPayment);
		model.addAttribute("OrderedProducts",list);
		
		return "success";
	}
	@RequestMapping(value="/pay",method=RequestMethod.GET)
	public String pay(){
		
		return "thankYou";
	}
	
}
