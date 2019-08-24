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

/**
 *
 * @author quang
 */
public class ManagerScoreView extends JPanel implements ActionListener {

    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    JLabel lblSubject;
    JTextField txtSubject;
    JButton btnSearch;
    JTable table;
    JScrollPane sp;
    int countPass = 0;
    int countLose = 0;
    JLabel lblPercentPass;
    JLabel lblPercentLose;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Xem điểm");
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
        p2.setLayout(new GridLayout(3, 1, 2, 2));
        table = new JTable();
        sp = new JScrollPane(table);
        lblPercentLose = new JLabel();
        lblPercentPass = new JLabel();
        p2.add(sp);
        p2.add(lblPercentLose);
        p2.add(lblPercentPass);

        pnManClass.add(p1);
        pnManClass.add(p2);

        btnSearch.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            if (!txtClass.getText().isEmpty()) {
                if (!txtSubject.getText().isEmpty()) {
                    GetListScore(txtClass.getText(), txtSubject.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
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
            "Môn học",
            "Kết quả"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<pojos.Score> listSchedule = null;
        listSchedule = ScoreDAO.GetScoreList(p_Class, p_Subject);
        countPass = 0;
        countLose = 0;
        listSchedule.forEach(item -> {
            String Result = "";
            if (item.getScoreAvg() >= 5) {
                Result = "Đậu";
                countPass = countPass + 1;
            } else {
                Result = "Rớt";
                countLose = countLose + 1;
            }
            model.addRow(new Object[]{
                item.getStudentId(),
                item.getFullName(),
                item.getScoreMid(),
                item.getScoreLast(),
                item.getScoreOther(),
                item.getScoreAvg(),
                item.getClass_(),
                item.getSubjectId(),
                Result
            });
        });
        table.setModel(model);
        lblPercentLose.setText("Số lượng rớt: " + countLose + " Tỉ lệ: " + (((float) countLose / listSchedule.size()) * 100));
        lblPercentPass.setText("Số lượng đậu: " + countPass + " Tỉ lệ: " + (((float) countPass / listSchedule.size()) * 100));
    }
}
