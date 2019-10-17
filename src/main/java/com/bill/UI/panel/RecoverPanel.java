package com.bill.UI.panel;


import com.bill.UI.util.ColorUtil;
import com.bill.UI.util.GUIUtil;

import javax.swing.JButton;
import javax.swing.JPanel;



public class RecoverPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover =new JButton("恢复");

    public RecoverPanel() {

        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

}