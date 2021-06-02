package com.online.store.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * AOP class for logging
 *
 * @author Dmitri Tšornõi
 */
@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.online.store.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.online.store.repository.*.*(..))")
    private void forRepositoryPackage(){}

    @Pointcut("execution(* com.online.store.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forRepositoryPackage() || forServicePackage() || forControllerPackage()")
    private void forAppFlow(){}


    @Before("forControllerPackage()")
    public void beforeController(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@Before: " + className + " calling method: " + method);

    }

    @AfterReturning("forControllerPackage()")
    public void afterReturningController(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@AfterReturning: " + className + " from method: " + method);
    }


    @Before("forServicePackage()")
    public void beforeService(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@Before: " + className + " calling method: " + method);

    }

    @AfterReturning("forServicePackage()")
    public void afterReturningService(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@AfterReturning: " + className + " from method: " + method);
    }


    @Before("forRepositoryPackage()")
    public void beforeRepository(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@Before: " + className + " calling method: " + method);

    }

    @AfterReturning("forRepositoryPackage()")
    public void afterReturningRepository(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        logger.info("@AfterReturning: " + className + " from method: " + method);
    }

}
