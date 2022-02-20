package com.example.web.data.dto.response.resource;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 리소스 상세 정보
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDetailDTO {
    // 리소스 정보
    @ApiParam(value = "리소스 이름", example = "Resource Name", required = true)
    private String resourceName;
}
