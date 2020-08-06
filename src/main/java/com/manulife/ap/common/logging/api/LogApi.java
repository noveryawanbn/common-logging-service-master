package com.manulife.ap.common.logging.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.manulife.ap.common.logging.model.BillStatusRequest;
import com.manulife.ap.common.logging.model.BillStatusResponse;
import com.manulife.ap.common.logging.model.PaymentChannelLogRequest;
import com.manulife.ap.common.logging.model.PaymentChannelLogResponse;

import io.swagger.annotations.ApiParam;

public interface LogApi {
	
	@PostMapping(value = "/v1/paymentChannels/{paymentChannel}/log", consumes = "application/json")
	PaymentChannelLogResponse insertPaymentChannelLog(
			@ApiParam(value = "authorization", required = true) 
			@RequestHeader("Authorization") String bearerToken,
			@ApiParam(value = "payment channel", required = true) 
			@PathVariable("paymentChannel") String paymentChannel,
			@ApiParam(value = "log request body", required = true) 
			@Valid @RequestBody PaymentChannelLogRequest log);
	
	@PostMapping(value = "/v1/paymentChannels/{paymentChannel}/billStatus", consumes = "application/json")
	BillStatusResponse updateBillStatus(
			@ApiParam(value = "authorization", required = true) 
			@RequestHeader("Authorization") String bearerToken,
			@ApiParam(value = "payment channel", required = true) 
			@PathVariable("paymentChannel") String paymentChannel,
			@ApiParam(value = "log request body", required = true) 
			@Valid @RequestBody BillStatusRequest request);
	
}
