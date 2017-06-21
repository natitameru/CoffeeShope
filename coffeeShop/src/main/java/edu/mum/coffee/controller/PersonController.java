package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;


@Controller
public class PersonController {

	@Autowired
	   private PersonService personService;
	   
	   @RequestMapping(value="/persons/{id}", method=RequestMethod.GET)
	   public String getAllProduct(@PathVariable Long id ,Model model){
		   model.addAttribute("persons",personService.findById(id));
		   return "persons";
	   }

	   @RequestMapping(value="/person", method=RequestMethod.POST)
	   public String createPerson(Person person){
		   personService.savePerson(person);
		   return "redirect:/persons";
	   }
	 
	   @RequestMapping(value="/person/delete", method=RequestMethod.POST)
	   public String deletePerson(@RequestParam Person person){ 
		   personService.removePerson(person);
		   return "redirect:/persons";
	   }
	  
	   @RequestMapping(value="/person/update", method=RequestMethod.POST)
	   public String updatePerson(@RequestParam Person person){
		   personService.savePerson(person);
		   return "redirect:/persons";
	   }
		
}
