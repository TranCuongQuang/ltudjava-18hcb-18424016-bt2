/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import connection.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Schedule;
import pojos.User;

/**
 *
 * @author quang
 */
public class ScheduleDAO {

    public static List<Schedule> GetScheduleList(String Class) {
        List<Schedule> listSchedule = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            String hql = "select st from Schedule st where class_ = :p_Class";
            Query query = session.createQuery(hql);
            query.setParameter("p_Class", Class);

            listSchedule = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listSchedule;
    }

    public static Schedule GetScheduleByID(String ID) {
        Schedule st = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Schedule u WHERE u.subjectId = :p_subjectId";
            Query query = session.createQuery(hql);
            query.setParameter("p_subjectId", ID);
            st = (Schedule) query.uniqueResult();

        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean SaveSchedule(Schedule st) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ScheduleDAO.GetScheduleByID(st.getSubjectId()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(st);
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
