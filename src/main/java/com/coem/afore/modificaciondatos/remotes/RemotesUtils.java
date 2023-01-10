package com.coem.afore.modificaciondatos.remotes;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coem.afore.modificaciondatos.models.ApiErrorModel;
import com.google.gson.Gson;

import feign.FeignException;

@Component
public class RemotesUtils {
	
	public List<String> responseErrorDetails(FeignException cause) {
		FeignException exception = (FeignException) cause;

		Optional<ByteBuffer> catalogosBody = exception.responseBody();

		if (!catalogosBody.isPresent()) {
			return null;
		}

		String catalogosResponseStringifiedBody = StandardCharsets.UTF_8.decode(catalogosBody.get())
				.toString();

		Gson gson = new Gson();
		ApiErrorModel catalogosResponse = gson.fromJson(catalogosResponseStringifiedBody,
				ApiErrorModel.class);

		return catalogosResponse.getDetalles();
	}

}
