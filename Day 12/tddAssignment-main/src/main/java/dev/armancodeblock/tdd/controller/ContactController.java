package dev.armancodeblock.tdd.controller;

import dev.armancodeblock.tdd.model.Person;
import dev.armancodeblock.tdd.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@PostMapping("/contact/save")
	public ResponseEntity<Person> save(@RequestBody Person person){
		Person saved = contactService.save(person);
		return  null;
	}
	@GetMapping("/contact/retrieve/{id}")
	public ResponseEntity<Person> retrieve(@PathVariable Integer id){
		return null;
	}
	@DeleteMapping("/contact/delete/{id}")
	public ResponseEntity<Void>  deletePersonById(@PathVariable Integer id){

		return null;
	}

	@PutMapping("/contact/update/{id}")
	public ResponseEntity<Person>  updatePersonById(@PathVariable Integer id,@RequestBody Person person){

		return null;
	}



}
