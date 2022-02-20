package com.example.web.data.dto.request;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 리소스 요청
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
    // 리소스 정보
    @ApiParam(value = "리소스 이름", example = "Resource Name", required = true)
    private String resourceName;

    // UUID
    @ApiParam(value = "UUID", example = "da91332a-9175-11ec-b909-0242ac120002", required = true)
    private String uuid;
}
