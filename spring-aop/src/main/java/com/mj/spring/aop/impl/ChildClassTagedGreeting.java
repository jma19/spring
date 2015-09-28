package com.mj.spring.aop.impl;

import com.mj.spring.aop.api.abstr.class_.ParentClassTagedGreeting;
import com.mj.spring.aop.aspect.AOPLog4jAnnotation;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 15/9/28.
 */
@Service
public class ChildClassTagedGreeting extends ParentClassTagedGreeting{

    @Override
    protected void sayGoodByeFromParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromParent method is executed");
    }

    @Override
    protected void sayHelloFromParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromParent method is executed");

    }

    @Override
    protected void sayHelloFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromGrantParent method is executed");

    }

    @Override
    protected void sayGoodByeFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromGrantParent method is executed");

    }
    public static void main(String[]args){
        Class<? super ChildClassTagedGreeting> parentClass= ChildClassTagedGreeting.class.getSuperclass();
        System.out.println(parentClass.getDeclaredAnnotation(AOPLog4jAnnotation.class));
    }
}
