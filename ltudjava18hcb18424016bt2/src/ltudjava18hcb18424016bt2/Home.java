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

        // add vào card chung
        pnMaster = new JPanel(new CardLayout());
        pnMaster.add(pnManClass, "ManClass");
        pnMaster.add(pnManSchedule, "ManSchedule");

        CardLayout card = (CardLayout) (pnMaster.getLayout());

        miClass = new JMenuItem(new AbstractAction("Quản lý lớp học") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManClass");
            }
        });
        miSchedule = new JMenuItem(new AbstractAction("Quản lý thời khóa biểu") {
            public void actionPerformed(ActionEvent e) {
                card.show(pnMaster, "ManSchedule");
            }
        });
        m1.add(miClass);
        m1.add(miSchedule);

        Container con = getContentPane();
        con.add(BorderLayout.NORTH, mb);
        con.add(BorderLayout.CENTER, pnMaster);

    }
}
