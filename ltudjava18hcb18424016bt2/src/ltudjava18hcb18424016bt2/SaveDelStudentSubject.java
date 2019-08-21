/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.SubjectStudentDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import pojos.StudentSubject;

/**
 *
 * @author quang
 */
public class SaveDelStudentSubject extends JPanel implements ActionListener {

    JPanel pnManClass;
    JTextField txtClass;
    JTextField txtSubject;
    JTextField txtStudentID;
    JButton btnSave;
    JTable table;
    JScrollPane sp;
    JButton btnSave_Cre;
    JTextField txtClass_Cre;
    JTextField txtStudentID_Cre;
    JTextField txtFullName_Cre;
    JTextField txtGender_Cre;
    JTextField txtCard_Cre;
    JTextField txtSubject_Cre;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Đăng ký, hủy học phần");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));

        JPanel pnCancel = new JPanel();
        pnCancel.setLayout(new GridLayout(13, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Hủy học phần");
        pnCancel.setBorder(titleImport);
        JLabel lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        JLabel lblSubject = new JLabel("Mã môn học");
        txtSubject = new JTextField(20);
        JLabel lblStudentID = new JLabel("Mã SV");
        txtStudentID = new JTextField(20);

        btnSave = new JButton("Lưu");
        pnCancel.add(lblClass);
        pnCancel.add(txtClass);
        pnCancel.add(lblSubject);
        pnCancel.add(txtSubject);
        pnCancel.add(lblStudentID);
        pnCancel.add(txtStudentID);

        pnCancel.add(btnSave);
        p1.add(pnCancel);

        JPanel pnCreate = new JPanel();
        pnCreate.setLayout(new GridLayout(13, 2, 2, 2));
        TitledBorder titleCreate = new TitledBorder("Đăng ký học phần");
        pnCreate.setBorder(titleCreate);
        JLabel lblClass_Cre = new JLabel("Tên lớp");
        txtClass_Cre = new JTextField(20);
        JLabel lblSubject_Cre = new JLabel("Mã môn học");
        txtSubject_Cre = new JTextField(20);
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
        pnCreate.add(lblSubject_Cre);
        pnCreate.add(txtSubject_Cre);
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
        TitledBorder t2 = new TitledBorder("Danh sách sinh viên");
        p2.setBorder(t2);
        p2.setLayout(new GridLayout(1, 1));
        table = new JTable();
        sp = new JScrollPane(table);
        p2.add(sp);

        pnManClass.add(p1);
        pnManClass.add(p2);

        btnSave.addActionListener(this);
        btnSave_Cre.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        boolean kq = false;
        if (e.getSource() == btnSave) {
            if (!txtClass.getText().isEmpty()
                    && !txtSubject.getText().isEmpty()
                    && !txtStudentID.getText().isEmpty()) {
                kq = SubjectStudentDAO.Delete(txtSubject.getText(), txtStudentID.getText(), txtClass.getText());
                if (kq == true) {
                    GetListStudentInClass(txtClass.getText(), txtSubject.getText());
                    JOptionPane.showMessageDialog(null, "Hủy học phần thành công.");
                } else {
                    JOptionPane.showMessageDialog(null, "Hủy học phần thất bại hoặc không tìm thấy sinh viên.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        } else if (e.getSource() == btnSave_Cre) {
            if (!txtClass_Cre.getText().isEmpty()
                    && !txtStudentID_Cre.getText().isEmpty()
                    && !txtFullName_Cre.getText().isEmpty()
                    && !txtGender_Cre.getText().isEmpty()
                    && !txtCard_Cre.getText().isEmpty()
                    && !txtClass_Cre.getText().isEmpty()
                    && !txtSubject_Cre.getText().isEmpty()) {

                StudentSubject ss = new StudentSubject();
                ss.setStudentId(txtStudentID_Cre.getText());
                ss.setFullName(txtFullName_Cre.getText());
                ss.setGender(txtGender_Cre.getText());
                ss.setCardNumber(txtCard_Cre.getText());
                ss.setClass_(txtClass_Cre.getText());
                ss.setSubjectId(txtSubject_Cre.getText());
                kq = SubjectStudentDAO.SaveStudentSubject(ss);

                if (kq == true) {
                    GetListStudentInClass(txtClass_Cre.getText(), txtSubject_Cre.getText());
                    JOptionPane.showMessageDialog(null, "Thêm thành công.");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }

    public void GetListStudentInClass(String p_Class, String p_Subject) {
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
