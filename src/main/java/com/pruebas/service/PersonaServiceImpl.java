package com.pruebas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;
/**@author ropold@yahoo.fr

**/
@Service
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	PersonaDAO personaDAO;
	
	@Override
	public List<Persona> findAll() {
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	public void save(Persona persona) {
		personaDAO.save(persona);
		
	}

	@Override
	public void deleteById(Long id) {
		personaDAO.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Persona getById(Long id) {
		return personaDAO.getById(id);
	}
}
