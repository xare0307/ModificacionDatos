package com.coem.afore.modificaciondatos.dtos;


import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DatosEntradaDto {

	@NonNull
	private String folioServicio;

	public String getFolioServicio() {
		return folioServicio;
	}

	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}

	@Override
	public String toString() {
		return "InfoUnifolioDto [folioServicio=" + folioServicio + "]";
	}

	public DatosEntradaDto(String folioServicio) {
		super();
		this.folioServicio = folioServicio;
	}
	
	
	
}
