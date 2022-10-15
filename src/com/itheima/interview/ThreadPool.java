package com.itheima.interview;

import java.util.concurrent.*;
/*
当调用线程池execute() 方法添加一个任务时，线程池会做如下判断：

1、如果有空闲线程，则直接执行该任务；
2、如果没有空闲线程，且当前运行的线程数少于corePoolSize，则创建新的线程执行该任务；
3、如果没有空闲线程，且当前的线程数等于corePoolSize，同时阻塞队列未满，则将任务入队列，而不添加新的线程；
4、如果没有空闲线程，且阻塞队列已满，同时池中的线程数小于maximumPoolSize ，则创建新的线程执行任务；
5、如果没有空闲线程，且阻塞队列已满，同时池中的线程数等于maximumPoolSize ，则根据构造函数中的 handler 指定的策略来拒绝新的任务。
 */
public class ThreadPool {

    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,8,5000, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {


    }
}
