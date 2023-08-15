package com.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.dao.TarjetaCreditoDAO;
import com.pruebas.model.MarcaTarjeta;
import com.pruebas.model.TarjetaCredito;
/**@author ropold@yahoo.fr

**/
@Service
public class TarjetaCreditoServiceImpl implements ITarjetaCreditoService {
	
	public static double GASTOS_VALIDOS = 1000;
	@Autowired
	TarjetaCreditoDAO tarjetaCreditoDAO;
	
	
	@Override
	public void save(TarjetaCredito tarjetaCredito) {
		//Calcula la tasa * el importe
			 double tasa = 0;
			 tasa = calcularTasaPorServicio(tarjetaCredito) * tarjetaCredito.getImporte();
			 tarjetaCredito.setImporte(tasa);
			 tarjetaCreditoDAO.save(tarjetaCredito);
		
	}
		
	@Override
	@Transactional(readOnly = true)
	public TarjetaCredito getById(Long id) {
		
		
				TarjetaCredito respuesta =  tarjetaCreditoDAO.getById(id);
				TarjetaCredito response = new TarjetaCredito();
				 //calculo la tasa segun la marca de la tarjeta
				 double tasa = 0;
				 tasa = calcularTasaPorServicio(respuesta) * respuesta.getImporte();
				 respuesta.setImporte(tasa);
				 //la respuesta tiene la marca y el importe
				 response.setImporte(respuesta.getImporte());
				 response.setMarcaTarjeta(respuesta.getMarcaTarjeta());
				 
				 return response ;
				 
	}
	
	boolean  isValidarOperacion(TarjetaCredito tarjeta) {
		
		if(tarjeta.getImporte() < GASTOS_VALIDOS) {
			return true;
		}
		return false;	
	}
	
	boolean isValidaTarjeta(TarjetaCredito tarjeta) {
		if(tarjeta != null) {
			if(tarjeta.getFechaVencimiento().after(tarjeta.getFechaActual())) {	
			return	true;
		
		}
		}
		return false;
	}
	

	static double calcularTasaPorServicio(TarjetaCredito tarjeta) {
		
		double tasa = 0;
		
		if (tarjeta.getMarcaTarjeta().equals(String.valueOf(MarcaTarjeta.AMEX))) {
			tasa = tarjeta.getFechaVencimiento().getMonth()* 0.1; //mes *0.1
		} else { 
			
				if (tarjeta.getMarcaTarjeta().equals(String.valueOf(MarcaTarjeta.NARA))) { // dia * 0.5
					tasa = tarjeta.getFechaVencimiento().getDay() * 0.5;
			} else {					
				if (tarjeta.getMarcaTarjeta().equals(String.valueOf(MarcaTarjeta.VISA))) { //año/mes
					tasa = tarjeta.getFechaVencimiento().getYear()/tarjeta.getFechaVencimiento().getMonth();
							
				}
			}
		}
		return tasa;
		
	}
}
