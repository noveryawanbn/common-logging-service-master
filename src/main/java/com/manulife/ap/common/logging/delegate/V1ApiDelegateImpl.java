package com.manulife.ap.common.logging.delegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.manulife.ap.common.logging.api.V1ApiDelegate;
import com.manulife.ap.common.logging.model.BillStatusRequest;
import com.manulife.ap.common.logging.model.BillStatusResponse;
import com.manulife.ap.common.logging.model.PaymentChannelLogRequest;
import com.manulife.ap.common.logging.model.PaymentChannelLogResponse;
import com.manulife.ap.common.logging.service.LogService;

@Component
public class V1ApiDelegateImpl implements V1ApiDelegate {
	private static final Logger log = LoggerFactory.getLogger(V1ApiDelegateImpl.class);
	@Autowired
	private LogService logService;

	@Override
	public ResponseEntity<PaymentChannelLogResponse> insertPaymentChannelLog(String market, String paymentChannel,
			PaymentChannelLogRequest log) {
		return new ResponseEntity<>(logService.insertPaymentChannelLog(market, paymentChannel, log), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BillStatusResponse> updateBillingStatus(String market, String paymentChannel,
			BillStatusRequest billStatusRequest) {
		log.debug("Received update bill status request: market: {} , paymentChannel: {}", market, paymentChannel);

		return new ResponseEntity<>(logService.updateBillStatus(market, paymentChannel, billStatusRequest),
				HttpStatus.OK);
	}

}
