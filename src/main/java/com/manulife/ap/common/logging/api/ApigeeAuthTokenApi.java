package com.manulife.ap.common.logging.api;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manulife.ap.common.logging.model.AuthTokenRequest;
import com.manulife.ap.common.logging.model.AuthTokenResponse;

import io.swagger.annotations.ApiParam;

@FeignClient(value="apigeeauthtoken", url="${apigee-auth.url}")
public interface ApigeeAuthTokenApi {
	
	@PostMapping(value = "/v1/mg/oauth2/token", consumes = "application/json")
	AuthTokenResponse retrieveToken(
			@ApiParam(value = "log request body", required = true) 
			@Valid @RequestBody AuthTokenRequest request);

}
