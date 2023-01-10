package com.coem.afore.modificaciondatos.services.aspect.impl;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import com.coem.afore.modificaciondatos.services.aspect.Profiled;


@Aspect
@Component
public class ProfiledAspectImpl {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfiledAspectImpl.class);

	/**
	 * profiled.
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	//@Around("@annotation(Profiled)")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();

		Profiled anotacion = method.getAnnotation(Profiled.class);
		String name = anotacion.name();
		
		System.out.println(name);

		StopWatch stopWatch = new StopWatch();
		stopWatch.start(pjp.toShortString());

		boolean isExceptionThrown = false;

		try {
			return pjp.proceed();
		} catch (Exception e) {

			isExceptionThrown = true;
			throw e;

		} finally {
			stopWatch.stop();
			TaskInfo task = stopWatch.getLastTaskInfo();
			String message = String.format("%s: %s ms " + (isExceptionThrown ? "(thrown  Exception )" : ""),
					task.getTaskName(), task.getTimeMillis());

			// MDC.put("tiempoTotal",task.getTimeMillis());
			// log.info("Se consumieron: TA - {} records, PS: {} records, Ot TS: {} records,
			// PCQR: {} records , TP: {} records , Spei: {} records , {} totales",
			// listOpTA.size(),listOpPS.size(), listOpTS.size(), listOpPCQR.size(),
			// listOpTP.size(), listOpSpei.size(), records.size());
			// MDC.remove("tiempoTotal");

			LOGGER.info("{}", message);
		}
	}
}
