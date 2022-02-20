package com.example.web.stub;

import com.example.web.data.dto.request.ResourceDTO;
import com.example.web.data.entity.ResourceEntity;
import com.example.web.data.entity.SubResource01Entity;
import com.example.web.data.entity.SubResource02Entity;
import com.example.web.data.entity.SubResource03Entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 엔티티 Stub
 */
public class EntitySub extends BaseEntityStub {
    /**
     * 리소스 엔티티 stub 획득
     * @return 리소스 엔티티 stub
     */
    public static ResourceEntity getResource() {
        // 리소스 DTO stub 획득
        ResourceDTO resourceDTO = DTOStub.getResource();

        // 리소스 엔티티 stub 설정
        ResourceEntity resourceEntity = ResourceEntity.builder()
                .id(1)
                .resourceName(resourceDTO.getResourceName())
                .uuid(resourceDTO.getUuid())
                .createdDate(CREATED_DATE)
                .updatedDate(UPDATED_DATE)
                .build();

        // 서브 리소스 02 엔티티 설정
        SubResource02Entity subResource02Entity = getSubResource02();
        subResource02Entity.setResourceId(resourceEntity.getId());
        subResource02Entity.setResourceEntity(resourceEntity);
        resourceEntity.setSubResource02Entities(new ArrayList<>(Arrays.asList(subResource02Entity)));

        // 서브 리소스 03 엔티티 설정
        SubResource03Entity subResource03Entity = getSubResource03();
        subResource03Entity.setResourceId(resourceEntity.getId());
        subResource03Entity.setResourceEntity(resourceEntity);
        resourceEntity.setSubResource03Entity(subResource03Entity);

        return resourceEntity;
    }

    /**
     * 서브 리소스 01 엔티티 stub 획득
     * @return 서브 리소스 01 엔티티 stub
     */
    public static SubResource01Entity getSubResource01() {
        // 리소스 DTO stub 획득
        ResourceDTO resourceDTO = DTOStub.getResource();

        // 서브 리소스 01 엔티티 stub 설정
        SubResource01Entity subResource01Entity = SubResource01Entity.builder()
                .id(1)
                .resourceName(resourceDTO.getResourceName())
                .createdDate(CREATED_DATE)
                .updatedDate(UPDATED_DATE)
                .build();

        return subResource01Entity;
    }

    /**
     * 서브 리소스 02 엔티티 stub 획득
     * @return 서브 리소스 02 엔티티 stub
     */
    public static SubResource02Entity getSubResource02() {
        // 리소스 DTO stub 획득
        ResourceDTO resourceDTO = DTOStub.getResource();

        // 서브 리소스 02 엔티티 stub 설정
        SubResource02Entity subResource02Entity = SubResource02Entity.builder()
                .id(1)
                .resourceName(resourceDTO.getResourceName())
                .createdDate(CREATED_DATE)
                .updatedDate(UPDATED_DATE)
                .build();

        return subResource02Entity;
    }

    /**
     * 서브 리소스 03 엔티티 stub 획득
     * @return 서브 리소스 03 엔티티 stub
     */
    public static SubResource03Entity getSubResource03() {
        // 리소스 DTO stub 획득
        ResourceDTO resourceDTO = DTOStub.getResource();

        // 서브 리소스 03 엔티티 stub 설정
        SubResource03Entity subResource03Entity = SubResource03Entity.builder()
                .id(1)
                .resourceName(resourceDTO.getResourceName())
                .createdDate(CREATED_DATE)
                .updatedDate(UPDATED_DATE)
                .build();

        return subResource03Entity;
    }
}
