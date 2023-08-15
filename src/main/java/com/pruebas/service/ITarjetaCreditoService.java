package com.pruebas.service;

import java.util.List;


import com.pruebas.model.Persona;
import com.pruebas.model.TarjetaCredito;
/**@author ropold@yahoo.fr
**/
public interface ITarjetaCreditoService {

	public void save(TarjetaCredito tarjetaCredito);
	
	public TarjetaCredito getById(Long id);
}
