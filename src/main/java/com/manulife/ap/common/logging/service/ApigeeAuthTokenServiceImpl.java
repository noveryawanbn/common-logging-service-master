package com.manulife.ap.common.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.manulife.ap.common.logging.api.ApigeeAuthTokenApi;
import com.manulife.ap.common.logging.model.AuthTokenRequest;
import com.manulife.ap.common.logging.model.AuthTokenResponse;
import com.manulife.ap.common.logging.model.ClientCredential;
import com.manulife.ap.config.ApigeeAuthConfigFactory;
import com.manulife.ap.mli.common.exception.ApiError;
import com.manulife.ap.mli.common.exception.ApiException;

import feign.FeignException;

@Component
public class ApigeeAuthTokenServiceImpl implements ApigeeAuthTokenService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApigeeAuthTokenServiceImpl.class);
	
	@Autowired
	private ApigeeAuthConfigFactory apigeeAuthConfigFactory;
	
	@Autowired
	private ApigeeAuthTokenApi apigeeAuthTokenApi;
	
    //@Cacheable(value = "apigeeAuthTokenCache", key = "#market + #functionName")
	@Override
	public String retrieveToken(String market, String functionName) {
		LOGGER.debug("COMMON_LogService retrieveApigeeAuthToken START: country: {} function: {}", market, functionName);
		ClientCredential marketCreds = apigeeAuthConfigFactory.getClientCredential(market);
		AuthTokenRequest authRequest = new AuthTokenRequest();
		authRequest.setClientId(marketCreds.getClientId());
		authRequest.setClientSecret(marketCreds.getClientSecret());
		AuthTokenResponse authResponse = null;
		try {
			authResponse = this.apigeeAuthTokenApi.retrieveToken(authRequest);
			LOGGER.info("COMMON_LogService retrieveApigeeAuthToken. Success!");
			//LOGGER.info(authResponse.getAccessToken());
			return "Bearer " + authResponse.getAccessToken();
		}catch (FeignException e) { 
			String errorMessage = "COMMON_LogService retrieveApigeeAuthToken Exception: " +e.getMessage(); 
			LOGGER.error(errorMessage);
			throw new ApiException(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Error: " + e.getMessage(), "Retrieve ApigeeAuthToken"));
		}
	}
	
}
