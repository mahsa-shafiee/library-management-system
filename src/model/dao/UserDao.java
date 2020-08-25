package model.dao;

import model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {
    private SessionFactory sessionFactory = SessionFactoryConfig.getSessionFactory();

    public String findUser(String user_name, String password) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select first_name from User where user_name=:user_name and password=:password";
        List<String> resultList = session.createQuery(hql, String.class)
                .setParameter("user_name", user_name)
                .setParameter("password", password)
                .getResultList();
        transaction.commit();
        session.close();
        return resultList.size() == 0 ? null : resultList.get(0);
    }

    public void insert(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
