package com.rickandmorty.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.rickandmorty.crud.commons.GenericServiceImpl;
import com.rickandmorty.crud.dao.api.PersonajeDaoAPI;
import com.rickandmorty.crud.model.Personaje;
import com.rickandmorty.crud.service.api.PersonajeServiceAPI;


@Service
public class PersonajeServiceImpl extends GenericServiceImpl<Personaje, Long> implements PersonajeServiceAPI {

	@Autowired
	private PersonajeDaoAPI personajeDaoAPI;
	
	@Override
	public CrudRepository<Personaje, Long> getDao() {
		return personajeDaoAPI;
	}

	
	
	
}

