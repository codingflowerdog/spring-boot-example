package com.example.web;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * QueryDSL 설정
 */
@Configuration
@EnableJpaRepositories
public class QuerydslConfig implements WebMvcConfigurer {
	@PersistenceContext
	private EntityManager entityManager;

	/**
     * JPA Query Factory 초기화
	 */
	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}
}
