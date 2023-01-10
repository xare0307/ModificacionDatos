package com.coem.afore.modificaciondatos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.coem.afore.modificaciondatos.enums.EMensajeException;


public class ApiErrorModel implements Serializable  {
	
	/**
	 * codigo.
	 */
	private String codigo;
	/**
	 * mensaje.
	 */
	private String mensaje;
	/**
	 * folio.
	 */
	private String folio;
	/**
	 * info.
	 */
	private String info;
	/**
	 * detalles.
	 */
	private List<String> detalles;

	/**
	 * 
	 */
	public ApiErrorModel() {
		super();
	}

	/**
	 * @param codigo
	 * @param mensaje
	 * @param folio
	 * @param info
	 * @param detalles
	 */
	public ApiErrorModel(String codigo, String mensaje, String folio, String info, List<String> detalles) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.folio = folio;
		this.info = info;
		this.detalles = Collections.unmodifiableList(detalles);
	}

	/**
	 * Constructor Enum.
	 * 
	 * @param error
	 */
	public ApiErrorModel(EMensajeException error, String folio, List<String> detalles) {
		super();
		this.codigo = error.getCodigo();
		this.mensaje = error.getMensaje();
		this.info = error.getInfo();
		this.folio = folio;
		this.detalles = Collections.unmodifiableList(detalles);
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the detalles
	 */
	public List<String> getDetalles() {
		if (ObjectUtils.isEmpty(detalles)) {
			return null;
		}

		return new ArrayList<>(detalles);
	}

	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(List<String> detalles) {
		if (ObjectUtils.isEmpty(detalles)) {
			return;
		}

		this.detalles = Collections.unmodifiableList(detalles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApiException [codigo=" + codigo + ", mensaje=" + mensaje + ", folio=" + folio + ", info=" + info
				+ ", detalles=" + detalles + "]";
	}


}
