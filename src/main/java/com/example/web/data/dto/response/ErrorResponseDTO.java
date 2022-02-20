package com.example.web.data.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 에러 응답
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    // 에러 메세지
    @ApiParam(value = "에러 메세지", example = "Internal Server Error", required = true)
    private String message;

    // 에러 코드
    @ApiParam(value = "에러 코드", example = "ERR_A01", required = true)
    private String code;

    // 상태 코드
    @ApiParam(value = "상태 코드", example = "500", required = true)
    private int status;
}
