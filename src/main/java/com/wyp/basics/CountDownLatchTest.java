package com.wyp.basics;

import java.util.concurrent.CountDownLatch;
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        Runnable ra = () -> {
                try {
                    System.out.println("child thread "+Thread.currentThread().getName()+" is running");
                    Thread.sleep(3000);
                    System.out.println("chile thread "+Thread.currentThread().getName()+" is finished");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

        new Thread(ra).start();
        new Thread(ra).start();

        try {
            System.out.println("waiting 2 threads ...");
            latch.await();
            System.out.println("2 threads finished");
            System.out.println("continue main thread");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}