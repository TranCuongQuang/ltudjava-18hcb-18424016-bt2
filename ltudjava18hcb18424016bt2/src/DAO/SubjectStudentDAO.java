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
import pojos.Schedule;
import pojos.Student;
import pojos.StudentSubject;

/**
 *
 * @author quang
 */
public class SubjectStudentDAO {

    public static StudentSubject GetStudentSubjectByID(String p_subjectId, String p_studentId, String p_Class) {
        StudentSubject st = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // st = (StudentSubject) session.get(StudentSubject.class, ID);

            String hql = "FROM StudentSubject u WHERE u.subjectId = :p_subjectId AND u.studentId = :p_studentId AND u.class_ = :p_Class";
            Query query = session.createQuery(hql);
            query.setParameter("p_subjectId", p_subjectId);
            query.setParameter("p_studentId", p_studentId);
            query.setParameter("p_Class", p_Class);
            st = (StudentSubject) query.uniqueResult();

        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean SaveStudentSubject(StudentSubject st) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectStudentDAO.GetStudentSubjectByID(st.getSubjectId(), st.getStudentId(), st.getClass_()) != null) {
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
