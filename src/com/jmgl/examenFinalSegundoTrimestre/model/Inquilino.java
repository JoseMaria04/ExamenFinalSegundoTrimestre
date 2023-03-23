package com.jmgl.examenFinalSegundoTrimestre.model;

import java.util.Date;

public class Inquilino {
	int id;
	String dni;
	String nombreCompleto;
	Date fechaInicioAlquiler;
	Date fechaFinAlquiler;
	Double cuotaMensual;
	int idVivienda;
	
	/**
	 * 
	 */
	public Inquilino() {
		super();
	}

	/**
	 * @param id
	 * @param dni
	 * @param nombreCompleto
	 * @param fechaInicioAlquiler
	 * @param fechaFinAlquiler
	 * @param cuotaMensual
	 * @param idVivienda
	 */
	public Inquilino(int id, String dni, String nombreCompleto, Date fechaInicioAlquiler, Date fechaFinAlquiler,
			Double cuotaMensual, int idVivienda) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaInicioAlquiler = fechaInicioAlquiler;
		this.fechaFinAlquiler = fechaFinAlquiler;
		this.cuotaMensual = cuotaMensual;
		this.idVivienda = idVivienda;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the fechaInicioAlquiler
	 */
	public Date getFechaInicioAlquiler() {
		return fechaInicioAlquiler;
	}

	/**
	 * @param fechaInicioAlquiler the fechaInicioAlquiler to set
	 */
	public void setFechaInicioAlquiler(Date fechaInicioAlquiler) {
		this.fechaInicioAlquiler = fechaInicioAlquiler;
	}

	/**
	 * @return the fechaFinAlquiler
	 */
	public Date getFechaFinAlquiler() {
		return fechaFinAlquiler;
	}

	/**
	 * @param fechaFinAlquiler the fechaFinAlquiler to set
	 */
	public void setFechaFinAlquiler(Date fechaFinAlquiler) {
		this.fechaFinAlquiler = fechaFinAlquiler;
	}

	/**
	 * @return the cuotaMensual
	 */
	public Double getCuotaMensual() {
		return cuotaMensual;
	}

	/**
	 * @param cuotaMensual the cuotaMensual to set
	 */
	public void setCuotaMensual(Double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	/**
	 * @return the idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}

	/**
	 * @param idVivienda the idVivienda to set
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}

	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", fechaInicioAlquiler="
				+ fechaInicioAlquiler + ", fechaFinAlquiler=" + fechaFinAlquiler + ", cuotaMensual=" + cuotaMensual
				+ ", idVivienda=" + idVivienda + "]";
	}
	
	
}
