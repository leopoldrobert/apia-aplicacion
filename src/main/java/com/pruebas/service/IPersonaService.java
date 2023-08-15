package com.pruebas.service;

import java.util.List;


import com.pruebas.model.Persona;
/**@author ropold@yahoo.fr
**/
public interface IPersonaService {

public List<Persona> findAll();
	
	public void save(Persona Persona);
	
	public Persona getById(Long id);
	
	public void deleteById(Long id);

}
