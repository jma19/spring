package com.mj.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/*
定义切面类
 */
@Aspect
public class MyAspect {

    //定义切点, 这个切点的使用范围是: 定义在com.mj.spring.aop包下的所有方法
    @Pointcut("execution(* com.mj.spring.aop.*.*(..))")
    public void aPointcut() {
    }

    //定义Before Advice
    @Before("aPointcut()")
    public void beforeAdvice() {
        System.out.println("before advice is executed!");
    }

    //定义AfterReturning Advice
    @AfterReturning(pointcut = "aPointcut()", returning = "r")
    public void afterReturningAdvice(String r) {
        if (r != null)
            System.out.println("after returning advice is executed! returning String is : " + r);
    }

    //定义After Advice
    @After("aPointcut()")
    public void AfterAdvice() {
        System.out.println("after advice is executed!");
    }

    @After("aPointcut() && args(str)")
    public void AfterAdviceWithArg(String str) {
        System.out.println("after advice with arg is executed!arg is : " + str);
    }

    //定义afterThrowingAdvice Advice
    @AfterThrowing(pointcut = "aPointcut()", throwing = "e")
    public void afterThrowingAdvice(Exception e) {
        System.out.println("after throwing advice is executed!exception msg is : " + e.getMessage());
    }

    //定义around advice
    @Around(value="execution(public String com.mj.spring.aop.UserManager.getUser(..))")
    public void aroundSayHello(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Before !! ");
        joinPoint.proceed();
        System.out.println("Around After !! ");
    }



}
