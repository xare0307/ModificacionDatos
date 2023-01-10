package com.coem.afore.modificaciondatos.enums;

public enum EMensajeException {
	
	E500("API.OA-5000", "No estas autorizado, favor de validar",
			"https://baz-afore.bancoazteca.com.mx/info#API.OA-5000");
	
	// Código error
	private String codigo;

	// Mensaje error
	private String mensaje;

	// Info error
	private String info;

	EMensajeException(String codigo, String mensaje, String info) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.info = info;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

}
