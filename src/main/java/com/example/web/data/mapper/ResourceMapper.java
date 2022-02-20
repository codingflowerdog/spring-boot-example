package com.example.web.data.mapper;

import com.example.web.data.dto.response.PaginationResponseDTO;
import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 리소스 맵퍼
 */
public class ResourceMapper {
    /**
     * 페이지네이션 DTO 변환
     * @return 페이지네이션 DTO
     */
    public static PaginationResponseDTO<List<ResourceListDTO>> pageableToDTO(Page<ResourceListDTO> pagination) {
        return PaginationResponseDTO.<List<ResourceListDTO>>builder()
                .data(pagination.getContent())
                .offset(pagination.getPageable().getOffset())
                .limit(pagination.getPageable().getPageSize())
                .total(pagination.getTotalElements())
                .build();
    }

    /**
     * 리소스 엔티티 DTO 변환
     * @param resourceEntity 리소스 엔티티
     * @return 리소스 상세정보 DTO
     */
    public static ResourceDetailDTO entityToResourceDetailDto(ResourceEntity resourceEntity) {
        return ResourceDetailDTO.builder()
                .resourceName(resourceEntity.getResourceName())
                .build();
    }
}
