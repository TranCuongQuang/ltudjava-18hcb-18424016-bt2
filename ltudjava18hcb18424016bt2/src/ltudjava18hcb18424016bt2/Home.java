/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author quang
 */
public class Home extends JFrame {

    JMenuItem miClass;
    JMenuItem miSchedule;
    JMenuItem miSaveDelStudentSubject;
    JMenuItem miManagerClass;
    JMenuItem miManagerSchedule;
    JMenuItem miScoreView;
    JMenuItem miManagerScoreView;
    JMenuItem miUpdateScoreView;
    JPanel pnMaster;

    public Home(String Title) {
        super(Title);
        // Menu
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Menu");
        mb.add(m1);

        // Quản lý thời lớp học
        Class cl = new Class();
        JPanel pnManClass = cl.CreateLayout();

        // Quản lý thời khóa biểu
        Schedule sch = new Schedule();
        JPanel pnManSchedule = sch.CreateLayout();

        // Quản lý thời khóa biểu
        SaveDelStudentSubject studentSubject = new SaveDelStudentSubject();
        JPanel pnSaveDelStudentSubject = studentSubject.CreateLayout();

        ManagerClass managerClass = new ManagerClass();
        JPanel pnManagerClass = managerClass.CreateLayout();

        ManagerSchedule managerSchedule = new ManagerSchedule();
        JPanel pnManagerSchedule = managerSchedule.CreateLayout();

        ScoreView scoreView = new ScoreView();
        JPanel pnScoreView = scoreView.CreateLayout();

        ManagerScoreView managerScoreView = new ManagerScoreView();
        JPanel pnManagerScoreView = managerScoreView.CreateLayout();

        UpdateScoreView updateScoreView = new UpdateScoreView();
        JPanel pnUpdateScoreView = updateScoreView.CreateLayout();

        // add vào card chung
        pnMaster = new JPanel(new CardLayout());
        pnMaster.add(pnManClass, "ManClass");
        pnMaster.add(pnManSchedule, "ManSchedule");
        pnMaster.add(pnSaveDelStudentSubject, "ManSaveDelStudentSubject");
        pnMaster.add(pnManagerClass, "ManManagerClass");
        pnMaster.add(pnManagerSchedule, "ManManagerSchedule");
        pnMaster.add(pnScoreView, "ManScoreView");
        pnMaster.add(pnManagerScoreView, "ManManagerScoreView");
        pnMaster.add(pnUpdateScoreView, "ManUpdateScoreView");

        CardLayout card = (CardLayout) (pnMaster.getLayout());

        miClass = new JMenuItem(new AbstractAction("Thêm sinh viên vào lớp học") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManClass");
            }
        });

        miSchedule = new JMenuItem(new AbstractAction("Thêm thời khóa biểu vào lớp học") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManSchedule");
            }
        });

        miSaveDelStudentSubject = new JMenuItem(new AbstractAction("Đăng ký, hủy học phần") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManSaveDelStudentSubject");
            }
        });

        miManagerClass = new JMenuItem(new AbstractAction("Xem danh sách lớp") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManManagerClass");
            }
        });

        miManagerSchedule = new JMenuItem(new AbstractAction("Xem thời khóa biểu") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManManagerSchedule");
            }
        });

        miScoreView = new JMenuItem(new AbstractAction("Import điểm") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManScoreView");
            }
        });

        miManagerScoreView = new JMenuItem(new AbstractAction("Xem điểm") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManManagerScoreView");
            }
        });

        miUpdateScoreView = new JMenuItem(new AbstractAction("Cập nhật điểm") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManUpdateScoreView");
            }
        });

        m1.add(miClass);
        m1.add(miSchedule);
        m1.add(miSaveDelStudentSubject);
        m1.add(miManagerClass);
        m1.add(miManagerSchedule);
        m1.add(miScoreView);
        m1.add(miManagerScoreView);
        m1.add(miUpdateScoreView);

        Container con = getContentPane();
        con.add(BorderLayout.NORTH, mb);
        con.add(BorderLayout.CENTER, pnMaster);

    }
}
