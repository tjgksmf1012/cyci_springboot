package kr.soft.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void beforeApi(JoinPoint joinPoint) throws Throwable {
        log.info("====================== before ======================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void AfterApi(JoinPoint joinPoint) throws Throwable {
        log.info("====================== After ======================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void AfterReturningApi(JoinPoint joinPoint) throws Throwable {
        log.info("====================== AfterReturning ======================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());
    }

    @Around("execution(* kr.soft.study.api.StudyController.*(..))")
    public Object AroundApi(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("====================== Start ======================");
        log.info("type-name: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName: {}", joinPoint.getSignature().getName());

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("====================== End ======================");
        log.info("class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("method: {}", joinPoint.getSignature().getName());
        log.info("time: {}", (end - start));

        return result;
    }
}
