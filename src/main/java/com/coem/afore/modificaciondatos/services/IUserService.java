package com.coem.afore.modificaciondatos.services;

import com.coem.afore.modificaciondatos.dtos.UserDto;
import com.coem.afore.modificaciondatos.models.GenericResponse;

public interface IUserService {
	
	
	GenericResponse<UserDto> consultarUsuario();
	
	

}
