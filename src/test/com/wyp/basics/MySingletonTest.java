package com.wyp.basics;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySingletonTest {

    @Test
    public void getInstance() {
        MySingleton.getInstance().doSomething();
    }
}