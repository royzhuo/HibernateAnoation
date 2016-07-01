package com.oto;

import com.domain.Address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author roy.zhuo
 */
/*单向关联*/
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Address address;
    private String major;
    /*配置关系对象关系
    1.cascade级联关系,all全级联
    2.JoinColumn主动类关系，name表示类的外健，unique表示唯一性
    保存的时候应先保存外健对象，在保存主表对象
    */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", unique = true)
    private CardId cardId;

    public Student(String name, Address address, String major, CardId cardId) {

        this.name = name;
        this.address = address;
        this.major = major;
        this.cardId = cardId;
    }

    public Student() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public CardId getCardId() {
        return cardId;
    }

    public void setCardId(CardId cardId) {
        this.cardId = cardId;
    }
}
