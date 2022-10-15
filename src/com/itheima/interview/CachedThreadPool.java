package com.itheima.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            es.submit(() -> System.out.println("i : " + finalI + "|线程名称：" + Thread.currentThread().getName()));
        }
    }
    /*
    输出结果为
    i : 2|线程名称：pool-1-thread-3
    i : 1|线程名称：pool-1-thread-2
    i : 0|线程名称：pool-1-thread-1
    优点：线程池会根据任务数量创建线程池，并且在一定时间内可以重复使用这些线程，产生相应的线程池。
    缺点：适用于短时间有大量任务的场景，它的缺点是可能会占用很多的资源。

     */
}
