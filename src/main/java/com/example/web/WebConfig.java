package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web 설정
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${web.clientUrl}")
	private String clientUrl;

	/**
     * CORS 맵핑 설정
	 * @param registry cors 레지스트리
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowCredentials(true)
			.allowedMethods("*")
			.allowedOrigins(clientUrl);
	}
}
