package oaec.dao;

import com.oaec.ha.test.HibernateUtil;
import oaec.Util.HibernateSessionFactory;
import oaec.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;
import javax.swing.*;
import java.util.List;

public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    private HibernateSessionFactory getSession;

    public LoginRegisterInfo() {

    }

    public String saveInfo(User user) {
        String mess = "error";
        getSession = new HibernateSessionFactory();
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            mess = "success";
            return mess;
        } catch (Exception e) {
            message("RegisterInfo error:" + e);
            e.printStackTrace();
            return null;
        }
    }

    public List<User> queryInfo(String type, Object value) {
        getSession = new HibernateSessionFactory();
        session = HibernateSessionFactory.getSession();
        try {
            String hql = "from User where username=?";
            org.hibernate.query.Query query = session.createQuery(hql);
            ((org.hibernate.query.Query) this.query).setParameter(0, value);
            List<User> list = ((org.hibernate.query.Query) this.query).list();
            transaction = session.beginTransaction();
            transaction.commit();
            return list;
        } catch (Exception e) {
            message("LoginRegisterInfo error:" + e);
            e.printStackTrace();
            return null;
        }
    }

    private void message(String mess) {
        int type = JOptionPane.YES_NO_OPTION;
        String title = "提示信息";
        JOptionPane.showMessageDialog(null, mess, title, type);
    }


}
