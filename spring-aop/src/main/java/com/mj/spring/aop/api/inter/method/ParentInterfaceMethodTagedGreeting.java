package com.mj.spring.aop.api.inter.method;


import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */
public interface ParentInterfaceMethodTagedGreeting extends GrantParentInterfaceMethdTagedGreeting {

    @AOPLog4jAnnotation
    void sayHelloFromParent();

    void sayGoodByeFromParent();

}
