package com.wyp.basics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class HelloWorldTest {

    HelloWorld hw;
    @Before
    public void setUp() throws Exception {
        hw = new HelloWorld();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void myLog() {
        hw.myLog("This is Log.");
    }

    @Test
    public void testInteger(){
        Integer a = new Integer(123);
        Integer b = new Integer(123);
        //false
        Assert.assertFalse(a==b);
        Integer a2 = 123;
        Integer b2 = 123;
        //true
        Assert.assertTrue(a2==b2);
    }
}