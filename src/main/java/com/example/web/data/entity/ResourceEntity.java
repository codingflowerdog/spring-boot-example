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
 * 리소스 엔티티
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resource")
public class ResourceEntity {
    // 리소스 ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "n4_id")
    private Integer id;

    // 리소스 이름
    @Column(name = "str_resource_name")
    private String resourceName;

    // UUID
    @Column(name = "str_uuid")
    private String uuid;

    // 생성일
    @CreationTimestamp
    @Column(name = "dt_created_date")
    private LocalDateTime createdDate;

    // 변경일
    @UpdateTimestamp
    @Column(name = "dt_updated_date")
    private LocalDateTime updatedDate;

    // 서브 리소스 01
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "n4_resource_id", referencedColumnName = "n4_id")
    private SubResource01Entity subResource01Entity;

    // 서브 리소스 02
    @OneToMany(mappedBy = "resourceEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<SubResource02Entity> subResource02Entities;

    // 서브 리소스 03
    @OneToOne(mappedBy = "resourceEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SubResource03Entity subResource03Entity;

    /**
     * 리소스 설정
     * @param resourceDTO 리소스 정보
     */
    public void setResource(ResourceDTO resourceDTO) {
        // 리소스 정보 설정
        this.resourceName = resourceDTO.getResourceName();
        this.uuid = resourceDTO.getUuid();
    }

    /**
     * 서브 리소스 02 설정
     * @param resourceDTO 리소스 정보
     */
    public void setSubResource02(ResourceDTO resourceDTO) {
        // 서브 리로스 02 정보 설정
        SubResource02Entity subResource02Entity = SubResource02Entity.builder()
                .resourceName(resourceDTO.getResourceName())
                .resourceEntity(this)
                .build();

        // 리소스 목록 없는 경우 초기화
        if (ObjectUtils.isEmpty(this.subResource02Entities)) {
            ArrayList<SubResource02Entity> subResource02Entities = new ArrayList<>();

            this.subResource02Entities = subResource02Entities;
        }

        this.subResource02Entities.add(subResource02Entity);
    }

    /**
     * 서브 리소스 03 설정
     * @param resourceDTO 리소스 정보
     */
    public void setSubResource03(ResourceDTO resourceDTO) {
        // 서브 리소스 03 정보 설정
        SubResource03Entity subResource03Entity = SubResource03Entity.builder()
                .resourceName(resourceDTO.getResourceName())
                .resourceEntity(this)
                .build();

        this.subResource03Entity = subResource03Entity;
    }
}