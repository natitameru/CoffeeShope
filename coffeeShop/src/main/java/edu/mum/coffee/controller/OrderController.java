package edu.mum.coffee.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
    
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
	   public String orderForm(Model model){
		   model.addAttribute("order",new Order());
		   return "listOfProduct";
	   }
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public String addCart(Product product){
		Orderline ol=new Orderline();
		ol.setProduct(product);
		list.add(ol);
		 return "redirect:/";
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
