package com.coem.afore.modificaciondatos.controlller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coem.afore.modificaciondatos.constants.AppConstants;
import com.coem.afore.modificaciondatos.dtos.UserDto;
import com.coem.afore.modificaciondatos.enums.EMensajeException;
import com.coem.afore.modificaciondatos.excepcion.ApiExcepcion;
import com.coem.afore.modificaciondatos.models.GenericResponse;
import com.coem.afore.modificaciondatos.remotes.IApiClientRemote;
import com.coem.afore.modificaciondatos.services.IUserService;
import com.coem.afore.modificaciondatos.services.aspect.Profiled;


/**
<b>HuellasController.java</b> 
@version: Superapp 1.0
@descripcion: Controller de huellas 
@author: ibrahim, Desarrollador
@ultimaModificacion: 10 nov. 2022 12:15:50
*/

@RestController
@RequestMapping("${app.huellas.path}")
public class HuellasController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HuellasController.class);

	
	@Autowired
	private IUserService userSvc;
	
	@Autowired
	private IApiClientRemote apiRemoteSrv;
	
	
	@GetMapping(path = "/user")
	@ResponseStatus(HttpStatus.OK)
	@Profiled
	public GenericResponse<UserDto> consultarUsuario(){
		LOGGER.info("Controller consultaUsuario init");
		
		//init tiempo
		return userSvc.consultarUsuario();
		//end tiempo 
		//end - int 0.01 mm
	}

	
	@GetMapping(path = "/userEror")
	@ResponseStatus(HttpStatus.OK)
	@Profiled
	public GenericResponse<UserDto> errorUsuario(){
		LOGGER.info("Controller errorUsuario init");
		throw new ApiExcepcion(Arrays.asList(AppConstants.MSJ_ERROR_SERVER), EMensajeException.E500);
	}
	
	@GetMapping(path = "/post")
	@ResponseStatus(HttpStatus.OK)
	@Profiled
	public ResponseEntity<Object> posts(){
		LOGGER.info("Controller open feing init");
		return new ResponseEntity<Object>(apiRemoteSrv.getAllPosts(), HttpStatus.OK);
		
	}
	
	
}
