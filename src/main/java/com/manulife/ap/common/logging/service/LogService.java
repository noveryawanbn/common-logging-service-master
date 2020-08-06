package com.manulife.ap.common.logging.service;

import com.manulife.ap.common.logging.model.BillStatusRequest;
import com.manulife.ap.common.logging.model.BillStatusResponse;
import com.manulife.ap.common.logging.model.PaymentChannelLogRequest;
import com.manulife.ap.common.logging.model.PaymentChannelLogResponse;

public interface LogService {
	
	public PaymentChannelLogResponse insertPaymentChannelLog(String market, String paymentChannel,
			PaymentChannelLogRequest log);
	
	public BillStatusResponse updateBillStatus(String market, String paymentChannel,
			BillStatusRequest request);

}
