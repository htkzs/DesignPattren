package com.itheima.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
runnable 没有返回值，callable 可以拿到有返回值，callable 可以看作是 runnable 的补充。
callable+futureTusk
 */
public class CallableTusk {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world!";
            }
        };
        FutureTask<String> futureTusk = new FutureTask<String>(callable);
        Thread thread = new Thread(futureTusk);
        thread.start();
        //主线程阻塞获取子线程执行的结果
        System.out.println(futureTusk.get());
    }
}
