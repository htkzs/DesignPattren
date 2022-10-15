package com.designpattren;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StaticInnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        /* 反射测试单例
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstructor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);
         */
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        /*序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singletonInstance"));
        oos.writeObject(instance);
        oos.close();
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singletonInstance"));
        Object o = ois.readObject();
        System.out.println(o == instance);


        /*

         */
    }
}
/*
静态内部类创建单例的方式 基于JVM的类加载机制保证单例 和线程安全
 */
class InnerClassSingleton implements Serializable {
    /*
    在序列化和反序列化时可以通过唯一serialVersionUID确定原类信息是否发生改变
     */
    private static final long serialVersionUID = 42L;

    private static class SingletonHolder{
        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        //为防止反射破坏单例 在创建单例的时候 模拟抛出一个运行异常终止执行
        if(SingletonHolder.innerClassSingleton != null){
            throw new RuntimeException("单例不允许创建多个实例");
        }
    }
    //通过访问静态内部类的一个属性时，触发类的实例化实例化
    public static InnerClassSingleton getInstance(){
        return SingletonHolder.innerClassSingleton;
    }
    /*
    JDK的序列化提供了一种替代方案 如果没有添加序列化id的时候 JVM会通过类名称或者字段名称自动生成一个序列化id 当下次再反序列化的时候同样会生成一个序列化id
    通过比对 如果相同就会被创建出来 如果不相等则会报如下错误;
    Exception in thread "main" java.io.InvalidClassException: com.designpattren.InnerClassSingleton; local class incompatible:
     stream classdesc serialVersionUID = 4834929340660068117, local class serialVersionUID = -3345922207085489912
    */
    //如果第一次增加这个方法 类相当于多了一个方法 和序列化前的类已经不是同一个类了 故会报错 解决办法就是增加一个序列化的唯一ID号
    Object readResolve() throws ObjectStreamException{
        return SingletonHolder.innerClassSingleton;
    }

    /*
     返回值为true
     */
}
