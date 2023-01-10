package com.coem.afore.modificaciondatos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coem.afore.modificaciondatos.models.ApiErrorModel;


@ControllerAdvice
public class ApiExeptionHandler {
	
	
	public ApiExeptionHandler() {
		
	}
	
	/**
	 * Manejo de errores.
	 * 
	 * @param e
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(value = { ApiExcepcion.class })
	public ResponseEntity<ApiErrorModel> handleApiRequestException(ApiExcepcion e) {
		ResponseEntity<ApiErrorModel> response = null;

		// Generación error detallado
		switch (e.getOption()) {
			case E500:
				// Error 500
				response = new ResponseEntity<>(buildApiError(e), HttpStatus.INTERNAL_SERVER_ERROR);
				break;
			default:
				// Error default
				response = new ResponseEntity<>(e.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
				break;
		}

		return response;

	}
	
	/**
	 * Respuesta internal server error.
	 * 
	 * @param e
	 * @return ApiException
	 */
	private ApiErrorModel buildApiError(ApiExcepcion e) {
		ApiErrorModel apiError = new ApiErrorModel();
		apiError.setCodigo(e.getOption().getCodigo());
		apiError.setMensaje(e.getOption().getMensaje());
		apiError.setInfo(e.getOption().getInfo());
		//apiError.setFolio(folio.getFolio());
		apiError.setDetalles(e.getBody().getDetalles());
		return apiError;
	}


}
