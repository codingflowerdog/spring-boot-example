package com.example.web.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 서브 리소스 02 엔티티
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_resource_02")
public class SubResource02Entity {
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "n4_resource_id", referencedColumnName = "n4_id")
    private ResourceEntity resourceEntity;
}