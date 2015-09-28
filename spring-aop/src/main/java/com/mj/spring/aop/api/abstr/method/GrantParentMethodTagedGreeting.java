package com.mj.spring.aop.api.abstr.method;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */
public abstract class GrantParentMethodTagedGreeting {
    @AOPLog4jAnnotation
    protected abstract void sayHelloFromGrantParent();

    protected abstract void sayGoodByeFromGrantParent();

}