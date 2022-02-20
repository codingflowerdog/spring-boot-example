package com.example.web.data.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 페이지네이션 요청 정보
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequestDTO {
    // 오프셋
    @ApiParam(value = "오프셋", example = "offset")
    @Builder.Default
    private int offset = 0;

    // 페이지당 표시 항목 수
    @ApiParam(value = "페이지당 표시 항목 수", example = "limit")
    @Builder.Default
    private int limit = 10;
}
