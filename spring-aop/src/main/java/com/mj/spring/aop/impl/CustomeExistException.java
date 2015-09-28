package com.mj.spring.aop.impl;

/**
 * Created by majun on 15/9/24.
 */
public class CustomeExistException extends Exception {

    public CustomeExistException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
