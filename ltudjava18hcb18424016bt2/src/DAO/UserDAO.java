/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.User;

/**
 *
 * @author quang
 */
public class UserDAO {

    public static User GetUserBy(String UserName, String Pass) {
        User us = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM User u WHERE u.userName = :p_UserName AND u.password = :p_Pass";
            Query query = session.createQuery(hql);
            query.setParameter("p_UserName", UserName);
            query.setParameter("p_Pass", Pass);
            us = (User) query.uniqueResult();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return us;
    }

    public static boolean UpdateUser(User st, String Pass) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (UserDAO.GetUserBy(st.getUserName(), st.getPassword()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            st.setPassword(Pass);
            session.update(st);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
