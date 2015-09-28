package com.mj.spring.aop.api.abstr.class_;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */

@AOPLog4jAnnotation
public abstract class ParentClassTagedGreeting extends GrantParentClassTagedGreeting {

    protected abstract void sayHelloFromParent();

    protected abstract void sayGoodByeFromParent();
}
