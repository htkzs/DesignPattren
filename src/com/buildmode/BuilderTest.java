package com.buildmode;
/*
建造者模式
 */
public class BuilderTest {
    public static void main(String[] args) {
        DefaultCreateProductBuilder builder = new DefaultCreateProductBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("productName", "companyName", "part1", "part2", "part3", "part4");
        SpecialCreateProductBuilder specialCreateProductBuilder = new SpecialCreateProductBuilder();
        Director director1 = new Director(specialCreateProductBuilder);
        Product product1 = director1.makeProduct("productName", "companyName", "part1", "part2", "part3", "part4");
        System.out.println(product1);
        System.out.println(product);

    }
}
interface productBuilder{
    void createProductName(String productName);
    void createCompanyName(String companyName);
    void createPart1(String part1);
    void createPart2(String part2);
    void createPart3(String part3);
    void createPart4(String part4);
    Product build();
}
class DefaultCreateProductBuilder implements productBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void createProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void createCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void createPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void createPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void createPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public void createPart4(String part4) {
        this.part4 = part4;
    }
    @Override
    public Product build(){
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}
/*
定义另一个建造者 按照该建造者的建造逻辑进行建造
 */
class SpecialCreateProductBuilder implements productBuilder{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    @Override
    public void createProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void createCompanyName(String companyName) {
         this.companyName = companyName;
    }

    @Override
    public void createPart1(String part1) {
         this.part1 = part1;
    }

    @Override
    public void createPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void createPart3(String part3) {
         this.part3 = part3;
    }

    @Override
    public void createPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3,this.part4);
    }
}
class Director{
    private productBuilder builder;

    public Director(productBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4){
        //控制创建的顺序
        builder.createProductName(productName);
        builder.createCompanyName(companyName);
        builder.createPart1(part1);
        builder.createPart2(part2);
        builder.createPart3(part3);
        builder.createPart4(part4);
        return builder.build();
    }
}


class Product{
    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }
}
