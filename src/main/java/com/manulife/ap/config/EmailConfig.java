package com.manulife.ap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.io.File;
import java.util.List;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.manulife.ap.client.notification.model.NotificationRequest;

public class EmailConfig {
	
	@Value("${notification.market}")
	private String notifMarket;

	@Value("${notification.from}")
	private String notifFrom;

	@Value("${notification.recipients}")
	private String notifRecipients;
	
	@Value("${notification.channel}")
	private  String notifChannel;
	
	@Value("${notification.messageBody}")
	private String notifMessageBody;

	@Value("${notification.senderName}")
	private String notifSenderName;

	@Value("${notification.subject}")
	private String notifSubject;
	
	public NotificationRequest notifEmailRequest(NotificationRequest notifEmail)
	{
		notifEmail.setMarket(notifMarket);
		notifEmail.setFrom(notifFrom);
		notifEmail.setRecipients(stringToList(notifRecipients));
		notifEmail.setChannel(notifChannel);
		notifEmail.setMessageBody(notifMessageBody);
		notifEmail.setSenderName(notifSenderName);
		notifEmail.setSubject(notifSubject);
		return notifEmail;
	}
	
	private  List<String> stringToList(String str) {
		
		List<String> list =Arrays.asList(str.split(","));		
		return list;
	}

}
