package com.example.web.exception;

import com.example.web.data.dto.response.ErrorResponseDTO;
import com.example.web.exception.custom.ExampleException;
import com.example.web.exception.custom.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 커스텀 전역 예외처리 핸들러
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    /**
     * 기존ㄴ 예외 처리
     * @param exception 예외
     * @return 에러 리스폰스
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponseDTO> notFoundException(Exception exception) {

        return generateErrorResponse(exception);
    }

    /**
     * 예제 예외 처리
     * @param exampleException 테스트 예외
     * @return 에러 리스폰스
     */
    @ExceptionHandler(ExampleException.class)
    protected ResponseEntity<ErrorResponseDTO> exampleException(ExampleException exampleException) {
        return generateErrorResponse(exampleException.getErrorCode());
    }

    /**
     * 대상 없음 예외 처리
     * @param notFoundException 대상 없음 예외
     * @return 에러 리스폰스
     */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException notFoundException) {

        return generateErrorResponse(notFoundException.getErrorCode());
    }

    /**
     * 커스텀 예외 에러 리스폰스 생성
     * @param errorCode 에러 코드
     * @return 에러 리스폰스
     */
    private ResponseEntity<ErrorResponseDTO> generateErrorResponse(ErrorCode errorCode) {
        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();

        return new ResponseEntity<>(response, null, errorCode.getStatus());
    }

    /**
     * 기존 예외 에러 리스폰스 생성
     * @param exception 예외
     * @return 에러 리스폰스
     */
    private ResponseEntity<ErrorResponseDTO> generateErrorResponse(Exception exception) {
        ErrorResponseDTO response = ErrorResponseDTO.builder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
