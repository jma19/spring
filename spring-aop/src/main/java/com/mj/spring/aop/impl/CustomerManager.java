package com.mj.spring.aop.impl;

import com.mj.spring.aop.api.CustomerManagerService;
import com.mj.spring.aop.aspect.AOPLog4jAnnotation;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerManagerService {

    @Override
    public void addCustomer(String customer) throws CustomeExistException {
        System.out.println("method addCustomer(String customer) is excuted");
    }

    @Override
    public void delete(String name) {
        System.out.println("method delete(String customer) is excuted");
    }
    @AOPLog4jAnnotation
    public void showFunction(){
        System.out.println("My job is to manage the customer");
    }
}