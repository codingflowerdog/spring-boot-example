package com.example.web.exception;

/**
 * 커스텀 예외 처리
 */
public class CustomException extends RuntimeException {
    // 에러 코드
    private ErrorCode errorCode;

    /**
     * 커스텀 예외 처리
     * @param errorCode 에러 코드
     */
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    /**
     * 에러 코드 정보 조회
     * @return 에러 코드
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
