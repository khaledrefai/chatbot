package com.khaled.chatbot.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;

import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
     @Getter
	private String secretKey = "secret";

	//validity in milliseconds
	private long validityInMs = 3600000; // 1h

	public String getSecretKey() {
		// TODO Auto-generated method stub
		return secretKey;
	}

	public long getValidityInMs() {
		// TODO Auto-generated method stub
		return validityInMs;
	}
}
