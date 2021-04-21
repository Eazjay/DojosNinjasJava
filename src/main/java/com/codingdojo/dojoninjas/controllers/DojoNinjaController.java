package com.codingdojo.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoNinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "dojo.jsp";
	}
	
	@RequestMapping(value="/dojos/create", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo.jsp";
		}
		else {
			Dojo d = dojoService.createDojo(dojo);
			return "redirect:/dojos/" + d.getId();
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/ninjas/create", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		}
		else {
			Ninja n = ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + n.getDojo().getId();
		}
	}
	
	@RequestMapping(value="/dojos/{id}", method=RequestMethod.GET)
	public String displayPage(Model model, @PathVariable("id") Long id) {
		Dojo d = dojoService.findDojo(id);
		model.addAttribute("dojo", d);
		return "dojoPage.jsp";
	}
}
