package edu.mum.coffee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {
	
   @Autowired
   private ProductService productService;
   
   @RequestMapping(value="/products", method=RequestMethod.GET)
   public String getAllProduct(Model model){
	   model.addAttribute("products",productService.getAllProduct());
	   return "listOfProduct";
   }

   @RequestMapping(value="/product", method=RequestMethod.POST)
   public String createProduct(Product product){
	   productService.save(product);
	   return "redirect:/products";
   }
 
   @RequestMapping(value="/product/delete", method=RequestMethod.POST)
   public String deleteProduct(@RequestParam int productId){ 
	   productService.delete(productService.getProduct(productId));
	   return "redirect:/products";
   }
  
   @RequestMapping(value="/product/update", method=RequestMethod.POST)
   public String updateProduct(Product product){
	   productService.save(product);
	   return "redirect:/products";
   }
	
	
}
