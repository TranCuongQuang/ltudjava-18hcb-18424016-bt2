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
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author quang
 */
public class test extends JFrame {

    JMenuItem miClass;
    JMenuItem miSchedule;
    JPanel pnMaster;

    public test(String Title) {
        super(Title);
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Menu");
        mb.add(m1);

        // Quản lý thời lớp học
        //Class clClass = new Class();
        //JPanel pnManClass = clClass.CreateLayout();
        JPanel pnManClass = new JPanel();
        //  TitledBorder titleClass = new TitledBorder("Quản lý lớp học");
        //   pnManClass.setBorder(titleClass);
        // pnManClass.add(new JTextField("TextField", 20));

        // Quản lý thời khóa biểu
        JPanel pnManSchedule = new JPanel();
        TitledBorder titleSchedule = new TitledBorder("Quản lý thời khóa biểu");
        pnManSchedule.setBorder(titleSchedule);
        pnManSchedule.add(new JButton("Button 1"));
        pnManSchedule.add(new JButton("Button 2"));
        pnManSchedule.add(new JButton("Button 3"));

        // add vào card chung
        pnMaster = new JPanel(new CardLayout());
        pnMaster.add(pnManClass, "ManClass");
        pnMaster.add(pnManSchedule, "ManSchedule");

        CardLayout cl = (CardLayout) (pnMaster.getLayout());

        miClass = new JMenuItem(new AbstractAction("Quản lý lớp học") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMaster, "ManClass");
            }
        });
        miSchedule = new JMenuItem(new AbstractAction("Quản lý thời khóa biểu") {
            public void actionPerformed(ActionEvent e) {
                cl.show(pnMaster, "ManSchedule");
            }
        });
        m1.add(miClass);
        m1.add(miSchedule);

        Container con = getContentPane();
        con.add(BorderLayout.NORTH, mb);
        con.add(BorderLayout.CENTER, pnMaster);
    }
}
