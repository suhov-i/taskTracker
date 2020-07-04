package com.epam.testtask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//logging aspect

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Pointcut("execution(* com.epam.testtask.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.epam.testtask.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        logger.info("===> calling method: " + method);
        for (Object obj : args) {
            logger.info("===> arg: " + obj);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();

        logger.info("===> returning from method: " + method);
        logger.info("===> result: " + result);
    }

    @AfterThrowing(pointcut = "forAppFlow()", throwing = "exc")
    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();

        logger.error("===> exception in method: " + method);
        logger.error("===> Exception: " + exc);
    }
}
