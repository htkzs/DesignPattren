package com.designpattren;
/*
应用场景:
程序需要处理不同系列的相关产品，但是您不希望它依赖于这些产品的具体类时，可以使用抽象工厂
优点:
1.可以确信你从工厂得到的产品彼此是兼容的。2.可以避免具体产品和客户端代码之间的紧密耦合。3.符合单一职责原则
4.符合开闭原则
 */
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
实例 背景创建一个数据库连接的中间件
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
/*
抽象工厂模式：特征 一组抽象组合
 */
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