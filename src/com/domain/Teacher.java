package com.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author roy.zhuo
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {


    /*
    主键生成，默认生成策略是increment

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    当用name做联合主键的时候 由于字符串长度是255 大于mysql主键长度，
    所以要限制它的长度，不然不会生成表

    @Id

    @Column(length = 10) */
/* 如果主键是字符串，就不能用jpa的主键生成策略，用hibernate的主键生成器 */

    @Id
//    @GeneratedValue(generator = "tid")    //generator主键生成器
//    @GenericGenerator(name = "tid", strategy = "assigned")
//    @Column(length = 10)
//    private String tid;
    @EmbeddedId //注解主键属性，复合主键
    private TeacherId teacherId;
    private String name;
    @Embedded       //属性级别的注解，表示该属性的类是个嵌入类，同时嵌入类必须表识是embeddale
    private Address address;
    private Date createTime;

    public Teacher() {
    }
    public Teacher(String name, Address address, Date createTime) {
        this.name = name;
        this.address = address;
        this.createTime = createTime;
    }

    public TeacherId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherId teacherId) {
        this.teacherId = teacherId;
    }

//    public String getTid() {
//        return tid;
//    }
//
//    public void setTid(String tid) {
//        this.tid = tid;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
