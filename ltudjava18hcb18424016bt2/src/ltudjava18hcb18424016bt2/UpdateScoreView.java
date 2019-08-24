/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.ScoreDAO;
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
import pojos.Score;

/**
 *
 * @author quang
 */
public class UpdateScoreView extends JPanel implements ActionListener {

    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    JLabel lblSubject;
    JTextField txtSubject;
    JLabel lblStudentID;
    JTextField txtStudentID;
    JLabel lblScoreMid;
    JTextField txtScoreMid;
    JLabel lblScoreLast;
    JTextField txtScoreLast;
    JLabel lblScoreOther;
    JTextField txtScoreOther;
    JLabel lblScoreAvg;
    JTextField txtScoreAvg;
    JButton btnUpdate;
    JButton btnClear;
    JTable table;
    JScrollPane sp;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Cập nhật điểm");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Thông tin");
        p1.setBorder(titleImport);
        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        lblSubject = new JLabel("Mã môn học");
        txtSubject = new JTextField(20);
        lblStudentID = new JLabel("Mã SV");
        txtStudentID = new JTextField(20);
        lblScoreMid = new JLabel("Điểm giữa kỳ");
        txtScoreMid = new JTextField(20);
        lblScoreLast = new JLabel("Điểm cuối kỳ");
        txtScoreLast = new JTextField(20);
        lblScoreOther = new JLabel("Điểm khác");
        txtScoreOther = new JTextField(20);
        lblScoreAvg = new JLabel("Điểm trung bình");
        txtScoreAvg = new JTextField(20);
        btnUpdate = new JButton("Cập nhật");
        btnClear = new JButton("Làm mới");
        p1.add(lblClass);
        p1.add(txtClass);
        p1.add(lblSubject);
        p1.add(txtSubject);
        p1.add(lblStudentID);
        p1.add(txtStudentID);
        p1.add(lblScoreMid);
        p1.add(txtScoreMid);
        p1.add(lblScoreLast);
        p1.add(txtScoreLast);
        p1.add(lblScoreOther);
        p1.add(txtScoreOther);
        p1.add(lblScoreAvg);
        p1.add(txtScoreAvg);
        p1.add(btnUpdate);
        p1.add(btnClear);

        JPanel p2 = new JPanel();
        TitledBorder t2 = new TitledBorder("Danh sách");
        p2.setBorder(t2);
        p2.setLayout(new GridLayout(1, 1));
        table = new JTable();
        sp = new JScrollPane(table);
        p2.add(sp);

        pnManClass.add(p1);
        pnManClass.add(p2);

        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdate) {
            if (!txtClass.getText().isEmpty()) {
                if (!txtSubject.getText().isEmpty() && !txtStudentID.getText().isEmpty()) {
                    Score st = ScoreDAO.GetScoreByID(txtStudentID.getText(), txtClass.getText(), txtSubject.getText());
                    boolean kq = false;
                    st.setStudentId(txtStudentID.getText());
                    st.setClass_(txtClass.getText());
                    st.setSubjectId(txtSubject.getText());
                    if (!txtScoreMid.getText().isEmpty()) {
                        st.setScoreMid(Float.parseFloat(txtScoreMid.getText()));
                    }
                    if (!txtScoreLast.getText().isEmpty()) {
                        st.setScoreLast(Float.parseFloat(txtScoreLast.getText()));
                    }
                    if (!txtScoreOther.getText().isEmpty()) {
                        st.setScoreOther(Float.parseFloat(txtScoreOther.getText()));
                    }
                    if (!txtScoreAvg.getText().isEmpty()) {
                        st.setScoreAvg(Float.parseFloat(txtScoreAvg.getText()));
                    }
                    kq = ScoreDAO.UpdateScore(st);

                    if (kq == true) {
                        GetOneScore(txtStudentID.getText(), txtClass.getText(), txtSubject.getText());

                        JOptionPane.showMessageDialog(null, "Cập nhật thành công.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        } else if (e.getSource() == btnClear) {
            txtClass.setText("");
            txtSubject.setText("");
            txtStudentID.setText("");
            txtScoreMid.setText("");
            txtScoreLast.setText("");
            txtScoreOther.setText("");
            txtScoreAvg.setText("");
        }
    }

    public void GetListScore(String p_Class, String p_Subject) {
        String[] columns = new String[]{
            "Mã SV",
            "Họ tên",
            "Điểm giữa kỳ",
            "Điểm cuối kỳ",
            "Điểm khác",
            "Điểm trung bình",
            "Lớp",
            "Môn học"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<pojos.Score> listSchedule = null;
        listSchedule = ScoreDAO.GetScoreList(p_Class, p_Subject);
        listSchedule.forEach(item -> {
            model.addRow(new Object[]{
                item.getStudentId(),
                item.getFullName(),
                item.getScoreMid(),
                item.getScoreLast(),
                item.getScoreOther(),
                item.getScoreAvg(),
                item.getClass_(),
                item.getSubjectId()
            });
        });
        table.setModel(model);
    }

    public void GetOneScore(String StudentID, String p_Class, String p_Subject) {
        String[] columns = new String[]{
            "Mã SV",
            "Họ tên",
            "Điểm giữa kỳ",
            "Điểm cuối kỳ",
            "Điểm khác",
            "Điểm trung bình",
            "Lớp",
            "Môn học"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        pojos.Score item = null;
        item = ScoreDAO.GetScoreByID(StudentID, p_Class, p_Subject);

        model.addRow(new Object[]{
            item.getStudentId(),
            item.getFullName(),
            item.getScoreMid(),
            item.getScoreLast(),
            item.getScoreOther(),
            item.getScoreAvg(),
            item.getClass_(),
            item.getSubjectId()
        });

        table.setModel(model);
    }
}
