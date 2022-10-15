区别一：throw 是语句抛出一个异常；throws 是方法抛出一个异常；
区别二：throws可以单独使用，但throw不能；
区别三：throw要么和try-catch-finally语句配套使用，要么与throws配套使用。但throws可以单独使用，然后再由处理异常的方法捕获。

```java
public class application {
    //throws 可以单独使用 throws 是方法抛出一个异常；
    public void execute() throws Exception {

    }

    public void calculate(int i) {
        try {
            int j = i / 0;
            //throw要么和try-catch-finally语句配套使用 
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

```