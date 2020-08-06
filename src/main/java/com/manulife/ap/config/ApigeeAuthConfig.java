package com.manulife.ap.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import com.manulife.ap.common.logging.model.ClientCredential;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "apigee-auth")
public class ApigeeAuthConfig {
	
	private String url;
	
	private Map<String, ClientCredential> credential;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, ClientCredential> getCredential() {
		return credential;
	}

	public void setCredential(Map<String, ClientCredential> credential) {
		this.credential = credential;
	}
	
}
