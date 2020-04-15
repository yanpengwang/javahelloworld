package com.wyp.basics;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NormalCountTest {

    @Test
    public void getCount() {
    }
    @Test
    public void testNormalNew() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);


        for (int i = 0; i < 100; i++) {
            es.execute(new NormalCount());
        }
        Thread.sleep(1000);
        es.shutdown();
        while (!es.isTerminated()) {
            Thread.sleep(100);
        }
        Assert.assertEquals(10000,NormalCount.getCount().intValue());
    }
}