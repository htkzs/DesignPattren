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
```java
package com.designpattren;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        //创建数据库连接
        IDataBaseUtils mysqlDataUtils = new mysqlDataUtils();
        connection connection = mysqlDataUtils.getConnection();
        connection.connect();
        command command = mysqlDataUtils.getCommand();
        command.command();
    }
}
/*
实例 背景创建一个数据库连接的中间程序工具
变化 mysql oracle
    connection command 相同的部分
 */

interface connection {
    void connect();
}
class mysqlConnection implements connection{

    @Override
    public void connect() {
        System.out.println("create a mysql connection");
    }
}
interface command{
    void command();
}
class mysqlCtl implements command{

    @Override
    public void command() {
        System.out.println("send a mysql command");
    }
}
interface IDataBaseUtils{
    connection getConnection();
    command getCommand();
}

class mysqlDataUtils implements IDataBaseUtils{

    @Override
    public connection getConnection() {
        return new mysqlConnection();
    }

    @Override
    public command getCommand() {
        return new mysqlCtl();
    }
}
```

>具体应用 connection接口就是用了这种抽象工厂模式。