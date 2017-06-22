package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.UserCredential;
import edu.mum.coffee.service.PersonService;



@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	   private PersonService personService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	   public String getAllPerson(Model model){
		   model.addAttribute("persons",personService.findAll());
		   return "listOfPersons";
	   }
	   
	   @RequestMapping(value="/{email}", method=RequestMethod.GET)
	   public String getPerson(@RequestParam String email, Model model){
		   model.addAttribute("person",personService.findByEmail(email));
		   return "listOfPersons";
	   }

	   @RequestMapping(value="/addPerson", method=RequestMethod.GET)
	   public String createPersonForm(Model model){

		   model.addAttribute("person",new Person());
		   model.addAttribute("userCredential",new UserCredential());
		   return "addPerson";
	   }
//	   @RequestMapping(value="/signUp", method=RequestMethod.GET)
//	   public String signUpForm(Model model){
//		   model.addAttribute("person",new Person());
//		   return "addPerson";
//	   }
	   @RequestMapping(value="/addPerson", method=RequestMethod.POST)
	   public String createPerson(UserCredential userCredential,Person person){
		   person.setUserCredential(userCredential);
		   personService.savePerson(person);
		   return "redirect:/home";
	   }
	 
	   @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	   public String deletePerson(@PathVariable long id){ 
		   personService.removePerson(personService.findById(id));
		   return "redirect:/home";
	   }
	  
	   @RequestMapping(value="/person/update", method=RequestMethod.POST)
	   public String updatePerson(@RequestParam Person person){
		   personService.savePerson(person);
		   return "redirect:/persons";
	   }
		
}
