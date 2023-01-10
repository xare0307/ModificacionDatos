package com.coem.afore.modificaciondatos.services.impl;

import org.apache.catalina.User;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coem.afore.modificaciondatos.constants.AppConstants;
import com.coem.afore.modificaciondatos.dao.IUserDao;
import com.coem.afore.modificaciondatos.dtos.UserDto;
import com.coem.afore.modificaciondatos.mapper.IDtoMapper;
import com.coem.afore.modificaciondatos.models.GenericResponse;
import com.coem.afore.modificaciondatos.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private IUserDao userDao;
	
	/**
	 * Mapper
	 */
	private final IDtoMapper mapper = Mappers.getMapper(IDtoMapper.class);
	
	
	@Override
	public GenericResponse<UserDto> consultarUsuario() {
		// TODO Auto-generated method stub
		
		LOGGER.info("Service User init");
		
		UserDto resultadoDB = mapper.map(userDao.getUserId(1));
		
		GenericResponse<UserDto> response = new GenericResponse<>();
		response.setFolio("folio");
		response.setMensaje(AppConstants.MSJ_OPERACION_EXITOSA);
		response.setResultado(resultadoDB);
		return response;
	}

}
