package com.mj.spring.aop.impl;

import com.mj.spring.aop.api.abstr.method.ParentMethodTagedGreeting;
import org.springframework.stereotype.Service;

/**
 * Created by majun on 15/9/28.
 */
@Service
public class ChildMethodTagedGreeting extends ParentMethodTagedGreeting{

    @Override
    protected void sayHelloFromParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromParent method is executed");
    }

    @Override
    protected void sayGoodByeFromParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromParent method is executed");
    }

    @Override
    protected void sayHelloFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayHelloFromGrantParent method is executed");
    }

    @Override
    protected void sayGoodByeFromGrantParent() {
        System.out.println(this.getClass().getName() + " sayGoodByeFromGrantParent method is executed");

    }
//
//    public static void main(String[]args){
//        Class<? super ChildMethodTagedGreeting> superclass = ChildMethodTagedGreeting.class.getSuperclass();
//
//
//        Method[] declaredMethods1 = ChildMethodTagedGreeting.class.getDeclaredMethods();
//        for(Method method:declaredMethods1){
//            System.out.println(method.getName());
//        }
//        System.out.println("=======================");
//        System.out.println(superclass.getName());
//        Method[] methods = superclass.getMethods();
//        for(Method method:methods){
//            System.out.println(method.getName());
//        }
//
//        System.out.println("========================");
//        Method[] declaredMethods = superclass.getDeclaredMethods();
//        for(Method method:declaredMethods){
//            System.out.println(method.getName());
//        }
 //   }
}
