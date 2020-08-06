package com.manulife.ap.common.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.manulife.ap.common.logging.api.LogApi;
import com.manulife.ap.common.logging.model.BillStatusRequest;
import com.manulife.ap.common.logging.model.BillStatusResponse;
import com.manulife.ap.common.logging.model.PaymentChannelLogRequest;
import com.manulife.ap.common.logging.model.PaymentChannelLogResponse;
import com.manulife.ap.mli.common.exception.ApiError;
import com.manulife.ap.mli.common.exception.ApiException;
import com.manulife.ap.mli.common.feign.client.factory.CountrifiedClientFactory;

import feign.FeignException;

@Service
public class LogServiceImpl implements LogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceImpl.class);
	private static final String APPLICATION_ADAPTER_PAYMENT_CHNL_NAME = "application.adapter.payment-channel";

	private static final String ERROR_STR = "Error: ";

	@Autowired
	private CountrifiedClientFactory feignClientFactory;
	
	@Autowired
	private ApigeeAuthTokenService apigeeAuthTokenService;
	
	LogApi logApi;

	@Override
	public PaymentChannelLogResponse insertPaymentChannelLog(String market, String paymentChannel,
			PaymentChannelLogRequest log) {
		LOGGER.debug("COMMON_LogService insertPaymentChannelLog START: country: {}", market);
		PaymentChannelLogResponse response = null;
		String bearerToken = apigeeAuthTokenService.retrieveToken(market, "insertPaymentChannelLog");
		try {
			this.logApi = feignClientFactory.getCountrifiedClient(market, APPLICATION_ADAPTER_PAYMENT_CHNL_NAME, LogApi.class);
			response = this.logApi.insertPaymentChannelLog(bearerToken, paymentChannel, log);
			LOGGER.info("response: {}", response);
			LOGGER.debug("COMMON_LogService insertPaymentChannelLog. Success!");	
			return response;
		}catch (FeignException e) { 
			String errorMessage = "COMMON_LogService insertPaymentChannelLog Exception: " +e.getMessage(); 
			LOGGER.error(errorMessage);
			throw new ApiException(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_STR + e.getMessage(), "Insert PaymentChannelLog"));
		}
	}

	@Override
	public BillStatusResponse updateBillStatus(String market, String paymentChannel, BillStatusRequest request) {
		LOGGER.debug("COMMON_LogService updateBillStatus START: country: {}, paymentChannel: {}", market , paymentChannel);
		BillStatusResponse response = null;
		String bearerToken = apigeeAuthTokenService.retrieveToken(market, "updateBillStatus");
		try {
			this.logApi = feignClientFactory.getCountrifiedClient(market, APPLICATION_ADAPTER_PAYMENT_CHNL_NAME, LogApi.class);
			response = this.logApi.updateBillStatus(bearerToken, paymentChannel, request);
			LOGGER.debug("COMMON_LogService updateBillStatus response: {}", response);
			LOGGER.info("COMMON_LogService updateBillStatus. Success!");	
			return response;
		}catch (FeignException e) { 
			String errorMessage = "COMMON_LogService updateBillStatus Exception: " +e.getMessage(); 
			LOGGER.debug("COMMON_LogService updateBillStatus Exception: request: {}", request, errorMessage);
			throw new ApiException(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_STR + e.getMessage(), "updateBillStatus"));
		}
	}

	
	
	
}
