package com.dius.stephan.springdemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dius.stephan.springdemo.repository.CatRepository;

@Controller
public class MvcController {
	
	@Autowired
	private CatRepository repository;
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView mv = new ModelAndView("pages/index");
		mv.addObject("currentDate", new Date());
		mv.addObject("pageTitle", "Home");
		return mv;
	}
	
	@RequestMapping("/cats")
	public ModelAndView cats() {
		return cats(0);
	}
	
	@RequestMapping("/cats/{page}")
	public ModelAndView cats(@PathVariable Integer page) {
		ModelAndView mv = new ModelAndView("pages/cats").addObject("pageTitle", "Cute cats");
		return mv.addObject("page", repository.findAll(new PageRequest(page, 4)));
	}
	
	@RequestMapping("/food")
	public ModelAndView parts() {
		return new ModelAndView("pages/food").addObject("pageTitle", "Fancy food");
	}

}
