package com.itheima.objectclone;


public class User implements Cloneable{

    private String username;

    private String password;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Object 类的 clone() 方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //判断两个对象内容是否相等就需要重写equals方法 否则会使用到Object的equals方法 本质是==
    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        if (username.equals(user.username) && password.equals(user.password)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        User userOne, userTwo, userThree;
        userOne = new User("username", "password");
        userTwo = userOne;
        userThree = (User) userOne.clone();

        System.out.println(userTwo==userOne);            //true
        System.out.println(userTwo.equals(userOne));    //true
        //通过 clone() 函数，我们成功地从 userOne 对象中克隆出了一份独立的 userThree 对象
        System.out.println(userThree==userOne);            //false
        System.out.println(userThree.equals(userOne));    //true

    }

}

