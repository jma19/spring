package com.mj.spring.aop.api.mix.method;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */
public abstract class AbstractParent implements InterfaceGrandParent{
    @AOPLog4jAnnotation
    protected abstract void sayHelloFromParent();
}
