package com.example.web.aspect.log;

import com.example.web.annotation.ActionMapping;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 로그 필드
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogField {
    // 타임스탬프
    @Expose
    @JsonProperty("timestamp")
    private String timestamp;

    // 접속자 IP
    @Expose
    @JsonProperty("ip")
    private String ip;

    // URI
    @Expose
    @JsonProperty("uri")
    private String uri;

    // 액션
    @Expose
    @JsonProperty("action")
    private String action;

    // 결과
    @Expose
    @JsonProperty("result")
    private String result;

    // 메세지
    @Expose
    @JsonProperty("message")
    private String message;

    // 클래스명
    @Expose
    @JsonProperty("class")
    private String className;

    // 메서드명
    @Expose
    @JsonProperty("method")
    private String methodName;

    // 파라미터
    @Expose
    @JsonProperty("parameters")
    private String parameters;

    // 메서드 정보
    private Method method;

    /**
     * 액션 정보 설정
     * @param joinPoint 조인 포인트
     * @return 로그 필드
     */
    public LogField init(JoinPoint joinPoint) {
        // 메서드 정보 획득
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 액션 정보 설정
        ActionMapping actionMapping = method.getAnnotation(ActionMapping.class);
        this.action = actionMapping.value().getAction();

        this.method = method;
        this.className = joinPoint.getTarget().getClass().getCanonicalName();
        this.methodName = this.method.getName();
        this.parameters = getParameters(joinPoint);

        return this;
    }

    /**
     * 액션 정보 설정
     * @return 로그 필드
     */
    public LogField action() {
        // 액션 정보 설정
        ActionMapping actionMapping = this.method.getAnnotation(ActionMapping.class);
        this.action = actionMapping.value().getAction();

        return this;
    }

    /**
     * 액션 정보 설정
     * @param action 액션 정보
     * @return 로그 필드
     */
    public LogField action(String action) {
        // 액션 정보 설정
        this.action = action;

        return this;
    }

    /**
     * 액션 정보 설정
     * @param request HTTP 리퀘스트
     * @return 로그 필드
     */
    public LogField target(HttpServletRequest request) {
        // 요청자 정보 설정
        this.ip = request.getRemoteAddr();
        this.uri = request.getRequestURI();

        return this;
    }

    /**
     * 성공 로그 처리
     */
    public LogField success() {
        this.result = "success";

        return this;
    }

    /**
     * 실패 로그 처리
     * @param message 에러 메세지
     */
    public LogField fail(String message) {
        this.result = "fail";
        this.message = message;

        return this;
    }

    /**
     * 로그 출력
     */
    public void print() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(this));
    }

    /**
     * 파라미터 정보 획득
     * @param joinPoint 조인 포인트
     * @return 파라미터 정보
     */
    private String getParameters(JoinPoint joinPoint) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        ArrayList<Object> parameters = new ArrayList<>();

        // 파라미터 설정
        for (Object parameter: joinPoint.getArgs()) {
            if ( !(parameter instanceof HttpServletRequest) && !(parameter instanceof HttpServletResponse)) {
                parameters.add(parameter);
            }
        }

        // 파라미터 문자열 변환
        return gson.toJson(parameters);
    }
}
