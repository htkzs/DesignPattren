package com.exception;

public class application {
    //throws 可以单独使用 throws 是方法抛出一个异常；
    public void execute() throws Exception{

    }

    public void calculate(int i){
        try{
            int j = i / 0;
            //throw要么和try-catch-finally语句配套使用
            throw new Exception();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
