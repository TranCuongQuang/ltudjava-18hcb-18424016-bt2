/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltudjava18hcb18424016bt2;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author quang
 */
public class Schedule {

    public JPanel CreateLayout() {
        JPanel pnManSchedule = new JPanel();
        TitledBorder titleSchedule = new TitledBorder("Quản lý thời khóa biểu");
        pnManSchedule.setBorder(titleSchedule);
        pnManSchedule.add(new JButton("Button 1"));
        pnManSchedule.add(new JButton("Button 2"));
        pnManSchedule.add(new JButton("Button 3"));
        return pnManSchedule;
    }
}
