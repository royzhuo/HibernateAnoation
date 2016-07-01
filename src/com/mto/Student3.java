package com.mto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * @author roy.zhuo
 */
/*多对一 多方*/
@Entity
public class Student3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String marjor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //多对一 设置级联和抓取策略积极
    @JoinColumn(name = "cid") //设置外健
    private ClassRoom classRoom;
    private Date createTime;

    public Student3(String name, String marjor, Date createTime) {
        this.name = name;
        this.marjor = marjor;
        this.createTime = createTime;
    }

    public Student3() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
