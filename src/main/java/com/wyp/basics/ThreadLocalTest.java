package com.wyp.basics;

class ThreadLocalDog {
    ThreadLocal<String> threadLocal=new ThreadLocal<String>();
}

class ThreadLocalDogStatic {
    static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocalDog threadLocalDog=new ThreadLocalDog();
        threadLocalDog.threadLocal.set("aaa");
        ThreadLocalDog threadLocalDog1=new ThreadLocalDog();
        System.out.println(threadLocalDog1.threadLocal.get());
        ThreadLocalDogStatic.threadLocal.set("bbb");
        System.out.println(ThreadLocalDogStatic.threadLocal.get());

    }
}
