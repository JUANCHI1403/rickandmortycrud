package com.rickandmorty.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickandmorty.crud.model.Personaje;
import com.rickandmorty.crud.service.api.PersonajeServiceAPI;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class PersonajeRestController {
	
	@Autowired
	private PersonajeServiceAPI personajeServiceAPI;

	@GetMapping(value = "/all")
	public List<Personaje> getAll() {
		return personajeServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Personaje find(@PathVariable Long id) {
		return personajeServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Personaje> save(@RequestBody Personaje personaje) {
		Personaje obj = personajeServiceAPI.save(personaje);
		return new ResponseEntity<Personaje>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Personaje> delete(@PathVariable Long id) {
		Personaje personaje = personajeServiceAPI.get(id);
		if (personaje != null) {
			personajeServiceAPI.delete(id);
		} else {
			return new ResponseEntity<Personaje>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Personaje>(personaje, HttpStatus.OK);
	}

	

}
