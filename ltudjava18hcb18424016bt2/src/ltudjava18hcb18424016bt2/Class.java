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

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Quản lý lớp học");
        pnManClass.setBorder(titleClass);
        //pnManClass.setLayout(null);

        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        fcCSV = new JFileChooser();
        btnImport = new JButton("Import");
        btnSave = new JButton("Lưu");
        table = new JTable();
        sp = new JScrollPane(table);

        lblClass.setBounds(20, 28, 90, 20);
        txtClass.setBounds(110, 30, 150, 20);
        btnImport.setBounds(280, 30, 110, 20);
        btnSave.setBounds(100, 60, 110, 20);

        sp.setVisible(false);

        pnManClass.add(lblClass);
        pnManClass.add(txtClass);
        pnManClass.add(btnImport);
        pnManClass.add(btnSave);
        pnManClass.add(sp);

        btnImport.addActionListener(this);
        btnSave.addActionListener(this);

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

                } else if (refix.equals("TKB")) {
                    System.out.println("Thông tin thời khóa biểu: [Mã môn học: " + item[0] + " , Tên môn học: " + item[1] + " , Phòng: " + item[2] + "]");
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
        sp.setVisible(true);
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
