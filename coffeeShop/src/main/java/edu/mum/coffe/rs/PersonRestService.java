package edu.mum.coffe.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@RestController
public class PersonRestService {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/personsR")
	public List<Person> findByEmail(@RequestParam String email) {
		return personService.findByEmail(email);
	}
	@RequestMapping(value="/personR",method=RequestMethod.POST)
	public Person savePerson(Person person) {
		return personService.savePerson(person);
	}
   
	@RequestMapping(value="/personR",method=RequestMethod.PUT)
	public Person updatePerson(Person person) {
		return personService.savePerson(person);
	}
   
}
