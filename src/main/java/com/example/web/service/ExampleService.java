package com.example.web.service;

import com.example.web.data.dto.request.PaginationRequestDTO;
import com.example.web.data.dto.request.ResourceDTO;
import com.example.web.data.dto.response.PaginationResponseDTO;
import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;
import com.example.web.data.mapper.ResourceMapper;
import com.example.web.exception.custom.NotFoundException;
import com.example.web.repository.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 예제 서비스
 */
@Service
public class ExampleService {
    @Autowired
    ResourceRepository resourceRepository;

    /**
     * 리소스 생성
     * @param resourceDTO 리소스 정보
     */
    public ResourceDetailDTO createResource(ResourceDTO resourceDTO) {
        // 리소스 생성 구현
        ResourceEntity resourceEntity = new ResourceEntity();

        // 리소스 정보 설정
        resourceEntity.setResource(resourceDTO);
        resourceEntity.setSubResource02(resourceDTO);
        resourceEntity.setSubResource03(resourceDTO);

        ResourceEntity savedResourceEntity = resourceRepository.save(resourceEntity);

        // DTO 변환
            return ResourceMapper.entityToResourceDetailDto(savedResourceEntity);
    }

    /**
     * 리소스 조회
     * @param resourceId 번호
     */
    public ResourceDetailDTO readResource(int resourceId) {
        // 리소스 조회
        ResourceDetailDTO resourceDetail = resourceRepository.findDetail(resourceId)
                .orElseThrow(NotFoundException::new);

        return resourceDetail;
    }

    /**
     * 리소스 목록 조회
     * @param paginationRequestDTO 페이지네이션 정보
     */
    public PaginationResponseDTO<List<ResourceListDTO>> readResources(PaginationRequestDTO paginationRequestDTO) {
        // 리소스 조회
        PageRequest pageRequest = PageRequest.of(paginationRequestDTO.getOffset(), paginationRequestDTO.getLimit());
        Page<ResourceListDTO> resources = resourceRepository.findAllResources(pageRequest);

        return ResourceMapper.pageableToDTO(resources);
    }

    /**
     * 리소스 수정
     * @param resourceId 번호
     * @param resourceDTO 리소스 정보
     */
    public ResourceDetailDTO updateResource(int resourceId, ResourceDTO resourceDTO) {
        // 리소스 조회
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(NotFoundException::new);

        // 리소스 수정
        resourceEntity.setResource(resourceDTO);

        ResourceEntity savedResourceEntity = resourceRepository.save(resourceEntity);

        // DTO 변환
        return ResourceMapper.entityToResourceDetailDto(savedResourceEntity);
    }

    /**
     * 리소스 삭제
     * @param resourceId 번호
     */
    public void deleteResource(int resourceId) {
        // 리소스 조회
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(NotFoundException::new);

        resourceRepository.delete(resourceEntity);
    }
}
