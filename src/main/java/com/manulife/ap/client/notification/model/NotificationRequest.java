package com.manulife.ap.client.notification.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NotificationRequest {
	
	private String market;	
	private String from;
	private List<String> recipients;
	private String channel;
	private String messageBody;
	private List<String> ccList;
	private String senderName;
	private String subject;
	private MultipartFile attachment1;
	private MultipartFile attachment2;
	private MultipartFile attachment3;
	private MultipartFile attachment4;
	private MultipartFile attachment5;
	private String app;
	private String contentType;
	private Boolean useocdm;
	private String customer; 
	private String templateId;
	private List<String> templateData;
	private List<String> miscData;
	
	
	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
	
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	public List<String> getCCList() {
		return ccList;
	}

	public void setCCList(List<String> ccList) {
		this.ccList = ccList;
	}
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public MultipartFile getAttachment1() {
		return attachment1;
	}

	public void setAttachment1(MultipartFile attachment1) {
		this.attachment1 = attachment1;
	}
	
	public MultipartFile getAttachment2() {
		return attachment2;
	}

	public void setAttachment2(MultipartFile attachment2) {
		this.attachment2 = attachment2;
	}
	
	public MultipartFile getAttachment3() {
		return attachment3;
	}

	public void setAttachment3(MultipartFile attachment3) {
		this.attachment3 = attachment3;
	}
	
	public MultipartFile getAttachment4() {
		return attachment4;
	}

	public void setAttachment4(MultipartFile attachment4) {
		this.attachment4 = attachment4;
	}
	
	public MultipartFile getAttachment5() {
		return attachment5;
	}

	public void setAttachment5(MultipartFile attachment5) {
		this.attachment5 = attachment5;
	}
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public Boolean getUseocdm() {
		return useocdm;
	}

	public void setUseocdm(Boolean useocdm) {
		this.useocdm = useocdm;
	}
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	public List<String> getTemplateData() {
		return templateData;
	}

	public void setTemplateData(List<String> templateData) {
		this.templateData = templateData;
	}
	
	public List<String> getMiscData() {
		return miscData;
	}

	public void setMiscData(List<String> miscData) {
		this.miscData = miscData;
	}
}
