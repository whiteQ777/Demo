package com.bill.gui.listener;

import com.bill.gui.frame.MainFrame;
import com.bill.gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Classname TooBarListener
 * @Description TODO
 * @Date 2019/10/19 10:43
 * @Created by HeYu5
 */
public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) e.getSource();
        if (b == p.bReport)
            p.workingPanel.show(ReportPanel.instance);
        if (b == p.bCategory)
            p.workingPanel.show(CategoryPanel.instance);
        if (b == p.bSpend)
            p.workingPanel.show(SpendPanel.instance);
        if (b == p.bRecord)
            p.workingPanel.show(RecordPanel.instance);
        if (b == p.bConfig)
            p.workingPanel.show(ConfigPanel.instance);
        if (b == p.bBackup)
            p.workingPanel.show(BackupPanel.instance);
        if (b == p.bRecover)
            p.workingPanel.show(RecoverPanel.instance);
    }
}