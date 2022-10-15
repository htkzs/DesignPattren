package com.itheima.interview;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
scheduleAtFixedRate 是以上⼀次任务的开始时间，作为下次定时任务的参考时间的
scheduleWithFixedDelay 是以上⼀次任务的结束时间，作为下次定时任务的参考时间的。
 */
public class ScheduledThreadPoolScheduleWithFixedDelay {
    public static void main(String[] args) {
        // 创建线程池
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        System.out.println("添加任务时间：" + LocalDateTime.now());
        // 2s之后开始执行定时任务，定时任务每隔4s执行一次
        ses.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + "执行任务：" + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 4, TimeUnit.SECONDS);
    }
    /*
    添加任务时间：2022-10-14T11:08:18.956
        pool-1-thread-1执行任务：2022-10-14T11:08:20.978
        pool-1-thread-1执行任务：2022-10-14T11:08:25.999
        pool-1-thread-2执行任务：2022-10-14T11:08:31.027
        pool-1-thread-2执行任务：2022-10-14T11:08:36.045
     */
}

