package com.company;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
	// HashMap = 数组+链表+红黑树
        HashMap<String,String> hashMap = new HashMap<String,String>(10);
        hashMap.put("user","zhangsan");
        //当在一个HashMap中插入一个已经包含的key值 返回的v就是被覆盖的原始值
        String v = hashMap.put("user","lisi");
        //向HashMap中存入一个key=null 将莫人放在数组下标为0的那个数组对应的链表上
        hashMap.put(null,"wangwu");
        String user = hashMap.get("user");
        System.out.println(user);

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("name","zhangsan");
        System.out.println(v);

    }
}
