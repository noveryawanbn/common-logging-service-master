package com.manulife.ap.common.logging.service;

public interface ApigeeAuthTokenService {
	
	public String retrieveToken(String market, String functionName);

}
