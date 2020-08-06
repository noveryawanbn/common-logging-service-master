package com.manulife.ap.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.manulife.ap.mli.common.feign.client.factory.CountrifiedClientFactory;
import com.manulife.ap.mli.common.feign.config.FeignConfig;

import feign.httpclient.ApacheHttpClient;

@Configuration
@RefreshScope
@EnableConfigurationProperties
public class FeignClientConfig {

	@Value("${request.read.timeout}")
	private Integer timeout;
	
	@Bean
	@Scope(value = "prototype")
	public CountrifiedClientFactory getFeignClientFactory(Environment environment) throws IOException{
		return (CountrifiedClientFactory) new CountrifiedClientFactory(environment, new FeignConfig(timeout)).setClient(new ApacheHttpClient());
	}

}