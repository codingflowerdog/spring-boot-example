package com.example.web.exception.custom;

import com.example.web.exception.CustomException;
import com.example.web.exception.ErrorCode;

/**
 * 예제 예외 처리
 */
public class ExampleException extends CustomException {
    public ExampleException() { super(ErrorCode.EXAMPLE_EXCEPTION); }
}
