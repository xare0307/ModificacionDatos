package com.coem.afore.modificaciondatos.services.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
<b>Profiled.java</b>  
@version: Superapp 1.0
@descripcion: Anotación profiled 
@author: ibrahim, Desarrollador
@ultimaModificacion: 10 nov. 2022 12:22:28
*/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Profiled {
	
	String name() default "origin";

}