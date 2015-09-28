package com.mj.spring.aop.impl.mix;

import com.mj.spring.aop.api.mix.method.AbstractParent;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 15/9/28.
 */
@Service("childMixMethodTagedGreeting")
public class ChildMixMethodTagedGreeting extends AbstractParent {
    //aop
    public void sayHelloFromInterfaceGrandParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromInterfaceGrandParent method is executed");
    }

    @Override
    protected void sayHelloFromParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromParent method is executed");

    }




}
