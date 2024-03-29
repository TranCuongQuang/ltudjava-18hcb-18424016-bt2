/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import DAO.LoginDAO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import pojos.User;

/**
 *
 * @author quang
 */
public class Login extends JFrame implements ActionListener {

    JButton btnLogin;
    JPanel panelLogin;
    JTextField txtUser;
    JPasswordField txtPass;
    JLabel lblUser;
    JLabel lblPass;

    public Login() {
        super("Đăng nhập");

        btnLogin = new JButton("Đăng nhập");
        panelLogin = new JPanel();
        txtUser = new JTextField(15);
        txtPass = new JPasswordField(15);
        lblUser = new JLabel("Tên đăng nhập ");
        lblPass = new JLabel("Mật khẩu");

        setSize(300, 200);
        setLocation(500, 280);
        panelLogin.setLayout(null);

        lblUser.setBounds(20, 28, 90, 20);
        txtUser.setBounds(110, 30, 150, 20);
        lblPass.setBounds(20, 63, 90, 20);
        txtPass.setBounds(110, 65, 150, 20);
        btnLogin.setBounds(110, 100, 110, 20);

        panelLogin.add(btnLogin);
        panelLogin.add(txtUser);
        panelLogin.add(txtPass);
        panelLogin.add(lblUser);
        panelLogin.add(lblPass);

        btnLogin.addActionListener(this);
        getContentPane().add(panelLogin);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String UserName = txtUser.getText().toString();
            char[] arrPass = txtPass.getPassword();
            String Pass = new String(arrPass);
            if (!UserName.isEmpty() && !Pass.isEmpty()) {
                User user = new User();
                user = LoginDAO.Login(UserName, Pass);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác!");
                } else {
                    // JOptionPane.showMessageDialog(null, "Success");
                    dispose();
                    Home h = new Home("Home", user);
                    h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    h.setVisible(true);
                    h.setSize(800, 600);
                    h.setLocation(400, 20);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
            }
        }
    }
}
