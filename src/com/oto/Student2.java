package com.oto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author roy.zhuo
 */
/*双向外健关联*/
@Entity
@Table(name = "student2")
public class Student2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String name;
    private String major;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", unique = true) //添加外健
    private CarId2 carId2;
    private Date createTime;

    public Student2(String name, String major, CarId2 carId2, Date createTime) {
        this.name = name;
        this.major = major;
        this.carId2 = carId2;
        this.createTime = createTime;
    }

    public Student2() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public CarId2 getCarId2() {
        return carId2;
    }

    public void setCarId2(CarId2 carId2) {
        this.carId2 = carId2;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
