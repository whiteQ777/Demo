package com.bill.gui.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Classname ReadImageTest
 * @Description TODO
 * @Date 2019/10/9 21:44
 * @Created by HeYu5
 */
public class ReadImageTest {
    public static void main(String[] args) {
        File file = new File("/img/backup.png");
        try {
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}