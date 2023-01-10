package com.coem.afore.modificaciondatos.remotes.fallbacks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.coem.afore.modificaciondatos.enums.EMensajeException;
import com.coem.afore.modificaciondatos.excepcion.ApiExcepcion;
import com.coem.afore.modificaciondatos.remotes.IApiClientRemote;
import com.coem.afore.modificaciondatos.remotes.RemotesUtils;

import feign.FeignException;
import feign.FeignException.BadRequest;

@Component
public class ApiClientesRemoteFallBackImpl implements FallbackFactory<IApiClientRemote> {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiClientesRemoteFallBackImpl.class);

	@Autowired
	private RemotesUtils remoteUtils;
	
	
	@Override
	public IApiClientRemote create(Throwable cause) {
		// TODO Auto-generated method stub
		if (cause instanceof BadRequest) {
			List<String> details = remoteUtils.responseErrorDetails((FeignException) cause);

			if (details.size() == 0) {
				details.add("peticion erronea");
			}

			LOGGER.info("BadRequest cause message: " + cause.getMessage());

			throw new ApiExcepcion(details,
					EMensajeException.E500);
		}
		
		return null;
	}

}
