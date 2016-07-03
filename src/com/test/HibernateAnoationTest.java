package com.test;

import com.domain.Address;
import com.domain.Teacher;
import com.domain.TeacherId;
import com.mtm.Custmers;
import com.mtm.Goods;
import com.mto.ClassRoom;
import com.mto.Student3;
import com.otm.ClassRoom2;
import com.otm.Department;
import com.otm.Employee;
import com.otm.Student5;
import com.oto.CarId2;
import com.oto.CardId;
import com.oto.Student;
import com.oto.Student2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
        Teacher teacher = new Teacher("hanshunping", address, new Date(), "数学");
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

    //一对一单向单元测试(单向外健关联)
    @Test
    public void testOnetoOneDanXiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CardId cardId = new CardId("roy");
        cardId.setCid("123456789987654321");
        Address address = new Address();
        address.setEmail("361022");
        address.setPhone("123");
        address.setAddress("xiamen");
        Student student = new Student("roy", address, "java", cardId);
        session.save(cardId);
        session.save(student);
        transaction.commit();

    }

    //一对一双向外健关联查询
    @Test
    public void testOneToOneShuangXiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        CarId2 carId2 = new CarId2("roy", new Date());
        carId2.setCid("12345678");
        Student2 student2 = new Student2("roy", "java", carId2, new Date());

        session.save(carId2);
        session.save(student2);

        transaction.commit();

    }

    //多对一单向外健关联
    @Test
    public void manyToOneDanXiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        ClassRoom classRoom1 = new ClassRoom("C01", "软件工程");
        ClassRoom classRoom2 = new ClassRoom("C02", "网络工程");

        Student3 student1 = new Student3("roy", "java", new Date());
        Student3 student2 = new Student3("alan", "c#", new Date());
        Student3 student3 = new Student3("miller", "c", new Date());
        Student3 student4 = new Student3("weir", "ios", new Date());

        student1.setClassRoom(classRoom1);
        student3.setClassRoom(classRoom1);
        student2.setClassRoom(classRoom2);
        student4.setClassRoom(classRoom2);

        session.save(classRoom1);
        session.save(classRoom2);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        transaction.commit();


    }

    //一对多单向关联关系
    @Test
    public void testOneToManyDanxiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Student5 student1 = new Student5("roy", "java", new Date());
        Student5 student2 = new Student5("alan", "jsp", new Date());
        Student5 student3 = new Student5("miller", "ios", new Date());
        Student5 student4 = new Student5("leo", "php", new Date());

        Set<Student5> students1 = new HashSet<>();
        students1.add(student1);
        students1.add(student2);
        Set<Student5> students2 = new HashSet<>();
        students2.add(student3);
        students2.add(student4);

        ClassRoom2 c1 = new ClassRoom2("软件工程", students1);
        c1.setCid("C001");
        ClassRoom2 c2 = new ClassRoom2("网络工程", students2);
        c2.setCid("C002");

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        session.save(c1);
        session.save(c2);

        transaction.commit();
    }

    //一对多双向外健关联关系
    @Test
    public void testOneToManyShuangXiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee("roy", new Date());
        Employee employee2 = new Employee("alan", new Date());
        Employee employee3 = new Employee("leo", new Date());
        Employee employee4 = new Employee("miller", new Date());

        Department department = new Department("ruan jian gong cheng");
        Department department2 = new Department("wang luo gong cheng");
        department.setDid("D001");
        department2.setDid("D002");

        employee.setDept(department);
        employee2.setDept(department);
        employee3.setDept(department);
        employee4.setDept(department2);

        session.save(department);
        session.save(department2);
        session.save(employee);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);

        transaction.commit();

    }

    //多对多单向
    @Test
    public void testManyToManyDanXiang() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Custmers custmer1 = new Custmers("roy", 3);
        Custmers customer2 = new Custmers("alan", 3);
        Custmers customer3 = new Custmers("miller", 6);

        Goods good1 = new Goods("color", 3, new Date());
        Goods good2 = new Goods("xuebi", 3, new Date());
        Goods good3 = new Goods("shouzhuabing", 6, new Date());
        Goods good4 = new Goods("babaozhou", 3, new Date());

        Set<Goods> orders1 = new HashSet<>();
        Set<Goods> orders2 = new HashSet<>();
        Set<Goods> orders3 = new HashSet<>();

        orders1.add(good1);
        orders1.add(good4);
        orders2.add(good2);
        orders3.add(good3);
        orders3.add(good4);
        orders3.add(good2);

        custmer1.setGoodses(orders1);
        customer2.setGoodses(orders2);
        customer3.setGoodses(orders3);

        session.save(good1);
        session.save(good2);
        session.save(good3);
        session.save(good4);
        session.save(custmer1);
        session.save(customer2);
        session.save(customer3);

        transaction.commit();

    }

}