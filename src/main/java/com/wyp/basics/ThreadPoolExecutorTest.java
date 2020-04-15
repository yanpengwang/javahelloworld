package com.wyp.basics;



import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


@Slf4j
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(20, 30, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), namedThreadFactory);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}
