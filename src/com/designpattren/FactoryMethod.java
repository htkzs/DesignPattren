package com.designpattren;
/*
模式定义:
定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使得一个类的实例化延迟到子类
实现不同产品的切换
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application app = new ConCreateProductA();
        Product object = (Product) app.getObject();
        object.method1();

    }
}

/*
  引入一个简单工厂用于帮助我们创建对象
 */
class simpleFactory {
    public static Product createProduct(String type){
        if(type.equals("0")){
            return new ProductA();
        }else if(type.equals("1")){
            return new ProductB();
        }
        return null;
    }
}
/*
引入接口 实现多态
 */
interface Product{
    void method1();
}
class ProductB implements Product {
    //假设方法method1()这段代码是永不改变的逻辑
    public void method1(){

        System.out.println("ProductB.method execute.");
    }

}
class ProductA implements Product {
    //假设方法method1()这段代码是永不改变的逻辑
    public void method1(){

        System.out.println("ProductA.method execute.");
    }

}
/*
定义抽象方法 实现将创建实例的过程推迟到具体的实现类中
 */
abstract class Application{
    /*
    创建product的这段代码可以认为是不变的逻辑
     */
    abstract Product createProduct();

    public Product getObject(){
        /*
        这里代表一些业务逻辑 忽略
         */
        Product product = createProduct();
        return product;

    }

}
class ConCreateProductA extends Application{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}