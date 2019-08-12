/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.StudentDAO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pojos.Student;

/**
 *
 * @author quang
 */
public class Ltudjava18hcb18424016bt2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Thêm sinh viên
//        Student st = new Student();
//        st.setStudentCode("0312171");
//        st.setFullName("Tạ Tấn Thêm");
//        st.setGender(true);
//        st.setCardNumber("04568966");
//        boolean kq = StudentDAO.SaveStudent(st);
//        if (kq == true) {
//            System.out.println("Thêm thành công");
//        } else {
//            System.out.println("Thêm thất bại");
//        }
//
//        // Lấy danh sách sinh viên
//        List<Student> ds = StudentDAO.GetStudentList();
//        for (int i = 0; i < ds.size(); i++) {
//            Student sv = ds.get(i);
//            System.out.println("MSSV: " + sv.getStudentCode());
//            System.out.println("Họ và tên: " + sv.getFullName());
//        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login lg = new Login();
            }
        });
        //Creating the Frame
//        JFrame frame = new JFrame("Chat Frame");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//
//        //Creating the MenuBar and adding components
//        JMenuBar mb = new JMenuBar();
//        JMenu m1 = new JMenu("FILE");
//        JMenu m2 = new JMenu("Help");
//        mb.add(m1);
//        mb.add(m2);
//        JMenuItem m11 = new JMenuItem("Open");
//        JMenuItem m22 = new JMenuItem("Save as");
//        m1.add(m11);
//        m1.add(m22);
//
//        //Creating the panel at bottom and adding components
//        JPanel panel = new JPanel(); // the panel is not visible in output
//        JLabel label = new JLabel("Enter Text");
//        JTextField tf = new JTextField(10); // accepts upto 10 characters
//        JButton send = new JButton("Send");
//        JButton reset = new JButton("Reset");
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(tf);
//        panel.add(send);
//        panel.add(reset);
//
//        // Text Area at the Center
//        JTextArea ta = new JTextArea();
//
//        //Adding Components to the frame.
//        frame.getContentPane().add(BorderLayout.SOUTH, panel);
//        frame.getContentPane().add(BorderLayout.NORTH, mb);
//        frame.getContentPane().add(BorderLayout.CENTER, ta);
//        frame.setVisible(true);

    }
}
