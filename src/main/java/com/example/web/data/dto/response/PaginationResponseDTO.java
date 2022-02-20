package com.example.web.data.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponseDTO <T> {
    // 데이터
    @ApiParam(value = "데이터", required = true)
    private T data;

    // 오프셋
    @ApiParam(value = "오프셋", example = "1", required = true)
    private Long offset;

    // 페이지당 표시 항목 수
    @ApiParam(value = "페이지당 표시 항목 수", example = "10", required = true)
    private int limit;

    // 총 리스트 수
    @ApiParam(value = "총 리스트 수", example = "100", required = true)
    private Long total;
    
}
