package com.example.web.exception.custom;

import com.example.web.exception.CustomException;
import com.example.web.exception.ErrorCode;

/**
 * 대상 없음 예외 처리
 */
public class NotFoundException extends CustomException {
    public NotFoundException() { super(ErrorCode.NOTFOUND); }
}
