package com.example.web.exception;

/**
 * 에러 코드
 */
public enum ErrorCode {
    EXAMPLE_EXCEPTION(400, "Example Exception"),
    NOTFOUND(404, "Resource not found");

    private final String message;
    private final int status;

    public String getMessage() { return message; }
    public int getStatus() { return status; }

    /**
     * 에러 코드 생성자
     * @param status 상태
     * @param message 에러메세지
     */
    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
}
