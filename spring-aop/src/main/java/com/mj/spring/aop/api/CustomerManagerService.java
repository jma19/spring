package com.mj.spring.aop.api;

import com.mj.spring.aop.impl.CustomeExistException;

/**
 * Created by majun on 15/9/24.
 */


public interface CustomerManagerService extends Deleteable{
    void addCustomer(String customer) throws CustomeExistException;
}
