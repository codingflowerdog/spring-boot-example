package com.example.web.stub;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 베이스 엔티티 Stub
 */
public class BaseEntityStub{
    static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static LocalDateTime CREATED_DATE = LocalDateTime.parse("2022-02-19 00:00:00", DATE_TIME_FORMAT);
    static LocalDateTime UPDATED_DATE = LocalDateTime.parse("2022-02-19 00:00:00", DATE_TIME_FORMAT);

    /**
     * 페이지네이션 결과 획득
     * @param offset 오프셋
     * @param limit 페이지당 표시 목록 수
     * @param entity 엔티티
     * @return 페이지네이션 결과
     */
    public static <E> Page<E> getPagination(int offset, int limit, E entity) {
        int count = 1;
        PageRequest pageRequest = PageRequest.of(offset, limit);

        return new PageImpl(
                new ArrayList<>(Arrays.asList(entity)),
                pageRequest,
                count);
    }
}
