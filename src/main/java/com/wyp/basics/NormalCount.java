package com.wyp.basics;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;


public class NormalCount implements Runnable {
    @Getter
    //private static volatile int count = 0;
    //private static AtomicInteger count = new AtomicInteger(0);
    private static LongAdder count = new LongAdder();

    @Override
    public void run()  {

        try {
            System.out.println(Thread.currentThread().getName() + " is waiting: " + count);
            for(int j = 0; j< 100; j++) {
                //synchronized(NormalCount.class)
                {
                    //count++;
                    //count.addAndGet(1);
                    count.add(1);
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + count + ", time=" + System.currentTimeMillis());
    }

}
