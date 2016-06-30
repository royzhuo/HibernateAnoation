package com.domain;

import javax.persistence.Embeddable;

/**
 * @author roy.zhuo
 */
/*
地址类
类级别注解
 1.用embeddable表示这个类是潜入类，可以让这个类充当另一个类的属性
 */

@Embeddable
public class Address {

    //邮编
    private String email;
    //名字
    private String address;
    //电话
    private String phone;

    public Address() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
