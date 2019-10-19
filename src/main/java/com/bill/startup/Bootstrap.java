package com.bill.startup;

import com.bill.gui.frame.MainFrame;
import com.bill.gui.panel.MainPanel;
import com.bill.gui.panel.SpendPanel;
import com.bill.gui.util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @Classname Bootstrap
 * @Description TODO
 * @Date 2019/10/19 10:38
 * @Created by HeYu5
 */
public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}