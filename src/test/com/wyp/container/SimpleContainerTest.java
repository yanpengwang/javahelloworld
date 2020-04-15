package com.wyp.container;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleContainerTest {

    @Test
    public void getInstance() {
        ServiceA a1 = SimpleContainer.getInstance(ServiceA.class);
        a1.callB();
        ServiceA a2 = SimpleContainer.getInstance(ServiceA.class);
        a2.callB();
    }
}