/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.ScheduleDAO;
import DAO.StudentDAO;
import DAO.SubjectStudentDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import pojos.Student;
import pojos.StudentSubject;

/**
 *
 * @author quang
 */
public class ManagerClass extends JPanel implements ActionListener {

    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    JLabel lblSubject;
    JTextField txtSubject;
    JButton btnSearch;
    JTable table;
    JScrollPane sp;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách lớp");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Tìm kiếm");
        p1.setBorder(titleImport);
        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        lblSubject = new JLabel("Mã môn học");
        txtSubject = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        p1.add(lblClass);
        p1.add(txtClass);
        p1.add(lblSubject);
        p1.add(txtSubject);
        p1.add(btnSearch);

        JPanel p2 = new JPanel();
        TitledBorder t2 = new TitledBorder("Danh sách");
        p2.setBorder(t2);
        p2.setLayout(new GridLayout(1, 1));
        table = new JTable();
        sp = new JScrollPane(table);
        p2.add(sp);

        pnManClass.add(p1);
        pnManClass.add(p2);

        btnSearch.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            if (!txtClass.getText().isEmpty()) {
                if (!txtSubject.getText().isEmpty()) {
                    GetListStudentSubjectInClass(txtClass.getText(), txtSubject.getText());
                } else {
                    GetListStudentInClass(txtClass.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }

    public void GetListStudentInClass(String p_Class) {
        String[] columns = new String[]{
            "Mã Sv",
            "Họ tên",
            "Giới tính",
            "CMND",
            "Lớp"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<Student> listStudent = null;
        listStudent = StudentDAO.GetStudentList(p_Class);
        listStudent.forEach(item -> {
            model.addRow(new Object[]{item.getStudentId(),
                item.getFullName(),
                item.getGender(),
                item.getCardNumber(),
                item.getClass_()
            });
        });
        table.setModel(model);
    }

    public void GetListStudentSubjectInClass(String p_Class, String p_Subject) {
        String[] columns = new String[]{
            "Mã Sv",
            "Họ tên",
            "Giới tính",
            "CMND",
            "Lớp"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<StudentSubject> listStudent = null;
        listStudent = SubjectStudentDAO.GetStudentSubjectList(p_Class, p_Subject);
        listStudent.forEach(item -> {
            model.addRow(new Object[]{item.getStudentId(),
                item.getFullName(),
                item.getGender(),
                item.getCardNumber(),
                item.getClass_()
            });
        });
        table.setModel(model);
    }
}
