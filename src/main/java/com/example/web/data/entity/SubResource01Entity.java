package com.example.web.data.entity;

import com.example.web.data.dto.request.ResourceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 서브 리소스 01 엔티티
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_resource_01")
public class SubResource01Entity {
    // 리소스 ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n4_id")
    private Integer id;

    @Column(name = "n4_resource_id", insertable = false, updatable = false)
    private Integer resourceId;

    // 리소스 이름
    @Column(name = "str_resource_name")
    private String resourceName;

    // 생성일
    @CreationTimestamp
    @Column(name = "dt_created_date")
    private LocalDateTime createdDate;

    // 변경일
    @UpdateTimestamp
    @Column(name = "dt_updated_date")
    private LocalDateTime updatedDate;

    // 리소스
    @OneToMany(mappedBy = "subResource01Entity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<ResourceEntity> resourceEntities;

    /**
     * 리소스 설정
     * @param resourceDTO 리소스 정보
     */
    public void addResource(ResourceDTO resourceDTO) {
        // 리소스 정보 설정
        ResourceEntity resourceEntity = ResourceEntity.builder()
                .resourceName(resourceDTO.getResourceName())
                .subResource01Entity(this)
                .build();

        // 리소스 목록 없는 경우 초기화
        if (ObjectUtils.isEmpty(this.resourceEntities)) {
            ArrayList<ResourceEntity> resourceEntities = new ArrayList<>();

            this.resourceEntities = resourceEntities;
        }

        this.resourceEntities.add(resourceEntity);
    }
}