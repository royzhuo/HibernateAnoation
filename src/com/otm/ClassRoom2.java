package com.otm;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author roy.zhuo
 */
/*一对多 单向 一方*/
@Entity
public class ClassRoom2 {

    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid", strategy = "assigned")
    @Column(length = 4)
    private String cid;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Set<Student5> students;

    public ClassRoom2(String name, Set<Student5> students) {
        this.name = name;
        this.students = students;
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

    public Set<Student5> getStudents() {
        return students;
    }

    public void setStudents(Set<Student5> students) {
        this.students = students;
    }
}
