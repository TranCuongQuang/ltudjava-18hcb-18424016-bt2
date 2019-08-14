/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.StudentDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import pojos.Student;

/**
 *
 * @author quang
 */
public class Class extends JPanel implements ActionListener {

    JFileChooser fc;
    JButton openButton;
    JPanel pnManClass;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Quản lý lớp học");
        pnManClass.setBorder(titleClass);
        pnManClass.add(new JTextField("TextField", 20));

        fc = new JFileChooser();
        openButton = new JButton("Import");
        pnManClass.add(openButton);
        openButton.addActionListener(this);
        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Class.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //JOptionPane.showMessageDialog(null, file.getName() + " Success " + file.getAbsolutePath());
                ReadData(file.getAbsolutePath(), "Class");
            }
        }
    }

    public static void ReadData(String file, String refix) {
        BufferedReader br = null;
        String line = "";
        String Path = file;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Path), "UTF-8"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                if (refix.equals("Class")) {
                    // Thêm sinh viên
                    Student st = new Student();
                    st.setStudentCode(item[0]);
                    st.setFullName(item[1]);
                    st.setGender(true);
                    st.setCardNumber(item[3]);
                    boolean kq = StudentDAO.SaveStudent(st);
                    if (kq == true) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại.");
                    }

                } else if (refix.equals("TKB")) {
                    System.out.println("Thông tin thời khóa biểu: [Mã môn học: " + item[0] + " , Tên môn học: " + item[1] + " , Phòng: " + item[2] + "]");
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "File không tồn tại.");
            }
        }
    }
}
