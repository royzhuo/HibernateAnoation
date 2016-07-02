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
import javax.persistence.Table;
import java.util.Set;

/**
 * @author roy.zhuo
 */
/*一对多 双向关联关系 一方*/
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "did")
    @GenericGenerator(name = "did", strategy = "assigned")
    @Column(length = 4)
    private String did; //部门编号
    //部门名称
    private String name;
    //员工
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //一对多，一方抓取策略是懒加载
    @JoinColumn(name = "did")
    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
