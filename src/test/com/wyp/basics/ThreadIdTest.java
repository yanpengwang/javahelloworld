package com.wyp.basics;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

public class ThreadIdTest {

    @Test
    public void get() throws InterruptedException{
        ThreadId tid = new ThreadId();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            es.execute(tid);
        }
        es.shutdown();
        while(!es.isTerminated()){
            Thread.sleep(100);
        }
    }
}