/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.StudentDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

/**
 *
 * @author quang
 */
public class Class extends JPanel implements ActionListener {

    JFileChooser fcCSV;
    JButton btnImport;
    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    File file;
    JButton btnSave;
    JTable table;
    JScrollPane sp;
    JButton btnSave_Cre;
    JTextField txtClass_Cre;
    JTextField txtStudentID_Cre;
    JTextField txtFullName_Cre;
    JTextField txtGender_Cre;
    JTextField txtCard_Cre;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Quản lý lớp học");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));

        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import file");
        pnImport.setBorder(titleImport);
        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        fcCSV = new JFileChooser();
        btnImport = new JButton("Import");
        btnSave = new JButton("Lưu");
        pnImport.add(lblClass);
        pnImport.add(txtClass);
        pnImport.add(btnImport);
        pnImport.add(btnSave);
        p1.add(pnImport);

        JPanel pnCreate = new JPanel();
        pnCreate.setLayout(new GridLayout(11, 2, 2, 2));
        TitledBorder titleCreate = new TitledBorder("Thêm mới");
        pnCreate.setBorder(titleCreate);
        JLabel lblClass_Cre = new JLabel("Tên lớp");
        txtClass_Cre = new JTextField(20);
        JLabel lblStudentID_Cre = new JLabel("Mã SV");
        txtStudentID_Cre = new JTextField(20);
        JLabel lblFullName_Cre = new JLabel("Họ tên");
        txtFullName_Cre = new JTextField(20);
        JLabel lblGender_Cre = new JLabel("Giới tính");
        txtGender_Cre = new JTextField(20);
        JLabel lblCard_Cre = new JLabel("CMND");
        txtCard_Cre = new JTextField(20);
        btnSave_Cre = new JButton("Lưu");
        pnCreate.add(lblClass_Cre);
        pnCreate.add(txtClass_Cre);
        pnCreate.add(lblStudentID_Cre);
        pnCreate.add(txtStudentID_Cre);
        pnCreate.add(lblFullName_Cre);
        pnCreate.add(txtFullName_Cre);
        pnCreate.add(lblGender_Cre);
        pnCreate.add(txtGender_Cre);
        pnCreate.add(lblCard_Cre);
        pnCreate.add(txtCard_Cre);
        pnCreate.add(btnSave_Cre);
        p1.add(pnCreate);

        JPanel p2 = new JPanel();
        TitledBorder t2 = new TitledBorder("Danh sách lớp");
        p2.setBorder(t2);
        p2.setLayout(new GridLayout(1, 1));
        table = new JTable();
        sp = new JScrollPane(table);
        p2.add(sp);

        pnManClass.add(p1);
        pnManClass.add(p2);

        btnImport.addActionListener(this);
        btnSave.addActionListener(this);
        btnSave_Cre.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnImport) {
            int returnVal = fcCSV.showOpenDialog(Class.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fcCSV.getSelectedFile();
            }
        } else if (e.getSource() == btnSave) {
            if (!txtClass.getText().isEmpty() && file != null) {
                ReadData(file.getAbsolutePath(), "Class");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        } else if (e.getSource() == btnSave_Cre) {
            if (!txtClass_Cre.getText().isEmpty()
                    && !txtStudentID_Cre.getText().isEmpty()
                    && !txtFullName_Cre.getText().isEmpty()
                    && !txtGender_Cre.getText().isEmpty()
                    && !txtCard_Cre.getText().isEmpty()) {

                // Thêm sinh viên
                Student st = new Student();
                boolean kq = false;
                st.setStudentId(txtStudentID_Cre.getText());
                st.setFullName(txtFullName_Cre.getText());
                st.setGender(txtGender_Cre.getText());
                st.setCardNumber(txtCard_Cre.getText());
                st.setClass_(txtClass_Cre.getText());
                kq = StudentDAO.SaveStudent(st);

                if (kq == true) {
                    GetListStudentInClass(txtClass_Cre.getText());

                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }

    public void ReadData(String file, String refix) {
        BufferedReader br = null;
        String line = "";
        String Path = file;
        boolean kq = false;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Path), "UTF-8"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                if (refix.equals("Class")) {
                    //System.out.println("Thông tin sinh viên: [MSSV: " + item[0] + " , Họ tên: " + item[1] + " , Giới tính: " + item[2] + " , CMND: " + item[3] + "]");
                    // Thêm sinh viên
                    Student st = new Student();
                    st.setStudentId(item[0]);
                    st.setFullName(item[1]);
                    st.setGender(item[2]);
                    st.setCardNumber(item[3]);
                    st.setClass_(txtClass.getText());
                    kq = StudentDAO.SaveStudent(st);

                }
            }
            if (refix.equals("Class")) {
                if (kq == true) {
                    GetListStudentInClass(txtClass.getText());

                    // Clear data
                    txtClass.setText("");
                    file = null;

                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại.");
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

    public void GetListStudentInClass(String p_Class) {
        //sp.setVisible(true);
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
}
