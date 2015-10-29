package com.dius.stephan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dius.stephan.springdemo.models.Cat;
import com.dius.stephan.springdemo.repository.CatRepository;

@RestController
public class CatRestController {
	
	@Autowired
	private CatRepository repository;
	
	@RequestMapping("/hi")
    @ResponseBody
    public String sayHi() {
        return "Hi from DiUS Cat Store";
    }
	
	@RequestMapping(value="/services/upload", method=RequestMethod.POST)
	public Cat upload(@RequestBody Cat cat) {
		return repository.save(cat);
	}
	
	@RequestMapping("/services/load/{id}")
	public Cat loadById(@PathVariable long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/services/find/{name}")
	public List<Cat> findByName(@PathVariable String name) {
		return repository.findByName(name);
	}

}