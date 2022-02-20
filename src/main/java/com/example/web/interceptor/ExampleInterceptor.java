package com.example.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 인터셉터 예제
 */
@Slf4j
@Component
public class ExampleInterceptor implements HandlerInterceptor {
    /**
     * 컨트롤러 전처리 작업
     * @param request 리퀘스트
     * @param response 리스폰스
     * @param handler 핸들러 대상
     * @return 체크 결과 true/false
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Pre Handle Process : '{}'", request.getRequestURI());

        return true;
    }

    /**
     * 컨트롤러 후처리 작업
     * @param request 리퀘스트
     * @param response 리스폰스
     * @param handler 핸들러 대상
     * @return 체크 결과 true/false
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("Post Handle Process : '{}'", request.getRequestURI());
    }
}
