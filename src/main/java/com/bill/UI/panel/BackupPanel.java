package com.bill.UI.panel;


import com.bill.UI.util.ColorUtil;
import com.bill.UI.util.GUIUtil;

import javax.swing.JButton;
import javax.swing.JPanel;



public class BackupPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup =new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

}