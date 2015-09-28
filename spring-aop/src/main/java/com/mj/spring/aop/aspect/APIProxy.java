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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by majun on 15/9/24.
 */
//@Aspect
public class APIProxy {

    private final static Log LOGGER = LogFactory.getLog(APIProxy.class);

    //切面应用范围是在com.mj.spring.aop.api下面所有的接口函数
    @Around("execution(* com.mj.spring.aop..*.*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //和方法的名字一致
        String signatureName = joinPoint.getSignature().getName();
        //获取类名
        Class<? extends Object> invokeClass = joinPoint.getTarget().getClass();

        //如果当前方法所在类被打上标签,那么当前方法是一个AOP切面点
        if (isCurrentClassTaged(invokeClass)) {
            LOGGER.info(joinPoint.getSignature() + " is tagged because the current class is taged");
            try {
                joinPoint.proceed();
            } finally {
                LOGGER.info("process other log logic");
                return;
            }
        }

        if (isCurrentMethodInClassTaged(invokeClass, signatureName)) {
            //如果当前方法所在类被打上标签,那么当前方法是一个AOP切面点
            LOGGER.info(joinPoint.getSignature() + " is tagged because the current methodßß is taged");
            try {
                joinPoint.proceed();
            } finally {
                LOGGER.info("process other log logic");
                return;
            }
        }

        //调用父类的方法,并且父类或父类方法被打上标签
        if (isCurrentMethodInParentAndTaged(invokeClass, signatureName)) {
            System.out.println(signatureName + " is taged because this method extend from parent class with tag");
            joinPoint.proceed();
            return;
        }
        //仅仅执行method就好
        joinPoint.proceed();


    }

    //扫描当前类的接口
    private boolean isCurrentMethodInInterfaceAndTagd(Class invokeClass, String signatureName) {
        Class[] interfaces = invokeClass.getInterfaces();
        if (interfaces.length == 0) {
            return false;
        }
        else {
            for (Class cas : interfaces) {
                System.out.println(cas.getName());
                Method[] methods = cas.getDeclaredMethods();
                for (Method method : methods) {
                    if (isCurrentMethodTaged(method, signatureName) ||
                            method.getName().equals(signatureName) && isCurrentClassTaged(cas)) {
                        return true;
                    }
                }
                return isCurrentMethodInInterfaceAndTagd(cas, signatureName);
            }

        }
        return false;
    }

    //扫描父类是否被打上标签,或者父类中的这个方法是否被打伤标签
    private boolean isCurrentMethodInParentAndTaged(Class invokeClass, String signatureName) {

        if (isCurrentMethodInInterfaceAndTagd(invokeClass, signatureName)) {
            return true;
        }

        LOGGER.info("isCurrentMethodInParentAndTaged" + invokeClass.getName());
        if (invokeClass.equals(Object.class)) {
            return false;
        } else {
            Method[] methods = invokeClass.getDeclaredMethods();
            for (Method method : methods) {
                if (isCurrentMethodTaged(method, signatureName) ||method.getName().equals(signatureName) && isCurrentClassTaged(invokeClass))
                {
                    return true;
                }
            }
            return isCurrentMethodInParentAndTaged(invokeClass.getSuperclass(), signatureName);
        }
    }






    //判断:方法名为signatureName在类invokeClass是否被taged
    private boolean isCurrentMethodInClassTaged(Class invokeClass, String signatureName) {
        Method methods[] = invokeClass.getDeclaredMethods();
        for (Method method : methods) {
            if (isCurrentMethodTaged(method, signatureName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCurrentClassTaged(Class invokeClass) {
        return invokeClass.getAnnotation(AOPLog4jAnnotation.class) != null;
    }

    private boolean isCurrentMethodTaged(Method method, String signatureName) {
        return method.getName().equals(signatureName) &&
                method.getAnnotation(AOPLog4jAnnotation.class) != null;

    }

    private void aroundAdvice1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        long start = System.currentTimeMillis();
        try {
            proceedingJoinPoint.proceed();
        } catch (Exception e) {
            if (e instanceof CustomeExistException) {
                LOGGER.warn(e.getMessage());
            }
            LOGGER.error(String.format("Method:%s call failed  parameter input:%s",
                    signature,
                    args), e);
        } finally {
            LOGGER.info(String.format("method:%s  parameter input:%s carry_out_time:%s ms",
                    signature, args, System.currentTimeMillis() - start));
        }
    }
}
