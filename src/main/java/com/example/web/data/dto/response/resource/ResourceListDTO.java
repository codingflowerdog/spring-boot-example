package com.example.web.data.dto.response.resource;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 리소스 목록
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceListDTO {
    // 리소스 번호
    @ApiParam(value = "리소스 ID", example = "1", required = true)
    private int resourceId;

    // 리소스 이름
    @ApiParam(value = "리소스 이름", example = "Resource Name", required = true)
    private String resourceName;

    // 생성일
    @ApiParam(value = "생성일", example = "2021-01-01", required = true)
    private LocalDateTime createdDate;
}
