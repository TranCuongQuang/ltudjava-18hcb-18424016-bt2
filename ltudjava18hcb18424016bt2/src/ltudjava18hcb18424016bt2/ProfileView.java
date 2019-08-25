/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.ScoreDAO;
import DAO.UserDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import pojos.Score;
import pojos.User;

/**
 *
 * @author quang
 */
public class ProfileView extends JPanel implements ActionListener {

    JPanel pnManClass;
    JLabel lblPassOld;
    JPasswordField txtPassOld;
    JLabel lblPassNew;
    JPasswordField txtPassNew;
    JLabel lblRePassNew;
    JPasswordField txtRePassNew;
    JButton btnUpdate;
    User user_login;

    public JPanel CreateLayout(User user) {
        user_login = user;
        pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Đổi mật khẩu");
        pnManClass.setBorder(titleClass);
        pnManClass.setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(7, 1, 2, 2));
        TitledBorder titleImport = new TitledBorder("Thông tin");
        p1.setBorder(titleImport);
        lblPassOld = new JLabel("Mật khẩu cũ");
        txtPassOld = new JPasswordField(20);
        lblPassNew = new JLabel("Mật khẩu mới");
        txtPassNew = new JPasswordField(20);
        lblRePassNew = new JLabel("Nhập lại mật khẩu mới");
        txtRePassNew = new JPasswordField(20);
        btnUpdate = new JButton("Cập nhật");
        p1.add(lblPassOld);
        p1.add(txtPassOld);
        p1.add(lblPassNew);
        p1.add(txtPassNew);
        p1.add(lblRePassNew);
        p1.add(txtRePassNew);
        p1.add(btnUpdate);

        pnManClass.add(p1);

        btnUpdate.addActionListener(this);

        return pnManClass;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdate) {
            char[] arrPassOld = txtPassOld.getPassword();
            String PassOld = new String(arrPassOld);

            char[] arrPassNew = txtPassNew.getPassword();
            String PassNew = new String(arrPassNew);

            char[] arrRePassNew = txtRePassNew.getPassword();
            String RePassNew = new String(arrRePassNew);

            if (!PassOld.isEmpty() && !PassNew.isEmpty() && !RePassNew.isEmpty()) {
                if (PassNew.equals(RePassNew)) {
                    User st = UserDAO.GetUserBy(user_login.getUserName(), PassOld);
                    boolean kq = false;
                    if (st != null) {
                        kq = UserDAO.UpdateUser(st, PassNew);
                    }
                    if (kq == true) {
                        txtPassNew.setText("");
                        txtRePassNew.setText("");
                        txtPassOld.setText("");
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới không trùng nhau.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }
}
