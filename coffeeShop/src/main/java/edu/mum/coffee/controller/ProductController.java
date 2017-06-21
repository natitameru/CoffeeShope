package edu.mum.coffee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
   @Autowired
   private ProductService productService;
   
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String getAllProduct(Model model){
	   model.addAttribute("products",productService.getAllProduct());
	   return "listOfProduct";
   }

   @RequestMapping(value="/productAdd", method=RequestMethod.POST)
   public String createProduct(Product product){
	   productService.save(product);
	   return "redirect:/home";
   }
 
   @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
   public String deleteProduct(@PathVariable int id){ 
	   productService.delete(productService.getProduct(id));
	   return "redirect:/home";
   }
  
   @RequestMapping(value="/update", method=RequestMethod.POST)
   public String updateProduct(Product product){
	   productService.save(product);
	   return "redirect:/products";
   }
   @RequestMapping("/addProduct")
   public String getProductForm(Model model){
	   model.addAttribute("product",new Product());
	   return "productAdd";
   }
	
}
