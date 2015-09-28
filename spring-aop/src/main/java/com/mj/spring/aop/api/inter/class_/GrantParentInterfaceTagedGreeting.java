package com.mj.spring.aop.api.inter.class_;


import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

@AOPLog4jAnnotation
public interface GrantParentInterfaceTagedGreeting {

    void sayHelloFromGrantParent();

    void sayGoodByeFromGrantParent();
}
