package edu.mum.coffe.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path="/personsR", produces="application/json")
	public List<Person> findByEmail(@RequestParam String email) {
		return personService.findByEmail(email);
	}
	@PostMapping(path="/personR",consumes="application/json",
			produces="application/json")
	public Person savePerson(Person person) {
		return personService.savePerson(person);
	}
	@PutMapping(path="/personR",consumes="application/json",
			produces="application/json")
	public Person updatePerson(Person person) {
		return personService.savePerson(person);
	}
   
}
