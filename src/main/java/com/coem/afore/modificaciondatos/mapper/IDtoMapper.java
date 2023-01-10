package com.coem.afore.modificaciondatos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.coem.afore.modificaciondatos.dtos.UserDto;
import com.coem.afore.modificaciondatos.entity.UserEntity;

/**
<b>IDtoMapper.java</b> 
@version: Superapp 1.0
@descripcion: Mapping Dtos - Entity
@author: ibrahim, Desarrollador
@ultimaModificacion: 10 nov. 2022 16:24:23
*/
@Mapper
public interface IDtoMapper {
		
	@Mapping(target = "nombre", source = "name" )
	@Mapping(target = "edad", source = "age")
	UserDto map(UserEntity user);

}
