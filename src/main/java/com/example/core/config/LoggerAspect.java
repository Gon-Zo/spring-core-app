package com.example.core.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Slf4j
@Component
public class LoggerAspect {

    long startAt = 0L;

    long endAt = 0L;

    /**
     * 모든 컨틀롤러 메소드 로그 적용
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("within(com.example.core.web.*)")
    public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {

        startAt = System.currentTimeMillis();

        getByRequest();

        Object joinPointProceed = joinPoint.proceed();

        endAt = System.currentTimeMillis();

        getByResponse();

        return joinPointProceed;
    }

    private void getByRequest() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String method = request.getMethod();

        log.info("REQUEST|method={}", method);

    }

    private void getByResponse() {

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        int status = response.getStatus();

        log.info("RESPONSE|status={}|{}ms", status, endAt - startAt);

    }
}
