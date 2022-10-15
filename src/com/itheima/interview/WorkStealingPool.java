package com.itheima.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
根据当前CPU⽣成线程池(newWorkStealingPool)
 */
public class WorkStealingPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                System.out.println("线程名：" + Thread.currentThread().getName());
            });
            while (!service.isTerminated()) {
            }
        }
    }
}
