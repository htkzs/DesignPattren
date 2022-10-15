package com.designpattren;
/*
懒汉式单例 在需要使用的时候再创建对象
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(LazySingleton.getInstance());
        },"THREAD1").start();

        new Thread(()->{
            System.out.println(LazySingleton.getInstance());
        },"THREAD2").start();
    }

}
/*
单线程下是安全的 多线程不安全
 */
class LazySingleton{
    //使用静态修饰 再类加载后 就可以获取到该变量的值
    private volatile static LazySingleton lazySingleton;
    //定义一个private的无参构造，只允许通过本类调用 创建对象 阻止外界通过new的方式创建对象
    private LazySingleton() {
    }
    /*
    使用synchronized同步 保证多线程下单例安全性 DCL 增加一次检查 纯粹为了提高效率
     */
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                    return lazySingleton;
                }
            }
        }

        return lazySingleton;
    }
}

/*
运行结果
com.designpattren.LazySingleton@72d6db17
com.designpattren.LazySingleton@72d6db17
 */
