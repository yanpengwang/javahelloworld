package com.wyp.basics;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId implements Runnable{
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(()->nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    @Override
    public void run(){
        System.out.println(get());
    }
}
