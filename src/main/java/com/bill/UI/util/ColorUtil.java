package com.bill.UI.util;

import java.awt.*;

/**
 * @Classname ColorUtil
 * @Description TODO
 * @Date 2019/10/9 14:30
 * @Created by HeYu5
 */
public class ColorUtil {
    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");

//  根据进度显示不同的颜色
    public static Color getByPercentage(int per){
        if (per > 100) {
            per = 100;

        }
        int r = 51;
        int g = 255;
        int b = 51;

        float rate = per / 100f;
        r = (int)((255-51)*rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;

    }
}