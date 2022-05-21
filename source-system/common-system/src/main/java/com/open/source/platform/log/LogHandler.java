package com.open.source.platform.log;

import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author hanguo
 * @date 2022/4/27
 * @Description 日志工具类
 */
@Aspect
@Component
@Order(1)
public class LogHandler {


    @Pointcut("@annotation(com.open.source.platform.annotation.LogAspect)")
    private void cutMethod() {
    }

    @Around("cutMethod()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
//        long startTime = System.currentTimeMillis();
//        Log log = Log.getLogger(AopUtils.getClazz(proceedingJoinPoint));
        Object result = null;
//        String argsBody = null;
//        try {
//            argsBody = AopUtils.getArgsString(proceedingJoinPoint);
//            result = proceedingJoinPoint.proceed();
//        } catch (ProcessException e) {
//            log.error(ErrorInfoUtils.buildErrorInfo(argsBody, proceedingJoinPoint, "Process", System.currentTimeMillis() - startTime), e);
//            throw e;
//        } catch (ErrorCodeException e) {
//            log.error(ErrorInfoUtils.buildErrorInfo(argsBody, proceedingJoinPoint, "Process", System.currentTimeMillis() - startTime), e);
//            throw e;
//        } catch (Throwable e) {
//            log.error(ErrorInfoUtils.buildErrorInfo(argsBody, proceedingJoinPoint, "Process", System.currentTimeMillis() - startTime), e);
//            ProcessInvoker processInvoker = AopUtils.getTargetMethodAnnotation(proceedingJoinPoint, ProcessInvoker.class);
//            if (processInvoker != null) {
//                throw new ProcessSystemException(processInvoker.errorCode(), e);
//            }
//        }
//
//        ProcessInvoker processInvoker = AopUtils.getTargetMethodAnnotation(proceedingJoinPoint, ProcessInvoker.class);
//        boolean printLog = processInvoker != null && processInvoker.printLog();
//        if (printLog) {
//            AccessLogBody accessLogBody = result == null ? AccessLogBody.DEFAULT_ACCESS_LOG(argsBody) : convertResult(argsBody, result);
//            log.info(buildAccessLog(proceedingJoinPoint, System.currentTimeMillis() - startTime, accessLogBody));
//        }
//
//
        return result;
    }
}
