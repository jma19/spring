package com.mj.spring.aop.aspect;

import com.google.common.collect.Lists;
import com.mj.spring.aop.api.inter.class_.ParentInterfaceTagedGreeting;
import com.mj.spring.aop.impl.CustomeExistException;
import com.mj.spring.aop.impl.inter.ChildInterTagedGreeting;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by majun on 15/9/24.
 */
@Component
@Aspect
public class APIProxyTemp{

    private final static Log LOGGER = LogFactory.getLog(APIProxy.class);

    //切面应用范围是在com.mj.spring.aop.api下面所有的接口函数
    @Around("execution(* com.mj.spring.aop..*.*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String signatureName = joinPoint.getSignature().getName();
        Class<? extends Object> invokeClass = joinPoint.getTarget().getClass();
        if (isTagged(invokeClass, signatureName)) {
            LOGGER.info(signatureName + " is tagged");
            joinPoint.proceed();
            return;
        }
        joinPoint.proceed();

    }

    //扫描父类是否被打上标签,或者父类中的这个方法是否被打伤标签
    private boolean isTagged(Class invokeClass, String signatureName) {
        if (isTaggedInInterfaceOf(invokeClass, signatureName)) {
            return true;
        }
        if (!invokeClass.equals(Object.class)) {
            return isTaggedInClassOf(invokeClass, signatureName) ? true :
                    isTagged(invokeClass.getSuperclass(), signatureName);
        }
        return false;
    }

    //扫描当前类的接口
    private boolean isTaggedInInterfaceOf(Class invokeClass, String signatureName) {
        Class[] interfaces = invokeClass.getInterfaces();
        for (Class cas : interfaces) {
            return isTaggedInClassOf(cas, signatureName) ? true :
                    isTaggedInInterfaceOf(cas, signatureName);
        }
        return false;
    }

    //方法名为signatureName的方法tagged有两种情况:方法本身被taged或者方法所在的类被taged
    private boolean isTaggedInClassOf(Class cas, String signatureName) {
        return Lists.newArrayList(cas.getDeclaredMethods())
                .stream().anyMatch(method ->
                        isMethodWithName(method, signatureName) && isMethodTagged(method)
                                || method.getName().equals(signatureName) && isClassTagged(cas));
    }

    private boolean isClassTagged(Class invokeClass) {
        return invokeClass.getAnnotation(AOPLog4jAnnotation.class) != null;
    }

    private boolean isMethodTagged(Method method) {
        return method.getAnnotation(AOPLog4jAnnotation.class) != null;
    }

    private boolean isMethodWithName(Method method, String name) {
        return method.getName().equals(name);
    }
}
