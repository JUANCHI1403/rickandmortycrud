package com.rickandmorty.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rickandmorty.crud.model.Personaje;
import com.rickandmorty.crud.service.api.PersonajeServiceAPI;


@Controller
@RequestMapping("/home")
public class PersonajeController {
	
	@Autowired
	private PersonajeServiceAPI personajeServiceAPI;
		
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personajeServiceAPI.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("personaje", new Personaje());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("personaje", personajeServiceAPI.get(id));
		} else {
			model.addAttribute("personaje", new Personaje());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Personaje personaje, Model model) {
		personajeServiceAPI.save(personaje);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		personajeServiceAPI.delete(id);

		return "redirect:/home/";
	}
	
	

}
