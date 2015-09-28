package com.mj.spring.aop.impl;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 15/9/28.
 */
@Service
@AOPLog4jAnnotation
public class ClassTagedGreeting {

    public void sayHello() {
        System.out.println(this.getClass().getName() + " sayHello method is executed");
    }

    public void sayGoodBye() {
        System.out.println(this.getClass().getName() + " sayGoodBye method is executed");
    }
}
