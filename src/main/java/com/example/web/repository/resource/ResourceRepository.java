package com.example.web.repository.resource;

import com.example.web.data.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 리소스 레포지토리 인터페이스
 */
public interface ResourceRepository extends JpaRepository<ResourceEntity, Integer>, ResourceRepositoryDsl {

}