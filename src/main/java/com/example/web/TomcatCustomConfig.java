package com.example.web;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * 톰캣 커스텀 설정
 */
@Configuration
public class TomcatCustomConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	/**
	 * 톰캣 커스터마이즈
	 * 톰캣에 적용된 RFC 3986 규칙을 우회하기 위한 메소드
	 * @param factory 톰캣 웹서버 팩토리
	 */
	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		factory.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "<>[\\]^`{|}_"));
	}
}
