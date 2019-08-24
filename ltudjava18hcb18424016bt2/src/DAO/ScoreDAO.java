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
import pojos.Score;

/**
 *
 * @author quang
 */
public class ScoreDAO {

    public static List<Score> GetScoreList(String Class, String Subject) {
        List<Score> listSchedule = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            String hql = "select st from Score st where class_ = :p_Class AND subjectId = :p_SubjectId";
            Query query = session.createQuery(hql);
            query.setParameter("p_Class", Class);
            query.setParameter("p_SubjectId", Subject);
            listSchedule = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listSchedule;
    }

    public static List<Score> GetScoreListBy(String StudentID, String Class, String Subject) {
        List<Score> listSchedule = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //System.out.println("User: " + StudentID + " Class: " + Class + " Subject: " + Subject);
            String hql;
            if (Subject.isEmpty()) {
                hql = "select st from Score st where studentId = :p_studentId AND class_ = :p_Class";
            } else {
                hql = "select st from Score st where studentId = :p_studentId AND class_ = :p_Class AND subjectId = :p_SubjectId";
            }
            Query query = session.createQuery(hql);
            query.setParameter("p_studentId", StudentID);
            query.setParameter("p_Class", Class);
            if (!Subject.isEmpty()) {
                query.setParameter("p_SubjectId", Subject);
            }
            listSchedule = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listSchedule;
    }

    public static Score GetScoreByID(String ID, String Class, String Subject) {
        Score st = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "FROM Score u WHERE u.studentId = :p_studentId AND class_ = :p_Class AND subjectId = :p_SubjectId";
            Query query = session.createQuery(hql);
            query.setParameter("p_studentId", ID);
            query.setParameter("p_Class", Class);
            query.setParameter("p_SubjectId", Subject);
            st = (Score) query.uniqueResult();

        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean SaveScore(Score st) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ScoreDAO.GetScoreByID(st.getStudentId(), st.getClass_(), st.getSubjectId()) != null) {
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

    public static boolean UpdateScore(Score st) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ScoreDAO.GetScoreByID(st.getStudentId(), st.getClass_(), st.getSubjectId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
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
