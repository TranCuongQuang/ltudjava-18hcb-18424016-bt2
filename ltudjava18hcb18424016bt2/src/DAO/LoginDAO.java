/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.HibernateUtil;
import java.util.List;
import ltudjava18hcb18424016bt2.Login;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Student;
import pojos.User;

/**
 *
 * @author quang
 */
public class LoginDAO {

    public static User Login(String UserName, String Pass) {
        User us = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM User u WHERE u.userName = :p_UserName AND u.password = :p_Pass";
            Query query = session.createQuery(hql);
            query.setParameter("p_UserName", UserName);
            query.setParameter("p_Pass", Pass);
            us = (User) query.uniqueResult();

            if (us != null) {
                System.out.println("User: " + us.getRole());
            }
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return us;
    }
}
