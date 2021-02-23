package com.example.java_tools;

public class User {

    private String foo = "123123";
    private String name;
    private Integer sex;
    private Boolean urban;
    private Double balance;
    private Float money;

    public User(String foo, String name, Integer sex, Boolean urban, Double balance, Float money) {
        this.foo = foo;
        this.name = name;
        this.sex = sex;
        this.urban = urban;
        this.balance = balance;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex()     {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getUrban() {
        return urban;
    }

    public void setUrban(Boolean urban) {
        this.urban = urban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}