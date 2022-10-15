package com.itheima.interview;

import java.util.Random;
import java.util.concurrent.*;

/*
固定数量的线程池(newFixedThreadPool)
execute和submit的区别
execute和submit都属于线程池的方法，execute只能提交Runnable类型的任务
submit既能提交Runnable类型任务也能提交Callable类型任务。
execute()没有返回值
submit有返回值，所以需要返回值的时候必须使用submit

 */
public class FixedThreadPool {
    /**
     * 定义线程池名称或优先级
     */


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /*
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }
        */
        /*
        创建线程工厂
        提供的功能：
        1. 设置（线程池中）线程的命名规则。
        2. 设置线程的优先级。
        3. 设置线程分组。
        4. 设置线程类型（用户线程、守护线程）。
         */
        ThreadFactory threadFactory = r -> {
            // ！！！！！！！一定要注意：要把任务Runnable设置给新创建的线程
            Thread thread = new Thread(r);
            // 设置线程的命名规则
            thread.setName("我的线程：" + r.hashCode());
            // 设置线程的优先级
            thread.setPriority(Thread.MAX_PRIORITY);
            return thread;
        };
        ExecutorService es = Executors.newFixedThreadPool(2, threadFactory);
        // 参数是接口类，所以lambda的()->{}在括号里面，上面的r->{}是直接一个类，并不是作为入参
        Future<Integer> result = es.submit(() -> {
            int num = new Random().nextInt(10);
            System.out.println("线程优先级" + Thread.currentThread().getPriority() + ", 随机数：" + num);
            return num;
        });
        // 打印线程池返回结果
        System.out.println("返回结果：" + result.get());


        /* 简单使用
        ExecutorService es = Executors.newFixedThreadPool(2);
        // 方式1
        Future<String> submit = es.submit(() -> Thread.currentThread().getName());
        System.out.println(submit.get());
        // 方式2
        //es.execute(() -> System.out.println(Thread.currentThread().getName()));
         */
    }
}
