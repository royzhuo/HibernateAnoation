package com.test;

import com.domain.Address;
import com.domain.Teacher;
import com.domain.TeacherId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;

/**
 * @author roy.zhuo
 */

public class HibernateAnoationTest {

    //测试数据库和表是否创建
    @Test
    public void exportSchema() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // 生成并输出sql到文件（当前目录）和数据库
        SchemaExport schemaExport = new SchemaExport(configuration);
        // 创建表结构，第一个true 表示在控制台打印sql语句，第二个true 表示导入sql语句到数据库
        schemaExport.create(true, true);
    }

    //添加测试
    @Test
    public void addTest() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        //获取session
        Session session = sessionFactory.getCurrentSession();
        //获取和开始事物
        Transaction transaction = session.beginTransaction();
        //进行持久化操作
        Address address = new Address();
        address.setAddress("xiamen");
        address.setEmail("3610222");
        address.setPhone("05921234567");
        Teacher teacher = new Teacher("hanshunping", address, new Date());
        // teacher.setTid("T000000001");
        TeacherId teacherId = new TeacherId();
        teacherId.setTid("T0000001");
        teacherId.setCardId("123456789012345678");
        teacher.setTeacherId(teacherId);
        session.save(teacher);
        //提交事物
        transaction.commit();
        //关闭会话
        //session.close();
    }

}