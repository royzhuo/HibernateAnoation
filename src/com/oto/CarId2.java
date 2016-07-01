package com.oto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author roy.zhuo
 */
/*双向外健关联*/
@Entity
@Table(name = "carId2")
public class CarId2 {

    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid", strategy = "assigned")
    @Column(length = 8)
    private String cid;
    private String name;
    @OneToOne(mappedBy = "carId2") //表示该表的被动的，不是主表
    private Student2 student2;
    private Date createTime;

    public CarId2(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public CarId2() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student2 getStudent2() {
        return student2;
    }

    public void setStudent2(Student2 student2) {
        this.student2 = student2;
    }
}
