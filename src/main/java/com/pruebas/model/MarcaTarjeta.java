package com.pruebas.model;

public  enum MarcaTarjeta {
	
		VISA("VISA"),
		NARA("NARA"),
		AMEX("AMEX");
		
		private String nombre;
		
		
		private MarcaTarjeta(String nombre)
		{
			this.nombre = nombre;
		}
	}
