package com.coem.afore.modificaciondatos.remotes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coem.afore.modificaciondatos.dtos.PostsDto;
import com.coem.afore.modificaciondatos.remotes.fallbacks.ApiClientesRemoteFallBackImpl;


@FeignClient(name = "remoteApi", url = "${app.base.path.remote.api}", fallbackFactory = ApiClientesRemoteFallBackImpl.class)
public interface IApiClientRemote {
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
	 List<PostsDto> getAllPosts();

}
