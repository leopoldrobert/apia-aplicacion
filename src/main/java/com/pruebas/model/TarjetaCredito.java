package com.pruebas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tarjetacredito")
public class TarjetaCredito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tarjeta_credito_id;
	
	@Column(name="numero_Tarjeta")
	private long numeroTarjeta;
	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
	private Persona persona;
	@Column
	private double importe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_Vencimiento")
	private Date fechaVencimiento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_Actual")
	private Date fechaActual;
	
	private MarcaTarjeta marca; //VISA, NARA, etc
	
	@Column(name="marca_Tarjeta")
	private String marcaTarjeta;

	public long getTarjeta_credito_id() {
		return tarjeta_credito_id;
	}
	public void setTarjeta_credito_id(long tarjeta_credito_id) {
		this.tarjeta_credito_id = tarjeta_credito_id;
	}
	
	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getMarcaTarjeta() {
		return marcaTarjeta;
	}
	public void setMarcaTarjeta(String marcaTarjeta) {
		this.marcaTarjeta = marcaTarjeta;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public TarjetaCredito() {
		super();
	}
	//
	public TarjetaCredito(double importe, String marcaTarjeta) {
		super();
		this.importe = importe;
		this.marcaTarjeta = marcaTarjeta;
	}
	
	public TarjetaCredito(long tarjeta_credito_id, long numeroTarjeta, Persona persona, double importe,
			Date fechaVencimiento, Date fechaActual, String marcaTarjeta) {
		super();
		this.tarjeta_credito_id = tarjeta_credito_id;
		this.numeroTarjeta = numeroTarjeta;
		this.persona = persona;
		this.importe = importe;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaActual = fechaActual;
		this.marcaTarjeta = marcaTarjeta;
	}
	
	
	
}
