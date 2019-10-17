package com.bill.UI.util;

import javax.swing.*;
import java.awt.*;


/**
 * @Classname CenterPanel
 * @Description TODO
 * @Date 2019/10/7 22:21
 * @Created by HeYu5
 */
public class CenterPanel extends JPanel {

    private double rate; //拉伸比例
    private JComponent c; //显示的组件
    private boolean strech; //是否拉伸

    public CenterPanel(double rate, boolean strech) {
        // setlayout是用来设置用户界面上的屏幕组件的格式布局 默认为流式布局
        this.setLayout(null);
        this.strech = strech;
        this.rate = rate;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    public void repaint(){
        if (null != c) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();

            if(strech){
                c.setSize((int)(containerSize.width*rate), (int)(containerSize.height*rate));

            }
            else{
                c.setSize(componentSize);
            }

            c.setLocation(containerSize.width/2-c.getSize().width/2,
                    containerSize.height/2-c.getSize().height/2);

            }
            super.repaint();

        }

    public void show(JComponent p) {
        this.c = p;
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
        this.updateUI();
    }


    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200,200);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b = new JButton("abc");
        cp.show(b);
    }





}