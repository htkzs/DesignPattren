package com.designpattren;
/*
饿汉式单例 ：类加载的初始化阶段就完成了实例的初始化。本质上就是借助于jvm类加载机制，保证实例的唯一性。
类加载过程:
1，加载二进制数据到内存中，生成对应的Class数据结构，
2，连接: a.验证，b.准备(给类的静态成员变量赋默认值)，c.解析
3，初始化:给类的静态变量赋初值

只有在真正使用对应的类时，才会触发初始化如（当前类是启动类即main函数所在类，直接进行new操作，访问静态属性、访问静态方法，
用反射访问类，初始化一个类的子类等.)
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance == instance1);
    }
}
class HungrySingleton{
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
