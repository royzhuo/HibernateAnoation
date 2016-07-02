package com.mtm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * @author roy.zhuo
 */
/*单向的*/
@Entity
public class Custmers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String name;
    private int money;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "custmer_goods",
        joinColumns = {@JoinColumn(name = "cid")},
        inverseJoinColumns = {@JoinColumn(name = "gid")}
    )
    private Set<Goods> goodses;

    public Custmers(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public Custmers() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Set<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(Set<Goods> goodses) {
        this.goodses = goodses;
    }
}
