package com.example.cobajpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Person;
import com.example.cobajpa.service.PersonServices;


@Controller
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	@RequestMapping(value="person",method=RequestMethod.POST)
	public ModelAndView goPerson(@ModelAttribute("person")Person person) {
		personServices.SaveOrUpdate(person);
		return new ModelAndView("person","listperson",personServices.getAllPerson());
	}
	@RequestMapping(value="person",method=RequestMethod.GET)
	public ModelAndView goPersonafterUpdate(@ModelAttribute("person")Person person) {
		return new ModelAndView("person","listperson",personServices.getAllPerson());
	}
	@RequestMapping(value ="updateperson",method=RequestMethod.GET)
    public ModelAndView formUpdatePerson(@RequestParam("id") int id){
        return new ModelAndView("updateperson","person",personServices.getById(id));
    }
	@RequestMapping(value ="updateperson",method=RequestMethod.POST)
    public String insertUpdatePerson(@ModelAttribute("person")Person person){
        personServices.SaveOrUpdate(person);
        return "redirect:person";
    }
	@RequestMapping(value="deleteperson")
	public String deleteKary(@RequestParam("id") int id){
        personServices.deletePerson(id);//delete nanti status. bukan delete
		return "redirect:person";
    }
}
