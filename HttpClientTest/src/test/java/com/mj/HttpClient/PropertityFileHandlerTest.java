package com.mj.HttpClient;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by majun on 15/9/15.
 */
public class PropertityFileHandlerTest {
    @Test
    public void should_throw_exception() throws Exception {
        Object apiUrl = PropertityFileHandler.get("123");
        System.out.println(apiUrl);
    }
}