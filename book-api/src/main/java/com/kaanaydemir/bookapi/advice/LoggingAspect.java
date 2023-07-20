package com.kaanaydemir.bookapi.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
            " @annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
            " @annotation(org.springframework.web.bind.annotation.PutMapping) ||" +
            " @annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object logOutput(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue = joinPoint.proceed();
        logger.info("Response Body: {}", returnValue);
        return returnValue;
    }
}
