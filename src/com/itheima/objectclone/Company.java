package com.itheima.objectclone;

public class Company implements Cloneable{

    private User user;

    private String address;

    public Company(User user, String address) {
        super();
        this.user = user;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /*
    浅拷贝
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    /*
    深拷贝
    1、递归调用clone()方法 对其中的引用类型再次调用clone方法
    所以使用深克隆就可以解决上述 Company 对象克隆过后两个 user 对象的引用地址相同的问题。我们修改一下 Company 类的 clone() 函数。
    protected Object clone() throws CloneNotSupportedException {
        Company company = (Company) super.clone();
        company.user = (User) company.getUser().clone();
        return company;
    }
     */
    @Override
    public boolean equals(Object obj) {
        Company company = (Company) obj;
        if (user.equals(company.getUser()) && address.equals(company.address)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        Company companyOne, companyTwo, companyThree;
        companyOne = new Company(new User("username", "password"), "上海市");
        companyTwo = companyOne;
        companyThree = (Company) companyOne.clone();

        System.out.println(companyTwo==companyOne);                //true
        System.out.println(companyTwo.equals(companyOne));        //true

        System.out.println(companyThree==companyOne);            //false
        System.out.println(companyThree.equals(companyOne));    //true
        /*
        companyThree 与 companyOne 中的 User 是同一个对象！也就是说 companyThree 只是克隆了 companyOne 的基本数据类型的数据，
        而对于引用类型的数据没有进行深度的克隆。也就是俗称的浅克隆。
        浅克隆：顾名思义，就是很表层的克隆，只克隆对象自身的引用地址；

        深克隆：也称“N层克隆”，克隆对象自身以及对象所包含的引用类型对象的引用地址。

        这里需要注意的是，对于基本数据类型（primitive）和使用常量池方式创建的String类型，都会针对原值克隆，所以不存在引用地址一说。当然不包括他们对应的包装类。

         */
        System.out.println(companyThree.getUser()==companyOne.getUser());            //true ? 这里为什么不是false呢
        System.out.println(companyThree.getUser().equals(companyOne.getUser()));    //true
        /*
        再运行测试代码，就能得到 companyThree.getUser()==companyOne.getUser() 为 false 的结果了。从实现过程来说，递归克隆存在克隆过程多且复杂的缺点。
         */
    }
}

