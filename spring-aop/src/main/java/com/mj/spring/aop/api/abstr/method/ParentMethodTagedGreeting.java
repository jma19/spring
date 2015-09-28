package com.mj.spring.aop.api.abstr.method;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */
public abstract class ParentMethodTagedGreeting extends GrantParentMethodTagedGreeting {

    @AOPLog4jAnnotation
    protected abstract void sayHelloFromParent();

    protected abstract void sayGoodByeFromParent();

    public void sayCommon(){

    }
}
