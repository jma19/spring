package com.mj.spring.aop.impl.inter;

import com.mj.spring.aop.api.inter.class_.ParentInterfaceTagedGreeting;
import com.mj.spring.aop.api.inter.method.ParentInterfaceMethodTagedGreeting;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 15/9/28.
 */
@Service("parentInterfaceTagedGreeting")
public class ChildInterTagedGreeting implements ParentInterfaceTagedGreeting{
    @Override
    public void sayHelloFromParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromParent method is executed");
    }

    @Override
    public void sayGoodByeFromParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromParent method is executed");
    }

    @Override
    public void sayHelloFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromGrantParent method is executed");

    }

    @Override
    public void sayGoodByeFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromGrantParent method is executed");
    }

}
