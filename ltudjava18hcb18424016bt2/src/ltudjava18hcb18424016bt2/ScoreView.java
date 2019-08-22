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

/**
 *
 * @author quang
 */
public class ScoreView extends JPanel implements ActionListener {

    JFileChooser fcCSV;
    JButton btnImport;
    JPanel pnManClass;
    JLabel lblClass;
    JTextField txtClass;
    JLabel lblSubject;
    JTextField txtSubject;
    File file;
    JButton btnSave;
    JTable table;
    JScrollPane sp;

    public JPanel CreateLayout() {
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Import điểm");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(2, 1));

        JPanel pnImport = new JPanel();
        pnImport.setLayout(new GridLayout(10, 2, 2, 2));
        TitledBorder titleImport = new TitledBorder("Import file");
        pnImport.setBorder(titleImport);
        lblClass = new JLabel("Tên lớp");
        txtClass = new JTextField(20);
        lblSubject = new JLabel("Mã môn học");
        txtSubject = new JTextField(20);
        fcCSV = new JFileChooser();
        btnImport = new JButton("Import");
        btnSave = new JButton("Lưu");
        pnImport.add(lblClass);
        pnImport.add(txtClass);
        pnImport.add(lblSubject);
        pnImport.add(txtSubject);
        pnImport.add(btnImport);
        pnImport.add(btnSave);

        JPanel p2 = new JPanel();
        TitledBorder t2 = new TitledBorder("Danh sách thời khóa biểu");
        p2.setBorder(t2);
        p2.setLayout(new GridLayout(1, 1));
        table = new JTable();
        sp = new JScrollPane(table);
        p2.add(sp);

        pnManClass.add(pnImport);
        pnManClass.add(p2);

        btnImport.addActionListener(this);
        btnSave.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnImport) {
            int returnVal = fcCSV.showOpenDialog(ScoreView.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fcCSV.getSelectedFile();
            }
        } else if (e.getSource() == btnSave) {
            if (!txtClass.getText().isEmpty() && file != null) {
                ReadData(file.getAbsolutePath(), "Score");
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
                if (refix.equals("Score")) {
                    pojos.Score st = new pojos.Score();
                    st.setStudentId(item[0]);
                    st.setFullName(item[1]);
                    st.setScoreMid(Float.parseFloat(item[2]));
                    st.setScoreLast(Float.parseFloat(item[3]));
                    st.setScoreOther(Float.parseFloat(item[4]));
                    st.setScoreAvg(Float.parseFloat(item[5]));
                    st.setClass_(txtClass.getText());
                    st.setSubjectId(txtSubject.getText());

                    kq = ScoreDAO.SaveScore(st);
                }
            }
            if (refix.equals("Score")) {
                if (kq == true) {
                    GetListScore(txtClass.getText(), txtSubject.getText());
                    // Clear data
                    txtClass.setText("");
                    txtSubject.setText("");
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
}
