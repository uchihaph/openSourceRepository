package com.open.source.platform.log;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInvocation;
//import org.apache.dubbo.rpc.Invocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: qiaojiange
 * @create: 2021/10/02
 * @Description Aop 工具类
 */
public class AopUtils {

    /**
     * 冒号
     */
    private static final String COLON = ":";
    /**
     * 逗号
     */
    private static final String COMMA = ",";

    /**
     * 获取切入点类名（不含包名）
     */
    public static String getSimpleClassName(ProceedingJoinPoint point) {
        return point.getTarget().getClass().getSimpleName();
    }

    /**
     * 获取类的 class文件
     * @param point 切点
     */
    public static Class getClazz(ProceedingJoinPoint point) {
        return point.getTarget().getClass();
    }

    /**
     * 获取切入点方法名
     */
    public static String getMethodName(ProceedingJoinPoint point) {
        return point.getSignature().getName();
    }

    /**
     * 获取参数字符串
     */
    public static String getArgsString(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        if(Objects.nonNull(args)){
            return JSON.toJSONString(args);
        }
        return null;

//        Map<String, Object> paramMap = Maps.newHashMap();
//        if (!ArrayUtils.isEmpty(args)) {
//            String[] paramNames = getTargetMethodSignature(point).getParameterNames();
//            for (int i = 0; i < args.length; i++) {
//                Object arg = args[i];
//                paramMap.put(paramNames[i], arg);
//            }
//        }
//        return paramMap.toString();
    }

    public static String getArgsString(MethodInvocation methodInvocation){
        Object[] args = methodInvocation.getArguments();
        Map<String, Object> paramMap = new HashMap<>();
        if (Objects.nonNull(args)) {
            Parameter[] paramNames = methodInvocation.getMethod().getParameters();
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                paramMap.put(paramNames[i].getName(), arg);
            }
        }
        return paramMap.toString();
    }

    /**
     * 获取目标方法给定注解
     */
    public static <T extends Annotation> T getTargetMethodAnnotation(ProceedingJoinPoint point,
                                                                     Class<T> annotationClass) {
        return getTargetMethodSignature(point).getMethod().getAnnotation(annotationClass);
    }

    /**
     * 获取方法签名
     */
    private static MethodSignature getTargetMethodSignature(ProceedingJoinPoint point) {
        return (MethodSignature)point.getSignature();
    }

    /**
     * 获取目标方法d的返回值类型
     */
    public static Class getTargetMethodReturnType(ProceedingJoinPoint point) {
        return getTargetMethodSignature(point).getReturnType();
    }

//    /**
//     * 生成参数打印字符串
//     */
//    @SuppressWarnings("rawtypes")
//    public static String generateParameterPrintString(Invocation invocation) {
//        StringBuilder printString = new StringBuilder("[");
//        Class[] parameterTypes = invocation.getParameterTypes();
//        if (ArrayUtils.isNotEmpty(parameterTypes)) {
//            Object[] parameters = invocation.getArguments();
//            for (int i = 0; i < parameterTypes.length; i++) {
//                Object parameter = parameters[i];
//                printString.append(parameterTypes[i].getSimpleName())
//                        .append(COLON).append(parameter).append(COMMA);
//            }
//            printString.deleteCharAt(printString.length() - 1);
//        }
//        printString.append("]");
//        return printString.toString();
//    }


}