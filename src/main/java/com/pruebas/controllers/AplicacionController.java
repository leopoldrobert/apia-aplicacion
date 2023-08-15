package com.pruebas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.TarjetaCreditoDAO;
import com.pruebas.model.TarjetaCredito;
import com.pruebas.service.PersonaServiceImpl;
import com.pruebas.service.TarjetaCreditoServiceImpl;

/**@author ropold@yahoo.fr
**/
@RestController
@RequestMapping("eldar")
public class AplicacionController {

	@Autowired
	PersonaServiceImpl personaService;
	
	@Autowired
	TarjetaCreditoServiceImpl tarjetaCreditoServiceImpl;
	
	@Autowired
	TarjetaCreditoDAO tarjetaCreditoDAO;

	@PostMapping("/guardar") //http://localhost:8080/eldar/guardar
	public void guardar (@RequestBody TarjetaCredito tarjeta) {
		
		tarjetaCreditoServiceImpl.save(tarjeta);
	}

	@GetMapping("/obtenerPorId/{id}")
	public TarjetaCredito obtenerPorId(@PathVariable("id") Long id) {
		
		return	tarjetaCreditoServiceImpl.getById(id);
		
	}
	
}
