/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.ScheduleDAO;
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
public class ManagerSchedule extends JPanel implements ActionListener {

    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    JButton btnSearch;
    JTable table;
    JScrollPane sp;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Danh sách thời khóa biểu");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Tìm kiếm");
        p1.setBorder(titleImport);
        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        p1.add(lblClass);
        p1.add(txtClass);
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
                GetListSchedule(txtClass.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }

    public void GetListSchedule(String p_Class) {
        String[] columns = new String[]{
            "Mã TKB",
            "Mã môn học",
            "Tên môn học",
            "Phòng",
            "Lớp"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        List<pojos.Schedule> listSchedule = null;
        listSchedule = ScheduleDAO.GetScheduleList(p_Class);
        listSchedule.forEach(item -> {
            model.addRow(new Object[]{
                item.getScheduleId(),
                item.getSubjectId(),
                item.getSubjectName(),
                item.getRoom(),
                item.getClass_()
            });
        });
        table.setModel(model);
    }
}
