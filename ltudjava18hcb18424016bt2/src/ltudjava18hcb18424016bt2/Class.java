/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author quang
 */
public class Class {

    public JPanel CreateLayout() {
        JPanel pnManClass = new JPanel();
        TitledBorder titleClass = new TitledBorder("Quản lý lớp học");
        pnManClass.setBorder(titleClass);
        pnManClass.add(new JTextField("TextField", 20));
        return pnManClass;
    }
}
