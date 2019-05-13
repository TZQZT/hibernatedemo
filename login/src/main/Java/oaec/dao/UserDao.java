package oaec.dao;

import com.oaec.ha.test.HibernateUtil;
import oaec.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;

public class UserDao {
    public int add(User user){
        //获取sessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //获取session对象
        Session session = sessionFactory.openSession();
        //开启事务
        session.beginTransaction();
        int id = (int) session.save(user);
        session.getTransaction().commit();
        session.close();
        return id;
    }
    public User findByUsername(String username){
        //获取sessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //获取session对象
        Session session = sessionFactory.openSession();
        //开启事务
        session.beginTransaction();
        String hql = "FROM User WHERE username=:username";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("username", username);
        User user = null;
        try {
            user = query.getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
