package com.example.web.stub;

import com.example.web.data.dto.request.PaginationRequestDTO;
import com.example.web.data.dto.request.ResourceDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;

/**
 * DTO stub
 */
public class DTOStub {
    /**
     * 리소스 DTO stub 획득
     * @return 리소스 DTO stub
     */
    public static ResourceDTO getResource() {
        return ResourceDTO.builder()
                .resourceName("resourceName")
                .uuid("da91332a-9175-11ec-b909-0242ac120002")
                .build();
    }

    /**
     * 페이지네이션 DTO stub 조회
     * @return 페이지네이션 DTO stub
     */
    public static PaginationRequestDTO getPagination() {
        return PaginationRequestDTO.builder()
                .offset(0)
                .limit(10)
                .build();
    }

    /**
     * 리소스 목록 조회 DTO stub 조회
     * @param resourceEntity 리소스 엔티티
     * @return 리소스 목록 조회 DTO stub
     */
    public static ResourceListDTO getResourceListDTO(ResourceEntity resourceEntity) {
        return ResourceListDTO.builder()
                .resourceId(resourceEntity.getId())
                .resourceName(resourceEntity.getResourceName())
                .createdDate(resourceEntity.getCreatedDate())
                .build();
    }
}
