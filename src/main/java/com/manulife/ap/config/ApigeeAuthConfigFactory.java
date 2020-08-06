package com.manulife.ap.config;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.manulife.ap.common.logging.model.ClientCredential;
import com.manulife.ap.mli.common.exception.ApiError;
import com.manulife.ap.mli.common.exception.ApiException;

@Component
public class ApigeeAuthConfigFactory {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApigeeAuthConfigFactory.class);
	
	private ApigeeAuthConfig apigeeAuthConfig;
	
	@Autowired
	public ApigeeAuthConfigFactory(ApigeeAuthConfig apigeeAuthConfig) {
		this.apigeeAuthConfig = apigeeAuthConfig;
	}
	
	/**
	 * Fetch the appropriate dynamics configuration properties according to market
	 * 
	 * @param market target
	 * @return CRMProperties of the market passed
	 * @throws ApiException
	 */
	public ClientCredential getClientCredential(String market) {
		LOGGER.info("ApigeeAuthConfigFactory.getClientCredential() - Entry");
		Optional<ClientCredential> optionalModel = Optional.ofNullable(apigeeAuthConfig.getCredential())
				.map(mapProp -> mapProp.getOrDefault(market, new ClientCredential()))
				.filter(Objects::nonNull).filter(model -> StringUtils.isNotEmpty(model.getClientId())
						&& StringUtils.isNotEmpty(model.getClientSecret())
						);
		if(optionalModel.isPresent()) {
			LOGGER.info("ApigeeAuthConfigFactory.getClientCredential() - Exit");
			return optionalModel.get();
		}
		LOGGER.info("Market is not supported!");

		throw new ApiException(new ApiError(HttpStatus.BAD_REQUEST, "ApigeeAuthConfigFactory",
				"getClientCredential() error: " + "Market not supported."));
	}
}
