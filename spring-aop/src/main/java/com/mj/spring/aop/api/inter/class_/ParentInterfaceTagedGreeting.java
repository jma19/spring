package com.mj.spring.aop.api.inter.class_;

import com.mj.spring.aop.aspect.AOPLog4jAnnotation;

/**
 * Created by majun on 15/9/28.
 */
@AOPLog4jAnnotation
public interface ParentInterfaceTagedGreeting extends GrantParentInterfaceTagedGreeting{
    void sayHelloFromParent();

    void sayGoodByeFromParent();

}
