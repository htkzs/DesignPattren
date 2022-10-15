package com.designpattren;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
美剧类型不能被反射创建 多线程的安全性是通过 JVM帮我们保证
 */
public enum EnumSingleton {
    INSTANCE;

    private static final long serialVersionUID = 43L;
    public void print(){
        System.out.println(this.hashCode());
    }
}
class EnumSingletonTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        /* 通过反射创建实例
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance = declaredConstructor.newInstance("INSTANCE", 0);
         */
        /*
        通过反序列化创建实例
         */
        EnumSingleton instance = EnumSingleton.INSTANCE;
        /* 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enumSingleton"));
        oos.writeObject(instance);
        oos.close();
         */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enumSingleton"));
        Object o = ois.readObject();
        System.out.println(o == instance);
        /* 反序列化

        */
    }
    /*
    运行结果
    true
     */
}
