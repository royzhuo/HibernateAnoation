package com.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author roy.zhuo
 */
/*
主键类
1.用embeddedId表示该类为符合主键，可以new一个主键类。必须实现 序列化接口 无参数构造方法 重写equls和hashcode方法
*/
@Embeddable
public class TeacherId implements Serializable {

    @Column(length = 8)
    private String tid;
    @Column(length = 18)
    private String cardId;

    public TeacherId() {
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherId)) return false;

        TeacherId teacherId = (TeacherId) o;

        if (tid != null ? !tid.equals(teacherId.tid) : teacherId.tid != null) return false;
        return !(cardId != null ? !cardId.equals(teacherId.cardId) : teacherId.cardId != null);

    }

    public String getTid() {

        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
