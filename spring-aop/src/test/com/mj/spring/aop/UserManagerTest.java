package com.mj.spring.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by majun on 15/9/23.
 */
public class UserManagerTest {
    private ApplicationContext applicationContext=null;
    @Before
    public void setUp() throws Exception {
        applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void shoud_get_user_maneger_bean() throws Exception {
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        assertThat(userManager!=null,is(true));
    }
    @Test
    public void should_apply_before_advice_and_after_advice_and_after_advice_with_arg() throws Exception{
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.addUser("Jun.Ma");
    }
    @Test
    public void should_apply_before_advice_and_after_advice() throws Exception{
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.deleteUser();
    }

    @Test
    public void should_apply_before_advice_and_after_advice_and_after_throwing_advice() throws Exception{
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.editUser();
    }

    @Test
    public void should_apply_before_advice_and_after_advice_after_return_advice() throws Exception{
        UserManager userManager = (UserManager) applicationContext.getBean("userManager");
        userManager.getUser();
    }
}