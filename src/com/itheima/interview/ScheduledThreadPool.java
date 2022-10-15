package com.itheima.interview;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
执行定时任务的线程(newScheduledThreadPool)
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        System.out.println("添加任务的时间：" + LocalDateTime.now());
        //延迟执行（一次）
        //ses.schedule(() -> System.out.println("执行子任务：" + LocalDateTime.now()), 3, TimeUnit.SECONDS);
        /*
        添加任务的时间：2022-10-14T10:49:39.122
        执行子任务：2022-10-14T10:49:42.147
         */
        //固定频率执行
        /*
        scheduleAtFixedRate方法参数的说明：
        Runnable command,long initialDelay,long period,TimeUnit unit
        command:执行的runnable
        initialDelay：第一次执行的延迟时间
        period: 固定频率的执行时间设置
        unit：时间单位
         */
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行任务：" + LocalDateTime.now());
            }
        },4,2,TimeUnit.SECONDS);
        /*
        添加任务的时间：2022-10-14T11:00:01.704
            pool-1-thread-1执行任务：2022-10-14T11:00:05.715
            pool-1-thread-1执行任务：2022-10-14T11:00:07.712
            pool-1-thread-2执行任务：2022-10-14T11:00:09.706
            pool-1-thread-2执行任务：2022-10-14T11:00:11.709
         */

        //如果在定义定时任务中设置了内部睡眠时间，比如
        /* 哪个值大以哪个值作为定时任务的执行周期
        ses.scheduleAtFixedRate((Runnable) () -> {
            System.out.println("执行任务： " + LocalDateTime.now());
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },2,4, TimeUnit.SECONDS);
        */

    }

}
