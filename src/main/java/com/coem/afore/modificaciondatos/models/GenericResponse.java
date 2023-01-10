package com.coem.afore.modificaciondatos.models;

import com.fasterxml.jackson.annotation.JsonInclude;



/**
<b>GenericResponse.java</b>  
@version: Superapp 1.0
@descripcion: Modelo de Respuesta generica
@author: ibrahim, Desarrollador
@ultimaModificacion: 10 nov. 2022 13:57:55
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {
	
	/**
	 * mensaje.
	 */
	private String mensaje;
	/**
	 * folio.
	 */
	private String folio;
	/**
	 * resultado.
	 */
	private T resultado;

	/**
	 * 
	 */
	public GenericResponse() {
		super();
	}

	/**
	 * @param mensaje
	 * @param folio
	 * @param resultado
	 */
	public GenericResponse(String mensaje, String folio, T resultado) {
		super();
		this.mensaje = mensaje;
		this.folio = folio;
		this.resultado = resultado;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the resultado
	 */
	public T getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericInsertResponse [mensaje=" + mensaje + ", folio=" + folio + ", resultado=" + resultado + "]";
	}


}
