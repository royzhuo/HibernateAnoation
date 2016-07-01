package com.mto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author roy.zhuo
 */
/*多对一  一方*/
@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid", strategy = "assigned")
    @Column(length = 3)
    private String cid;//班级编号
    private String cname;//班级名称

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
