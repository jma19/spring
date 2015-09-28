package com.mj.spring.aop.api.inter.method;


import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

public interface GrantParentInterfaceMethdTagedGreeting {

    @AOPLog4jAnnotation
    void sayHelloFromGrantParent();

    void sayGoodByeFromGrantParent();
}
