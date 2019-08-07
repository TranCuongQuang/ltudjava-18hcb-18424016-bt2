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
import pojos.Student;

/**
 *
 * @author quang
 */
public class StudentDAO {

    public static List<Student> GetStudentList() {
        List<Student> listStudent = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select st from Student st";
            Query query = session.createQuery(hql);
            listStudent = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listStudent;
    }

    public static Student GetStudentByID(String ID) {
        Student st = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            st = (Student) session.get(Student.class, ID);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean SaveStudent(Student st) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.GetStudentByID(st.getStudentCode()) != null) {
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
