package kms.project.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogTraceAspect {
    private ThreadLocalLogTrace logTrace;

    public LogTraceAspect(ThreadLocalLogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Pointcut("execution(* kms.project.controller.*.*(..))")
    private void controller(){};

    @Pointcut("execution(* kms.project.service..*.*(..))")
    private void service(){};

    @Pointcut("execution(* kms.project.repository..*.*(..))")
    private void repository(){};
/*
    @Pointcut("execution( * kms.project.aop.*.*(..))")
    private void aop(){};*/

    @Around("@annotation(kms.project.aop.Trace)")
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        TraceStatus status = null;
        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);
            //로직 호출
//            Object result = method.invoke(target, args);
            Object result = joinPoint.proceed();
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e );
            throw e;
        }

    }
}
