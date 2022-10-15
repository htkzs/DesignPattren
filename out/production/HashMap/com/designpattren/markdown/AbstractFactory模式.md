>抽象工厂模式
>工厂模式的基础架构
```java
package com.designpattren;

public class AbstractFactoryTest {
    public static void main(String[] args) {

    }
}
/*
实例 背景创建一个数据库连接的中间件
变化 mysql oracle
    connection command 相同的部分
 */

interface connection {
    void connect();
}

interface command{
    void command();
}
interface IDataBaseUtils{
    connection getConnection();
    command getCommand();
}
```
>具体产品的实现
