package com.coem.afore.modificaciondatos.models;

public class TramiteDatosModel {

	private String folioAut;
	private String tipoServ;
	private String curpsolicitante;
	
	public String getFolioAut() {
		return folioAut;
	}
	public void setFolioAut(String folioAut) {
		this.folioAut = folioAut;
	}
	public String getTipoServ() {
		return tipoServ;
	}
	public void setTipoServ(String tipoServ) {
		this.tipoServ = tipoServ;
	}
	public String getCurpsolicitante() {
		return curpsolicitante;
	}
	public void setCurpsolicitante(String curpsolicitante) {
		this.curpsolicitante = curpsolicitante;
	}
	@Override
	public String toString() {
		return "TramiteDatosModel [folioAut=" + folioAut + ", tipoServ=" + tipoServ + ", curpsolicitante="
				+ curpsolicitante + "]";
	}
	public TramiteDatosModel(String folioAut, String tipoServ, String curpsolicitante) {
		super();
		this.folioAut = folioAut;
		this.tipoServ = tipoServ;
		this.curpsolicitante = curpsolicitante;
	}
	public TramiteDatosModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
