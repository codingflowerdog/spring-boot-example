package com.example.web.repository.resource;

import com.example.web.data.dto.response.resource.ResourceDetailDTO;
import com.example.web.data.dto.response.resource.ResourceListDTO;
import com.example.web.data.entity.ResourceEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.web.data.entity.QResourceEntity.resourceEntity;

@Repository
public class ResourceRepositoryImpl extends QuerydslRepositorySupport implements ResourceRepositoryDsl {
    private final JPAQueryFactory queryFactory;

    public ResourceRepositoryImpl(JPAQueryFactory queryFactory) {
        super(ResourceEntity.class);
        this.queryFactory = queryFactory;
    }

    /**
     * 리소스 조회
     * @param uuid UUID
     * @return 리소스
     */
    @Override
    public Optional<ResourceEntity> findByUUID(String uuid) {
        BooleanBuilder conditions = new BooleanBuilder();

        // 조회 대상 설정
        JPAQuery<ResourceEntity> query = queryFactory.select(resourceEntity);
        query.from(resourceEntity);

        // 조건 설정
        conditions.and(resourceEntity.uuid.eq(uuid));
        query.where(conditions);

        return Optional.ofNullable(query.fetchOne());
    }

    /**
     * 리소스 조회
     * @param resourceId 리소스 ID
     * @return 리소스
     */
    @Override
    public Optional<ResourceDetailDTO> findDetail(int resourceId) {
        BooleanBuilder conditions = new BooleanBuilder();

        // 조회 대상 설정
        JPAQuery<ResourceDetailDTO> query = queryFactory.select(Projections.fields(ResourceDetailDTO.class,
                resourceEntity.resourceName
        ));

        // 대상 설정
        query.from(resourceEntity);

        // 조건 설정
        conditions.and(resourceEntity.id.eq(resourceId));
        query.where(conditions);

        return Optional.ofNullable(query.fetchOne());
    }

    /**
     * 리소스 목록 조회
     * @return 리소스 목록
     */
    @Override
    public List<ResourceListDTO> findAllResources() {
        // 조회 대상 설정
        JPAQuery<ResourceListDTO> query = queryFactory.select(Projections.fields(ResourceListDTO.class,
                resourceEntity.id.as("resourceId"),
                resourceEntity.resourceName,
                resourceEntity.createdDate
        ));
        query.from(resourceEntity);

        return query.fetch();
    }

    /**
     * 리소스 목록 조회
     * @param pageable 페이지네이션 정보
     * @return 리소스 페이지네이션
     */
    @Override
    public Page<ResourceListDTO> findAllResources(Pageable pageable) {
        // 조회 대상 설정
        JPAQuery<ResourceListDTO> query = queryFactory.select(Projections.fields(ResourceListDTO.class,
                resourceEntity.id.as("resourceId"),
                resourceEntity.resourceName,
                resourceEntity.createdDate
        ));
        query.from(resourceEntity);

        // 결과 조회
        List<ResourceListDTO> results = query.fetch();

        // 전체 레코드 수 조회
        JPAQuery<Integer> countQuery = queryFactory.select(resourceEntity.id);
        countQuery.from(resourceEntity);
        int count = query.fetch().size();

        return new PageImpl(
                results,
                pageable,
                count
        );
    }
}