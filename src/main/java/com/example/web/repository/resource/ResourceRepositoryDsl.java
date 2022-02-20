package com.example.web.repository.resource;

import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * 리소스 레포지토리 DSL 인터페이스
 */
public interface ResourceRepositoryDsl {
    // 리소스 조회
    public Optional<ResourceEntity> findByUUID(String uuid);

    // 리소스 조회
    public Optional<ResourceDetailDTO> findDetail(int resourceId);

    // 리소스 목록 조회
    public Page<ResourceListDTO> findAllResources(Pageable pageable);

    // 리소스 목록 조회
    public List<ResourceListDTO> findAllResources();
}