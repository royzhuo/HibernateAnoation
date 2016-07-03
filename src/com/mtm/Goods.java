package com.mtm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

/**
 * @author roy.zhuo
 */

/*单向*/
@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    private String name;
    private int price;
    private Date createTime;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "goodses")
    private Set<Custmers> custmerses;

    public Goods(String name, int price, Date createTime) {
        this.name = name;
        this.price = price;
        this.createTime = createTime;
    }

    public Goods() {
    }

    public Set<Custmers> getCustmerses() {
        return custmerses;
    }

    public void setCustmerses(Set<Custmers> custmerses) {
        this.custmerses = custmerses;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
