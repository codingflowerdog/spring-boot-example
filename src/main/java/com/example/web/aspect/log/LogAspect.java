package com.example.web.aspect.log;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 로그 AOP
 */
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LogAspect {
    private final HttpServletRequest request;

    /**
     * 로그 출력
     * @param joinPoint 조인 포인트
     */
    @AfterReturning("execution(* com.example.web.controller..*.*(..)) && @annotation(com.example.web.annotation.ActionMapping)")
    public void print(JoinPoint joinPoint) {
        // 로그 출력
        new LogField()
                .init(joinPoint)
                .target(request)
                .action()
                .success()
                .print();
    }

    /**
     * 로그 출력
     * @param joinPoint 조인 포인트
     */
    @AfterThrowing(value="execution(* com.example.web.controller..*.*(..)) && @annotation(com.example.web.annotation.ActionMapping)", throwing = "exception")
    public void exception(JoinPoint joinPoint, Exception exception) {
        // 로그 출력
        new LogField()
                .init(joinPoint)
                .target(request)
                .action()
                .fail(exception.getMessage())
                .print();
    }
}
